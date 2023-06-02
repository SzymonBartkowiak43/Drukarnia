package Wydawnictwo;

import javax.swing.*;
import java.awt.*;

public class  BazoweUstawieniaDziałow {

    public static void ukryjWszyskiePrzyciski(JLabel label) {
    Component[] components = label.getComponents();
    for (Component component : components) {
        if (component != null) {
            component.setVisible(false);
        }
      }
    }

    public static void ustawieniaStronyStartowel(JLabel label, JButton button1,JButton button2,JButton button3 ) {
        ukryjWszyskiePrzyciski(label);
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
    }




}
