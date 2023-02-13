package ru.laetinandrej.polikek.tests.loginTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidDataTest extends BaseTest {

    @ParameterizedTest
    @DisplayName("Вход с неправильными данными")
    @Epic(value = "Процесс входа в аккаунт")
    @Feature(value = "Окно ввода логина и пароля")
    @Story(value = "Некорректные данные")
    @Description(value = "Попытка входа с неправильным логином и/или паролем")
    @Severity(value = SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "IncorrectLogin, IncorrectPassword",
            "technoPol6, IncorrectPassword",
            "IncorrectLogin, technoPolis2022",
            "+7-800-555-35-3555, technoPolis2022"
        }
    )
    public void InvalidData(String login, String password) {
        loginPage = new LoginPage();
        loginPage.loginIn(login,password);
        assertTrue(loginPage.invalidDataMessageExists());
    }
}
