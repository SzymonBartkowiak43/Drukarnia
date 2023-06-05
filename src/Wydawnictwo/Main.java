package Wydawnictwo;

import DziałHandlu.*;
import DziałProgramowy.Autor;

public class Main extends Thread {
    public static void main(String[] args) {

        ListaDostepnychKsiazekDoDrukowania.StartoweKsiazki();
        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

        Ksiązka ksiazka1 = new Romanse("Dis nie mile widziany", autor1 , 23.4, 123);
        Ksiązka ksiazka2 = new Romanse("Ania zielone gory", autor1 , 23.4, 123);
        Ksiązka ksiazka3 = new Romanse("Szalone koty ida do roboty", autor1 , 23.4, 123);

        Czasopismo czasopismo1 = new Tygodnik("Chwila dla cb", autor1, 1,10.00);
        Czasopismo czasopismo2 = new Tygodnik("Chwila dla cb", autor1, 2,10.00);
        Czasopismo czasopismo3 = new Tygodnik("Chwila dla cb", autor1, 3,10.00);


        Sklep.dodajPozycje(ksiazka1,200);
        Sklep.dodajPozycje(ksiazka1,200);
        Sklep.dodajPozycje(ksiazka2,100);
        Sklep.dodajPozycje(ksiazka3,300);

        Sklep.dodajPozycje(czasopismo1,100);
        Sklep.dodajPozycje(czasopismo1,300);
        Sklep.dodajPozycje(czasopismo2,30);
        Sklep.dodajPozycje(czasopismo3,100);

        Sklep.wyswietlZawartoscSklepu();

        new Frame();
    }
}
