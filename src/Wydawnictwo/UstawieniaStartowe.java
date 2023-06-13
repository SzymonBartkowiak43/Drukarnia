package Wydawnictwo;

import DziałHandlu.*;
import DziałProgramowy.Autor;
import DziałProgramowy.TymczasowiAutorzy;
import DziałProgramowy.TytulyDoStworzenia;
import DziałProgramowy.ZatrudnieniAutorzy;

public class UstawieniaStartowe {
    public UstawieniaStartowe() {
        TymczasowiAutorzy.Autorzy();
        ZatrudnieniAutorzy.Zatrudnieni();
        TytulyDoStworzenia.TworzoneTytyly();

        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

        Ksiązka ksiazka1 = new Romanse("Testowy Romans 1", autor1 , 23.4, 123);
        Ksiązka ksiazka2 = new Romanse("Testowy Romans 2", autor1 , 23.4, 123);
        Ksiązka ksiazka3 = new Romanse("Testowy Romans 3", autor1 , 23.4, 123);

        Ksiązka ksiazka4 = new Sensacyjne("Testowy Sensacyjny", autor1,30.2,134);

        Ksiązka ksiazka5 = new Album("Testowy Album1", autor1,100.2,13);
        Ksiązka ksiazka6 = new Album("Testowy Album 2", autor1,103,122);

        Czasopismo czasopismo1 = new Tygodnik("Testwy tygodnik 1", autor1, 1,10.00);
        Czasopismo czasopismo2 = new Tygodnik("Testwy tygodnik 2", autor1, 2,10.00);
        Czasopismo czasopismo3 = new Tygodnik("Testwy tygodnik 3", autor1, 3,10.00);

        Czasopismo czasopismo4 = new Miesięczniki("Testwy MIesiecznik 1 ", autor1, 1,10.00);
        Czasopismo czasopismo5 = new Kwartalnik("Testowy Kwartalnik 1", autor1, 1,10.00);

        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(ksiazka1);
        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(ksiazka2);
        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(ksiazka3);
        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(ksiazka4);

        ListaDostepnychKsiazekDoDrukowania.dodajAlbum(ksiazka5);
        ListaDostepnychKsiazekDoDrukowania.dodajAlbum(ksiazka6);

        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(czasopismo1);
        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(czasopismo2);
        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(czasopismo3);
        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(czasopismo4);
        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(czasopismo5);


        MagazynSklepu.dodajPozycje(ksiazka1,200);
        MagazynSklepu.dodajPozycje(ksiazka1,200);
        MagazynSklepu.dodajPozycje(ksiazka2,100);
        MagazynSklepu.dodajPozycje(ksiazka3,300);
        MagazynSklepu.dodajPozycje(ksiazka4,10);
        MagazynSklepu.dodajPozycje(ksiazka5,12);
        MagazynSklepu.dodajPozycje(ksiazka6,90);

        MagazynSklepu.dodajPozycje(czasopismo1,100);
        MagazynSklepu.dodajPozycje(czasopismo1,300);
        MagazynSklepu.dodajPozycje(czasopismo2,30);

        MagazynSklepu.dodajPozycje(czasopismo3,100);
        MagazynSklepu.dodajPozycje(czasopismo4,20);
        MagazynSklepu.dodajPozycje(czasopismo5,40);

        MagazynSklepu.wyswietlZawartoscSklepu();
    }
}
