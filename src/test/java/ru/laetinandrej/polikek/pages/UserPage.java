package ru.laetinandrej.polikek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import ru.laetinandrej.polikek.elements.NavigationMenu;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserPage extends BasePage{
    public final String Photo_Upload_Xpath = "//*[@class = 'html5-upload-link' and @name='photo']";
    public final String Note_Time = "//*[@class = 'feed_date']";
    public final String Popup_Tabs = "//*[@class = 'new_topic_icodown']";
    public final String Delete_Button = "//*[contains(@href, 'profile')]";
    public final String AufPhotoPath = "src/test/resources/img/auf.jpg";
    public UserPage(){
        pageUrl = "https://ok.ru/profile/586899577999";
        uniqueComponent = "Вся информация";
        openPage();
        checkPage();
    }

    @Override
    public void checkPage(){
        assertTrue($(byText(uniqueComponent)).exists());
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), pageUrl);
    }

    @Step("Переход на страницу заметок")
    public void goToNotes(){
        NavigationMenu navigationMenu = new NavigationMenu();
        navigationMenu.selectNoteTab();
    }


    public List<String> getTime(){
        return $$(By.xpath(Note_Time)).texts();
    }

    @Step("Проверка успешности создания заметки")
    public boolean checkTimePoints(List<String> points) {
        DateTime time = DateTime.now();
        int minutes = time.getMinuteOfHour();
        for (String elem : points) {
            String mnts = elem.split(":")[1];
            // вот тут нужно придумать метрику получше, но должно работать, если в hh:59 минут не запускать
            if (Math.abs(minutes - Integer.parseInt(mnts)) < 2) return true;
        }
        return false;
    }
    public ElementsCollection findPopUps(){
        return $$(By.xpath(Popup_Tabs));
    }

    public void deleteNotes(ElementsCollection popUps){
        for(SelenideElement element: popUps){
            System.out.println("Жизнь - тлен");
            actions().moveToElement(element).click();
            $(byText("Удалить")).click();
        }
    }

    @Step("Загрузка фото")

    public void uploadPhoto(String path){
        $(By.xpath(Photo_Upload_Xpath)).
                uploadFile(new File(path));
    }
}

