package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PageAuthorization {
   SelenideElement
    administrationButton = $x("//a[@href='/admin']"),
    userName = $x("//*[@id='username']"),
    passWord = $x("//*[@id='password']"),
    sinhgInButton = $x("//button[@class = 'primary']");

   public void clickadministrationBatton(){
       administrationButton.click();
   }

   public void inputUserName(String username){
        userName.sendKeys(username);
    }
   public void inputPassWord(String password){
       passWord.sendKeys(password);
   }

   public void clickAsinhgInBatton(){
    sinhgInButton.click();
}
}