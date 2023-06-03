package Wydawnictwo;

import DziałDruku.DziałDruku;
import DziałProgramowy.Autor;
import DziałProgramowy.DziałProgramowy;
import DziałProgramowy.TytulyKsiazek;
import DziałProgramowy.Ksiazka;
import DziałProgramowy.TymczasowiAutorzy;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame implements ActionListener {

    protected ImageIcon miastoIcon;
    protected ImageIcon drukIkona;
    protected ImageIcon programowaniaIkona;
    protected ImageIcon handlowyIkona;
    protected Icon iconaCofnięcia;
    protected JButton buttonDD;
    protected JButton buttonDH;
    protected JButton buttonDP;
    protected JButton buttonCzasopisma;
    protected JButton buttonZlecD;
    protected JButton buttonKS;
    protected JLabel label;
    protected JButton buttoncofanie;
    protected JButton buttonPokCoDrukuje;
    protected JButton buttonPokKolejke;
    protected JButton buttonPozGotoweDoOdbioru;
    protected JButton buttonWybDrukarnie;
    protected JButton buttonSklep;
    protected JButton romanse;
    protected JButton album;
    protected JButton sensacyjne;
    protected TytulyKsiazek tytuly = new TytulyKsiazek();

    protected JComboBox<Object> comboBox;

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
            this.setName("Dział Druku");
            buttonDD.setVisible(false);
            buttonDH.setVisible(false);
            buttonDP.setVisible(false);

            buttonZlecD = new JButton("Zlec drukowanie");
            buttonZlecD.setVisible(true);
            buttonZlecD.setBounds(0, 50, 300, 50);
            buttonZlecD.addActionListener(this);

            buttonPokCoDrukuje = new JButton("Pokaż co sie drukuje");
            buttonPokCoDrukuje.setVisible(true);
            buttonPokCoDrukuje.setBounds(0, 150, 300, 50);
            buttonPokCoDrukuje.addActionListener(this);

            buttonPokKolejke = new JButton("Pokaz kolejke drukowania");
            buttonPokKolejke.setVisible(true);
            buttonPokKolejke.setBounds(0, 250, 300, 50);
            buttonPokKolejke.addActionListener(this);

            buttonPozGotoweDoOdbioru = new JButton("Pokaz pozycje gotowe do odbioru");
            buttonPozGotoweDoOdbioru.setVisible(true);
            buttonPozGotoweDoOdbioru.setBounds(0, 350, 300, 50);
            buttonPozGotoweDoOdbioru.addActionListener(this);

            buttonWybDrukarnie = new JButton("Wybierz Drukarnie");
            buttonWybDrukarnie.setVisible(true);
            buttonWybDrukarnie.setBounds(0, 450, 300, 50);
            buttonWybDrukarnie.addActionListener(this);

            akutualnaDrukarnia = new JTextField();
            akutualnaDrukarnia.setFont(new Font("MV BOli", Font.PLAIN, 15));
            akutualnaDrukarnia.setVisible(true);
            akutualnaDrukarnia.setBounds(0, 550, 400, 40);
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
        if (e.getSource() == buttonDH) {
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
        if (e.getSource() == buttonDP) {
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
        if (e.getSource() == buttonKS) {
            BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
            buttoncofanie.setVisible(true);


            album = new JButton("Album");
            album.setBounds(100, 100, 180, 60);
            album.addActionListener(this);
            album.setVisible(true);

            romanse = new JButton("Romanse");
            romanse.setBounds(300, 100, 180, 60);
            romanse.addActionListener(this);
            romanse.setVisible(true);

            sensacyjne = new JButton("Sensacyjne");
            sensacyjne.setBounds(500, 100, 180, 60);
            sensacyjne.addActionListener(this);
            sensacyjne.setVisible(true);


            label.add(album);
            label.add(romanse);
            label.add(sensacyjne);


            for (Ksiazka ksiazka : tytuly.getTytuly()) {
                System.out.println(ksiazka.getGatunek());
            }

            }
        if (e.getSource() == romanse) {
                 BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
            buttoncofanie.setVisible(true);
            this.setLayout(new FlowLayout());
            List<String> Romanse = new ArrayList<>();

            for (Ksiazka ksiazka : tytuly.getTytuly()) {
                if (ksiazka.getGatunek() == "Romanse") {
                    System.out.println(ksiazka.getNazwa());
                    Romanse.add(ksiazka.getNazwa());
                }
            }
            comboBox= new JComboBox(Romanse.toArray());
            comboBox.addActionListener(this);
            comboBox.setVisible(true);

            this.add(comboBox);
            this.pack();
            }

            if(e.getSource()==comboBox)
            {
                BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
                buttoncofanie.setVisible(true);

                TymczasowiAutorzy autorzy_pom=new TymczasowiAutorzy();

                DziałProgramowy zatrudnieniautorzy = new DziałProgramowy();
                zatrudnieniautorzy.zatrudnijTymAutorow(autorzy_pom);
                //jutro zrobie jeszcze to wirtualnie :D bo jebia mi sie te comboBoxy i te drugie gowna
                System.out.println("Wybierz autora:");
                int i=1;
                for(Autor autor: zatrudnieniautorzy.getZatrudnieniAutorzy())
                {
                    System.out.println(i + " " + autor.getImie()+" "+autor.getNazwisko()+", Ocena: "+autor.getOcena());
                    i++;
                }

            }

            if (e.getSource() == buttonCzasopisma) {
                BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
                buttoncofanie.setVisible(true);
            }
            if (e.getSource() == buttonZlecD) {
                new odDruku();
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
        }
    }



