package util;

import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public enum ApacheHttpUtilPro {
    ;
    private static final Logger logger = LoggerFactory.getLogger(ApacheHttpUtil.class);

    /**
     * setConnectTimeout: 从客户端到url建立连接的超时时间
     */
    private static final int CONNECT_TIMEOUT = 30 * 1000;

    /**
     * setSocketTimeout: 连接上一个url后，获取response的返回等待时间
     */
    private static final int SOCKET_TIMEOUT = 3600 * 1000;

    public static JSONObject postHttpJsonData(String URL, Object requestBody, Map<String, String> headersMap, String... saveRespHeaderName) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();

        CookieStore cookieStore = new BasicCookieStore();
        // 默认是 CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try (CloseableHttpClient httpClient = createSSLClientDefaultBuilder()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore)
                .build()) {
            HttpPost post = new HttpPost(URL);
            // UTF-8 解决中文乱码
            StringEntity params = null;
            if (requestBody instanceof JSONObject) {
                JSONObject requestBodyJson = (JSONObject) requestBody;
                params = new StringEntity(requestBodyJson.toJSONString(), "UTF-8");
            } else if (requestBody instanceof String) {
                params = new StringEntity((String) requestBody, "UTF-8");
            } else {
                throw new IllegalArgumentException("请求参数格式不正确");
            }
            post.addHeader("content-type", "application/json; charset=UTF-8");
            post.addHeader("Accept", "application/json");
            post.addHeader("Accept-Encoding", "UTF-8");
            post.addHeader("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");

            if (!CollectionUtils.isEmpty(headersMap)) {
                for (Map.Entry<String, String> entry : headersMap.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            post.setEntity(params);

            // 发送 post 请求
            HttpResponse response = httpClient.execute(post);
            if (response == null) {
                throw new RuntimeException("response is null");
            } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return getResponseJsonObject(response, saveRespHeaderName);
            } else {
                logger.warn("response status is not 200");
                return getResponseJsonObject(response, saveRespHeaderName);
            }
        } catch (Exception ex) {
            logger.error("{0}", ex);
            throw new RuntimeException("error");
        }
    }


    public static JSONObject getHttpJsonData(String URL, Map<String, String> headerMap, String... saveRespHeaderName) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();

        try (CloseableHttpClient httpClient = createSSLClientDefaultBuilder()
                .setDefaultRequestConfig(requestConfig)
                .build()) {
            HttpGet httpGet = new HttpGet(URL);
            httpGet.addHeader("content-type", "application/json; charset=UTF-8");
            httpGet.addHeader("Accept", "application/json");
            httpGet.addHeader("Accept-Encoding", "UTF-8");

            if (!CollectionUtils.isEmpty(headerMap)) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 发送 httpGet 请求
            HttpResponse response = httpClient.execute(httpGet);
            if (response == null) {
                throw new RuntimeException("response is null");
            } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return getResponseJsonObject(response, saveRespHeaderName);
            } else {
                logger.warn("response status is not 200");
                return getResponseJsonObject(response, saveRespHeaderName);
            }
        } catch (Exception ex) {
            logger.error("{0}", ex);
            throw new RuntimeException("error");
        }
    }


    private static JSONObject getResponseJsonObject(HttpResponse response, String[] saveRespHeaderName) throws IOException {
        InputStream in = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String lines;
        StringBuilder responseMsg = new StringBuilder("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
            responseMsg.append(lines);
        }
        reader.close();
        in.close();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", responseMsg.toString());
        // save header
        for (String name : saveRespHeaderName) {
            jsonObject.put(name, response.getHeaders(name));
        }
        return jsonObject;
    }

    /**
     * 绕过https证书校验
     */
    public static HttpClientBuilder createSSLClientDefaultBuilder() {
        HttpClientBuilder httpClientBuilder = null;
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            // 实现该接口，证书受信任的X509证书校验为true
            builder.loadTrustMaterial(null, (chain, authType) -> true);
            // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(builder.build(), new String[]{"TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            //  HttpsURLConnection对象就可以正常连接HTTPS了，无论其证书是否经权威机构的验证，只要实现了接口X509TrustManager的类MyX509TrustManager信任该证书。
            httpClientBuilder = HttpClients.custom().setSSLSocketFactory(socketFactory);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("系统异常");
        }
        return httpClientBuilder;
    }
}
