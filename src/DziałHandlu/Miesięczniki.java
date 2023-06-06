package DziałHandlu;
import DziałProgramowy.Autor;
public class Miesięczniki extends Czasopismo {
	public Miesięczniki(String tytul, Autor autor, int numer, double cena) 
	{
        super(tytul, autor, numer, cena);
        gatunek = "Miesiecznik";
    }

}
