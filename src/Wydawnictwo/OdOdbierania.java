package Wydawnictwo;

import DziałDruku.Drukarnie;
import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;
import DziałHandlu.MagazynSklepu;

import javax.swing.*;
import java.util.HashMap;

public class OdOdbierania {

    OdOdbierania()
    {
        String wyswietlany = "Odebrane Tytuly: \n";

        HashMap<Ksiązka, Integer> ksiazki = Drukarnie.getWydrukowaneKsiazki();
        HashMap<Czasopismo, Integer> czasopisma = Drukarnie.getWydrukowaneCzasopsima();

        for (HashMap.Entry<Ksiązka, Integer> entry : ksiazki.entrySet()) {
            Ksiązka klucz = entry.getKey();
            Integer wartosc = entry.getValue();
            MagazynSklepu.dodajPozycje(klucz, wartosc);

            wyswietlany += klucz.getTytul() + "\n";
        }

        for (HashMap.Entry<Czasopismo, Integer> entry : czasopisma.entrySet()) {
            Czasopismo klucz = entry.getKey();
            Integer wartosc = entry.getValue();
            MagazynSklepu.dodajPozycje(klucz, wartosc);

            wyswietlany += klucz.getTytul() + "\n";
        }

        JOptionPane.showMessageDialog(null,
                wyswietlany, "Odebrane Pozycje " ,JOptionPane.INFORMATION_MESSAGE);
    }
}
