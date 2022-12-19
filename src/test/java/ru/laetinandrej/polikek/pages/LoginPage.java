package ru.laetinandrej.polikek.pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import ru.laetinandrej.polikek.elements.LoginInWindow;
import ru.laetinandrej.polikek.elements.LogoutConfirmationWindow;
import ru.laetinandrej.polikek.elements.navigationToolbar.ToolBar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage{

    public final String Invalid_Data_Message = "Неправильно указан логин и/или пароль";
    public final String No_Login_Message = "Введите логин";
    public final String No_Password_Message = "Введите пароль";
    public final String Time_Line_Loc = "//*[@class = 'nav-side_i-w']";
    public final String Top_Panel_Left_Corner = "//*[@id = 'topPanelLeftCorner']";
    public final String Saved_Profile_Login_Page = "https://ok.ru/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose";
    public final String Saved_Profile_Exit_Button = "//*[contains(@class, 'user-profile-redesign_delete-icon')]";
    LoginInWindow logWindow;

    public LoginPage(){
        pageUrl = "https://ok.ru/";
        logWindow = new LoginInWindow();
        uniqueComponent = logWindow.LoginButtonLoc;
        openPage();
        checkPage();
    }

    @Override
    public void checkPage(){
        if(!WebDriverRunner.getWebDriver().getCurrentUrl().equals(pageUrl)){
            logOutIfNeeded();
        }
        assertTrue($(By.xpath(uniqueComponent)).exists());
    }
    public void logOutIfNeeded() {
        if (!WebDriverRunner.getWebDriver().getCurrentUrl().equals(pageUrl)){
            openPage();
        }
        if ($(By.xpath(Top_Panel_Left_Corner)).exists()) {
            ToolBar toolBar = new ToolBar();
            toolBar.openUCard();
            toolBar.uCardLogOutButtonClick();

            LogoutConfirmationWindow LogoutWindow = new LogoutConfirmationWindow();
            LogoutWindow.confirm();
        }
        if (WebDriverRunner.getWebDriver().getCurrentUrl().equals(Saved_Profile_Login_Page)){
            if (!$(By.xpath(logWindow.LoginButtonLoc)).exists()) {
                $(By.xpath(Saved_Profile_Exit_Button)).shouldBe(visible).click();
            }
        }
    }
    public void loginIn(String login, String password){
        logWindow.appendLogin(login);
        logWindow.appendPassword(password);
        logWindow.acceptLoginIn();
    }

    public boolean noLoginMessageExists(){
        return $(byText(No_Login_Message)).exists();
    }

    public boolean noPasswordMessageExists() {
        return $(byText(No_Password_Message)).exists();
    }

    public boolean invalidDataMessageExists(){
        return $(byText(Invalid_Data_Message)).exists();
    }

    public boolean timeLineLocExists(){
        return $(By.xpath(Time_Line_Loc)).exists();
    }



    public void correctLoginIn(){
        loginIn("technoPol6","technoPolis2022");
    }
}
