package DziałProgramowy;

public class KsiazkaTworzona {
    private String nazwa;
    private String gatunek;

    public KsiazkaTworzona(String nazwa, String gatunek)
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
