package ru.laetinandrej.polikek.testo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;




public class MonoidTest {
    private void LogginIn(String login, String password){
        $(By.name("st.email")).append(login);
        $(By.name("st.password")).append(password);
        $(by("value","Войти в Одноклассники")).click();
    }
    @Test
    public void OkLoginPageTest() {
        WebDriverManager.chromedriver().setup();

        String login = "dungeon";
        String password = "master";

        open("https://ok.ru/");
        LogginIn(login,password);
        $(byText("Неправильно указан логин и/или пароль")).should(exist);
    }
}

