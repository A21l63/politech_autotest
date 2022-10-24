package ru.laetinandrej.polikek.testo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.laetinandrej.polikek_testo.Main;

public class MainTests {
    @Test
    public void fooTestFalse() {
        Main oops = new Main();
        Assertions.assertEquals("ass we can", oops.foo());
    }
    @Test
    public void fooTestTrue() {
        Main oops = new Main();
        Assertions.assertEquals("ass", oops.foo());
    }
}
