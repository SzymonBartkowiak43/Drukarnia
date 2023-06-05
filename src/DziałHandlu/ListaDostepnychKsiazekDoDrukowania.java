package DziałHandlu;

import DziałProgramowy.Autor;

import java.util.ArrayList;
import java.util.List;

public class ListaDostepnychKsiazekDoDrukowania {
    private static List<Object> katalog= new ArrayList<>();

    public ListaDostepnychKsiazekDoDrukowania() {

    }
    public static List<Object> getKatalog() {
        return katalog;
    }
    public static void StartoweKsiazki() {
        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

        Ksiązka ksiazka1 = new Romanse("Dis nie mile widziany", autor1 , 23.4, 123);
        Ksiązka ksiazka2 = new Romanse("Ania zielone gory", autor1 , 23.4, 123);
        Ksiązka ksiazka3 = new Romanse("Szalone koty ida do roboty", autor1 , 23.4, 123);

        katalog.add(ksiazka1);
        katalog.add(ksiazka2);
        katalog.add(ksiazka3);
    }
}
