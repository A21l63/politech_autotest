package ru.laetinandrej.polikek.tests.loginTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectDataTest extends BaseTest{
    @Test
    @DisplayName("Корректный вход")
    @Epic(value = "Процесс входа в аккаунт")
    @Feature(value = "Окно ввода логина и пароля")
    @Story(value = "Корректный вход")
    @Description(value = "Вход при корректных входных данных")
    @Severity(value = SeverityLevel.BLOCKER)
    public void CorrectLoginCorrectPassword() {
        loginPage = new LoginPage();

        String login = "technoPol6";
        String password = "technoPolis2022";

        loginPage.loginIn(login, password);
        // Проверка на успешность входа на страницу (появилась кнопка "Лента")
        assertTrue(loginPage.timeLineLocExists());
    }

    @AfterEach
    void LogOutIfNeeded() {
            loginPage.logOutIfNeeded();
    }
}

