package ru.laetinandrej.polikek.elements.navigationToolbar;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ToolBar {
    private final UCard uCard;
    public ToolBar(){
        uCard = new UCard();
    }
    public void openUCard(){uCard.openCard();}
    public void uCardLogOutButtonClick(){uCard.logOutButtonClick();}
}
