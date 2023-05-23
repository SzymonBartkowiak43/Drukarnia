package DziałDruku;

import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) {



        DziałDruku działDruku = new DziałDruku();
        Scanner scanner = new Scanner(System.in);
        boolean mozna = true;
        String ksiazka;

        while (mozna) {
            System.out.println("1 - zlec Drukowanie, 2 - pokaż co aktualnie sie produkuje, 3 - pokazKolejkeDrukowania");
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

            }
        }


//        działDruku.zlecDrukowanie("Ania", 100);
//
//        działDruku.zlecDrukowanie("Aniaaa", 1000);
//
//        działDruku.pokazCoAktualnieSieProdukuje();

















    }
}


//=======
//import DziałHandlu.Ksiązka;
//import DziałHandlu.Album;
//import DziałHandlu.Czasopismo;
//import DziałHandlu.Tygoniki;
//import DziałHandlu.Sensacyjne;
//import DziałHandlu.Miesięczniki;
//import DziałHandlu.DziałHandlowy;
//public class Main {
//    public static void main(String[] args) {
//        DziałHandlowy dzialHandlowy = new DziałHandlowy();
//
//        Autor autor1 = new Autor("Szymon", "Bartkowiak", 6.3, 4632);
//        Autor autor2 = new Autor("Cezary", "Babik", 5.6, 1462);
//
//        Ksiązka sensacyjna = new Sensacyjne("Poradnik jak nie wbic globala", autor2, 67.1, 165);
//>>>>>>> fcaee1f8bc783500da846a05cf303578aef97279
//
//        Czasopismo tygodnik = new Tygoniki("Tygodnik Białkowy", autor1, 1435, 5);
//        Czasopismo miesiecznik = new Miesięczniki("Miesięcznik ", autor2, 314, 10);
//
//        dzialHandlowy.dodajPozycje(sensacyjna);
//        dzialHandlowy.dodajPozycje(tygodnik);
//        dzialHandlowy.dodajPozycje(miesiecznik);
//
//        dzialHandlowy.pokazKatalog();
//    }
//