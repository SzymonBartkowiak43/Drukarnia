package DziałHandlu;

import DziałProgramowy.Autor;

import java.util.ArrayList;
import java.util.List;

public class ListaDostepnychCzasopismDoDrukowania {


    private static List<Object> katalogCzasopism= new ArrayList<>();

    public static void StartoweCzasopisma() {
        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

        Czasopismo czasopismo1 = new Tygodnik("Cejrowski 1 ", autor1,1,20.00);
        Czasopismo czasopismo2 = new Tygodnik("Cejrowski 2", autor1,2,20.00);
        Czasopismo czasopismo3 = new Tygodnik("Bravo 1", autor1,1,20.00);

        Czasopismo czasopismo4 = new Miesięczniki("Bravo 2", autor1,1,20.00);

        katalogCzasopism.add(czasopismo1);
        katalogCzasopism.add(czasopismo2);
        katalogCzasopism.add(czasopismo3);
        katalogCzasopism.add(czasopismo4);
    }


    public static List<Object> getKatalogCzasopism() {
        return katalogCzasopism;
    }

    public static void dodajCzasopismo(Czasopismo czasopismo)
    {
        katalogCzasopism.add(czasopismo);
    }
}
