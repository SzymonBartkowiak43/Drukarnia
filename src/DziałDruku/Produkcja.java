package DziałDruku;

public class Produkcja implements Runnable {
    private int ileProcent;
    private Drukarnie drukarnia;
    private int predkoscProdukcji = 100;
    public Produkcja() {
        ileProcent = 0;
    }

    public void setDrukarnia(Drukarnie drukarnia) {
        this.drukarnia = drukarnia;
    }

    public void setPredkoscProdukcji(int predkoscProdukcji) {
        this.predkoscProdukcji = predkoscProdukcji;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; ++i)
        {
            tick();
        }
        ileProcent = 0;

        drukarnia.powiadomOZakończeniuProdukcji();
    }

    public void tick () {
        try {
            Thread.sleep(predkoscProdukcji);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       ileProcent++;
    }

    public String getileProcent () {
        return   ileProcent + "%";
    }
}
