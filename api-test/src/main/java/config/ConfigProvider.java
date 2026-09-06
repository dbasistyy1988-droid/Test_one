package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static Apiconfig apiProps = ConfigFactory.create(Apiconfig.class);
    // Блок для автоматического вывода параметров перед запуском тестов
    static {
        System.out.println("=== Запуск автотестов: Конфигурация ===");
        System.out.println("URL стенда и API: " + apiProps.url());
        System.out.println("Тайм-аут поиска элементов: " + apiProps.timeOut() + " сек.");
        System.out.println("Режим логирования: " + apiProps.loginMode());

        // Скрываем логин и пароль по условию задачи
        System.out.println("Credentials для входа в админку: [ДАННЫЕ СКРЫТЫ]");

        System.out.println("Стартовый товар -> Имя: " + apiProps.productName() + ", Цена: " + apiProps.productPrice());
        System.out.println("=======================================");
    }
}
