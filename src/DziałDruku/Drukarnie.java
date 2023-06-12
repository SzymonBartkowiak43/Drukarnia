package DziałDruku;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;

import java.util.HashMap;

abstract public class Drukarnie  {
    protected Produkcja produkcja = new Produkcja();
    protected int ksiazkaCzyCzasopismo; // ksiazka = 0 czasopismo = 1
    protected String coDrukuje;
    protected  Ksiązka drukownaKsiazka;
    protected  Czasopismo drukowneCzasopismo;
    protected int ileSztuk;
    protected  boolean czyMonzaRozpacząćProdukcje = true;
    protected  int mocPrzerobowa; //czas w ms ile potrzebuje do wyprodukowania 1 ksiazki
    protected HashMap<Ksiązka, Integer> kolekaDodrukowaniaKsiazek = new HashMap<Ksiązka, Integer>();
    protected HashMap<Czasopismo, Integer> kolekaDodrukowaniaCzasopsim = new HashMap<Czasopismo, Integer>();
    protected static HashMap<Ksiązka, Integer> wydrukowaneKsiazki = new HashMap<Ksiązka, Integer>();
    protected static HashMap<Czasopismo, Integer> wydrukowaneCzasopsima = new HashMap<Czasopismo, Integer>();


    public void zacznijDrukować(Ksiązka ksiązka , int ilosc) {
        if(czyMonzaRozpacząćProdukcje) {
            czyMonzaRozpacząćProdukcje = false;
            ksiazkaCzyCzasopismo = 0;
            coDrukuje = ksiązka.getTytul();
            drukownaKsiazka = ksiązka;
            ileSztuk = ilosc;
            wyliczCzasProdukcji();

            produkcja.setDrukarnia(this);
            Thread t1 = new Thread(produkcja);
            t1.start();
        } else {
            System.out.println("Nie mozna rozpacząć produkcji, aktualnie drukujemy " + coDrukuje + ", Wydrukowano " + produkcja.getileProcent());
            kolekaDodrukowaniaKsiazek.put(ksiązka, ilosc);
        }
    }

    public void zacznijDrukować(Czasopismo czasopismo , int ilosc) {
        if(czyMonzaRozpacząćProdukcje) {
            czyMonzaRozpacząćProdukcje = false;
            ksiazkaCzyCzasopismo = 1;
            coDrukuje = czasopismo.getTytul();
            drukowneCzasopismo = czasopismo;
            ileSztuk = ilosc;
            wyliczCzasProdukcji();

            produkcja.setDrukarnia(this);
            Thread t1 = new Thread(produkcja);
            t1.start();
        } else {
            System.out.println("Nie mozna rozpacząć produkcji, aktualnie drukujemy " + coDrukuje + ", Wydrukowano " + produkcja.getileProcent());
            kolekaDodrukowaniaCzasopsim.put(czasopismo, ilosc);
        }
    }

    public  void setCzyMonzaRozpacząćProdukcje (boolean czyMozna) {
        czyMonzaRozpacząćProdukcje = czyMozna;
        if(kolekaDodrukowaniaKsiazek.size() != 0) {
            Ksiązka ksiązka = kolekaDodrukowaniaKsiazek.keySet().iterator().next();
            Integer ilosc = kolekaDodrukowaniaKsiazek.remove(ksiązka);
            zacznijDrukować(ksiązka,ilosc);
            System.out.println("Zaczynam drukować " + coDrukuje);
        } else if (kolekaDodrukowaniaCzasopsim.size() != 0) {
            Czasopismo czasopismo = kolekaDodrukowaniaCzasopsim.keySet().iterator().next();
            Integer ilosc = kolekaDodrukowaniaCzasopsim.remove(czasopismo);
            zacznijDrukować(czasopismo,ilosc);
            System.out.println("Zaczynam drukować " + coDrukuje);
        }
    }
    public void powiadomOZakończeniuProdukcji() {
            System.out.println("Produkcja dziela " + coDrukuje +  " zakończona.");
            if(ksiazkaCzyCzasopismo == 0) {
                if (wydrukowaneKsiazki.containsKey(drukownaKsiazka)) {
                    int aktualnaWartość = wydrukowaneKsiazki.get(drukownaKsiazka);
                    int nowaWartość = aktualnaWartość + ileSztuk;
                    wydrukowaneKsiazki.put(drukownaKsiazka, nowaWartość);
                } else {
                    wydrukowaneKsiazki.put(drukownaKsiazka, ileSztuk);
                }

            } else {
                if (wydrukowaneCzasopsima.containsKey(drukowneCzasopismo)) {
                    int aktualnaWartość = wydrukowaneCzasopsima.get(drukowneCzasopismo);
                    int nowaWartość = aktualnaWartość + ileSztuk;
                    wydrukowaneCzasopsima.put(drukowneCzasopismo , nowaWartość);
                } else {
                    wydrukowaneCzasopsima.put(drukowneCzasopismo, ileSztuk);
                }
            }

            setCzyMonzaRozpacząćProdukcje(true);
        }

