package ru.laetinandrej.polikek.elements.navigationToolbar;

public class ToolBar {
    private final UCard uCard;
    public ToolBar(){
        uCard = new UCard();
    }
    public void openUCard(){uCard.openCard();}
    public void uCardLogOutButtonClick(){uCard.logOutButtonClick();}
}
