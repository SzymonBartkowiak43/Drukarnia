package Wydawnictwo;

import javax.swing.*;

public class PrzyciskDziałuProgramowego extends Frame {
    public PrzyciskDziałuProgramowego() {
        this.setName("Dział Programowy");
        programowaniaIkona = new ImageIcon("działProgramowyImage.png");
        BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
        buttoncofanie.setVisible(true);

        buttonKS = new JButton("Książki");
        buttonKS.setBounds(400, 100, 180, 60);
        buttonKS.addActionListener(this);
        buttonKS.setVisible(true);

        buttonCzasopisma = new JButton("Czasopisma");
        buttonCzasopisma.setVisible(true);
        buttonCzasopisma.setBounds(200, 100, 180, 60);
        buttonCzasopisma.addActionListener(this);

        label.add(buttonCzasopisma);
        label.add(buttonKS);
        label.setIcon(programowaniaIkona);
    }
}
