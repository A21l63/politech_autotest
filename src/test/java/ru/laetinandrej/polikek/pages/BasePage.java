package ru.laetinandrej.polikek.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;



public abstract class BasePage {
    public String pageUrl;
    String uniqueComponent;

    @Step("Открытие страницы")
    protected void openPage() {
        open(pageUrl);
    }

    @Step("Проверка страницы")
    abstract void checkPage();
}
