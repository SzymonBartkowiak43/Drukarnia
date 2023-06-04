package DziałProgramowy;

import java.util.ArrayList;
import java.util.List;

public class TytulyDoStworzenia {
    private List<Ksiazka> tytuly= new ArrayList<>();

    public TytulyDoStworzenia()
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
