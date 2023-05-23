package DziałDruku;

import java.util.Scanner;

public class DziałDruku  {


    private Drukarnie pierwszaZwykłaDrukarnia = new ZwykłaDrukarnia();
    private Drukarnie drugaZwykłaDrukarnia = new ZwykłaDrukarnia();


    private Drukarnie wybranaDrukarnia = pierwszaZwykłaDrukarnia;

    public void wybierzDrukarnie() {
        System.out.println("Którą drukarnie chcesz wbrac? 1 - pierwsza Drukarnia, 2 - druga Drukarnia");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch (wybor) {
            case 1 -> wybranaDrukarnia = pierwszaZwykłaDrukarnia;
            case 2 -> wybranaDrukarnia = drugaZwykłaDrukarnia;
        }
    }
    public void zlecDrukowanie( String nazwaKsiazki, int iloscSztuk) {
        wybranaDrukarnia.zacznijDrukowaćKsiążke(nazwaKsiazki, iloscSztuk);
    }
    public void pokazCoAktualnieSieProdukuje() {
        wybranaDrukarnia.wypiszCoAktualnieSięProdukuje();
    }
    public void pokazWydrukowanePozycje() {
        wybranaDrukarnia.wypiszWydykowanePozycje();
    }
    public void pokazKolejkeDrukowania() {
        wybranaDrukarnia.wypiszKolejkeDrukowania();
    }
}
