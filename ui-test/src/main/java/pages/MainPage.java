package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    SelenideElement
            administrationButton = $x("//a[@href='/admin']"),
            userName = $x("//*[@id='username']"),
            passWord = $x("//*[@id='password']"),
            sinhgInButton = $x("//button[@class = 'primary']"),
            nName = $x("//*[@id='n-name']"),
            nPrice = $x("//*[@id='n-price']"),
            addBtn = $x("//*[@class = 'btn btn-add']"),
            returnToThesite = $x("//a[@href = '/']"),
            addToCart = $x("//*[@class='btn' and @data-name='Булочка']"),
            addToCartTwo = $x("//*[@class='btn' and @data-name='Бургер']"),
            addToCartTree = $x("//*[@class='btn' and @data-name='Колбаса']"),
            baSket = $x("//*[@class = 'btn btn-cart']"),
            informerInvalid = $x("//div[text()='Неверные учетные данные пользователя']"),
            placeOrder = $x("//button[@id = 'makeOrder']"),
            informergood = $x("//*[@id='toast-container']/div[text()='Заказ принят в обработку!']"),
            totalPrice = $x("//*[@id='total-price']"),
            toast = $x("//*[@class='toast']"),
            productBun = $x("//*[@value='Булочка']"),
            productSave = $x("//tr[descendant::input[@value='Булочка']]//button[text()='Сохранить']");

    ElementsCollection
            productCardList = $$x("//*[contains(@id, 'card')]"),
            productNameList = $$x("//h4"),
            productPlusList = $$x("//button[@data-action = 'qty-change' and @data-step ='1']"),
            productMinusList = $$x("//button[@data-action = 'qty-change' and @data-step ='-1']"),
            productCountInputList = $$x("//input[@type='number']");

    @Step("Нажатие на кнопку Администрирования")
    public void clickadministrationButton() {
        administrationButton.click();
    }
    @Step("Ввод логина")
    public void inputUserName(String username) {
        userName.sendKeys(username);
    }
    @Step("Ввод пароля")
    public void inputPassWord(String password) {
        passWord.sendKeys(password);
    }
    @Step("Нажатие на кнопку авторизации")
    public void clickAsinhgInBatton() {
        sinhgInButton.click();
    }
    @Step("Проверка отображения названий товаров")
    public void inputName(String name) {
        nName.sendKeys(name);
    }
    @Step("Проверка отображения цен товаров")
    public void inputPrice(String price) {
        nPrice.sendKeys(price);
    }
    @Step("Нажатие на кнопку Создать")
    public void clickAddBatton() {
        addBtn.click();
    }
    @Step("Нажатие на кнопку обновления страницы")
    public void clickReturnToThesiteBatton() {
        returnToThesite.click();
    }
    @Step("Проверка видимости карточки товара")
    public void checkCard() {
        addToCart.should(visible);
    }
    @Step("клик на карточку товара")
    public void clickToCard() {
        addToCart.click();
    }
    @Step("Клик на кнопку Корзины")
    public void clickBaSket() {
        baSket.click();
    }
    @Step("Проверка навидимости информера")
    public void checkInfornerInvalid() {
        informerInvalid.should(visible);
    }
    @Step("Клик на кнопку Плюс")
    public void clickProductPlus(int index) {
        productPlusList.get(index)
                .click();
    }
    @Step("Клик на кнопку Минус")
    public void clickProductMinus(int index) {
        productMinusList.get(index)
                .click();
    }
    @Step("Проверка изменения количества товара")
    public void verifyProductCountValue(int index, String text) {
        productCountInputList.get(index)
                .shouldHave(Condition.value(text));
    }
    @Step("Проверка количества карточек в списке")
    public void verifiProductCardSize(int size) {
        productCardList.shouldHave(CollectionCondition.size(size));
    }
    @Step("Проверка соответствия названия товара переданному значению")
    public void productName(String name) {
        productNameList.should(CollectionCondition.containExactTextsCaseSensitive(name));
    }


}