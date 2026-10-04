import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class POAuthorizationPage extends BaseTest{


    @Step("Авторизация на сайте")
    @Test
    @DisplayName("Авторизация на сайте")
    void authorizationTest(){
        pageAuthorization.clickadministrationBatton();
        pageAuthorization.inputUserName("admin");
        pageAuthorization.inputPassWord("secret123");
        pageAuthorization.clickAsinhgInBatton();
    }
}
