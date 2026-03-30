package practice.auth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Token信息封装类
 */

@Data
public class TokenPayload implements Serializable {
    /**
     * 应用id
     */
    private String appId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 随机数，防止重放攻击
     */
    private String nonce;
}
