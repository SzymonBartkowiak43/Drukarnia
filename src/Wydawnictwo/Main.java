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

        Ksiązka ksiazka4 = new Sensacyjne("Alibaba i 40 rozbojnikow", autor1,30.2,134);

        Ksiązka ksiazka5 = new Album("Album rodziny Adamsow", autor1,100.2,13);

        Czasopismo czasopismo1 = new Tygodnik("Chwila dla cb", autor1, 1,10.00);
        Czasopismo czasopismo2 = new Tygodnik("Chwila dla cb", autor1, 2,10.00);
        Czasopismo czasopismo3 = new Tygodnik("Chwila dla cb", autor1, 3,10.00);

        Czasopismo czasopismo4 = new Miesięczniki("CDAction", autor1, 1,10.00);
        Czasopismo czasopismo5 = new Kwartalnik("Mazurki i nie tylko", autor1, 1,10.00);


        Sklep.dodajPozycje(ksiazka1,200);
        Sklep.dodajPozycje(ksiazka1,200);
        Sklep.dodajPozycje(ksiazka2,100);
        Sklep.dodajPozycje(ksiazka3,300);
        Sklep.dodajPozycje(ksiazka4,10);
        Sklep.dodajPozycje(ksiazka5,12);


        Sklep.dodajPozycje(czasopismo1,100);
        Sklep.dodajPozycje(czasopismo1,300);
        Sklep.dodajPozycje(czasopismo2,30);
        Sklep.dodajPozycje(czasopismo3,100);
        Sklep.dodajPozycje(czasopismo4,20);
        Sklep.dodajPozycje(czasopismo5,40);

        Sklep.wyswietlZawartoscSklepu();

        new Frame();
    }
}
