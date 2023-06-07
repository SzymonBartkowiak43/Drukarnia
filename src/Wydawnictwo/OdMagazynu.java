package Wydawnictwo;

import DziałHandlu.MagazynSklepu;

import javax.swing.*;

public class OdMagazynu {

    public OdMagazynu() {
        String wyswietlany = MagazynSklepu.wyswietlZawartoscSklepu();

        JOptionPane.showMessageDialog(null,
                wyswietlany, "Magazyn" ,JOptionPane.INFORMATION_MESSAGE);
    }

}
