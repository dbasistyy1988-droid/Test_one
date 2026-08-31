import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;


public class DnDTests {

    SelenideElement firstCard = $x("//*[@id = 'card-50']");

    SelenideElement cardButton = $x("//*[@id = 'open-cart-btn']");

    SelenideElement threeCart = $x("//*[@id='cart-item-50']/button");

    @BeforeEach
    void setup()
    {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
    }

   // Задача 1.1
    @Test
    void simpleDnD(){
        sleep(1000);
        firstCard.dragAndDrop(DragAndDropOptions.to(cardButton));
        sleep(2000);
    }
   // Задача 2.1
    @Test
    void deleteCard(){
        firstCard.dragAndDrop(DragAndDropOptions.to(cardButton));
        sleep(1000);
        cardButton.click();
        sleep(1000);
        threeCart.click();
        sleep(1000);
        $x("//*[@id='cart-item-50']").shouldNot(exist);
    }
}