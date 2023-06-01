package DziałDruku;

import DziałHandlu.Ksiązka;

import java.util.HashMap;

abstract public class Drukarnie  {
    protected Produkcja produkcja = new Produkcja();
    protected String coDrukuje;
    protected  Ksiązka drukownaKsiazka;
    protected int ileSztuk;
    protected  boolean czyMonzaRozpacząćProdukcje = true;
    protected  int mocPrzerobowa; //czas w ms ile potrzebuje do wyprodukowania 1 ksiazki
    protected HashMap<Ksiązka, Integer> kolekaDodrukowania = new HashMap<Ksiązka, Integer>();
    protected HashMap<Ksiązka, Integer> wydrukowanePozycje = new HashMap<Ksiązka, Integer>();


    public void zacznijDrukowaćKsiążke(Ksiązka ksiązka , int ilosc) { // male zmiany
        if(czyMonzaRozpacząćProdukcje) {
            czyMonzaRozpacząćProdukcje = false;
            coDrukuje = ksiązka.getTytul();
            drukownaKsiazka = ksiązka;
            ileSztuk = ilosc;
            wyliczCzasProdukcji();

            produkcja.setDrukarnia(this);
            Thread t1 = new Thread(produkcja);
            t1.start();
        } else {
            System.out.println("Nie mozna rozpacząć produkcji, aktualnie drukujemy " + coDrukuje + ", Wydrukowano " + produkcja.getileProcent());
            kolekaDodrukowania.put(ksiązka, ilosc);
        }
    }
    public  void setCzyMonzaRozpacząćProdukcje (boolean czyMozna) {
        czyMonzaRozpacząćProdukcje = czyMozna;
        if(kolekaDodrukowania.size() != 0) {
            Ksiązka ksiązka = kolekaDodrukowania.keySet().iterator().next();
            Integer ilosc = kolekaDodrukowania.remove(ksiązka);
            zacznijDrukowaćKsiążke(ksiązka,ilosc);
            System.out.println("Zaczynam drukować " + coDrukuje);
        }
    }
    public void powiadomOZakończeniuProdukcji() {
            System.out.println("Produkcja dziela " +coDrukuje +  " zakończona.");
            wydrukowanePozycje.put(drukownaKsiazka, ileSztuk);
            setCzyMonzaRozpacząćProdukcje(true);
        }

    public void wypiszKolejkeDrukowania() {
        kolekaDodrukowania.forEach((key, value) -> System.out.println("Pozycja: " + key.getTytul() + ", Ilosc: " + value));
        if(kolekaDodrukowania.isEmpty())
            System.out.println("Kolejka drukowania jest pusta");
    }
    public void wypiszWydykowanePozycje() {
        wydrukowanePozycje.forEach((key, value) -> System.out.println("Pozycja: " + key.getTytul() + ", Ilosc: " + value));
        if(wydrukowanePozycje.isEmpty())
            System.out.println("Nie ma zadnych wydrukowanych pozycji");
    }

    public String wypiszCoAktualnieSięProdukuje() {
        String zwracany ="";
        if(!czyMonzaRozpacząćProdukcje) {
            zwracany +="Akutalnie Produkujemy: ";
            zwracany += "Książka: " + coDrukuje + ", Ilość: " + ileSztuk + " sztuk "  + produkcja.getileProcent(); }
        else
            zwracany += "Maszyna nic nie produkuje";
        return zwracany;
    }
    public void wyliczCzasProdukcji () {
        produkcja.setPredkoscProdukcji(mocPrzerobowa*ileSztuk/100);
    }
}
