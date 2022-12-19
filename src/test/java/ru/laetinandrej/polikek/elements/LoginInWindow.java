package ru.laetinandrej.polikek.elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginInWindow {
    public final String LoginLoc = "//input[@class='it h-mod' and  @name='st.email']";
    public final String PasswordLoc = "//input[@id='field_password' or @name='st.password']";
    public final String LoginButtonLoc = "//input[@class='button-pro __wide' and @value='Войти в Одноклассники']";
    public void appendLogin(String login){
        $(By.xpath(LoginLoc)).append(login);
    }
    public void appendPassword(String password){
        $(By.xpath(PasswordLoc)).append(password);
    }
    public void acceptLoginIn(){
        $(By.xpath(LoginButtonLoc)).shouldBe(visible).click();
    }
}
