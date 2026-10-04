import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import pages.MainPageAssert;
import pages.PageAuthorization;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected PageAuthorization pageAuthorization;
    MainPage mainPage;
    MainPageAssert mainPageAssert;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));

        open("http://localhost:8080/");


        pageAuthorization = new PageAuthorization();
        mainPage = new MainPage();
        mainPageAssert = new MainPageAssert(mainPage);

    }

}
