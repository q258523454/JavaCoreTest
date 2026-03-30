package practice.auth.entity;

import lombok.Data;

/**
 * token校验结果
 */
@Data
public class ValidationResult {
    /**
     * 校验是否通过
     */
    private boolean valid;

    /**
     * 应用appid
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
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 消息
     */
    private String message;
}