    public String wypiszKolejkeDrukowania() {

        StringBuilder zwracany = new StringBuilder();

        if(!kolekaDodrukowaniaKsiazek.isEmpty()) {
            for (HashMap.Entry<Ksiązka, Integer> entry : kolekaDodrukowaniaKsiazek.entrySet()) {
                Ksiązka key = entry.getKey();
                Integer value = entry.getValue();

                zwracany.append("Pozycja: ").append(key.getTytul()).append(", Ilosc: ").append(value).append("\n");
            }
        }

        if(!kolekaDodrukowaniaCzasopsim.isEmpty()) {
            for (HashMap.Entry<Czasopismo, Integer> entry : kolekaDodrukowaniaCzasopsim.entrySet()) {
                Czasopismo key = entry.getKey();
                Integer value = entry.getValue();

                zwracany.append("Pozycja: ").append(key.getTytul()).append(", Ilosc: ").append(value).append("\n");
            }
        }

        if (kolekaDodrukowaniaKsiazek.isEmpty() && kolekaDodrukowaniaCzasopsim.isEmpty()) {
            zwracany.append("Kolejka drukowania jest pusta");
        }

        return zwracany.toString();
    }
    public String  wypiszWydykowanePozycje() {
        StringBuilder zwracanyK = new StringBuilder();

        if(!wydrukowaneKsiazki.isEmpty()) {
            zwracanyK.append("Ksiazki :").append("\n");
        for (HashMap.Entry<Ksiązka, Integer> entry : wydrukowaneKsiazki.entrySet()) {
            Ksiązka key = entry.getKey();
            Integer value = entry.getValue();

            zwracanyK.append("Pozycja: ").append(key.getTytul()).append(", Ilosc: ").append(value).append("\n");
        }
        }

        if(!wydrukowaneCzasopsima.isEmpty()) {
            zwracanyK.append("Czasopsima :").append("\n");
            for (HashMap.Entry<Czasopismo, Integer> entry : wydrukowaneCzasopsima.entrySet()) {
                Czasopismo key = entry.getKey();
                Integer value = entry.getValue();

                zwracanyK.append("Pozycja: ").append(key.getTytul()).append(", Ilosc: ").append(value).append("\n");
            }
        }
        if (wydrukowaneKsiazki.isEmpty() && wydrukowaneCzasopsima.isEmpty()) {
            zwracanyK.append("Nie ma zadnych wydrukowanych pozycji");
        }

        return zwracanyK.toString();
    }

    public String wypiszCoAktualnieSięProdukuje() {
        String zwracany ="";
        if(!czyMonzaRozpacząćProdukcje) {
            zwracany +="Akutalnie Produkujemy: ";
            zwracany +=  coDrukuje + ", Ilość: " + ileSztuk + " Wyprodukowano: "  + produkcja.getileProcent(); }
        else
            zwracany += "Maszyna nic nie produkuje";
        return zwracany;
    }
    public void wyliczCzasProdukcji () {
        produkcja.setPredkoscProdukcji(mocPrzerobowa*ileSztuk/100);
    }
    public static HashMap<Ksiązka, Integer> getWydrukowaneKsiazki() {
        HashMap<Ksiązka, Integer> tym = new HashMap<>();
        tym.putAll(wydrukowaneKsiazki);
        wydrukowaneKsiazki.clear();
        return tym;
    }
    public static HashMap<Czasopismo, Integer> getWydrukowaneCzasopsima() {
        HashMap<Czasopismo, Integer> tym = new HashMap<>();
        tym.putAll(wydrukowaneCzasopsima);
        wydrukowaneCzasopsima.clear();
        return tym;
    }
}
