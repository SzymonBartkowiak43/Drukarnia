package DziałProgramowy;

public class Ksiazka {
    private String nazwa;
    private String gatunek;

    public Ksiazka(String nazwa, String gatunek)
    {
        this.nazwa=nazwa;
        this.gatunek=gatunek;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public String getGatunek()
    {
        return gatunek;
    }
}
