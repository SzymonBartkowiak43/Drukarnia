package DziałHandlu;

abstract class Ksiązka {
    private String tytul;
    private String autor;
    private double cena;
    private int ilośćStron;

    Ksiązka (String tytul, String autor, double cena, int iloscStron) {
        this.tytul = tytul;
        this.autor = autor;
        this.cena = cena;
        this.ilośćStron = iloscStron;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public double getCena() {
        return cena;
    }

    public int getIlośćStron() {
        return ilośćStron;
    }
}
