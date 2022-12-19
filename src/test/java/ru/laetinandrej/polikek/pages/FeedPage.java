package ru.laetinandrej.polikek.pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeedPage extends BasePage{
    private final String Note_Field = "//*[@class= 'pf-head_itx_a']";
    private final String Auf_Quote_Theme = "//*[@data-decorator-id = '103']";
    private final String Text_Field = "//*[@data-module='postingForm/mediaText']";
    private final String Note_Submit_Button = "//*[@data-save = 'Сохранить']";

    public FeedPage(){
        pageUrl = "https://ok.ru/feed";
        uniqueComponent = "//*[@class='main-feed portlet']";
        openPage();
        checkPage();
    }
    @Override
    public void checkPage(){
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), pageUrl);
        assertTrue($(By.xpath(uniqueComponent)).exists());
    }

    public void openNoteWindow(){
        $(By.xpath(Note_Field)).shouldBe(visible).click();
    }

    public void appendText(String noteText){
        $(By.xpath(Text_Field)).shouldBe(visible).append(noteText);
    }

    public void chooseTheme(){
        $(By.xpath(Auf_Quote_Theme)).shouldBe(visible).click();
    }

    public void postNote(){
        $(By.xpath(Note_Submit_Button)).shouldBe(visible).click();
    }
}
