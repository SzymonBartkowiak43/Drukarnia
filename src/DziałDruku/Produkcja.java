package DziałDruku;

public class Produkcja implements Runnable {

    private static int ileProcent;

    public Produkcja() {
        ileProcent = 0;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 100; ++i)
        {
            tick();
        }
        ileProcent = 0;
    }

    public void tick () {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       ileProcent++;
    }

    public void aktualnaProdukcja() {
        System.out.println("Wyprodukowano: " + ileProcent + "%");
    }
    public String getileProcent () {
        return   ileProcent + "%";
    }
}
