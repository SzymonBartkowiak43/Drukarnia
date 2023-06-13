package Wydawnictwo;

import javax.swing.*;

public class OdPokazaniaWydrukowanych {

    OdPokazaniaWydrukowanych() {
        String wyswietlany = Frame.działDruku.pokazWydrukowanePozycje();

        JOptionPane.showMessageDialog(null,
                wyswietlany, "Kolejka" ,JOptionPane.INFORMATION_MESSAGE);
    }
}
