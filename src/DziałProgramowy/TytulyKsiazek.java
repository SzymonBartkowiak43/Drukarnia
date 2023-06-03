package DziałProgramowy;

import DziałHandlu.Ksiązka;
import DziałHandlu.Romanse;

import java.util.ArrayList;
import java.util.List;

public class TytulyKsiazek {
    private List<Ksiazka> tytuly= new ArrayList<>();

    public TytulyKsiazek ()
    {
        tytuly.add(new Ksiazka("Lapanie zydow", "Romanse"));
        tytuly.add(new Ksiazka("Getto w moim miescie", "Sensacyjne"));
        tytuly.add(new Ksiazka("Lolipop", "Romanse"));
    }
    public List<Ksiazka> getTytuly() {
        return tytuly;
    }
    public int getRozmiar()
    {
        return tytuly.size();
    }


}
