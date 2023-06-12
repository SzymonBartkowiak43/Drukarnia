package DziałHandlu;
import DziałProgramowy.Autor;

public class Czasopismo {
	private String tytul;
	private Autor autor;
	private int numer;
	private double cena;
    protected  String gatunek;

    public String getGatunek() {
        return gatunek;
    }

    public Czasopismo (String tytul, Autor autor, int numer, double cena) {
        this.tytul = tytul;
        this.autor = autor;
        this.cena = cena;
        this.numer = numer;
    }
    public void ustawGatunek(String gatunek)
        {
            this.gatunek=gatunek;
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
    public double getNumer() {
        return numer;
    }
	
	
	

}
