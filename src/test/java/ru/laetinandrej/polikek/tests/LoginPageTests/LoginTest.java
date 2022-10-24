package ru.laetinandrej.polikek.tests.LoginPageTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest extends LoginPage{

    @Test
    public void NoLoginIncorrectPassword() {
        String login = "";
        String password = "IncorrectPassword";

        LogginIn(login, password);

        $(byText(NoLoginMessage)).should(exist);
    }

    @Test
    public void IncorrectLoginNoPassword() {
        String login = "IncorrectLogin";
        String password = "";

        LogginIn(login, password);

        $(byText(NoPasswordMessage)).should(exist);
    }

    @Test
    public void NoLoginCorrectPassword() {
        String login = "";
        String password = "technoPolis2022";

        LogginIn(login, password);

        $(byText(NoLoginMessage)).should(exist);
    }

    @Test
    public void CorrectLoginNoPassword() {
        String login = "technoPol6";
        String password = "";

        LogginIn(login, password);

        $(byText(NoPasswordMessage)).should(exist);
    }

    @Test
    public void IncorrectLoginIncorrectPassword() {
        String login = "IncorrectPassword";
        String password = "IncorrectLogin";

        LogginIn(login,password);

        $(byText(InvalidDataMessage)).should(exist);
    }

    @Test
    public void CorrectLoginIncorrectPassword() {
        String login = "IncorrectLogin";
        String password = "IncorrectPassword";

        LogginIn(login, password);

        $(byText(InvalidDataMessage)).should(exist);
    }

    @Test
    public void IncorrectLoginCorrectPassword() {
        String login = "IncorrectLogin";
        String password = "technoPolis2022";

        LogginIn(login, password);

        $(byText(InvalidDataMessage)).should(exist);
    }

    @Test
    public void CorrectLoginCorrectPassword() {
        String login = "technoPol6";
        String password = "technoPolis2022";

        LogginIn(login, password);
        // Проверка на успешность входа на страницу (появилась кнопка "Лента")
        $(By.xpath(LoginLocators.timeLineLoc)).should(exist);

        LogOut();
    }

    @Test
    public void IncorrectPhoneNumber() {
        //Фронт не дает возможности ввести логин длиннее заданных ограничений
        String phoneNumber = "+7-800-555-35-35";
        String password = "technoPolis2022";

        LogginIn(phoneNumber, password);

        $(byText(InvalidDataMessage)).should(exist);
    }
}

