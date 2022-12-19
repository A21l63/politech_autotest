package ru.laetinandrej.polikek.tests.loginTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectDataTest extends BaseTest{
    @Test
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

