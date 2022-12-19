package ru.laetinandrej.polikek.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhotoPage extends BasePage{
    public final String Uploaded_Photos = "//*[contains(@class, 'photo-img')]";
    public final String Exit_From_Photo_Button = "//*[@class = 'control__4rmea']";

    public PhotoPage(){
        pageUrl = "https://ok.ru/profile/586899577999/photos";
        uniqueComponent = "Все фото";
        openPage();
        checkPage();
    }
    @Override
    public void checkPage(){
        assertTrue($(byText(uniqueComponent)).exists());
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), pageUrl);
    }

    public boolean checkAnyPhotosExist(){
        return $(By.xpath(Uploaded_Photos)).exists();
    }

    public ElementsCollection getPhotos(){
        return $$(By.xpath(Uploaded_Photos));
    }

    public void deleteAllPhotos(ElementsCollection photos){
        for(SelenideElement element: photos){
            element.click();
            $(byText("Ещё")).shouldBe(Condition.visible).click();
            $(byText("Удалить фотографию")).shouldBe(Condition.visible).click();
            $(By.xpath(Exit_From_Photo_Button)).shouldBe(Condition.visible).click();
        }
    }
}
