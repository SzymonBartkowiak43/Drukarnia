package DziałProgramowy;

import java.util.ArrayList;
import java.util.List;

public class TymczasowiAutorzy {
    private static List<Autor> tymczasAutorzy= new ArrayList<>();

    public TymczasowiAutorzy()
    {

    }
    public static void Autorzy()
    {
        tymczasAutorzy.add(new Autor("Cezary", "Bambik", 4.4, 4552));
        tymczasAutorzy.add(new Autor("Andrzej", "Dudu", 6.3, 3602));
        tymczasAutorzy.add(new Autor("Cezary", "Bambik", 8.4, 1200));

    }
    public static void dodajAutora(Autor autor)
    {
        tymczasAutorzy.add(autor);
    }

    public static void usunAutora(int i)
    {
        tymczasAutorzy.remove(i);
    }

    public static List<Autor> getTymczasowiAutorzy()
    {
        return tymczasAutorzy;
    }

}
