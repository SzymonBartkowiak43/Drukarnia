package DziałHandlu;
import DziałProgramowy.Autor;
public class Romanse extends Ksiązka
{

	public Romanse(String tytuł, Autor autor, double cena, int iloscStron) 
	{
        super(tytuł, autor, cena, iloscStron);
        gatunek = "Romanse";

    }

}
