package DziałProgramowy;

import DziałDruku.Drukarnie;
import DziałHandlu.*;
import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.swing.*;

public class CzasZatrudnienia extends Thread {
    private int ileDni;
    private double pensja;


    private String gatunek;

    Autor autorpom;

    public CzasZatrudnienia(int ileDni )
    {
        this.ileDni=ileDni;
    }

    public void run()
    {
        for(int i=0 ; i<ileDni; i++) {
            try{
                Thread.sleep(1000);
            } catch  (InterruptedException e) {
            }
        }

        TymczasowiAutorzy.getTymczasowiAutorzy().add(autorpom);
        autorpom.dodajSaldo(pensja);
        JOptionPane.showMessageDialog(null, autorpom.getImie()+" "+autorpom.getNazwisko()+
                " napisal ksiażkę. Wyplata: "+autorpom.getSaldo()+"zł", "INFORMACJA", JOptionPane.INFORMATION_MESSAGE);

    }
    public void setAutorpom(Autor autorpom)
    {
        this.autorpom=autorpom;
    }

    public void setPensja(double pensja)
    {
        this.pensja=pensja;
    }

    public void setGatunek(String gatunek)
    {
        this.gatunek=gatunek;
    }


}
