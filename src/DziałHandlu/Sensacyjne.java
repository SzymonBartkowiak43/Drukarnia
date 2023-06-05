package DziałHandlu;
import DziałProgramowy.Autor;
public class Sensacyjne extends Ksiązka {
	public Sensacyjne(String tytuł, Autor autor, double cena, int iloscStron) 
	{
        super(tytuł, autor, cena, iloscStron);
        gatunek = "Sensacyjne";
    }
}
