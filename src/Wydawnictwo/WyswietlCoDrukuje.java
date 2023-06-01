package Wydawnictwo;

import DziałDruku.DziałDruku;

import javax.swing.*;

public class WyswietlCoDrukuje {
    DziałDruku dzial = new DziałDruku();

    WyswietlCoDrukuje() {
        System.out.println("laaa");
        String wyswietlany = dzial.pokazCoAktualnieSieProdukuje();

        JOptionPane.showMessageDialog(null,
                wyswietlany, "Produkuje" ,JOptionPane.INFORMATION_MESSAGE);


    }
}
