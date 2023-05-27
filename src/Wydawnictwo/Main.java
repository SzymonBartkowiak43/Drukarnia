package Wydawnictwo;

import DziałDruku.DziałDruku;
import DziałHandlu.Ksiązka;
import DziałHandlu.Romanse;
import DziałProgramowy.Autor;

import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) {

        DziałDruku działDruku = new DziałDruku();
        Scanner scanner = new Scanner(System.in);
        boolean mozna = true;
        String ksiazka;
        int ileSztuk;
        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);
        Ksiązka romans = new Romanse("Ania",autor1,19.00,200);



        while (mozna) {
            System.out.println("1 - zlec Drukowanie, 2 - pokaż co aktualnie sie produkuje, 3 - pokazKolejkeDrukowania" +
                    " 4 - wypisz wydrukowane pozycje gotowe do odbiru, 5 - wybierz drukarnie");
            int wyb = scanner.nextInt();
            switch (wyb) {
                case 0 -> mozna = false;
                case 1 -> {
                    System.out.println("Podaj tytul ksiazki: ");
                    ksiazka = scanner.nextLine();
                    ksiazka = scanner.nextLine();
                    System.out.println("Podaj ile sztuk wydrukować: ");
                    ileSztuk = scanner.nextInt();

                    działDruku.zlecDrukowanie(romans, ileSztuk);
                }
                case 2 -> działDruku.pokazCoAktualnieSieProdukuje();
                case 3 -> działDruku.pokazKolejkeDrukowania();
                case 4 -> działDruku.pokazWydrukowanePozycje();
                case 5 -> działDruku.wybierzDrukarnie();
            }
        }
    }
}
