package ru.laetinandrej.polikek.tests.loginTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoPasswordTest extends BaseTest {

    @Test
    @DisplayName("Вход без пароля")
    @Epic(value = "Процесс входа в аккаунт")
    @Feature(value = "Окно ввода логина и пароля")
    @Story(value = "Отсутсвует пароль")
    @Description(value = "Попытка входа без введенного пароля с неправильным логином")
    @Severity(value = SeverityLevel.BLOCKER)
    public void IncorrectLoginNoPassword() {
        loginPage = new LoginPage();

        String login = "IncorrectLogin";
        String password = "";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noPasswordMessageExists());
    }

    @Test
    @DisplayName("Вход без пароля")
    @Epic(value = "Процесс входа в аккаунт")
    @Feature(value = "Окно ввода логина и пароля")
    @Story(value = "Отсутсвует пароль")
    @Description(value = "Попытка входа без введенного пароля с правильным логином")
    @Severity(value = SeverityLevel.BLOCKER)
    public void CorrectLoginNoPassword() {
        loginPage = new LoginPage();

        String login = "technoPol6";
        String password = "";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noPasswordMessageExists());
    }
}
