package DziałDruku;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;

import java.util.HashMap;

public class DziałDruku  {

    private Drukarnie pierwszaZwykłaDrukarnia = new ZwykłaDrukarnia(100);
    private Drukarnie drugaZwykłaDrukarnia = new ZwykłaDrukarnia(200);
    private Drukarnie lepszaDrukarnia = new LepszaDrukarnia(150);
    private Drukarnie wybranaDrukarnia = pierwszaZwykłaDrukarnia;

    public static boolean czyJestWybranaNajlepszaDrukarnia;

    public String getAktualnaDrukarnia() {
        return aktualnaDrukarnia;
    }

    private String aktualnaDrukarnia = "Zwykla Drukarnia 1";

    public void wybierzDrukarnie(int wybor) {
        if(wybor == 3) {
            czyJestWybranaNajlepszaDrukarnia = true;
        } else {
            czyJestWybranaNajlepszaDrukarnia = false;
        }

        switch (wybor) {
            case 1 -> wybranaDrukarnia = pierwszaZwykłaDrukarnia;
            case 2 -> wybranaDrukarnia = drugaZwykłaDrukarnia;
            case 3 -> wybranaDrukarnia = lepszaDrukarnia;
        }
        switch (wybor) {
            case 1 -> aktualnaDrukarnia = "Zwykla Drukarnia 1";
            case 2 -> aktualnaDrukarnia = "Zwykla Drukarnia 2";
            case 3 -> aktualnaDrukarnia = "Drukarnia Wszystkiego";
        }
    }
    public void zlecDrukowanie( Ksiązka ks, int iloscSztuk) {
        wybranaDrukarnia.zacznijDrukować(ks, iloscSztuk);
    }
    public void zlecDrukowanie(Czasopismo cz, int iloscSztuk) {
        wybranaDrukarnia.zacznijDrukować(cz, iloscSztuk);
    }
    public String pokazCoAktualnieSieProdukuje() {
        String zwracany = "";
        zwracany += wybranaDrukarnia.wypiszCoAktualnieSięProdukuje();
        return zwracany;
    }
    public String pokazWydrukowanePozycje() {
        String zwracany = "";
        zwracany += wybranaDrukarnia.wypiszWydykowanePozycje();
        return zwracany;
    }
    public String pokazKolejkeDrukowania() {
        String zwracany = "";
        zwracany += wybranaDrukarnia.wypiszKolejkeDrukowania();
        return zwracany;
    }

}
