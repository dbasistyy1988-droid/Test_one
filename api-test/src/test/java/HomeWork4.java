import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static io.restassured.filter.log.LogDetail.ALL;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class HomeWork4 {
    // Задача 1
    private RequestSpecification basicRQ = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .setAuth(RestAssured.basic("admin", "secret123"))
            .log(ALL)
            .build();

    @Test
    void hometest1() {
        given()
                .spec(basicRQ)
                .queryParam("size", 1)
                .queryParam("page", 1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void hometest2() {
        given()
                .baseUri("http://localhost:8080")
                .log().all()
                .queryParam("page", 1)
                .queryParam("size", 7)
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void hometest3() {

        given()
                .spec(basicRQ)
                .contentType(ContentType.JSON)
                .body("""

                        {
                        "name": "Хлебцы",
                        "price": 11.1
                        }
                  """)
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200);

        given()
                .spec(basicRQ)
                .queryParam("page", 0)
                .queryParam("size", 11)
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .body("goods.name", hasItem("Хлебцы"));


    }

    @Test
    void hometest4() {

        given()
                .spec(basicRQ)
                .contentType(ContentType.JSON)
                .body("""

                        {
                 "name": "Товар22",
                 "price": 9.9
                        }
                  """)
                .when()
                .post("/goods/add")
                .then()
                .statusCode(200);

        List<String> productNames = given()
                .spec(basicRQ)
                .queryParam("page", 0)
                .queryParam("size", 11)
                .when()
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("goods.name");

        assertThat(productNames)
                .as("Список товаров не сождержит созданный продукт")
                .contains("Товар22");


    }

    @Test
    void hometest5() {
        String responsBody = given()
                .spec(basicRQ)
                .queryParam("size", -1)
                .queryParam("page", 1)
                .get("/goods/list")
                .then()
                .log().all()
                .statusCode(400)
                .extract()
                .asString();

        assertThat(responsBody)
                .isNotBlank()
                .contains("Page size must not be less than one");

    }

    @Test
    void hometest6() {
        given()
                .spec(basicRQ)
                .pathParam("id", 50)
                .get("/goods/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void hometest7() {
        String message = given()
                .spec(basicRQ)
                .pathParam("id", 100)
                .get("/goods/{id}")
                .then()
                .log().all()
                .statusCode(404)
                .extract()
                .jsonPath()
                .getString("message");

        assertThat(message)
                .isEqualToIgnoringCase("Good with id '100' is not found!");


    }
    @Test // Баг - не удаляются записи начиная с 50 по 53 id
    void hometest8() {
        given()
                .spec(basicRQ)
                .pathParam("id", 55)
                .delete("/goods/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void hometest9() {
        String message = given()
                .spec(basicRQ)
                .pathParam("id", 1)
                .delete("/goods/{id}")
                .then()
                .log().all()
                .statusCode(404)
                .extract()
                .asString();


        assertThat(message)
                .isEqualToIgnoringCase("Good with id '1' is not found");
}
    @Test
    void hometest10() {
        given()
                .spec(basicRQ)
                .contentType(ContentType.JSON)
                .pathParam("id", 50)
                .body("""
                        {
                            "name": "Смена названия",
                            "price": 0.1
                         }                 
                        """)
                .patch("/goods/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void hometest11() {
        String message = given()
                .spec(basicRQ)
                .contentType(ContentType.JSON)
                .pathParam("id", 150)
                .body("""
                        {
                            "name": "Смена названия",
                            "price": 0.1
                         }                 
                        """)
                .patch("/goods/{id}")
                .then()
                .log().all()
                .statusCode(404)
                .extract()
                //.jsonPath()
                .asString();

        assertThat(message)
                .isEqualToIgnoringCase("Good with id '150' is not found");

}
}