package Wydawnictwo;

import javax.swing.*;

public class PrzyciskDziałuProgramowego extends Frame {
    public PrzyciskDziałuProgramowego() {
        this.setName("Dział Programowy");
        programowaniaIkona = new ImageIcon("działProgramowyImage.png");
        BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
        buttoncofanie.setVisible(true);

        buttonZlecNapisanieDzieła = new JButton("Zlec Napisanie Dzieła");
        buttonZlecNapisanieDzieła.setBounds(400, 100, 180, 60);
        buttonZlecNapisanieDzieła.addActionListener(this);
        buttonZlecNapisanieDzieła.setVisible(true);

        buttonZatrudnijAutora = new JButton("Zatrudnij Autora");
        buttonZatrudnijAutora.setBounds(100, 100, 180, 60);
        buttonZatrudnijAutora.addActionListener(this);
        buttonZatrudnijAutora.setVisible(true);

        buttonZwolnijAutora = new JButton("Zwolnij Autora");
        buttonZwolnijAutora.setBounds(100, 180, 180, 60);
        buttonZwolnijAutora.addActionListener(this);
        buttonZwolnijAutora.setVisible(true);

        label.add(buttonZwolnijAutora);
        label.add(buttonZatrudnijAutora);
        label.add(buttonZlecNapisanieDzieła);
        label.setIcon(programowaniaIkona);
    }
}
