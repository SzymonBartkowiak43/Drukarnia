package DziałHandlu;
import DziałProgramowy.Autor;

public class Ksiązka {
    private String tytul;
    private Autor autor;
    private double cena;
    private int ilośćStron;

    public Ksiązka (String tytul, Autor autor, double cena, int iloscStron) {
        this.tytul = tytul;
        this.autor = autor;
        this.cena = cena;
        this.ilośćStron = iloscStron;
    }


    public String getTytul() {
        return tytul;
    }

    public Autor getAutor() {
        return autor;
    }

    public double getCena() {
        return cena;
    }

    public int getIlośćStron() {
        return ilośćStron;
    }
}
