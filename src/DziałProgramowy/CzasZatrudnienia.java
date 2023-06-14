package DziałProgramowy;
import javax.swing.*;

public class CzasZatrudnienia extends Thread {
    private int ileDni;
    private double pensja;
    private Autor autorpom;
    private String umowa;
    private int indexAutora;

    public CzasZatrudnienia(int ileDni )
    {
        this.ileDni=ileDni;
    }

    public void run()
    {
        for(int i=1 ; i<=ileDni; i++) {
            try{

                if(umowa.equals("Umowa o pracę") && i%13==0)
                {
                    if (ZatrudnieniAutorzy.getZatrudnieniAutorzy().indexOf(autorpom)!=-1) {
                        JOptionPane.showMessageDialog(null, "Wypłacono pensje (" + pensja + "zl) autorowi: " +
                                        autorpom.getImie() + " " + autorpom.getNazwisko(),
                                "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        autorpom.dodajSaldo(pensja);
                    }
                    else {
                        break;
                    }
                }
                Thread.sleep(1000);

            } catch  (InterruptedException e) {
            }
        }
        if(umowa.equals("Umowa o dzieło")) {

            TymczasowiAutorzy.getTymczasowiAutorzy().add(autorpom);
            autorpom.dodajSaldo(pensja);
            JOptionPane.showMessageDialog(null, autorpom.getImie() + " "
                    + autorpom.getNazwisko() + " napisal ksiażkę. Wyplata: " + autorpom.getSaldo()
                    + "zł", "INFORMACJA", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(umowa.equals("Umowa o pracę")) {
            if (ZatrudnieniAutorzy.getZatrudnieniAutorzy().indexOf(autorpom) != -1)
            {
                int answer = JOptionPane.showOptionDialog(null,
                        "Autorowi " + autorpom.getImie() + " "
                                + autorpom.getNazwisko() + " skończyła się umowa. Czy chcesz ją przedlużyć?",
                        "Zatwierdz",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        null,
                        0);

            if (answer == 1) {
                ZatrudnieniAutorzy.getZatrudnieniAutorzy().remove(autorpom);
            }
            if (answer == 0) {
                CzasZatrudnienia t = new CzasZatrudnienia(ileDni);
                t.setAutorpom(autorpom);
                t.setPensja(pensja);
                t.setIndexAutora(indexAutora);
                t.setUmowa(umowa);
                t.start();
            }
        }
        }

    }
    public void setAutorpom(Autor autorpom)
    {
        this.autorpom=autorpom;
    }

    public void setPensja(double pensja)
    {
        this.pensja=pensja;
    }

    public void setUmowa(String umowa)
    {
        this.umowa=umowa;
    }
    public void setIndexAutora(int indexAutora)
    {
        this.indexAutora=indexAutora;
    }


}
