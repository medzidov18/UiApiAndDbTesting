package api.filters;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import io.restassured.filter.*;
import io.restassured.response.Response;
import io.restassured.specification.*;

public class CustomLogFilter implements Filter {
    Logger log = AqualityServices.getLogger();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        log.info(String.format("%s %s  =>  %s  %s", requestSpec.getMethod(), requestSpec.getURI(), response.getStatusCode(), response.getStatusLine()));
        log.info(response.getBody().prettyPrint());

        return response;
    }
}
