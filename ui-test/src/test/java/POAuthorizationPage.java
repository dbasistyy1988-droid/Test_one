import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class POAuthorizationPage extends BaseTest{



    @Test
    void authorizationTest(){
        pageAuthorization.clickadministrationBatton();
        pageAuthorization.inputUserName("admin");
        pageAuthorization.inputPassWord("secret123");
        pageAuthorization.clickAsinhgInBatton();
    }
}
