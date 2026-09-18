package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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


    public void clickadministrationButton() {
        administrationButton.click();
    }

    public void inputUserName(String username) {
        userName.sendKeys(username);
    }

    public void inputPassWord(String password) {
        passWord.sendKeys(password);
    }

    public void clickAsinhgInBatton() {
        sinhgInButton.click();
    }

    public void inputName(String name) {
        nName.sendKeys(name);
    }

    public void inputPrice(String price) {
        nPrice.sendKeys(price);
    }

    public void clickAddBatton() {
        addBtn.click();
    }

    public void clickReturnToThesiteBatton() {
        returnToThesite.click();
    }

    public void checkCard() {
        addToCart.should(visible);
    }

    public void clickToCard() {
        addToCart.click();
    }

    public void clickBaSket() {
        baSket.click();
    }

    public void checkInfornerInvalid() {
        informerInvalid.should(visible);
    }

    public void clickProductPlus(int index) {
        productPlusList.get(index)
                .click();
    }

    public void clickProductMinus(int index) {
        productMinusList.get(index)
                .click();
    }

    public void verifyProductCountValue(int index, String text) {
        productCountInputList.get(index)
                .shouldHave(Condition.value(text));
    }

    public void verifiProductCardSize(int size) {
        productCardList.shouldHave(CollectionCondition.size(size));
    }

    public void productName(String name) {
        productNameList.should(CollectionCondition.containExactTextsCaseSensitive(name));
    }


}