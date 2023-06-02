package DziałHandlu;

import DziałProgramowy.Autor;
import DziałProgramowy.Autorzy;

import java.util.ArrayList;
import java.util.List;

public class TymczasowaListaKsiazek { ////DO NAPRAWIENIA I ZROBIENI POZADNIE
    private List<Object> katalog= new ArrayList<>();



    private Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

    public TymczasowaListaKsiazek () {
        Ksiązka ksiazka1 = new Romanse("Dis nie mile widziany", autor1 , 23.4, 123);
        Ksiązka ksiazka2 = new Romanse("Ania zielone gory", autor1 , 23.4, 123);
        Ksiązka ksiazka3 = new Romanse("Szalone koty ida do roboty", autor1 , 23.4, 123);

        katalog.add(ksiazka1);
        katalog.add(ksiazka2);
        katalog.add(ksiazka3);
    }
    public List<Object> getKatalog() {
        return katalog;
    }
}
