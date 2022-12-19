package ru.laetinandrej.polikek.tests.loginTest;

import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoLoginTest extends BaseTest {
    @Test
    public void NoLoginIncorrectPassword() {
        loginPage = new LoginPage();

        String login = "";
        String password = "IncorrectPassword";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noLoginMessageExists());
    }

    @Test
    public void NoLoginCorrectPassword() {
        loginPage = new LoginPage();

        String login = "";
        String password = "technoPolis2022";

        loginPage.loginIn(login, password);

        assertTrue(loginPage.noLoginMessageExists());
    }

}
