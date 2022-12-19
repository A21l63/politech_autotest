package ru.laetinandrej.polikek.tests.LoginTest;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectData extends BaseTest{
    @Test
    public void CorrectLoginCorrectPassword() {
        logPage = new LoginPage();

        String login = "technoPol6";
        String password = "technoPolis2022";

        logPage.logginIn(login, password);
        // Проверка на успешность входа на страницу (появилась кнопка "Лента")
        assertTrue(logPage.timeLineLocExists());
    }

    @AfterEach
    void LogOutIfNeeded() {
        if (!WebDriverRunner.getWebDriver().getCurrentUrl().equals(logPage.PageUrl) || $(By.xpath(logPage.TopPanelLeftCorner)).exists()) {
            logPage.logOutIfNeeded();
        }
    }
}

