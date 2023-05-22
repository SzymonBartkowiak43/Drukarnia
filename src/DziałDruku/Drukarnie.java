package DziałDruku;

import java.util.HashMap;

abstract public class Drukarnie  {
    private double mocPrzerobowar;
    private int jakośćDruku;
    private double cenaDruku;
    private int aktualneObciążenie;
    private Produkcja produkcja = new Produkcja();
    private HashMap<String, Integer> coAkutalnieSieProdukuje = new HashMap<String, Integer>();
    private String coDrukuje;

    Drukarnie () {
    }
    public void zacznijDrukować(String nazwa, int ilosc) {
        coAkutalnieSieProdukuje.put(nazwa, ilosc);
        Produkcja pr = new Produkcja();
        Thread t1 = new Thread(pr);
        t1.start();
        produkcja.tick();
        coDrukuje = nazwa;
    }

    public void wypiszStanDruku () {
        System.out.println(coDrukuje + " " +produkcja.getileProcent());
    }

}
