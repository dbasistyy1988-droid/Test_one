import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class POMainPage extends BaseTest {


    @Test
    void infornerInvalid() {
        mainPage.clickadministrationButton();
        mainPage.inputUserName("admin");
        mainPage.inputPassWord("secret123123");
        mainPage.clickAsinhgInBatton();
        mainPage.checkInfornerInvalid();

    }

    @Test
    void productVitrina() {
        mainPage.clickadministrationButton();
        mainPage.inputUserName("admin");
        mainPage.inputPassWord("secret123");
        mainPage.clickAsinhgInBatton();
        mainPage.inputName("Булочка");
        mainPage.inputPrice("100");
        mainPage.clickAddBatton();
        mainPage.clickReturnToThesiteBatton();
        mainPage.checkCard();
    }

    @Test
    void productBasket() {
        mainPage.clickToCard();
        mainPage.clickBaSket();
        mainPage.checkCard();
    }

    @Test
    void productPlus() {
        mainPage.clickProductPlus(1);
        mainPage.verifyProductCountValue(1, "2");
    }

    @Test
    void productMinus() {
        mainPage.clickProductMinus(1);
        mainPage.verifyProductCountValue(1, "1");
    }

    @Test
    void verificationSizeProductCarts() {
        mainPage.verifiProductCardSize(5);
    }

    @Test
    void verificationName() {
        mainPage.productName("Хворост");
    }

    @Test
    void checkCardAssert() {
        mainPageAssert.visibleAdministrationBatton();
    }

    @Test
    void orderWithalertmore() {
        mainPageAssert.clickToCardOne();
        mainPageAssert.clickToCardTwo();
        mainPageAssert.clickToCardTree();
        mainPageAssert.clickAddBatton();
        sleep(2000);
        mainPageAssert.clickPlaseOrderBatton();
        mainPageAssert.verifiInformerGood();
    }

    @Test
    void totalPrice() {
        mainPageAssert.clickToCardOne();
        mainPageAssert.clickToCardTwo();
        mainPageAssert.clickToCardTree();
        mainPageAssert.clickAddBatton();
        mainPageAssert.totalPriceList("298");
    }

    @Test
    void checkToast() {
        mainPageAssert.clickToCardOne();
        mainPageAssert.checkToast();
    }
    @Test
    void productEditing(){
        mainPageAssert.clickAdministrationBattonAssert();
        mainPageAssert.inputUserNameAssert("admin");
        mainPageAssert.inputPassWordAssert("secret123");
        mainPageAssert.clickAsinhgInBattonAssert();
        sleep(2000);
        mainPageAssert.inputProductBun(" с мясом");
        mainPageAssert.clickProductSave();
        mainPageAssert.clickReturnToThesite();
        mainPageAssert.visibleProductCart("Булочка с мясом");
    }
}