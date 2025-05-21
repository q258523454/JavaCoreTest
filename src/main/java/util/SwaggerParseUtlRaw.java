package util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public enum SwaggerParseUtlRaw {
    ;

    /**
     * 待解析的文件目录
     */
    private static final String RESOURCE_DIRECTORY = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\resources\\swagger\\test";


    public static void main(String[] args) throws IOException {
        List<String> fileList = new ArrayList<>();
        // 读取所有的 yaml 文件
        SwaggerParseUtl.getPathList(RESOURCE_DIRECTORY, ".yaml", fileList);
        // 依次解析 yaml 文件
        for (String file : fileList) {
            String[] split = file.replace("\\", "/").split("/");
            // 文件名
            String fileName = split[split.length - 1];
            // 这里的 swagger.yaml 按服务名存放
            String serviceName = split[split.length - 2];
            SwaggerParseUtl.parseSwaggerYamlByContent(file, serviceName, fileName);
        }
    }
}
