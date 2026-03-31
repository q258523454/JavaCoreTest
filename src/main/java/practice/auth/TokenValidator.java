package practice.auth;


import com.fasterxml.jackson.databind.ObjectMapper;

import practice.auth.entity.TokenPayload;
import practice.auth.entity.ValidationResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Token验证器
 */
public enum TokenValidator {
    ;

    private static final Logger logger = LoggerFactory.getLogger(TokenValidator.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Token分隔符
     */
    private static final String TOKEN_SEPARATOR = ".";

    /**
     * 允许的时间偏移（秒），用于处理服务器时间不同步, 默认无偏移:0
     */
    private static final long ALLOWED_CLOCK_SKEW = 0L;

    /**
     * 已使用的nonce缓存（防止重放攻击）,后续改成Redis等分布式缓存
     */
    private static final Map<String, Long> usedNonceCache = new HashMap<>();

    /**
     * 防重攻击,缓存时间
     */
    private static final long NONCE_CACHE_EXPIRE = 5 * 60 * 1000;

    public static final String SIGN_ALGORITHM = "HmacSHA256";

    /**
     * 验证Token
     *
     * @param token            待验证的Token
     * @param credentialBase64 从配置加载credential
     */
    public static ValidationResult validateToken(String token, String credentialBase64) {
        return validateToken(token, credentialBase64, null, false);
    }

    /**
     * 验证Token
     *
     * @param token            待验证的Token
     * @param credentialBase64 从配置加载credential
     * @param antiReplay       是否需要防重
     */
    public static ValidationResult validateToken(String token, String credentialBase64, boolean antiReplay) {
        return validateToken(token, credentialBase64, null, antiReplay);
    }

    /**
     * 验证Token
     *
     * @param token            待验证的Token
     * @param credentialBase64 从配置加载credential
     * @param expectedAppId    期望的appId（可选）
     * @param antiReplay       是否需要防重
     */
    public static ValidationResult validateToken(String token, String credentialBase64, String expectedAppId, boolean antiReplay) {
        ValidationResult result = new ValidationResult();
        try {
            // 检查Token格式
            String[] parts = token.split("\\" + TOKEN_SEPARATOR);
            if (parts.length != 3) {
                result.setValid(false);
                result.setErrorCode("INVALID_FORMAT");
                result.setErrorMessage("Token格式错误");
                return result;
            }

            String headerBase64 = parts[0];
            String payloadBase64 = parts[1];
            String signature = parts[2];

            // 解析Payload获取appId
            String payloadJson = new String(Base64.getDecoder().decode(payloadBase64.getBytes(StandardCharsets.UTF_8)));

            TokenPayload tokenPayload = OBJECT_MAPPER.readValue(payloadJson, TokenPayload.class);
            String appId = tokenPayload.getAppId();
            Long createTime = tokenPayload.getCreateTime();
            Long expireTime = tokenPayload.getExpireTime();
            String nonce = tokenPayload.getNonce();

            // 验证appId (例如:白名单appid, 只有订阅的appid才能通过)
            if (expectedAppId != null && !expectedAppId.equals(appId)) {
                result.setValid(false);
                result.setErrorCode("appid mismatch");
                result.setErrorMessage("appId不匹配");
                return result;
            }
            if (credentialBase64 == null) {
                result.setValid(false);
                result.setErrorCode("appid not found");
                result.setErrorMessage("未找到对应的appId配置");
                return result;
            }

            // 验证签名
            byte[] credential = Base64.getDecoder().decode((credentialBase64.getBytes(StandardCharsets.UTF_8)));

            String signContent = headerBase64 + TOKEN_SEPARATOR + payloadBase64;
            if (!verifySignature(signContent, signature, credential)) {
                result.setValid(false);
                result.setErrorCode("invalid signature");
                result.setErrorMessage("签名验证失败");
                return result;
            }

            // 验证过期时间
            long currentTime = Instant.now().getEpochSecond();
            if (expireTime < (currentTime - ALLOWED_CLOCK_SKEW)) {
                result.setValid(false);
                result.setErrorCode("token expired");
                result.setErrorMessage("Token已过期");
                return result;
            }

            // 验证token创建时间（防止提前创建好在未来的token）
            if (createTime > (currentTime + ALLOWED_CLOCK_SKEW)) {
                result.setValid(false);
                result.setErrorCode("invalid issue time");
                result.setErrorMessage("Token签发时间无效");
                return result;
            }

            // 验证nonce防止重放攻击(先给小微预留)
            if (!validateNonce(nonce, antiReplay)) {
                result.setValid(false);
                result.setErrorCode("replay attack");
                result.setErrorMessage("检测到重放攻击");
                return result;
            }

            // 所有验证通过
            result.setValid(true);
            result.setAppId(appId);
            result.setCreateTime(createTime);
            result.setExpireTime(expireTime);
            result.setMessage("Token验证成功");
        } catch (Exception e) {
            logger.error("An exception occurred when verifying the Token", e);
            result.setValid(false);
            result.setErrorCode("VALIDATION_ERROR");
            result.setErrorMessage("验证过程中发生错误: " + e.getMessage());
        }
        return result;
    }

    /**
     * 验证签名
     */
    private static boolean verifySignature(String data, String signature, byte[] key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, SIGN_ALGORITHM);
            Mac mac = Mac.getInstance(SIGN_ALGORITHM);
            mac.init(secretKeySpec);

            byte[] expectedSignature = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            String expectedSignatureBase64 = Base64.getEncoder().encodeToString(expectedSignature);

            return signature.equals(expectedSignatureBase64);

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            logger.error("Signature verification failed", e);
            return false;
        }
    }

    /**
     * 验证nonce，防止重放攻击
     */
    private static boolean validateNonce(String nonce, boolean antiReplay) {
        if (!antiReplay) {
            return true;
        }
        synchronized (usedNonceCache) {
            // FIXME 这里只是演示, usedNonceCache 一定要用分布式缓存
            // 第一步: 先清理过期的nonce
            // ....省略代码...
            long currentTime = System.currentTimeMillis();
            usedNonceCache.entrySet().removeIf(new Predicate<Map.Entry<String, Long>>() {
                @Override
                public boolean test(Map.Entry<String, Long> entry) {
                    // ....省略代码..
                    // ....省略代码..
                    return (currentTime - entry.getValue()) > NONCE_CACHE_EXPIRE;
                }
            });

            // 第二步: 检查nonce是否已使用过
            if (usedNonceCache.containsKey(nonce)) {
                return false;
            }

            // 记录已使用的nonce
            usedNonceCache.put(nonce, currentTime);
            return true;
        }
    }
}