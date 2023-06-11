package DziałProgramowy;

import java.util.ArrayList;
import java.util.List;


public class TytulyDoStworzenia {
    private static List<KsiazkaTworzona> tytuly= new ArrayList<>();

    public TytulyDoStworzenia()
    {
    }

    public static void TworzoneTytyly()
    {
        tytuly.add(new KsiazkaTworzona("Lapanie zydow", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Getto w moim miescie", "Sensacyjne"));
        tytuly.add(new KsiazkaTworzona("Lolipop", "Romanse"));
    }
    public static List<KsiazkaTworzona> getTytuly() {
        return tytuly;
    }


    public static int getRozmiar()
    {
        return tytuly.size();
    }


}
