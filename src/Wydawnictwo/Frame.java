package Wydawnictwo;

import DziałDruku.DziałDruku;
import DziałHandlu.Ksiązka;

import javax.swing.*;
import java.awt.*;
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
    protected JLabel label;
    protected JButton buttoncofanie;
    protected JButton buttonZlecD;
    protected JButton buttonPokCoDrukuje;
    protected JButton buttonPokKolejke;
    protected JButton buttonPozGotoweDoOdbioru;
    protected JButton buttonWybDrukarnie;
    protected  JTextField akutualnaDrukarnia;

    public static DziałDruku działDruku = new DziałDruku();

    Frame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setName("Wydawnictwo");
        this.setSize(800,800);
        this.setLocationRelativeTo(null);

        label = new JLabel();
        miastoIcon = new ImageIcon("58585.png");
        label.setIcon(miastoIcon);

        buttonDD = new JButton("Dział Druku");
        buttonDD.setBounds(100,100,180,60);
        buttonDD.addActionListener(this);

        buttonDH = new JButton("Dział Handlu");
        buttonDH.setBounds(300,100,180,60);
        buttonDH.addActionListener(this);

        buttonDP = new JButton("Dział Programowy");
        buttonDP.setBounds(500,100,180,60);
        buttonDP.addActionListener(this);


        label.add(buttonDP);
        label.add(buttonDH);
        label.add(buttonDD);

        iconaCofnięcia = new ImageIcon("Cofnięcie.png");
        buttoncofanie = new JButton(iconaCofnięcia);
        buttoncofanie.setBounds(740,0,60,60);
        buttoncofanie.addActionListener(this);
        buttoncofanie.setVisible(false);


        label.add(buttoncofanie);

        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDD) {
            this.setName("Dział Druku");
            buttonDD.setVisible(false);
            buttonDH.setVisible(false);
            buttonDP.setVisible(false);

            buttonZlecD = new JButton("Zlec drukowanie");
            buttonZlecD.setVisible(true);
            buttonZlecD.setBounds(0,50,300,50);
            buttonZlecD.addActionListener(this);

            buttonPokCoDrukuje  = new JButton("Pokaż co sie drukuje");
            buttonPokCoDrukuje.setVisible(true);
            buttonPokCoDrukuje.setBounds(0,150,300,50);
            buttonPokCoDrukuje.addActionListener(this);

            buttonPokKolejke = new JButton("Pokaz kolejke drukowania");
            buttonPokKolejke.setVisible(true);
            buttonPokKolejke.setBounds(0,250,300,50);
            buttonPokKolejke.addActionListener(this);

            buttonPozGotoweDoOdbioru = new JButton("Pokaz pozycje gotowe do odbioru");
            buttonPozGotoweDoOdbioru.setVisible(true);
            buttonPozGotoweDoOdbioru.setBounds(0,350,300,50);
            buttonPozGotoweDoOdbioru.addActionListener(this);

            buttonWybDrukarnie = new JButton("Wybierz Drukarnie");
            buttonWybDrukarnie.setVisible(true);
            buttonWybDrukarnie.setBounds(0,450,300,50);
            buttonWybDrukarnie.addActionListener(this);

            akutualnaDrukarnia = new JTextField();
            akutualnaDrukarnia.setFont(new Font("MV BOli", Font.PLAIN,15));
            akutualnaDrukarnia.setVisible(true);
            akutualnaDrukarnia.setBounds(0,550,400,40);
            akutualnaDrukarnia.setBackground(Color.black);
            akutualnaDrukarnia.setForeground(Color.pink);
            akutualnaDrukarnia.setText("Aktualnie wybrana drukarnia: " + działDruku.getAktualnaDrukarnia());
            akutualnaDrukarnia.setEditable(false);

            drukIkona = new ImageIcon("Drukarnia.png");

            label.setIcon(drukIkona);
            label.add(buttonZlecD);
            label.add(buttonPokCoDrukuje);
            label.add(buttonPokKolejke);
            label.add(buttonPozGotoweDoOdbioru);
            label.add(buttonWybDrukarnie);
            label.add(akutualnaDrukarnia);

            buttoncofanie.setVisible(true);
            this.setVisible(true);
        }
        if(e.getSource() == buttonDH) {
            this.setName("Dział Handlowy");
            handlowyIkona = new ImageIcon("działHandlowyImage.png");
            BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
            buttoncofanie.setVisible(true);

            label.setIcon(handlowyIkona);

        }
        if(e.getSource() == buttonDP) {
            this.setName("Dział Programowy");
            programowaniaIkona = new ImageIcon("działProgramowyImage.png");
            BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
            buttoncofanie.setVisible(true);

            label.setIcon(programowaniaIkona);
        }
        if(e.getSource() == buttonZlecD) {
            new odDruku();
        }
        if(e.getSource() == buttonPokCoDrukuje) {
            new WyswietlCoDrukuje();
        }
        if(e.getSource() == buttonPokKolejke) {
            new OdWypisaniaKolejki();
        }
        if(e.getSource() == buttonPozGotoweDoOdbioru) {
            new OdPokazaniaWydrukowanych();
        }
        if(e.getSource() == buttonWybDrukarnie) {
            new OdWybraniaDrukarni(akutualnaDrukarnia);
        }
        if(e.getSource() == buttoncofanie) {
            BazoweUstawieniaDziałow.ustawieniaStronyStartowel(label,buttonDP,buttonDH,buttonDD);
            label.setIcon(miastoIcon);
        }
    }
}
