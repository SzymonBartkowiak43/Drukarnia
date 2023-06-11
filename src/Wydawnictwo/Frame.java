package Wydawnictwo;

import DziałDruku.DziałDruku;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    protected ImageIcon miastoIcon;
    protected ImageIcon drukIkona;
    protected ImageIcon programowaniaIkona;
    protected ImageIcon handlowyIkona;
    protected Icon iconaCofnięcia;
    protected JButton buttonDD;
    protected JButton buttonDH;
    protected JButton buttonDP;
    protected JButton buttonZlecD;
    protected JButton buttonZlecNapisanieDzieła;
    protected JLabel label;
    protected JButton buttoncofanie;
    protected JButton buttonPokCoDrukuje;
    protected JButton buttonPokKolejke;
    protected JButton buttonPozGotoweDoOdbioru;
    protected JButton buttonWybDrukarnie;
    protected JButton buttonZatrudnijAutora;
    protected JButton buttonZwolnijAutora;
    protected JButton buttonSklep;
    protected JButton buttonMagazyn;
    protected JTextField akutualnaDrukarnia;

    public static DziałDruku działDruku = new DziałDruku();



    Frame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setName("Wydawnictwo");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);

        label = new JLabel();
        miastoIcon = new ImageIcon("58585.png");
        label.setIcon(miastoIcon);

        buttonDD = new JButton("Dział Druku");
        buttonDD.setBounds(100, 100, 180, 60);
        buttonDD.addActionListener(this);

        buttonDH = new JButton("Dział Handlu");
        buttonDH.setBounds(300, 100, 180, 60);
        buttonDH.addActionListener(this);

        buttonDP = new JButton("Dział Programowy");
        buttonDP.setBounds(500, 100, 180, 60);
        buttonDP.addActionListener(this);

        label.add(buttonDP);
        label.add(buttonDH);
        label.add(buttonDD);

        iconaCofnięcia = new ImageIcon("Cofnięcie.png");
        buttoncofanie = new JButton(iconaCofnięcia);
        buttoncofanie.setBounds(740, 0, 60, 60);
        buttoncofanie.addActionListener(this);
        buttoncofanie.setVisible(false);

        label.add(buttoncofanie);

        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDD) {
            new PrzyciskDziałuDruku();
            dispose();
        }
        if (e.getSource() == buttonDH) {
            new PrzyciskDziałuHandlowego();
            dispose();
        }
        if (e.getSource() == buttonDP) {
            new PrzyciskDziałuProgramowego();
            dispose();
        }
        if (e.getSource() == buttonZlecNapisanieDzieła) {
            new OdKsiaskiTworzonej();
            }
        if (e.getSource() == buttonZatrudnijAutora) {
            new OdZatrudniania();
        }
        if (e.getSource() == buttonZwolnijAutora) {
            new OdZwalniania();
        }
            if (e.getSource() == buttonZlecD) {
                new OdDruku();
            }
            if (e.getSource() == buttonPokCoDrukuje) {
                new WyswietlCoDrukuje();
            }
            if (e.getSource() == buttonPokKolejke) {
                new OdWypisaniaKolejki();
            }
            if (e.getSource() == buttonPozGotoweDoOdbioru) {
                new OdPokazaniaWydrukowanych();
            }
            if (e.getSource() == buttonWybDrukarnie) {
                new OdWybraniaDrukarni(akutualnaDrukarnia);
            }
            if (e.getSource() == buttoncofanie) {
                BazoweUstawieniaDziałow.ustawieniaStronyStartowel(label, buttonDP, buttonDH, buttonDD);
                label.setIcon(miastoIcon);
            }
            if(e.getSource() == buttonSklep) {
                new OdSkelpu();
            }
            if(e.getSource() == buttonMagazyn) {
                new OdMagazynu();
            }
        }
    }



