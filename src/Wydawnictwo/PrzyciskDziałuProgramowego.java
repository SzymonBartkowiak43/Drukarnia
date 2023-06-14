package Wydawnictwo;

import javax.swing.*;
import java.awt.*;

public class PrzyciskDziałuProgramowego extends Frame {
    public PrzyciskDziałuProgramowego() {
        this.setName("Dział Programowy");
        programowaniaIkona = new ImageIcon("działProgramowyImage.png");
        BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
        buttoncofanie.setVisible(true);

        buttonZlecNapisanieDzieła = new JButton("Zlec Napisanie Dzieła");
        buttonZlecNapisanieDzieła.setBounds(300, 100, 180, 60);
        buttonZlecNapisanieDzieła.setVisible(true);
        buttonZlecNapisanieDzieła.setBackground(Color.WHITE);
        buttonZlecNapisanieDzieła.setForeground(Color.BLUE);
        buttonZlecNapisanieDzieła.addActionListener(this);


        buttonZatrudnijAutora = new JButton("Zatrudnij Autora");
        buttonZatrudnijAutora.setBounds(300, 165, 180, 60);
        buttonZatrudnijAutora.setVisible(true);
        buttonZatrudnijAutora.setBackground(Color.WHITE);
        buttonZatrudnijAutora.setForeground(Color.BLUE);
        buttonZatrudnijAutora.addActionListener(this);

        buttonZwolnijAutora = new JButton("Zwolnij Autora");
        buttonZwolnijAutora.setBounds(300, 230, 180, 60);
        buttonZwolnijAutora.setVisible(true);
        buttonZwolnijAutora.setBackground(Color.WHITE);
        buttonZwolnijAutora.setForeground(Color.BLUE);
        buttonZwolnijAutora.addActionListener(this);

        label.add(buttonZwolnijAutora);
        label.add(buttonZatrudnijAutora);
        label.add(buttonZlecNapisanieDzieła);
        label.setIcon(programowaniaIkona);
    }
}
