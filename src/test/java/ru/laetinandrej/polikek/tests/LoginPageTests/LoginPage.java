package ru.laetinandrej.polikek.tests.LoginPageTests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    
    protected final String loginPage = "https://ok.ru/";
    
    protected final String InvalidDataMessage = "Неправильно указан логин и/или пароль";
    protected final String NoLoginMessage = "Введите логин";
    protected final String NoPasswordMessage = "Введите пароль";
    
    protected void LogginIn(String login, String password){
        open(loginPage);

        $(By.xpath(LoginLocators.loginLoc)).append(login);
        $(By.xpath(LoginLocators.passwordLoc)).append(password);
        $(By.xpath(LoginLocators.loginButtonLoc)).click();
    }
    
    protected void LogOut(){
        $(By.xpath(LoginLocators.ucardToolbarLoc)).click();
        $(By.xpath(LoginLocators.logoutButtonLoc)).click();
        $(By.xpath(LoginLocators.logoutConfirmButtonLoc)).click();
    }
}
