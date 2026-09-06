package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(
        Config.LoadType.MERGE
)
@Config.Sources(
        {"classpath:config.properties"}
)

public interface Apiconfig extends Config {

    @Key("URL")
    String url();

    @Key("Timeout")
    int timeOut();

    @Key("Login.mode")
    String loginMode();

    @Key("Admin.login")
    String adminLogin();

    @Key("Admin.password")
    String adminPassword();

    @Key("Product.name")
    String productName();

    @Key("Product.price")
    double productPrice();

}
