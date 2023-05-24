package api.requests;

import api.filters.CustomLogFilter;
import io.restassured.filter.Filter;

import static api.specifications.Specifications.*;
import static dataread.DataRead.*;
import static io.restassured.RestAssured.given;

public class TokenRequests {
    private static Filter logFilter = new CustomLogFilter();

    public static String getToken(String variant) {
        return given()
                .spec(requestSpecForToken)
                .filters(logFilter)
                .queryParam(configDataApiDTO.getVariantParam(), variant)
                .post(configDataApiDTO.getGetTokenInTokenRequests())
                .asString();
    }
}
