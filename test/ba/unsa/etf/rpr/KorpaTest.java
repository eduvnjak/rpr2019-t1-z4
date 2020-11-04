package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    /*@BeforeEach
    void setUp() {
    }*/

    @Test
    void dodajArtikl1() {
        Korpa korpa = new Korpa();
        Artikl artikl = new Artikl("test" , 1, "kod");
        assertTrue(korpa.dodajArtikl(artikl));
        Artikl artikl1 = korpa.getArtikli()[0];
        assertEquals(artikl, artikl1);
    }
    @Test
    void dodajArtikl2() {
        Korpa korpa = new Korpa();
        for (int i = 0; i < 50; i++) {
            korpa.dodajArtikl(new Artikl("artikl " + i, i , "kod" + i));
        }
        assertFalse(korpa.dodajArtikl(new Artikl("artikl", 1, "test")));
        Artikl posljednji = korpa.getArtikli()[49];
        assertAll("testDodajArtikl",
                ()->assertEquals(posljednji.getNaziv(), "artikl 49"),
                ()->assertEquals(posljednji.getCijena(), 49),
                ()->assertEquals(posljednji.getKod(), "kod49"));
    }

    @Test
    void getArtikli() {
    }

    @Test
    void izbaciArtiklSaKodom() {
        Korpa korpa = new Korpa();
        Artikl artikl = new Artikl("artikl1", 1, "kod1");
        korpa.dodajArtikl(artikl);
        assertAll("izbaciArtikle",
                ()->assertNull(korpa.izbaciArtiklSaKodom("kod")),
                ()->assertEquals(korpa.izbaciArtiklSaKodom("kod1"), artikl),
                ()->assertEquals(korpa.getArtikli().length, 0));
    }

    @Test
    void dajUkupnuCijenuArtikala1() {
        Korpa korpa = new Korpa();
        for (int i = 0; i < 10; i++) {
            korpa.dodajArtikl(new Artikl("artikl " + i+1, i+1, "" + i + 1 ));
        }
        assertEquals(korpa.dajUkupnuCijenuArtikala(), 55);
    }
    @Test
    void dajUkupnuCijenuArtikala2() {
        Korpa korpa = new Korpa();
        assertEquals(korpa.dajUkupnuCijenuArtikala(), 0);
    }
}