package DziałHandlu;
import DziałProgramowy.Autor;
public class Tygodnik extends Czasopismo{
	public Tygodnik(String tytul, Autor autor, int numer, double cena)
	{
        super(tytul, autor, numer, cena);
        gatunek = "Tygodnik";
    }

}
