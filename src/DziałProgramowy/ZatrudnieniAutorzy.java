package DziałProgramowy;

import java.util.ArrayList;
import java.util.List;

public class ZatrudnieniAutorzy {
    private static List<Autor> zatrudnieniAutorzy= new ArrayList<>();

    public ZatrudnieniAutorzy()
    {

    }
    public static void Zatrudnieni()
    {
        zatrudnieniAutorzy.add(new Autor("Katarzyna", "Michalak", 9.9, 3314));
    }

    public static void dodajAutora(Autor autor)
    {
        zatrudnieniAutorzy.add(autor);
    }

    public static void usunAutora(int i)
    {
        zatrudnieniAutorzy.remove(i);
    }

    public static List<Autor> getTymczasowiAutorzy()
    {
        return zatrudnieniAutorzy;
    }
    {
    }


}
