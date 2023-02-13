package ru.laetinandrej.polikek.tests.loginTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoLoginTest extends BaseTest {
    @Test
    @DisplayName("Вход без логина")
    @Epic(value = "Процесс входа в аккаунт")
    @Feature(value = "Окно ввода логина и пароля")
    @Story(value = "Отсутсвует логин")
    @Description(value = "Попытка входа без введенного логина")
    @Severity(value = SeverityLevel.BLOCKER)
    public void NoLoginIncorrectPassword() {
        loginPage = new LoginPage();

        String login = "";
        String password = "IncorrectPassword";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noLoginMessageExists());
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void NoLoginCorrectPassword() {
        loginPage = new LoginPage();

        String login = "";
        String password = "technoPolis2022";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noLoginMessageExists());
    }

}
