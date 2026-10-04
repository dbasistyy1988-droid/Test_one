package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class PageAuthorization {
   SelenideElement
    administrationButton = $x("//a[@href='/admin']"),
    userName = $x("//*[@id='username']"),
    passWord = $x("//*[@id='password']"),
    sinhgInButton = $x("//button[@class = 'primary']");

   @Step("Клик на кнопку Администрирования")
   public void clickadministrationBatton(){
       administrationButton.click();
   }
   @Step("Ввод логина")
   public void inputUserName(String username){
        userName.sendKeys(username);
    }
    @Step("Ввод пароля")
   public void inputPassWord(String password){
       passWord.sendKeys(password);
   }
    @Step("Клик на кнопку авторизации")
   public void clickAsinhgInBatton(){
    sinhgInButton.click();
}
}