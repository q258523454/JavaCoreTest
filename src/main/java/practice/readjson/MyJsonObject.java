
package practice.readjson;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class MyJsonObject {


    private String message;
    private DataBean data;

    @NoArgsConstructor
    @Data
    public static class DataBean {

        private HeadersBean headers;
        private BodyBean body;
        private String statusCode;
        private int statusCodeValue;

        @NoArgsConstructor
        @Data
        public static class HeadersBean {
        }

        @NoArgsConstructor
        @Data
        public static class BodyBean {
            /**
             * pageSize : 50
             * pageNo : 1
             * totalPage : 1
             * pageUrl : null
             * nextPage : 1
             * totalCount : 39
             * upPage : 1
             * lastResult : 50
             * firstResult : 0
             */

            private int pageSize;
            private int pageNo;
            private int totalPage;
            private Object pageUrl;
            private int nextPage;
            private int totalCount;
            private int upPage;
            private int lastResult;
            private int firstResult;
            private List<ResultListBean> resultList;

            @NoArgsConstructor
            @Data
            public static class ResultListBean {
                /**
                 * initializationId : null
                 * appId : null
                 * du : null
                 * microserviceId : 7fe63df2c74b4bcb902385f484d446b9
                 * microserviceName : WelinkOpenCloudFormRedBlueWecode
                 * pipelineName : null
                 * createdBy : l30038132
                 * creationDate : 2023-07-26 14:13:58
                 * serviceType : microService
                 * repositoryName : welink-open-cloud-form-wecode
                 * repositoryAppIdDuList : null
                 * workspaceId : p451a60b0c1c343ac81e4258d1c40f024
                 * workspaceName : ITWeLink
                 * projectId : g94b1c5728e84460cb19e71fcdf506a34
                 * projectName : Open
                 * synchronizedDate : 2023-07-26 19:45:33
                 * zone : null
                 * microserviceGranularity : microService
                 * microserviceGranularityName : 微服务
                 * microserviceMode : selfDevelop
                 * microserviceModeName : 自研
                 * microserviceDesc : null
                 * enterpriseId : null
                 * appServiceId : null
                 * appServiceCode : null
                 * appServiceName : null
                 * microserviceSource : cloudDragon
                 * groupId : null
                 * groupModuleId : null
                 * groupAppId : null
                 * groupName : null
                 * strategy : null
                 * groupDataSource : null
                 */

                private Object initializationId;
                private Object appId;
                private Object du;
                private String microserviceId;
                private String microserviceName;
                private Object pipelineName;
                private String createdBy;
                private String creationDate;
                private String serviceType;
                private String repositoryName;
                private String repositoryUrl;
                private Object repositoryAppIdDuList;
                private String workspaceId;
                private String workspaceName;
                private String projectId;
                private String projectName;
                private String synchronizedDate;
                private Object zone;
                private String microserviceGranularity;
                private String microserviceGranularityName;
                private String microserviceMode;
                private String microserviceModeName;
                private Object microserviceDesc;
                private Object enterpriseId;
                private Object appServiceId;
                private Object appServiceCode;
                private Object appServiceName;
                private String microserviceSource;
                private Object groupId;
                private Object groupModuleId;
                private Object groupAppId;
                private Object groupName;
                private Object strategy;
                private Object groupDataSource;
            }
        }
    }
}
