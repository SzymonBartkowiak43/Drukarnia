package Wydawnictwo;

import java.util.List;
import DziałHandlu.Ksiązka;
import DziałHandlu.Album;
import DziałHandlu.Czasopismo;
import DziałHandlu.Tygoniki;
import DziałHandlu.Sensacyjne;
import DziałHandlu.Miesięczniki;
import DziałHandlu.DziałHandlowy;
public class Main {
    public static void main(String[] args) {
        DziałHandlowy dzialHandlowy = new DziałHandlowy();

        Autor autor1 = new Autor("Szymon", "Bartkowiak", 6.3, 4632);
        Autor autor2 = new Autor("Cezary", "Babik", 5.6, 1462);

        Ksiązka sensacyjna = new Sensacyjne("Poradnik jak nie wbic globala", autor2, 67.1, 165);

        Czasopismo tygodnik = new Tygoniki("Tygodnik Białkowy", autor1, 1435, 5);
        Czasopismo miesiecznik = new Miesięczniki("Miesięcznik ", autor2, 314, 10);

        dzialHandlowy.dodajPozycje(sensacyjna);
        dzialHandlowy.dodajPozycje(tygodnik);
        dzialHandlowy.dodajPozycje(miesiecznik);

        dzialHandlowy.pokazKatalog();
    }
}