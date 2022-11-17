package ru.laetinandrej.polikek.tests.LoginPageTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends LoginPage{

    @AfterEach
    void NoLogginIn() {
        if ($(By.xpath(LoginLocators.topPanelLeftCorner)).exists()) {
            $(By.xpath(LoginLocators.ucardToolbarLoc)).click();
            $(By.xpath(LoginLocators.logoutButtonLoc)).click();
            $(By.xpath(LoginLocators.logoutConfirmButtonLoc)).click();
        }
    }
    @Test
    public void NoLoginIncorrectPassword() {
        String login = "";
        String password = "IncorrectPassword";

        LogginIn(login, password);

        $(byText(NoLoginMessage)).should(exist);
    }

    @Test
    public void IncorrectLoginNoPassword() {
        String login = "IncorrectLogin";
        String password = "";

        LogginIn(login, password);

        $(byText(NoPasswordMessage)).should(exist);
    }

    @Test
    public void NoLoginCorrectPassword() {
        String login = "";
        String password = "technoPolis2022";

        LogginIn(login, password);

        $(byText(NoLoginMessage)).should(exist);
    }

    @Test
    public void CorrectLoginNoPassword() {
        String login = "technoPol6";
        String password = "";

        LogginIn(login, password);

        $(byText(NoPasswordMessage)).should(exist);
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
        LogginIn(login,password);

        $(byText(InvalidDataMessage)).should(exist);
    }


    @Test
    public void CorrectLoginCorrectPassword() {
        String login = "technoPol6";
        String password = "technoPolis2022";

        LogginIn(login, password);
        // Проверка на успешность входа на страницу (появилась кнопка "Лента")
        $(By.xpath(LoginLocators.timeLineLoc)).should(exist);
    }
}

