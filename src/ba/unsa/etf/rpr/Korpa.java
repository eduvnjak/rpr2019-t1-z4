package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Korpa {
    private List<Artikl> artikli = new ArrayList<>();

    public boolean dodajArtikl(Artikl a) {
        if(artikli.size() == 50){
            return false;
        }
        artikli.add(a);
        return true;
    }

    public Artikl[] getArtikli() {
        return artikli.toArray(new Artikl[0]);
    }



    public Artikl izbaciArtiklSaKodom(String kod) {
        for (Artikl a: artikli) {
            if(a.getKod().equals(kod)){
                artikli.remove(a);
                return a;
            }
        }
        return null;
    }

    public int dajUkupnuCijenuArtikala() {
        int suma = 0;
        for (Artikl a:
             artikli) {
            suma += a.getCijena();
        }
        return suma;
    }
}
