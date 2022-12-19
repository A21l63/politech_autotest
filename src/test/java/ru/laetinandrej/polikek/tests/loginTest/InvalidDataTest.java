package ru.laetinandrej.polikek.tests.loginTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidDataTest extends BaseTest {

    @ParameterizedTest
    @CsvSource(value = {
            "IncorrectLogin, IncorrectPassword",
            "technoPol6, IncorrectPassword",
            "IncorrectLogin, technoPolis2022",
            "+7-800-555-35-3555, technoPolis2022"
        }
    )
    public void InvalidDataNoLogin(String login, String password) {
        loginPage = new LoginPage();
        loginPage.loginIn(login,password);
        assertTrue(loginPage.invalidDataMessageExists());
    }
}
