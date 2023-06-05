package DziałProgramowy;

import java.util.ArrayList;
import java.util.List;

public class TytulyDoStworzenia {
    private List<KsiazkaTworzona> tytuly= new ArrayList<>();

    public TytulyDoStworzenia()
    {
        tytuly.add(new KsiazkaTworzona("Lapanie zydow", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Getto w moim miescie", "Sensacyjne"));
        tytuly.add(new KsiazkaTworzona("Lolipop", "Romanse"));
    }
    public List<KsiazkaTworzona> getTytuly() {
        return tytuly;
    }
    public int getRozmiar()
    {
        return tytuly.size();
    }


}
