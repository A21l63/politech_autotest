package ru.laetinandrej.polikek.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek.pages.FeedPage;
import ru.laetinandrej.polikek.pages.LoginPage;
import ru.laetinandrej.polikek.pages.UserPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class AddNoteAndCheckFeedTest extends BaseTest{


    @BeforeEach
    void init(){
        loginPage = new LoginPage();
        loginPage.correctLoginIn();
    }

    @Test
    @DisplayName("Добавление заметки с выбором фона")
    @Epic(value = "Заметки")
    @Story(value = "Корректное создание заметки")
    @Description(value = "Добавление заметки с выбором фона")
    @Severity(value = SeverityLevel.MINOR)
    void addNoteWithThemeAndCheckFeed() throws InterruptedException {
        String noteText = "Пусть лучше ногу жмет ботинок, чем руку айтишник \n Джейсон Стэтхэм";
        feedPage = new FeedPage();
        feedPage.openNoteWindow();
        feedPage.appendText(noteText);
        feedPage.chooseTheme();
        feedPage.postNote();

        TimeUnit.SECONDS.sleep(2);

        userPage = new UserPage();
        userPage.goToNotes();
        assertTrue(userPage.checkTimePoints(userPage.getTime()));
        //нужно реализовать удаление всех заметок, но мои полномочия уже все
        //userPage.deleteNotes(userPage.findPopUps());
    }

    @AfterEach
    void logOut(){
        loginPage.logOutIfNeeded();
    }
}
