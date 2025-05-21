package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.HashMap;

public class StringJsonUtil {
    @SneakyThrows
    public static void main(String[] args) {
        /**
         * {
         *     "HEAD": {
         *         "xHdrLen": 203,
         *         "xIsuCnl": "X86",
         *         "xRtnCod": "SUC0000"
         *     },
         *     "BODY": {
         *         "DEMO1X1": [
         *             {
         *                 "xCrdNum": "11111"
         *             }
         *         ]
         *     }
         * }
         */
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
        //System.out.println(jsonNode.toPrettyString());

    }
}
