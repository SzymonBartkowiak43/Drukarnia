package DziałDruku;

import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) {


        DziałDruku działDruku = new DziałDruku();
        Scanner scanner = new Scanner(System.in);
        boolean mozna = true;
        String ksiazka;

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
                    działDruku.zlecDrukowanie(ksiazka, 100);
                }
                case 2 -> działDruku.pokazCoAktualnieSieProdukuje();
                case 3 -> działDruku.pokazKolejkeDrukowania();
                case 4 -> działDruku.pokazWydrukowanePozycje();
                case 5 -> działDruku.wybierzDrukarnie();

            }
        }

















    }
}
