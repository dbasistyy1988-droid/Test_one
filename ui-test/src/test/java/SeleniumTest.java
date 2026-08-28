import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Duration;
import java.util.List;
import java.util.Set;


//Задача 1
public class SeleniumTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @Test
    void productVitrina() {
        //Блок кода для авторизации в админке
        driver.findElement(By.xpath("//a[@href='/admin']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret123");
        driver.findElement(By.xpath("//button[@class = 'primary']")).click();
        //Блок кода c ожиданием прогрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Блок кода для добавления товара в админке
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='n-name']")));
        driver.findElement(By.xpath("//*[@id='n-name']")).sendKeys("Бургер");
        driver.findElement(By.xpath("//*[@id='n-price']")).sendKeys("100");
        driver.findElement(By.xpath("//button[@class = 'btn btn-add']")).click();
        //Переход на витрину
        driver.findElement(By.xpath("//a[@href = '/']")).click();
        // Находим элемент с текстом на витрине
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Бургер']"))).getText();
        // Проверка с помощью AssertJ
        assertThat(actualText)
                .as("Карточка товара в витрине под названием 'Бургер' отсутствует")
                .isEqualTo("Бургер");


    }


    @Test
    void productBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn' and @data-name='Бургер']"))).click();
        driver.findElement(By.xpath("//*[@class = 'btn btn-cart']")).click();
        // Находим элемент в корзине
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Бургер']"))).getText();
        // Проверка с помощью AssertJ
        assertThat(actualText)
                .as("Карточка товара в корзине под названием 'Бургер' отсутствует")
                .isEqualTo("Бургер");

    }

    @Test
    void failLogPass(){

        //Блок кода для авторизации в админке
        driver.findElement(By.xpath("//a[@href='/admin']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin1");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret1234");
        driver.findElement(By.xpath("//button[@class = 'primary']")).click();
        //Блок кода c ожиданием появления ошибки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неверные учетные данные пользователя']"))).getText();
        // Проверка с помощью AssertJ
        assertThat(actualText)
                .as("Введены не валидные данные")
                .isEqualTo("Неверные учетные данные пользователя");

    }

    @Test
    void refreshBasket(){
        //Добавление товара в корзину
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn' and @data-name='Бургер']"))).click();
        driver.findElement(By.xpath("//*[@class = 'btn btn-cart']")).click();
        //Обновление страницы
        driver.navigate().refresh();
        //Проверка сохранения товаров после обновления
        driver.findElement(By.xpath("//*[@class = 'btn btn-cart']")).click();
        var elements = driver.findElements(By.xpath("//b[text()='Бургер']"));
        assertFalse(elements.isEmpty(),"Ошибка: после обновления страницы корзина пуста!");
        System.out.println("Товар 'Бургер' успешно сохранился в корзине.");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}