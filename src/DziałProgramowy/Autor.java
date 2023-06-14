package DziałProgramowy;

public class Autor {
    private String imie;
    private String nazwisko;
    private double ocena;
    private int ileChceZarabiać;
    private double saldo;
    private Umowy umowa;

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

    public Autor(String imie, String nazwisko, double ocena, int ileChceZarabiać) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.ileChceZarabiać = ileChceZarabiać;
        this.saldo=0;
    }
    public void wybierzUmowę(Umowy umowa)
    {
        this.umowa=umowa;
    }

    public void dodajSaldo(double pensja)
    {
        this.saldo+=pensja;
    }

    public double getSaldo()
    {
        return saldo;
    }
}
