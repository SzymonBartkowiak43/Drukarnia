package DziałDruku;

import DziałHandlu.Ksiązka;

import java.util.Scanner;

public class DziałDruku  {

    private Drukarnie pierwszaZwykłaDrukarnia = new ZwykłaDrukarnia(100);
    private Drukarnie drugaZwykłaDrukarnia = new ZwykłaDrukarnia(200);
    private Drukarnie lepszaDrukarnia = new LepszaDrukarnia(150);
    private Drukarnie wybranaDrukarnia = pierwszaZwykłaDrukarnia;

    public void wybierzDrukarnie() {
        System.out.println("Którą drukarnie chcesz wbrac? 1 - pierwsza Drukarnia, 2 - druga Drukarnia, 3 - lepsza Drukarnia");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch (wybor) {
            case 1 -> wybranaDrukarnia = pierwszaZwykłaDrukarnia;
            case 2 -> wybranaDrukarnia = drugaZwykłaDrukarnia;
            case 3 -> wybranaDrukarnia = lepszaDrukarnia;
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
    public void pokazWydrukowanePozycje() {
        wybranaDrukarnia.wypiszWydykowanePozycje();
    }
    public void pokazKolejkeDrukowania() {
        wybranaDrukarnia.wypiszKolejkeDrukowania();
    }
}
