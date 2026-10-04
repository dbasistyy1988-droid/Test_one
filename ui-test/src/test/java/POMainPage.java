import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class POMainPage extends BaseTest {


    @Test
    @DisplayName("Авторизация на сайте с некорректным паролем")
    void infornerInvalid() {
        mainPage.clickadministrationButton();
        mainPage.inputUserName("admin");
        mainPage.inputPassWord("secret123123");
        mainPage.clickAsinhgInBatton();
        mainPage.checkInfornerInvalid();

    }

    @Test
    @DisplayName("Добавление товара и проверка отображения")
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
    @DisplayName("Добавление товара в корзину")
    void productBasket() {
        mainPage.clickToCard();
        mainPage.clickBaSket();
        mainPage.checkCard();
    }

    @Test
    @DisplayName("Увеличение количества единиц товара и проверка соответствия")
    void productPlus() {
        mainPage.clickProductPlus(1);
        mainPage.verifyProductCountValue(1, "2");
    }

    @Test
    @DisplayName("Уменьшение количества единиц товара и проверка соответствия")
    void productMinus() {
        mainPage.clickProductMinus(1);
        mainPage.verifyProductCountValue(1, "1");
    }

    @Test
    @DisplayName("Проверка количества карточек товара")
    void verificationSizeProductCarts() {
        mainPage.verifiProductCardSize(5);
    }

    @Test
    @DisplayName("Проверка наличия карточки товара")
    void verificationName() {
        mainPage.productName("Хворост");
    }

    @Test
    @DisplayName("Проверка видимости кнопки Администрирования")
    void checkCardAssert() {
        mainPageAssert.visibleAdministrationBatton();
    }

    @Test
    @DisplayName("Проверка успешного оформления заказа состоящего из 3 товаров")
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
    @DisplayName("Проверка суммы товаров в корзине")
    void totalPrice() {
        mainPageAssert.clickToCardOne();
        mainPageAssert.clickToCardTwo();
        mainPageAssert.clickToCardTree();
        mainPageAssert.clickAddBatton();
        mainPageAssert.totalPriceList("298");
    }

    @Test
    @DisplayName("Проверка отображения тоста")
    void checkToast() {
        mainPageAssert.clickToCardOne();
        mainPageAssert.checkToast();
    }
    @Test
    @DisplayName("Корректировка товар и проверка успешного изменения")
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