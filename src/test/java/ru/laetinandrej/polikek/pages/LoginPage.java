package ru.laetinandrej.polikek.pages;

import org.openqa.selenium.By;
import ru.laetinandrej.polikek.elements.LogoutConfirmationWindow;
import ru.laetinandrej.polikek.elements.NavigationToolbar.UCard;
import ru.laetinandrej.polikek.tests.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    public final String InvalidDataMessage = "Неправильно указан логин и/или пароль";
    public final String NoLoginMessage = "Введите логин";
    public final String NoPasswordMessage = "Введите пароль";

    public final String LoginLoc = "//input[@class='it h-mod' and  @name='st.email']";
    public final String PasswordLoc = "//input[@id='field_password' or @name='st.password']";
    public final String LoginButtonLoc = "//input[@class='button-pro __wide' and @value='Войти в Одноклассники']";

    public final String TimeLineLoc = "//*[@class = 'nav-side_i-w']";
    public final String TopPanelLeftCorner = "//*[@id = 'topPanelLeftCorner']";

    public LoginPage(){
        PageUrl = "https://ok.ru/";
        UniqueComponentXPath = LoginButtonLoc;
        openPage();
        checkPage();
    }

    public void logOutIfNeeded() {
        UCard uCard = new UCard();
        uCard.openCard();
        uCard.logOutButtonClick();

        LogoutConfirmationWindow LogoutWindow = new LogoutConfirmationWindow();
        LogoutWindow.confirm();
    }
    public void logginIn(String login, String password){
        $(By.xpath(LoginLoc)).append(login);
        $(By.xpath(PasswordLoc)).append(password);
        $(By.xpath(LoginButtonLoc)).shouldBe(visible).click();
    }

    public boolean noLoginMessageExists(){
        return $(byText(NoLoginMessage)).exists();
    }

    public boolean noPasswordMessageExists() {
        return $(byText(NoPasswordMessage)).exists();
    }

    public boolean invalidDataMessageExists(){
        return $(byText(InvalidDataMessage)).exists();
    }

    public boolean timeLineLocExists(){
        return $(byText(TimeLineLoc)).exists();
    }
}
