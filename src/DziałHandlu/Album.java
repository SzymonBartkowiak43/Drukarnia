package DziałHandlu;
import DziałProgramowy.Autor;
public class Album extends Ksiązka {
    public Album(String tytuł, Autor autor, double cena, int iloscStron) {
        super(tytuł, autor, cena, iloscStron);

        gatunek = "Albumy";
    }



}
