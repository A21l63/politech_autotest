package ru.laetinandrej.polikek.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.laetinandrej.polikek.elements.NavigationMenu;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.pages.PhotoPage;
import ru.laetinandrej.polikek.pages.UserPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UploadPhotoTest extends BaseTest{
    @BeforeEach
    void init(){
        loginPage = new LoginPage();
        loginPage.correctLoginIn();
    }

    @Test
    void addNoteWithThemeAndCheckFeed() throws InterruptedException {
        userPage = new UserPage();
        $(By.xpath(userPage.Photo_Upload_Xpath)).
                uploadFile(new File("src/test/resources/img/auf.jpg"));

        NavigationMenu navigationMenu = new NavigationMenu();
        navigationMenu.selectPhoto_Tab();

        TimeUnit.SECONDS.sleep(2);

        photoPage = new PhotoPage();
        photoPage.checkAnyPhotosExist();

        assertTrue(photoPage.checkAnyPhotosExist());
    }

    @AfterEach
    void finalise(){
        photoPage.deleteAllPhotos(photoPage.getPhotos());

        loginPage.logOutIfNeeded();
    }
}
