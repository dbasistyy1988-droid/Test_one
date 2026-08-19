package rest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static rest.endpoints.URLs.GOODS;

public class RestApiBuilder {

    RequestSpecification spec;
    public static final String
            BASIC_URL = "http://localhost:8080";
    private static final String LOGIN = "admin";
    private static final String PASS = "secret123";


    public RestApiBuilder() {
        spec = given().baseUri(BASIC_URL);
    }

    public RestApiBuilder(String uri){
        spec = given().baseUri(BASIC_URL)
                .log().all()
                .relaxedHTTPSValidation();

    }

    public RestApiBuilder addAuth(String login, String password){
        spec = spec.auth().basic(login, password);

        return this;
    }

    public RestApiBuilder setContentJSON() {
        spec = spec.contentType(ContentType.JSON);

        return this;
    }

    public RequestSpecification getSpec() {
        return spec;
    }

    public static RestApiBuilder getBuilder () {
        return new RestApiBuilder().addAuth(LOGIN, PASS);
    }

    public static RestApiBuilder getBuilderWithoutAuth () {
        return new RestApiBuilder();
    }


}
