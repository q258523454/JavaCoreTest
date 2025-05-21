
package practice.http;

import com.alibaba.fastjson.JSONObject;

import lombok.SneakyThrows;
import util.ApacheHttpUtil;

public class RunTest {


    @SneakyThrows
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("张三", 18);
        jsonObject.put("王五", 21);

        JSONObject postJsonObject = new JSONObject();
        postJsonObject.put("学生", jsonObject);

        JSONObject result = new JSONObject();

        String URL1 = "http://localhost:8081/parseJsonByte?a=1&b=2";
        ApacheHttpUtil.postHttpJsonByte(URL1, postJsonObject, result);

        String URL2 = "http://localhost:8081/parseJsonData?a=1&b=2";
        ApacheHttpUtil.postHttpJsonData(URL2, postJsonObject, result);
    }
}
