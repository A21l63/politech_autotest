package ru.laetinandrej.polikek.elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {
    public final String Photo_Tab = "//*[contains(@data-l, 'userPhotos')]";
    public final String Note_Tab = "//*[contains(@data-l, 'userStatuses')]";
    public void selectPhoto_Tab(){
        $(By.xpath(Photo_Tab)).shouldBe(visible).click();
    }
    public void selectNoteTab(){
        $(By.xpath(Note_Tab)).shouldBe(visible).click();
    }
}
