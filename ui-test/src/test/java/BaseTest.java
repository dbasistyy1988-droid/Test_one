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
        open("http://localhost:8080/");


        pageAuthorization = new PageAuthorization();
        mainPage = new MainPage();
        mainPageAssert = new MainPageAssert(mainPage);

    }

}
