package Wydawnictwo;

import DziałHandlu.*;
import DziałProgramowy.Autor;
import DziałProgramowy.TymczasowiAutorzy;
import DziałProgramowy.ZatrudnieniAutorzy;

public class Main extends Thread {
    public static void main(String[] args) {

        ListaDostepnychKsiazekDoDrukowania.StartoweKsiazki();
        TymczasowiAutorzy.Autorzy();
        ZatrudnieniAutorzy.Zatrudnieni();
        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

        Ksiązka ksiazka1 = new Romanse("Dis nie mile widziany", autor1 , 23.4, 123);
        Ksiązka ksiazka2 = new Romanse("Ania zielone gory", autor1 , 23.4, 123);
        Ksiązka ksiazka3 = new Romanse("Szalone koty ida do roboty", autor1 , 23.4, 123);

        Ksiązka ksiazka4 = new Sensacyjne("Alibaba i 40 rozbojnikow", autor1,30.2,134);

        Ksiązka ksiazka5 = new Album("Album rodziny Adamsow", autor1,100.2,13);

        Czasopismo czasopismo1 = new Tygodnik("Chwila dla cb 1", autor1, 1,10.00);
        Czasopismo czasopismo2 = new Tygodnik("Chwila dla cb 2", autor1, 2,10.00);
        Czasopismo czasopismo3 = new Tygodnik("Chwila dla cb 3", autor1, 3,10.00);

        Czasopismo czasopismo4 = new Miesięczniki("CDAction 1 ", autor1, 1,10.00);
        Czasopismo czasopismo5 = new Kwartalnik("Mazurki i nie tylko 1", autor1, 1,10.00);


        MagazynSklepu.dodajPozycje(ksiazka1,200);
        MagazynSklepu.dodajPozycje(ksiazka1,200);
        MagazynSklepu.dodajPozycje(ksiazka2,100);
        MagazynSklepu.dodajPozycje(ksiazka3,300);
        MagazynSklepu.dodajPozycje(ksiazka4,10);
        MagazynSklepu.dodajPozycje(ksiazka5,12);


        MagazynSklepu.dodajPozycje(czasopismo1,100);
        MagazynSklepu.dodajPozycje(czasopismo1,300);
        MagazynSklepu.dodajPozycje(czasopismo2,30);
        MagazynSklepu.dodajPozycje(czasopismo3,100);
        MagazynSklepu.dodajPozycje(czasopismo4,20);
        MagazynSklepu.dodajPozycje(czasopismo5,40);

        MagazynSklepu.wyswietlZawartoscSklepu();

        new Frame();
    }
}
