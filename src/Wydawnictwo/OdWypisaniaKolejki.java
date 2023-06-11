package Wydawnictwo;

import Wydawnictwo.Frame;

import javax.swing.*;

public class OdWypisaniaKolejki {

    OdWypisaniaKolejki() {
    String wyswietlany = Frame.działDruku.pokazKolejkeDrukowania();

        JOptionPane.showMessageDialog(null,
    wyswietlany, "Kolejka" ,JOptionPane.INFORMATION_MESSAGE);
    }
}
