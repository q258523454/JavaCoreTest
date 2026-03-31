package practice.auth;


import com.fasterxml.jackson.databind.ObjectMapper;

import practice.auth.entity.TokenPayload;
import util.SecureNumberUtil;

import org.apache.http.auth.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Token生成器
 */
public enum TokenGenerator {
    ;

    private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Token过期时间（秒），默认30分钟
     */
    private static final long TOKEN_EXPIRE_SECONDS = 30 * 60;

    /**
     * Token过期前多久需要刷新, 默认5分钟
     */
    private static final long TOKEN_EXPIRE_LAST_SECONDS = 5 * 60;

    /**
     * 签名算法
     */
    private static final String SIGN_ALGORITHM = "HmacSHA256";

    /**
     * Token分隔符
     */
    private static final String TOKEN_SEPARATOR = ".";

    /**
     * 生成Token
     *
     * @param appId            应用ID
     * @param credentialBase64 base64编码的密钥
     * @return 生成的Token
     */
    public static String generateToken(String appId, String credentialBase64) throws AuthenticationException {
        try {
            // 解码credential
            byte[] credential = Base64.getDecoder().decode(credentialBase64.getBytes(StandardCharsets.UTF_8));

            // 构建Header
            Map<String, Object> header = new HashMap<>();
            // 固定为 HmacSHA256 安全算法
            header.put("algorithm", SIGN_ALGORITHM);
            header.put("type", "JWT");
            String headerJson = OBJECT_MAPPER.writeValueAsString(header);
            String headerBase64 = Base64.getEncoder().encodeToString(headerJson.getBytes(StandardCharsets.UTF_8));

            // 构建Payload
            long currentTime = Instant.now().getEpochSecond();

            TokenPayload tokenPayload = new TokenPayload();
            tokenPayload.setAppId(appId);
            tokenPayload.setCreateTime(currentTime);
            tokenPayload.setExpireTime(currentTime + TOKEN_EXPIRE_SECONDS);
            // 随机数，防止重放攻击
            tokenPayload.setNonce(generateNonce());

            String payloadJson = OBJECT_MAPPER.writeValueAsString(tokenPayload);

            String payloadBase64 = Base64.getEncoder().encodeToString(payloadJson.getBytes(StandardCharsets.UTF_8));

            // 签名内容
            String signContent = headerBase64 + TOKEN_SEPARATOR + payloadBase64;
            // 生成签名
            String signature = generateSignature(signContent, credential);

            // 组装Token
            return signContent + TOKEN_SEPARATOR + signature;
        } catch (Exception e) {
            logger.error("Generation token failed", e);
            throw new AuthenticationException("Generation token failed");
        }

    }

    /**
     * 生成HMAC签名
     */
    private static String generateSignature(String data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, SIGN_ALGORITHM);
        Mac mac = Mac.getInstance(SIGN_ALGORITHM);
        mac.init(secretKeySpec);

        byte[] signatureBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    /**
     * 生成随机数
     */
    private static String generateNonce() {
        return SecureNumberUtil.randomNumberStringNonZeroFirst(32);
    }

    /**
     * 解析Token（不验证签名，用于内部检查）
     */
    private static TokenPayload parseToken(String token) {
        try {
            String[] parts = token.split("\\" + TOKEN_SEPARATOR);
            if (parts.length != 3) {
                throw new IllegalArgumentException("Token format error");
            }
            String payloadBase64 = parts[1];
            String payloadJson = new String(Base64.getDecoder().decode(payloadBase64), StandardCharsets.UTF_8);
            return OBJECT_MAPPER.readValue(payloadJson, TokenPayload.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Parsing token failed", e);
        }
    }

    /**
     * 验证Token是否即将过期（用于刷新Token）
     */
    public static boolean isTokenExpiring(String token) {
        try {
            TokenPayload tokenPayload = parseToken(token);
            long currentTime = Instant.now().getEpochSecond();
            long expireTime = tokenPayload.getExpireTime();
            // Token快要过期了, 需要刷新
            return (expireTime - currentTime) < TOKEN_EXPIRE_LAST_SECONDS;
        } catch (Exception e) {
            // 解析失败视为需要刷新
            return true;
        }
    }
}