package util;

import cn.hutool.core.util.ObjectUtil;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;

@Slf4j
public enum SwaggerParseUtl {
    ;

    /**
     * 待解析的文件目录
     */
    private static final String RESOURCE_DIRECTORY = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\resources\\swagger\\test\\service1\\a.yaml";

    public static final String SWAGGER_TEST = "swagger/test";

    @NotBlank
    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();
        // 读取所有的 yaml 文件
        getPathList(RESOURCE_DIRECTORY, ".yaml", fileList);
        // 依次解析 yaml 文件
        for (String file : fileList) {
            String[] split = file.replace("\\", "/").split("/");
            // 文件名
            String fileName = split[split.length - 1];
            // 这里的 swagger.yaml 按服务名存放
            String serviceName = split[split.length - 2];
            parseSwaggerYamlByFile(SWAGGER_TEST, serviceName, fileName);
        }
    }

    /**
     * 方式一：直接通过文件路径解析
     *
     * @param resourceRelativePath 目标文件在 resources 下的相对路径
     * @param serviceName          服务名
     * @param fileName             文件
     */
    public static void parseSwaggerYamlByFile(String resourceRelativePath, String serviceName, String fileName) {
        String filePath = resourceRelativePath + "/" + serviceName + "/" + fileName;
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        SwaggerParseResult result = new OpenAPIParser().readLocation(filePath, null, options);
        parseSwagger(serviceName, fileName, result);
    }

    /**
     * 方式二：读取文件内容,然后再解析
     * 注意中方式 ref 需要用 # 开头
     * 像这种 $ref: './swagger/swagger-reference.yaml#/type'， 将报错:malformed or unreadable swagger supplied
     * 我们需要改成: '#swagger/swagger-reference.yaml'
     *
     * @param yamlFilePath yaml文件的绝对路径
     * @param serviceName  服务名
     * @param fileName     文件
     */
    public static void parseSwaggerYamlByContent(String yamlFilePath, String serviceName, String fileName) throws IOException {
        Path path = java.nio.file.Paths.get(yamlFilePath);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        StringBuilder data = new StringBuilder();
        for (String line : allLines) {
            // content解析中，$ref 必须是 $ref: '# 格式，否则会报错: malformed or unreadable swagger supplied
            if (line.contains("$ref: ")) {
                if (!line.trim().startsWith("$ref: '#") && !line.trim().startsWith("$ref: \"#")) {
                    continue;
                }
            }
            data.append(line).append("\n");
        }
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        SwaggerParseResult result = new OpenAPIParser().readContents(data.toString(), null, options);
        parseSwagger(serviceName, fileName, result);
    }

    /**
     * 解析swagger，输出 url 和 method
     */
    private static void parseSwagger(String serviceName, String fileName, SwaggerParseResult result) {
        if (result.getOpenAPI() == null) {
            throw new RuntimeException(result.getMessages().toString());
        }
        OpenAPI openAPI = result.getOpenAPI();
        Paths paths = openAPI.getPaths();

        for (Map.Entry<String, PathItem> entry : paths.entrySet()) {
            // url path
            String path = entry.getKey();
            // api
            PathItem pathItem = entry.getValue();
            Operation api = getOperation(pathItem);
            // request type
            PathItem.HttpMethod method = getMethod(pathItem);
            // operationId
            String operationId = api.getOperationId();
            // 描述
            String description = "";
            if (!StringUtils.isEmpty(api.getDescription())) {
                description = api.getDescription();
            } else {
                description = api.getSummary();
            }
            String tag = "";
            if (!CollectionUtils.isEmpty(api.getTags())) {
                tag = api.getTags().get(0);
            }

            Components components = openAPI.getComponents();
            // 获取所有参数名(path,header,formData,query,body)
            List<String> allParameter = new ArrayList<>();
            // 如果想要获取参数，删除下面这行代码的注释即可
            allParameter = getAllParameter(components, api);

            System.out.println(MessageFormat.format("{0}\t{1}\t{2}\t{3}\t{4}\t{5}\t{6}\t参数:{7}", serviceName, fileName,
                    method, path, tag, operationId, description, allParameter));
        }
    }

    /**
     * 解析api中的所有参数名
     */
    @SuppressWarnings("unchecked")
    public static List<String> getAllParameter(Components components, Operation api) {
        List<String> parameterAll = new ArrayList<>();

        List<String> parameterList = new ArrayList<>();
        List<Parameter> parameters = api.getParameters();
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Parameter parameter : parameters) {
                parameterList.add(parameter.getName());
            }
        }

        List<String> bodyParameterList = new ArrayList<>();
        RequestBody requestBody = api.getRequestBody();

        // 如果 requestBody 为空,直接返回 parameterList 即可
        if (null == requestBody || null == requestBody.getContent()) {
            return parameterList;
        }

        Content content = requestBody.getContent();
        for (Map.Entry<String, MediaType> stringMediaTypeEntry : content.entrySet()) {
            MediaType value = stringMediaTypeEntry.getValue();
            if (null == value || null == value.getSchema()) {
                continue;
            }
            Schema schema = value.getSchema();
            Map<String, Object> properties = new HashMap<>();
            if (null != schema.getProperties()) {
                properties = schema.getProperties();
            } else {
                String ref = schema.get$ref();
                if (!StringUtils.isEmpty(ref) && null != components.getSchemas()) {
                    String[] split = ref.split("/");
                    String schemaKey = split[split.length - 1];
                    Schema refSchema = components.getSchemas().get(schemaKey);
                    if (null != refSchema) {
                        properties = refSchema.getProperties();
                    }
                }
            }
            if (null != properties) {
                for (Map.Entry<String, Object> stringObjectEntry : properties.entrySet()) {
                    String key = stringObjectEntry.getKey();
                    bodyParameterList.add(key);
                }
            }
        }
        parameterAll.addAll(parameterList);
        parameterAll.addAll(bodyParameterList);
        return parameterAll;
    }

    /**
     * 获取请求方法类型
     */
    public static PathItem.HttpMethod getMethod(PathItem pathItem) {
        Operation api = null;
        if (!ObjectUtil.isEmpty(pathItem.getGet())) {
            return PathItem.HttpMethod.GET;
        } else if (!ObjectUtil.isEmpty(pathItem.getPost())) {
            return PathItem.HttpMethod.POST;
        } else if (!ObjectUtil.isEmpty(pathItem.getPut())) {
            return PathItem.HttpMethod.PUT;
        } else if (!ObjectUtil.isEmpty(pathItem.getDelete())) {
            return PathItem.HttpMethod.DELETE;
        } else if (!ObjectUtil.isEmpty(pathItem.getPatch())) {
            return PathItem.HttpMethod.PATCH;
        } else {
            throw new RuntimeException("不支持的请求类型");
        }
    }

    /**
     * 获取 Operation Api
     */
    public static Operation getOperation(PathItem pathItem) {
        Operation api = null;
        if (!ObjectUtil.isEmpty(pathItem.getGet())) {
            api = pathItem.getGet();
        } else if (!ObjectUtil.isEmpty(pathItem.getPost())) {
            api = pathItem.getPost();
        } else if (!ObjectUtil.isEmpty(pathItem.getPut())) {
            api = pathItem.getPut();
        } else if (!ObjectUtil.isEmpty(pathItem.getDelete())) {
            api = pathItem.getDelete();
        } else if (!ObjectUtil.isEmpty(pathItem.getPatch())) {
            api = pathItem.getPatch();
        } else {
            throw new RuntimeException("不支持的请求类型");
        }
        return api;
    }

    /**
     * 递归遍历指定路径下的指定格式, 返回 List<String>
     *
     * @param targetPath             文件路径
     * @param suffix                 文件格式后缀  eg: ".xml"
     * @param returnAbsolutePathList 全部指定文件的绝对路径列表(包含文件后缀)
     */
    public static List<String> getPathList(String targetPath, String suffix, List<String> returnAbsolutePathList) {
        File root = new File(targetPath);
        // 非目录
        if (!root.isDirectory()) {
            returnAbsolutePathList.add(root.getAbsolutePath());
            return returnAbsolutePathList;
        }
        // 目录则递归遍历
        File[] files = root.listFiles();
        if (null != files) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归xml
                    getPathList(file.getAbsolutePath(), suffix, returnAbsolutePathList);
                } else if (file.getName().contains(suffix)) {
                    returnAbsolutePathList.add(file.getAbsolutePath());
                }
            }
        }
        return returnAbsolutePathList;
    }
}
