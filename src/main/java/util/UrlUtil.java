package util;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public enum UrlUtil {
    ;

    public static Map<String, String> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();

        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    public static Map<String, Object> getQueryParameter(String url) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            final String charset = "utf-8";
            url = URLDecoder.decode(url, charset);
            if (url.indexOf('?') != -1) {
                final String contents = url.substring(url.indexOf('?') + 1);
                String[] keyValues = contents.split("&");
                for (String keyValue : keyValues) {
                    String key = keyValue.substring(0, keyValue.indexOf("="));
                    String value = keyValue.substring(keyValue.indexOf("=") + 1);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 替换?值
     *
     * @param url      url
     * @param key      key
     * @param newValue newValue
     * @return String
     */
    public static String replace(String url, String key, String newValue) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).replaceQueryParam(key, newValue).build().toUri();
        return uri.toString();
    }


    public static void main(String[] args) {
        String url = "https://api.xxxx.com/mcloud/mag/ProxyForDownLoad/appstore_file/web/down/c5a25189798" +
                "b4277bdb1e9f635205f4a/%E5%AF%BC%E5%85%A5Excel%E6%B5%81%E7%A8%8B%E5%9B%BE.png?expires=1661140953489&s=" +
                "MCACDlOuh_6YlhReGGUeHgm3Ag4cXSV7_JdbFM8pSasrPA";
        String url2 = "https://www.baidu.com";
        Map<String, Object> map = getQueryParameter(url2);
        log.info(JSON.toJSONString(map));

        // 替换query参数
        String s1 = replace(url, "s", "111");
        log.info(s1);

        // 添加查询参数
        String s2 = UriComponentsBuilder.fromUriString("http://www.baidu.com")
                .queryParam("ztest", "123")
                .build().toString();
        log.info(s2);


        String myUrl = "https://api.xxxx.com/mcloud/mag/ProxyForDownLoad/appstore_file/web/down/4cf1d1ec672e488d87e79d1275b01213/%E5%AF%BC%E5%85%A5Excel%E6%B5%81%E7%A8%8B%E5%9B%BE.png?expires=1661866661020&s=MCECDj1pcoLeuHGadxFuFYhZAg8A0hvNbtqnWzgl9XGM3is";
        String s3 = UriComponentsBuilder.fromUriString(myUrl)
                .queryParam("isOpen", "true")
                .build().toString();
        log.info(s3);

    }


}
