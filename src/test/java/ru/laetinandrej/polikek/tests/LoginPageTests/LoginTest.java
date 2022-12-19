package ru.laetinandrej.polikek.tests.LoginPageTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest{

    @AfterEach
    void LogOutIfNeeded() {
        LoginPage logPage = new LoginPage();
        if (!WebDriverRunner.getWebDriver().getCurrentUrl().equals(logPage.loginPage) || $(By.xpath(LoginLocators.topPanelLeftCorner)).exists()) {

            $(By.xpath(LoginLocators.ucardToolbarLoc)).click();
            $(By.xpath(LoginLocators.logoutButtonLoc)).click();
            $(By.xpath(LoginLocators.logoutConfirmButtonLoc)).click();
        }
    }
    @Test
    public void NoLoginIncorrectPassword() {
        LoginPage logPage = new LoginPage();

        String login = "";
        String password = "IncorrectPassword";

        logPage.LogginIn(login, password);

        $(byText(logPage.NoLoginMessage)).should(exist);
    }

    @Test
    public void IncorrectLoginNoPassword() {
        LoginPage logPage = new LoginPage();

        String login = "IncorrectLogin";
        String password = "";

        logPage.LogginIn(login, password);

        $(byText(logPage.NoPasswordMessage)).should(exist);
    }

    @Test
    public void NoLoginCorrectPassword() {
        LoginPage logPage = new LoginPage();

        String login = "";
        String password = "technoPolis2022";

        logPage.LogginIn(login, password);

        $(byText(logPage.NoLoginMessage)).should(exist);
    }

    @Test
    public void CorrectLoginNoPassword() {
        LoginPage logPage = new LoginPage();

        String login = "technoPol6";
        String password = "";

        logPage.LogginIn(login, password);

        $(byText(logPage.NoPasswordMessage)).should(exist);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "IncorrectLogin, IncorrectPassword",
            "technoPol6, IncorrectPassword",
            "IncorrectLogin, technoPolis2022",
            "+7-800-555-35-3555, technoPolis2022"
    }
    )
    public void InvalidData(String login, String password) {
        LoginPage logPage = new LoginPage();

        logPage.LogginIn(login,password);

        $(byText(logPage.InvalidDataMessage)).should(exist);
    }


    @Test
    public void CorrectLoginCorrectPassword() {
        LoginPage logPage = new LoginPage();

        String login = "technoPol6";
        String password = "technoPolis2022";

        logPage.LogginIn(login, password);
        // Проверка на успешность входа на страницу (появилась кнопка "Лента")
        $(By.xpath(LoginLocators.timeLineLoc)).should(exist);
    }
}

