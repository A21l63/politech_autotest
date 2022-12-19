package ru.laetinandrej.polikek.pages;

import static com.codeborne.selenide.Selenide.open;



public abstract class BasePage {
    public String pageUrl;
    String uniqueComponent;

    protected void openPage() {
        open(pageUrl);
    }

    abstract void checkPage();
}
