package ru.laetinandrej.polikek.tests.LoginTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidData extends BaseTest {

    @ParameterizedTest
    @CsvSource(value = {
            "IncorrectLogin, IncorrectPassword",
            "technoPol6, IncorrectPassword",
            "IncorrectLogin, technoPolis2022",
            "+7-800-555-35-3555, technoPolis2022"
        }
    )
    public void InvalidDataNoLogin(String login, String password) {
        logPage = new LoginPage();
        logPage.logginIn(login,password);
        assertTrue(logPage.invalidDataMessageExists());
    }
}
