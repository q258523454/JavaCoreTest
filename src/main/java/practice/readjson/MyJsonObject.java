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
