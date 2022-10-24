package ru.laetinandrej.polikek.tests.NoSelenideBasicTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek_testo.Main;

public class MainTests {
    @Test
    public void fooTestFalse() {
        Main oops = new Main();
        Assertions.assertNotEquals("as", oops.foo());
    }
    @Test
    public void fooTestTrue() {
        Main oops = new Main();
        Assertions.assertEquals("as we can", oops.foo());
    }
}
