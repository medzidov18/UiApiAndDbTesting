package api.filters;

import io.restassured.filter.Filter;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.response.Response;

import static dataread.DataRead.configDataApiDTO;

public class Filters {
    public static final Filter FORCE_JSON_RESPONSE_BODY = (reqSpec, respSpec, ctx) -> {
        Response response = ctx.next(reqSpec, respSpec);
        ((RestAssuredResponseOptionsImpl<?>) response).setContentType(configDataApiDTO.getContentTypeJson());
        return response;
    };
}
