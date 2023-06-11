package DziałProgramowy;

public class Autor {
    private String imie;
    private String nazwisko;

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getOcena() {
        return ocena;
    }

    public int getIleChceZarabiać() {
        return ileChceZarabiać;
    }

    private Umowy umowa;

    public Umowy getUmowa()
    {
        return umowa;
    }

    private double ocena;
    private int ileChceZarabiać;


    public Autor(String imie, String nazwisko, double ocena, int ileChceZarabiać) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.ileChceZarabiać = ileChceZarabiać;
    }

    public void wybierzUmowę(Umowy umowa)
    {
        this.umowa=umowa;
    }
}
