package DziałDruku;

import java.util.HashMap;

public class DziałDruku  {

    private Drukarnie pierwszaZwykłaDrukarnia = new ZwykłaDrukarnia();

    public void zlecDrukowanie(String nazwaKsiazki, int iloscSztuk) {
        pierwszaZwykłaDrukarnia.zacznijDrukować(nazwaKsiazki, iloscSztuk);
    }

    public void pokazCoAktualnieSieProdukuje() {
        pierwszaZwykłaDrukarnia.wypiszCoAktualnieSięProdukuje();
    }
    public void pokazKsiazkiGotoweDoTransportu() {

    }
    public void pokazKolejkeDrukowania() {
        pierwszaZwykłaDrukarnia.wypiszKolejkeDrukowania();
    }
}
