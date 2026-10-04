package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.visible;
import static java.awt.SystemColor.text;


public class MainPageAssert extends AbstractAssert<MainPageAssert, MainPage> {

    public MainPageAssert(MainPage mainPage) {
        super(mainPage, MainPageAssert.class);


    }
    @Step("Проверка видимости кнопки Администрирования")
    public void visibleAdministrationBatton() {
        actual.administrationButton.should(visible);
    }
    @Step("Проверка видимости карточки товара один и нажатие не нее")
    public void clickToCardOne() {
        actual.addToCart.should(visible)
                .click();
    }
    @Step("Проверка видимости карточки товара два и нажатие не нее")
    public void clickToCardTwo() {
        actual.addToCartTwo.should(visible)
                .click();
    }
    @Step("Проверка видимости карточки товара два и нажатие не нее")
    public void clickToCardTree() {
        actual.addToCartTree.should(visible)
                .click();
    }
    @Step("Нажатие на кнопку добавления в корзину")
    public void clickAddBatton() {
        actual.baSket.click();


    }
    @Step("Нажатие на кнопку оформления заказа")
    public void clickPlaseOrderBatton() {
        actual.placeOrder.click();

    }
    @Step("Проверка отображения информера об успешном оформлении заказа")
    public void verifiInformerGood() {
        actual.informergood.should(visible);
    }
    @Step("Проверка итоговой стоимости в списке: {price}")
    public void totalPriceList(String price) {
        actual.totalPrice.shouldHave(Condition.exactText(String.valueOf(price)));
    }
    @Step("Проверка отображения всплывающего уведомления")
    public void checkToast() {
        actual.toast.should(visible);
    }
    @Step("Нажатие на кнопку администрирования")
    public void clickAdministrationBattonAssert() {
        actual.administrationButton.click();
    }
    @Step("Ввод логина")
    public void inputUserNameAssert(String username) {
        actual.userName.sendKeys(username);
    }
    @Step("Ввод пароля")
    public void inputPassWordAssert(String password) {
        actual.passWord.sendKeys(password);
    }
    @Step("Нажатие на кнопку авторизации")
    public void clickAsinhgInBattonAssert() {
        actual.sinhgInButton.click();
    }
    @Step("Ввод названия продукта")
    public void inputProductBun(String text) {
        actual.productBun.sendKeys(text);
    }
    @Step("Нажатие на кнопку сохранения продукта")
    public void clickProductSave() {
        actual.productSave.click();
    }
    @Step("Нажатие на кнопку возврата на сайт")
    public void clickReturnToThesite(){
        actual.returnToThesite.click();
    }
    @Step("ВПроверка наличия продукта с названием: {text}")
    public void visibleProductCart(String text){
        actual.productNameList.should(CollectionCondition.itemWithText(text));
    }
}