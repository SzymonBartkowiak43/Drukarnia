package DziałHandlu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MagazynSklepu {

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
            WszystkieCzasopisma.put(czasopismo , nowaWartość);
        } else {
            WszystkieCzasopisma.put(czasopismo, ilosc);
        }
    }

    public static String wyswietlZawartoscSklepu() {
        String zwracany = "Dostępne Czasopisma:\n";
        for (HashMap.Entry<Czasopismo, Integer> entry : getWszystkieCzasopisma().entrySet()) {
            Czasopismo czasopismo = entry.getKey();
            int ilosc = entry.getValue();
            zwracany += czasopismo.getTytul() + " " + czasopismo.getNumer() + " - ilość: " + ilosc + "\n";

        }

        zwracany += "\n\nDostępne Ksiazki: \n";
        for (HashMap.Entry<Ksiązka, Integer> entry : getWszystkiePozycyje().entrySet()) {
            Ksiązka ksiazka = entry.getKey();
            int ilosc = entry.getValue();
            zwracany +=ksiazka.getTytul() + " - ilość: " + ilosc + "\n";
        }
        return zwracany;
    }

    public static List<Ksiązka> zwrocKsiazki(String gatunek) {
        List<Ksiązka> katalog = new ArrayList<>();

        for (HashMap.Entry<Ksiązka, Integer> entry : getWszystkiePozycyje().entrySet()) {
            Ksiązka ksiazka = entry.getKey();

            String Gatunek = ksiazka.getGatunek();
            if(Gatunek.equals(gatunek)) {
                katalog.add(ksiazka);
                System.out.println(ksiazka.getTytul());
            }
        }
        return katalog;
    }


    public static List<Czasopismo> zwrocCzasopisma(String gatunek) {
        List<Czasopismo> katalog = new ArrayList<>();

        for (HashMap.Entry<Czasopismo, Integer> entry : getWszystkieCzasopisma().entrySet()) {
            Czasopismo czasopismo= entry.getKey();

            String Gatunek = czasopismo.getGatunek();
            if(Gatunek.equals(gatunek)) {
                katalog.add(czasopismo);
                System.out.println(czasopismo.getTytul());
            }
        }
        return katalog;
    }

    public static boolean sprawdzCzyjestTyleSztuk(Ksiązka książka, int ilosc) {

        int aktualnaWartość = WszystkieKsiażki.get(książka);
        int nowaWartość = aktualnaWartość - ilosc;


        if(nowaWartość >= 0 ) {
            return true;
        }
        else
            return false;
    }
    public static boolean sprawdzCzyjestTyleSztuk(Czasopismo czasopismo, int ilosc) {

        int aktualnaWartość = WszystkieCzasopisma.get(czasopismo);
        int nowaWartość = aktualnaWartość - ilosc;


        if(nowaWartość >= 0 ) {
            return true;
        }
        else
            return false;
    }


    public static  void kup(Ksiązka książka, int ilosc) {

        int aktualnaWartość = WszystkieKsiażki.get(książka);
        int nowaWartość = aktualnaWartość - ilosc;

        if(nowaWartość == 0) {
            WszystkieKsiażki.remove(książka);
        } else {
            WszystkieKsiażki.put(książka, nowaWartość);
        }
    }

    public static  void kup(Czasopismo czasopismo, int ilosc) {

        int aktualnaWartość =  WszystkieCzasopisma.get(czasopismo);
        int nowaWartość = aktualnaWartość - ilosc;

        if(nowaWartość == 0) {
            WszystkieCzasopisma.remove(czasopismo);
        } else {
            WszystkieCzasopisma.put(czasopismo, nowaWartość);
        }
    }
    public static  int ileDostepnychSztuk(Ksiązka książka) {
        int aktualnaWartość = WszystkieKsiażki.get(książka);
        return aktualnaWartość;
    }
    public static  int ileDostepnychSztuk(Czasopismo czasopismo) {
        int aktualnaWartość = WszystkieCzasopisma.get(czasopismo);
        return aktualnaWartość;
    }





}
