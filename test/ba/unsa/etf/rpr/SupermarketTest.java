package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void dodajArtikl() {
        Supermarket supermarket = new Supermarket();
        Artikl artikl = new Artikl("test" , 1, "kod");
        supermarket.dodajArtikl(artikl);
        assertEquals(supermarket.getArtikli().length, 1);
        Artikl artikl1 = supermarket.getArtikli()[0];
        assertEquals(artikl, artikl1);
    }
    @Test
    void dodajArtiklPun() {
        Supermarket supermarket = new Supermarket();
        for (int i = 0; i < 1000; i++) {
            supermarket.dodajArtikl(new Artikl("artikl" + i, i, "kod"+i));
        }
        PrintStream printStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        supermarket.dodajArtikl(new Artikl("artikl", 1, "kod"));
        assertEquals(outputStream.toString().trim(), "Supermarket je popunjen");
        System.setOut(printStream);
    }

    @Test
    void izbaciArtiklSaKodom() {
        Supermarket supermarket = new Supermarket();
        Artikl artikl = new Artikl("artikl1", 1, "kod1");
        supermarket.dodajArtikl(artikl);
        assertAll("izbaciArtikle",
                ()->assertNull(supermarket.izbaciArtiklSaKodom("kod")),
                ()->assertEquals(supermarket.izbaciArtiklSaKodom("kod1"), artikl),
                ()->assertEquals(supermarket.getArtikli().length, 0));

    }
}