package DziałHandlu;

import DziałDruku.DziałDruku;
import DziałProgramowy.Autor;

import java.util.ArrayList;
import java.util.List;

public class ListaDostepnychKsiazekDoDrukowania {
    private static List<Object> katalog= new ArrayList<>();
    private static List<Object> albumy = new ArrayList<>();

    public ListaDostepnychKsiazekDoDrukowania() {
    }

    public static void StartoweKsiazki() {
        Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);

        Ksiązka ksiazka1 = new Romanse("Dis nie mile widziany", autor1 , 23.4, 123);
        Ksiązka ksiazka2 = new Romanse("Ania zielone gory", autor1 , 23.4, 123);
        Ksiązka ksiazka3 = new Romanse("Szalone koty ida do roboty", autor1 , 23.4, 123);
        Ksiązka ksiazka4 = new Romanse("Magda Gelser ", autor1 , 23.4, 123);

        Ksiązka ksiazka5 = new Album("Album xx ", autor1 , 23.4, 123);
        Ksiązka ksiazka6 = new Album("Album xxx ", autor1 , 23.4, 123);


        katalog.add(ksiazka1);
        katalog.add(ksiazka2);
        katalog.add(ksiazka3);
        katalog.add(ksiazka4);
        albumy.add(ksiazka5);
        albumy.add(ksiazka6);
    }

    public static List<Object> getKatalog() {
        if(DziałDruku.czyJestWybranaNajlepszaDrukarnia) {
            List<Object> polaczonaLista = new ArrayList<>();
            polaczonaLista.addAll(katalog);
            polaczonaLista.addAll(albumy);
            return polaczonaLista;
        }
        return katalog;
    }

    public static void dodajKsiazke(Ksiązka ksiazka)
    {
        katalog.add(ksiazka);
    }
    public static void dodajAlbum(Ksiązka album) {
        albumy.add(album);
    }
}
