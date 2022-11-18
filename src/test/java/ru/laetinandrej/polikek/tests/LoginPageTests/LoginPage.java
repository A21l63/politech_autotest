package ru.laetinandrej.polikek.tests.LoginPageTests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    protected final String loginPage = "https://ok.ru/";
    protected final String InvalidDataMessage = "Неправильно указан логин и/или пароль";
    protected final String NoLoginMessage = "Введите логин";
    protected final String NoPasswordMessage = "Введите пароль";

    public LoginPage(){
        open(loginPage);
    }
    protected void LogginIn(String login, String password){

        $(By.xpath(LoginLocators.loginLoc)).append(login);
        $(By.xpath(LoginLocators.passwordLoc)).append(password);
        $(By.xpath(LoginLocators.loginButtonLoc)).click();
    }
}
