package dataread.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ConfigDataApiDTO {
    private String baseUri;
    private String apiPath;
    private String tokenRequestsPath;
    private String testsRequestsPath;
    private String contentTypeJson;
    private String contentTypeOfImage;
    private String variantParam;
    private String projectIdParam;
    private String sidParam;
    private String projectNameParam;
    private String testNameParam;
    private String methodNameParam;
    private String classNameParam;
    private String envParam;
    private String testIdParam;
    private String contentParam;
    private String contentTypeParam;
    private String usersEnvName;
    private String getTestsByJsonRequest;
    private String addTestInTestRequests;
    private String addLogsInTestRequests;
    private String getTokenInTokenRequests;
    private String addAttachmentsInTestRequests;
    private String tokenForCoockieParam;
    private String simpleDateFormat;
}
