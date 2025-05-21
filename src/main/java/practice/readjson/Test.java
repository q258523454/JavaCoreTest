
package practice.readjson;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

public class Test {

    public static final String JSON_PATH = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\resources\\jsonfile\\test.json";

    public static void main(String[] args) throws IOException {
        File file = new File(JSON_PATH);
        String content = FileUtils.readFileToString(file, "UTF-8");
        MyJsonObject myJsonObject = JSONObject.parseObject(content, MyJsonObject.class);
        MyJsonObject.DataBean data = myJsonObject.getData();

        MyJsonObject.DataBean.BodyBean body = data.getBody();
        List<MyJsonObject.DataBean.BodyBean.ResultListBean> resultList = body.getResultList();
        for (MyJsonObject.DataBean.BodyBean.ResultListBean resultListBean : resultList) {
            String microserviceName = resultListBean.getMicroserviceName();
            System.out.println(microserviceName);
        }
    }

}
