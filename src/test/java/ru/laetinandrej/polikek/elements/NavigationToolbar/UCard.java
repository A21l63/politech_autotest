package ru.laetinandrej.polikek.elements.NavigationToolbar;

import org.openqa.selenium.By;
import ru.laetinandrej.polikek.elements.LogoutConfirmationWindow;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UCard {

    public final String InstanceXPath = "//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']";
    public final String LogoutButtonLoc = "//*[@class='lp' and @data-l = 't,logout']";

    public void openCard(){
        $(By.xpath(InstanceXPath)).shouldBe(visible).click();
    }


    public void logOutButtonClick(){
        $(By.xpath(LogoutButtonLoc)).shouldBe(visible).click();
    }
}
