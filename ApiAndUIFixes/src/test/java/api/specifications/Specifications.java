package api.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static dataread.DataRead.*;

public class Specifications {
    private static final String apiUrl = configDataApiDTO.getBaseUri() + configDataApiDTO.getApiPath();

    public static RequestSpecification requestSpecForToken = new RequestSpecBuilder()
            .setBaseUri(apiUrl + configDataApiDTO.getTokenRequestsPath())
            .build();

    public static RequestSpecification requestSpecForTests = new RequestSpecBuilder()
            .setBaseUri(apiUrl + configDataApiDTO.getTestsRequestsPath())
            .build();
}
