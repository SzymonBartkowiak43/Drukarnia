package DziałProgramowy;

import DziałDruku.Drukarnie;

public class CzasZatrudnienia extends Thread {
    private int ileDni;

    public CzasZatrudnienia(int ileDni )
    {
        this.ileDni=ileDni;
    }

    public void run()
    {
        for(int i=0 ; i<ileDni; i++) {
            System.out.println(i + "Tutaj!");
        }

        try{
            Thread.sleep(1000);
        } catch  (InterruptedException e) {
        }

    }

}
