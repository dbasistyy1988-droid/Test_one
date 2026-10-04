
import config.ConfigProvider;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rest.assertions.BasicApiAssert;
import rest.endpoints.URLs;

import static rest.RestApiBuilder.getBuilder;


@DisplayName("[POST]/goods/add")
public class CreateGoodTests {

    String goodName = "Проверк1";
    double price = 1.5d;
    @Step("Проверка успешного создания товара")
    @Test
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

    @Test
    @BeforeEach
    public void сheckingСonfig(){
        System.out.println(ConfigProvider.apiProps.url());
    }


}