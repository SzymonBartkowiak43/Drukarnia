package DziałHandlu;

import DziałProgramowy.Autor;
public class Kwartalnik extends Czasopismo {
    public Kwartalnik(String tytul, Autor autor, int numer, double cena)
    {
        super(tytul, autor, numer, cena);
        gatunek = "Kwartalnik";
    }

}
