package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private List<Artikl> artikli = new ArrayList<>();

    public void dodajArtikl(Artikl artikl) {
        if(artikli.size() == 1000){
            System.out.println("Supermarket je popunjen");
            return;
        }
        artikli.add(artikl);
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
}
