package DziałDruku;

import java.util.HashMap;

abstract public class Drukarnie  {
    private Produkcja produkcja = new Produkcja();
    private String coDrukuje;
    private int ileSztuk;
    private  boolean czyMonzaRozpacząćProdukcje = true;
    private HashMap<String, Integer> kolekaDodrukowania = new HashMap<String, Integer>();
    private HashMap<String, Integer> wydrukowanePozycje = new HashMap<String, Integer>();


    public void zacznijDrukowaćKsiążke(String nazwa, int ilosc) {
        if(czyMonzaRozpacząćProdukcje) {
            czyMonzaRozpacząćProdukcje = false;
            coDrukuje = nazwa;
            ileSztuk = ilosc;

            produkcja.setDrukarnia(this);
            //Produkcja pr = new Produkcja();
            Thread t1 = new Thread(produkcja);
            t1.start();
        } else {
            System.out.println("Nie mozna rozpacząć produkcji, aktualnie drukujemy ksiażke " + coDrukuje + " Pozostało " + produkcja.getileProcent());
            kolekaDodrukowania.put(nazwa, ilosc);
        }
    }
    public  void setCzyMonzaRozpacząćProdukcje (boolean czyMozna) {
        czyMonzaRozpacząćProdukcje = czyMozna;
        if(kolekaDodrukowania.size() != 0) {
            String ksiazka = kolekaDodrukowania.keySet().iterator().next();
            Integer ilosc = kolekaDodrukowania.remove(ksiazka);
            zacznijDrukowaćKsiążke(ksiazka,ilosc);
            System.out.println("Zaczynam drukować " + coDrukuje);
        }
    }
    public void powiadomOZakończeniuProdukcji() {
            System.out.println("Produkcja dziala " +coDrukuje +  " zakończona.");
            wydrukowanePozycje.put(coDrukuje, ileSztuk);
            setCzyMonzaRozpacząćProdukcje(true);
        }

    public void wypiszKolejkeDrukowania() {
        kolekaDodrukowania.forEach((key, value) -> System.out.println("Pozycja: " + key + ", Ilosc: " + value));
        if(kolekaDodrukowania.isEmpty())
            System.out.println("Kolejka drukowania jest pusta");
    }
    public void wypiszWydykowanePozycje() {
        wydrukowanePozycje.forEach((key, value) -> System.out.println("Pozycja: " + key + ", Ilosc: " + value));
        if(wydrukowanePozycje.isEmpty())
            System.out.println("Nie ma zadnych wydrukowanych pozycji");
    }

    public void wypiszCoAktualnieSięProdukuje() {
        if(!czyMonzaRozpacząćProdukcje) {
            System.out.print("Akutalnie Produkujemy: ");
            System.out.println("Książka: " + coDrukuje + ", Ilość: " + ileSztuk + " sztuk "  + produkcja.getileProcent()); }
        else
            System.out.println("Maszyna nic nie produkuje");

    }
}
