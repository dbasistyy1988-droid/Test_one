import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;



//Задача 2
public class SelenideTest {
    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    SelenideElement administrationButton = $x("//a[@href='/admin']");
    SelenideElement userName = $x("//*[@id='username']");
    SelenideElement passWord = $x("//*[@id='password']");
    SelenideElement sinhgInButton = $x("//button[@class = 'primary']");
    SelenideElement nName = $x("//*[@id='n-name']");
    SelenideElement nPrice = $x("//*[@id='n-price']");
    SelenideElement addBtn = $x("//button[@class = 'btn btn-add']");
    SelenideElement returnToThesite = $x("//a[@href = '/']");
    SelenideElement addToCart = $x("//*[@class='btn' and @data-name='Булочка']");
    SelenideElement addToCartTwo = $x("//*[@class='btn' and @data-name='Бургер']");
    SelenideElement addToCartTree = $x("//*[@class='btn' and @data-name='Колбаса']");
    SelenideElement addToCartFour = $x("//*[@class='btn' and @data-name='Хворост']");
    SelenideElement baSket = $x("//*[@class = 'btn btn-cart']");
    SelenideElement placeOrder = $x("//button[@id = 'makeOrder']");
    SelenideElement itemOne = $x("//*[@data-name='Колбаса']/button");
    SelenideElement itemTwo = $x("//*[@data-name='Бургер']/button");
    SelenideElement productBun = $x("//*[@value='Булочка']");
    SelenideElement productSave = $x("//tr[descendant::input[@value='Булочка']]//button[text()='Сохранить']");


    @Test
    void productVitrina() {
        administrationButton.click();
        userName.sendKeys("admin");
        passWord.sendKeys("secret123");
        sinhgInButton.click();
        nName.sendKeys("Булочка");
        nPrice.sendKeys("99");
        addBtn.click();
        returnToThesite.click();

        $x("//h4[text()='Булочка']").should(Condition.visible);

    }

    @Test
    void productBasket() {
        addToCart.click();
        baSket.click();

        $x("//b[text()='Булочка']").should(Condition.visible);
    }


    @Test
    void failLogPass() {
        administrationButton.click();
        userName.sendKeys("admin");
        passWord.sendKeys("secret123123");
        sinhgInButton.click();

        $x("//div[text()='Неверные учетные данные пользователя']").should(Condition.visible);
    }

    @Test
    void refreshBasket() {
        addToCart.click();
        baSket.click();
        refresh();
        baSket.click();

        $x("//b[text()='Булочка']").should(Condition.visible);

    }

    @Test
    void orderWithalertmore() {

        addToCart.click();
        addToCartTwo.click();
        addToCartTree.click();
        addToCartFour.click();
        baSket.click();
        placeOrder.click();

        Alert activAlert = Selenide.switchTo().alert();
        System.out.println(activAlert.getText());
        activAlert.accept();

    }

    //Задача 3
    @Test
    void orderWithalertnorm() {
        addToCart.click();
        addToCartTwo.click();
        addToCartTree.click();
        baSket.click();
        placeOrder.click();


        $x("//*[@id='toast-container']/div[text()='Заказ принят в обработку!']").should(Condition.visible);
    }

    @Test
    void totalPrice() {
        itemOne.click();
        itemTwo.click();
        baSket.click();

        $x("//*[@id='total-price'] ").shouldHave(Condition.exactText("200"));
    }

    @Test
    void newNotice() {
        administrationButton.click();
        userName.sendKeys("admin");
        passWord.sendKeys("secret123");
        sinhgInButton.click();
        nName.sendKeys("Хворост");
        nPrice.sendKeys("10");
        addBtn.click();

        $x(" //*[text() ='Товар успешно добавлен!']").should(Condition.visible);
    }

    @Test
    void productEditing() {
        administrationButton.click();
        userName.sendKeys("admin");
        passWord.sendKeys("secret123");
        sinhgInButton.click();
        productBun.hover();
        productBun.sendKeys(" с мясом");
        productSave.click();
        returnToThesite.click();

        $x("//*[@class='product-card']/h4[text()='Булочка с мясом']").should(Condition.visible);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        if(testInfo.getTestMethod().isPresent() && testInfo.getTestMethod().get().getName().equals("productEditing"));{
        administrationButton.click();
        $x("//tr[descendant::input[@value='Булочка с мясом']]//button[text()='Удалить']").click();
        Selenide.confirm();
        }
    }
}