package Wydawnictwo;

import DziałDruku.DziałDruku;

import javax.swing.*;

public class WyswietlCoDrukuje  {
    WyswietlCoDrukuje() {
        String wyswietlany = Frame.działDruku.pokazCoAktualnieSieProdukuje();

        JOptionPane.showMessageDialog(null,
                wyswietlany, "Produkuje" ,JOptionPane.INFORMATION_MESSAGE);
    }
}
