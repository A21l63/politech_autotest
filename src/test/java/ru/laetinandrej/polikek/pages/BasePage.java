package ru.laetinandrej.polikek.pages;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.source.tree.AssertTree;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasePage {
    public String PageUrl;
    String UniqueComponentXPath;

    protected void openPage() {
        open(PageUrl);
    }

    protected void checkPage() {
        assertTrue($(By.xpath(UniqueComponentXPath)).exists());
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), PageUrl);
    }
}
