package DziałProgramowy;

import java.util.ArrayList;
import java.util.List;

public class TymczasowiAutorzy {
    private List<Autor> tymczasAutorzy= new ArrayList<>();

    public TymczasowiAutorzy()
    {
        tymczasAutorzy.add(new Autor("Cezary", "Bambik", 4.4, 4552));
        tymczasAutorzy.add(new Autor("Andrzej", "Dudu", 6.3, 3602));
        tymczasAutorzy.add(new Autor("Cezary", "Bambik", 8.4, 1200));
    }

    public List<Autor> getTymczasowiAutorzy()
    {
        return tymczasAutorzy;
    }

}
