package DziałHandlu;

import java.util.HashMap;

public class Sklep {

    private static HashMap<Ksiązka, Integer> WszystkieKsiażki = new HashMap<Ksiązka, Integer>();
    private static HashMap<Czasopismo, Integer> WszystkieCzasopisma = new HashMap<Czasopismo, Integer>();

    public static HashMap<Czasopismo, Integer> getWszystkieCzasopisma() {
        return WszystkieCzasopisma;
    }

    public static HashMap<Ksiązka, Integer> getWszystkiePozycyje() {
        return WszystkieKsiażki;
    }

    public static void dodajPozycje(Ksiązka książka, int ilosc) {
        if (WszystkieKsiażki.containsKey(książka)) {
            int aktualnaWartość = WszystkieKsiażki.get(książka);
            int nowaWartość = aktualnaWartość + ilosc;
            WszystkieKsiażki.put(książka, nowaWartość);
        } else {
            WszystkieKsiażki.put(książka, ilosc);
        }
    }
    public static void dodajPozycje(Czasopismo czasopismo, int ilosc) {
        if (WszystkieCzasopisma.containsKey(czasopismo)) {
            int aktualnaWartość = WszystkieCzasopisma.get(czasopismo);
            int nowaWartość = aktualnaWartość + ilosc;
            WszystkieCzasopisma.put(czasopismo, nowaWartość);
        } else {
            WszystkieCzasopisma.put(czasopismo, ilosc);
        }
    }

    public static void wyswietlZawartoscSklepu() {
        System.out.println("Dostępne Czasopisma:");
        for (HashMap.Entry<Czasopismo, Integer> entry : getWszystkieCzasopisma().entrySet()) {
            Czasopismo czasopismo = entry.getKey();
            int ilosc = entry.getValue();
            System.out.println(czasopismo.getTytul() + " - ilość: " + ilosc);
        }

        System.out.println("Dostępne Ksiazki:");
        for (HashMap.Entry<Ksiązka, Integer> entry : getWszystkiePozycyje().entrySet()) {
            Ksiązka ksiazka = entry.getKey();
            int ilosc = entry.getValue();
            System.out.println(ksiazka.getTytul() + " - ilość: " + ilosc);
        }
    }


}
