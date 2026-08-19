import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rest.assertions.BasicApiAssert;
import rest.endpoints.URLs;

import static rest.RestApiBuilder.getBuilder;


@DisplayName("[POST]/goods/add")
public class CreateGoodTests {

    String goodName = "Проверк1";
    double price = 1.5d;

    @Test
    @DisplayName("200")
    void addNewGood() {
        Response response = getBuilder().setContentJSON().getSpec().log().all().body("""
                        
                        {
                          "name": "%s",
                          "price": 1.8
                        }
                        
                        """.formatted(goodName))
                .post(URLs.GOODS + URLs.ADD);
        // response.prettyPrint();
        BasicApiAssert.assertThat(response)
                .statusCodeIsEquals(200)
                .fieldIsExists("data.id")
                .fieldIsExists("message")
                .fieldIsEquals("message", "success");

    }

}