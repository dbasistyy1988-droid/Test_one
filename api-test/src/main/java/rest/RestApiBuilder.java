package rest;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.filter;
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
                .filter(new AllureRestAssured())
                .log().all()
                .relaxedHTTPSValidation();

    }

    public RestApiBuilder addAuth(String login, String password){
        spec = spec.auth().basic(login, password)
                .filter(new AllureRestAssured());



        return this;
    }
    @Step("Проверка формирования json")
    public RestApiBuilder setContentJSON() {
        spec = spec.contentType(ContentType.JSON)
                .filter(new AllureRestAssured());


        return this;
    }
    @Step("Проверка отправки запроса")
    public RequestSpecification getSpec() {
        return spec;
    }
    @Step("Проверка авторизации")
    public static RestApiBuilder getBuilder () {
        return new RestApiBuilder().addAuth(LOGIN, PASS);
    }

    public static RestApiBuilder getBuilderWithoutAuth () {
        return new RestApiBuilder();
    }


}
