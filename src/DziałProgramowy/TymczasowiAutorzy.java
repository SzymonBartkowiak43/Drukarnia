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
        tymczasAutorzy.add(new Autor("Roman", "Rutkowski", 8.4, 2200));
        tymczasAutorzy.add(new Autor("Konrad", "Makowski", 3.5, 4000));
        tymczasAutorzy.add(new Autor("Anastazy", " Jaworski", 8.1, 3000));
        tymczasAutorzy.add(new Autor("Leszek", "Kalinowski", 6.6, 3232));
        tymczasAutorzy.add(new Autor("Albert", "Pawlak", 9.2, 5262));
        tymczasAutorzy.add(new Autor("Amadeusz", "Mazurek", 1.4, 1523));
        tymczasAutorzy.add(new Autor("Diego", "Kamiński", 5.3, 1200));

    }
    public static List<Autor> getTymczasowiAutorzy()
    {
        return tymczasAutorzy;
    }

}
