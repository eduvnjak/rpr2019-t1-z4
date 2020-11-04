package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtiklTest {
    Artikl artikl = new Artikl("naziv", 1 , "kod");
    @Test
    void getNaziv() {
        assertEquals(artikl.getNaziv(), "naziv");
    }

    @Test
    void getKod() {
        assertEquals(artikl.getKod(), "kod");
    }

    @Test
    void getCijena() {
        assertEquals(artikl.getCijena(),1);
    }
}