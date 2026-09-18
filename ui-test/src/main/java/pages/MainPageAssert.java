package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.visible;
import static java.awt.SystemColor.text;


public class MainPageAssert extends AbstractAssert<MainPageAssert, MainPage> {

    public MainPageAssert(MainPage mainPage) {
        super(mainPage, MainPageAssert.class);


    }

    public void visibleAdministrationBatton() {
        actual.administrationButton.should(visible);
    }

    public void clickToCardOne() {
        actual.addToCart.should(visible)
                .click();
    }

    public void clickToCardTwo() {
        actual.addToCartTwo.should(visible)
                .click();
    }

    public void clickToCardTree() {
        actual.addToCartTree.should(visible)
                .click();
    }

    public void clickAddBatton() {
        actual.baSket.click();


    }

    public void clickPlaseOrderBatton() {
        actual.placeOrder.click();

    }

    public void verifiInformerGood() {
        actual.informergood.should(visible);
    }

    public void totalPriceList(String price) {
        actual.totalPrice.shouldHave(Condition.exactText(String.valueOf(price)));
    }

    public void checkToast() {
        actual.toast.should(visible);
    }

    public void clickAdministrationBattonAssert() {
        actual.administrationButton.click();
    }

    public void inputUserNameAssert(String username) {
        actual.userName.sendKeys(username);
    }

    public void inputPassWordAssert(String password) {
        actual.passWord.sendKeys(password);
    }

    public void clickAsinhgInBattonAssert() {
        actual.sinhgInButton.click();
    }

    public void inputProductBun(String text) {
        actual.productBun.sendKeys(text);
    }

    public void clickProductSave() {
        actual.productSave.click();
    }
    public void clickReturnToThesite(){
        actual.returnToThesite.click();
    }
    public void visibleProductCart(String text){
        actual.productNameList.should(CollectionCondition.itemWithText(text));
    }
}