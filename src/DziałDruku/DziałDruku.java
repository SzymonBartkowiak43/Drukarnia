package DziałDruku;

import DziałHandlu.Ksiązka;

import java.util.Scanner;

public class DziałDruku  {

    private Drukarnie pierwszaZwykłaDrukarnia = new ZwykłaDrukarnia(100);
    private Drukarnie drugaZwykłaDrukarnia = new ZwykłaDrukarnia(200);
    private Drukarnie lepszaDrukarnia = new LepszaDrukarnia(150);
    private Drukarnie wybranaDrukarnia = pierwszaZwykłaDrukarnia;

    public String getAktualnaDrukarnia() {
        return aktualnaDrukarnia;
    }

    private String aktualnaDrukarnia = "Pierwsza zwykla drukarnia";

    public void wybierzDrukarnie(int wybor) {
        switch (wybor) {
            case 1 -> wybranaDrukarnia = pierwszaZwykłaDrukarnia;
            case 2 -> wybranaDrukarnia = drugaZwykłaDrukarnia;
            case 3 -> wybranaDrukarnia = lepszaDrukarnia;
        }
        switch (wybor) {
            case 1 -> aktualnaDrukarnia = "Pierwsza zwykla drukarnia";
            case 2 -> aktualnaDrukarnia = "Druga zwykla drukarnia";
            case 3 -> aktualnaDrukarnia = "Lepsza drukarnia";
        }
    }
    public void zlecDrukowanie( Ksiązka ks, int iloscSztuk) {
        wybranaDrukarnia.zacznijDrukowaćKsiążke(ks, iloscSztuk);
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
