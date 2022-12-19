package ru.laetinandrej.polikek.tests.LoginTest;

import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoLogin extends BaseTest {
    @Test
    public void NoLoginIncorrectPassword() {
        logPage = new LoginPage();

        String login = "";
        String password = "IncorrectPassword";

        logPage.logginIn(login, password);

        assertTrue(logPage.noLoginMessageExists());
    }

    @Test
    public void NoLoginCorrectPassword() {
        logPage = new LoginPage();

        String login = "";
        String password = "technoPolis2022";

        logPage.logginIn(login, password);

        assertTrue(logPage.noLoginMessageExists());
    }

}
