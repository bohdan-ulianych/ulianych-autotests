package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:./app.properties"})
public interface AppConfig extends Config {

    @Key("start.url")
    String startUrl();

    @Key("email")
    String email();

    @Key("valid.login")
    String validLogin();

    @Key("invalid.login")
    String invalidLogin();

    @Key("valid.password")
    String validPassword();

    @Key("invalid.password")
    String invalidPassword();

    @Key("return.password")
    String returnPassword();

    @Key("timeout.element")
    int elementTimeout();

}
