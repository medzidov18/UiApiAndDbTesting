package api.requests;

import api.filters.CustomLogFilter;
import api.models.TestDTO;
import io.restassured.filter.Filter;
import org.apache.commons.codec.binary.Base64;
import utility.LogsUtility;
import java.util.List;

import static api.filters.Filters.*;
import static api.specifications.Specifications.*;
import static dataread.DataRead.*;
import static io.restassured.RestAssured.given;

public class TestsRequest {
    private static Filter logFilter = new CustomLogFilter();

    public static List<TestDTO> getTestsById(String projectID) {
        return List.of(given()
                .spec(requestSpecForTests)
                .filters(FORCE_JSON_RESPONSE_BODY, logFilter)
                .queryParam(configDataApiDTO.getProjectIdParam(), projectID)
                .post(configDataApiDTO.getGetTestsByJsonRequest())
                .then()
                .extract()
                .body()
                .as(TestDTO[].class));
    }

    public static String addTest(String projectName, String testName, String methodName) {
        return given()
                .spec(requestSpecForTests)
                .filters(logFilter)
                .queryParam(configDataApiDTO.getSidParam(), testDataApiDTO.getSid())
                .queryParam(configDataApiDTO.getProjectNameParam(), projectName)
                .queryParam(configDataApiDTO.getTestNameParam(), testName)
                .queryParam(configDataApiDTO.getMethodNameParam(), methodName)
                .queryParam(configDataApiDTO.getEnvParam(), System.getProperty(configDataApiDTO.getUsersEnvName()))
                .post(configDataApiDTO.getAddTestInTestRequests())
                .asString();
    }

    public static void addLogsToTest(String testId) {
        List<String> lines = LogsUtility.getLogsOfTest();
        for (String line : lines) {
            addLog(testId, line);
        }
    }

    private static void addLog(String testId, String line) {
        given()
                .spec(requestSpecForTests)
                .filters(logFilter)
                .queryParam(configDataApiDTO.getTestIdParam(), testId)
                .queryParam(configDataApiDTO.getContentParam(), line)
                .post(configDataApiDTO.getAddLogsInTestRequests());
    }

    public static void addScreenShot(String testId, byte[] bytes) {
        Base64 binaryBase64 = new Base64();

        given()
                .spec(requestSpecForTests)
                .filters(logFilter)
                .contentType("application/x-www-form-urlencoded")
                .formParam(configDataApiDTO.getTestIdParam(), testId)
                .formParam(configDataApiDTO.getContentParam(), new String(binaryBase64.encode(bytes)))
                .formParam(configDataApiDTO.getContentTypeParam(), configDataApiDTO.getContentTypeOfImage())
                .post(configDataApiDTO.getAddAttachmentsInTestRequests());
    }
}
