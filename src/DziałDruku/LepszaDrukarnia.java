package DziałDruku;

public class LepszaDrukarnia extends Drukarnie{
    LepszaDrukarnia (int mocPrzerobowa) {
        this.mocPrzerobowa = mocPrzerobowa;
    }
    public void zacznijDrukowaćAlbum(String nazwa, int ilosc) {
        if(czyMonzaRozpacząćProdukcje) {
            czyMonzaRozpacząćProdukcje = false;
            coDrukuje = "Album " + nazwa;
            ileSztuk = ilosc;
            wyliczCzasProdukcji();

            produkcja.setDrukarnia(this);
            Thread t1 = new Thread(produkcja);
            t1.start();
        } else {
            System.out.println("Nie mozna rozpacząć produkcji, aktualnie drukujemy ksiażke " + coDrukuje + " Pozostało " + produkcja.getileProcent());
            kolekaDodrukowania.put(drukownaKsiazka, ilosc);
        }
    }
}
