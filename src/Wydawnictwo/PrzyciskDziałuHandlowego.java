package Wydawnictwo;

import javax.swing.*;
import java.awt.*;

public class PrzyciskDziałuHandlowego extends Frame {
    public PrzyciskDziałuHandlowego(){
        this.setName("Dział Handlowy");
        handlowyIkona = new ImageIcon("działHandlowyImage.png");
        BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
        buttoncofanie.setVisible(true);

        buttonSklep = new JButton("Sklep");
        buttonSklep.setVisible(true);
        buttonSklep.setBounds(300, 150, 300, 50);
        buttonSklep.setBackground(Color.WHITE);
        buttonSklep.setForeground(Color.BLUE);
        buttonSklep.addActionListener(this);
        buttonSklep.setFont(new Font("MV BOli", Font.PLAIN, 15));

        label.add(buttonSklep);
        label.setIcon(handlowyIkona);
    }
}
