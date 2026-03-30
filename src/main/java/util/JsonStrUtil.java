package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.HashMap;

public class JsonStrUtil {
    @SneakyThrows
    public static void main(String[] args) {
        jackSonTest();
        JSONPathEvalTest();
    }

    private static void jackSonTest() throws JsonProcessingException {
        String jsonString = "{\n" +
                "    \"HEAD\": {\n" +
                "        \"xHdrLen\": 203,\n" +
                "        \"xIsuCnl\": \"X86\",\n" +
                "        \"xWkeCod\": \"1\",\n" +
                "        \"xRtnCod\": \"SUC0000\"\n" +
                "    },\n" +
                "    \"BODY\": {\n" +
                "        \"DEMO1X1\": [\n" +
                "            {\n" +
                "                \"xCrdNum\": \"11111\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";


        try {
            JsonNode jsonNode = new ObjectMapper().readTree(jsonString).get("HEAD").get("xWkeCod");
            HashMap hashMap = new ObjectMapper().readValue(jsonString, HashMap.class);
            String value = (String) ((HashMap) (hashMap.get("HEAD"))).get("xWkeCod");
            ((HashMap) (hashMap.get("HEAD"))).get("xWkeCod");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonString);

        JsonNode jsonNode = new ObjectMapper().readTree(jsonString);

        JsonNode jsonNode2 = jsonNode.get("HEAD");

        JsonNode xWkeCod = jsonNode2.get("xWkeCod");
        if (null == xWkeCod) {
            System.out.println("BODY HEAD 无 xWkeCod 字段");
        } else {
            System.out.println("BODY HEAD 有 xWkeCod 字段");

        }

        ((ObjectNode) jsonNode2).put("xWkeCod", "");

        System.out.println(jsonNode.toString());
        // JSON格式化输出
        // System.out.println(jsonNode.toPrettyString());
    }


    /**
     * JSONPath.eval 使用
     */
    public static void JSONPathEvalTest() {
        String jsonStr = "{ \"store\": {\"book\": [{ \"category\": \"reference\"," +
                "\"author\": \"Nigel Rees\",\"title\": \"Sayings of the Century\"," +
                "\"price\": 8.95},{ \"category\": \"fiction\",\"author\": \"Evelyn Waugh\"," +
                "\"title\": \"Sword of Honour\",\"price\": 12.99,\"isbn\": \"0-553-21311-3\"" +
                "}],\"bicycle\": {\"color\": \"red\",\"price\": 19.95}}}";

        System.out.println(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);

        System.out.println("\n Book数目：" + JSONPath.eval(jsonObject, "$.store.book.size()"));
        System.out.println("第一本书title：" + JSONPath.eval(jsonObject, "$.store.book[0].title"));
        System.out.println("price大于10元的book：" + JSONPath.eval(jsonObject, "$.store.book[price > 10]"));
        System.out.println("price大于10元的title：" + JSONPath.eval(jsonObject, "$.store.book[price > 10][0].title"));
        System.out.println("category(类别)为fiction(小说)的book：" + JSONPath.eval(jsonObject, "$.store.book[category = 'fiction']"));
        System.out.println("bicycle的所有属性值" + JSONPath.eval(jsonObject, "$.store.bicycle.*"));
        System.out.println("bicycle的color和price属性值" + JSONPath.eval(jsonObject, "$.store.bicycle['color','price']"));
    }
}
