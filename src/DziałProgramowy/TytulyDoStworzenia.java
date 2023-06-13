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
        tytuly.add(new KsiazkaTworzona("Ponad chmurami", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Labirynt mroku", "Sensacyjne"));
        tytuly.add(new KsiazkaTworzona("Podróż przez czas", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Skrzydła miłości", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Krwawe zemsty", "Sensacyjne"));
        tytuly.add(new KsiazkaTworzona("Cicha przeszłość", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Gorzka słodycz", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Zagubiona prawda", "Sensacyjne"));
        tytuly.add(new KsiazkaTworzona("Zakazane uczucie", "Romanse"));
        tytuly.add(new KsiazkaTworzona("Polityka", "Miesięczniki"));
        tytuly.add(new KsiazkaTworzona("Gazeta Wyborcza", "Tygodniki"));
        tytuly.add(new KsiazkaTworzona("Auto Świat", "Miesięczniki"));
        tytuly.add(new KsiazkaTworzona("Odkrywca", "Miesięczniki"));
        tytuly.add(new KsiazkaTworzona("M jak Mieszkanie", "Miesięczniki"));
        tytuly.add(new KsiazkaTworzona("Świerszczyk", "Tygodniki"));
        tytuly.add(new KsiazkaTworzona("Rzeczpospolita", "Tygodniki"));
        tytuly.add(new KsiazkaTworzona("Kuchnia", "Tygodniki"));
        tytuly.add(new KsiazkaTworzona("Cicho", "Albumy"));
        tytuly.add(new KsiazkaTworzona("Anatomia", "Albumy"));
        tytuly.add(new KsiazkaTworzona("W drodze po szczęście", "Albumy"));
        tytuly.add(new KsiazkaTworzona("Rysy", "Albumy"));
        tytuly.add(new KsiazkaTworzona("Dla Ciebie", "Albumy"));
    }
    public static List<KsiazkaTworzona> getTytuly() {
        return tytuly;
    }


}
