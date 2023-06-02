package DziałDruku;

import DziałHandlu.Ksiązka;
import DziałHandlu.Romanse;
import DziałProgramowy.Autor;

import java.util.Scanner;

public class ZarządzanieDziałemDruku { //Nic nie robi do wywalenia
    String coSieProdukuje;
    private DziałDruku działDruku = new DziałDruku();
    private Scanner scanner = new Scanner(System.in);
    private String ksiazka;
    private int ileSztuk;
    private Autor autor1 = new Autor("Cezary", "Babik", 6.2, 4572);
    private  Ksiązka romans = new Romanse("Ania", autor1, 19.00, 200);

    public void zarzadzanie() {
        boolean mozna = true;

        while(mozna)
        {
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
                case 2 -> coSieProdukuje = działDruku.pokazCoAktualnieSieProdukuje();
                case 3 -> działDruku.pokazKolejkeDrukowania();
                case 4 -> działDruku.pokazWydrukowanePozycje();
                case 5 -> działDruku.wybierzDrukarnie(1);
            }
        }
    }
}
