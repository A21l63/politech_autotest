package ru.laetinandrej.polikek.elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LogoutConfirmationWindow {
    public final String LogoutConfirmButtonLoc = "//*[@data-l='t,logout' and @type='submit']";
    public final String CancelConfirmButtonLoc = "//*[@data-l='t,close' and @type='submit']";

    public void confirm(){
        $(By.xpath(LogoutConfirmButtonLoc)).shouldBe(visible).click();
    }

    public void cancel(){
        $(By.xpath(CancelConfirmButtonLoc)).shouldBe(visible).click();
    }
}
