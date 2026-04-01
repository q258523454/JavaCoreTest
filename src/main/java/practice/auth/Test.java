package practice.auth;

import com.alibaba.fastjson.JSON;

import practice.auth.entity.ValidationResult;
import util.encrypt.BASE64Util;

import org.apache.http.auth.AuthenticationException;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, AuthenticationException {
        String appId = "com.xxxxxxx.com";
        // 原密钥: 012345678901234567890123456789012345678901234567890123456789abcd
        String credential = "MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5YWJjZA==";
        System.out.println(new String(BASE64Util.decryptBASE64(credential)));

        // 测试1
        test1(appId, credential);

        // 测试2
        test2(appId, credential);
    }

    private static void test1(String appId, String credential) throws AuthenticationException {
        String token = TokenGenerator.generateToken(appId, credential);
        System.out.println("token: " + token);
        ValidationResult validationResult = TokenValidator.validateToken(token, credential);
        System.out.println("validationResult=" + JSON.toJSONString(validationResult));
        validationResult = TokenValidator.validateToken(token, credential);
        System.out.println("validationResult=" + JSON.toJSONString(validationResult));
    }

    /**
     * 防重测试
     */
    private static void test2(String appId, String credential) throws AuthenticationException {
        String token = TokenGenerator.generateToken(appId, credential);
        System.out.println("token: " + token);
        ValidationResult validationResult2 = TokenValidator.validateToken(token, credential, true);
        System.out.println("validationResult2=" + JSON.toJSONString(validationResult2));
        validationResult2 = TokenValidator.validateToken(token, credential, true);
        System.out.println("validationResult2=" + JSON.toJSONString(validationResult2));
    }
}
