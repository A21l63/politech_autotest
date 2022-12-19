package ru.laetinandrej.polikek.tests.loginTest;

import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoPasswordTest extends BaseTest {

    @Test
    public void IncorrectLoginNoPassword() {
        loginPage = new LoginPage();

        String login = "IncorrectLogin";
        String password = "";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noPasswordMessageExists());
    }

    @Test
    public void CorrectLoginNoPassword() {
        loginPage = new LoginPage();

        String login = "technoPol6";
        String password = "";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noPasswordMessageExists());
    }
}
