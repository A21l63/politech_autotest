package ru.laetinandrej.polikek.tests.LoginTest;

import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoPassword extends BaseTest {

    @Test
    public void IncorrectLoginNoPassword() {
        logPage = new LoginPage();

        String login = "IncorrectLogin";
        String password = "";

        logPage.logginIn(login, password);

        assertTrue(logPage.noPasswordMessageExists());
    }

    @Test
    public void CorrectLoginNoPassword() {
        logPage = new LoginPage();

        String login = "technoPol6";
        String password = "";

        logPage.logginIn(login, password);

        assertTrue(logPage.noPasswordMessageExists());
    }
}
