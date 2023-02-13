package ru.laetinandrej.polikek.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.elements.NavigationMenu;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.pages.PhotoPage;
import ru.laetinandrej.polikek.pages.UserPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UploadPhotoTest extends BaseTest{
    @BeforeEach
    void init(){
        loginPage = new LoginPage();
        loginPage.correctLoginIn();
    }

    @Test
    @DisplayName("Добавление фотографии")
    @Epic(value = "Фотографии")
    @Feature(value = "Добавление фотографии")
    @Description(value = "Добавление фотографии и последующим удалением оной")
    @Severity(value = SeverityLevel.NORMAL)
    void addPhotoAndDeleteAfter() throws InterruptedException {
        userPage = new UserPage();

        userPage.uploadPhoto(userPage.AufPhotoPath);

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
