package Wydawnictwo;

import DziałDruku.DziałDruku;
import DziałHandlu.*;
import DziałProgramowy.Autor;
import DziałProgramowy.DziałProgramowy;
import DziałProgramowy.TytulyDoStworzenia;
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
    protected TytulyDoStworzenia tytuly = new TytulyDoStworzenia();

    protected JComboBox<Object> romanseBox;

    protected JTextField akutualnaDrukarnia;

    protected JComboBox<Object> autorBox;

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
            romanseBox= new JComboBox(Romanse.toArray());
            romanseBox.addActionListener(this);
            romanseBox.setVisible(true);

            romanseBox.setBounds(0,0,200,100);
            label.add(romanseBox);
            }

            if(e.getSource()==romanseBox)
            {
                String wybor=romanseBox.getSelectedItem().toString();

                BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
                buttoncofanie.setVisible(true);

                TymczasowiAutorzy autorzy_pom=new TymczasowiAutorzy();

                DziałProgramowy zatrudnieniautorzy = new DziałProgramowy();
                zatrudnieniautorzy.zatrudnijTymAutorow(autorzy_pom);
                System.out.println(wybor);

                System.out.println("Wybierz autora:");

                List<String> Autorzy = new ArrayList<>();
                int i=0;
                for (Autor autor : zatrudnieniautorzy.getZatrudnieniAutorzy()) {
                    Autorzy.add(autor.getImie()+" "+autor.getNazwisko()+", Ocena: "+autor.getOcena());
                }

                autorBox= new JComboBox(Autorzy.toArray());
                autorBox.addActionListener(this);
                autorBox.setBounds(200,200,200,100);
                autorBox.setVisible(true);
                Ksiązka ksiazka_pom;
                if(e.getSource()==autorBox) {
                    ksiazka_pom = new Ksiązka(wybor, zatrudnieniautorzy.getZatrudnieniAutorzy().get(autorBox.getSelectedIndex()), 122.3, 424);
                    System.out.println(ksiazka_pom.getTytul() + " " + ksiazka_pom.getAutor().getImie() + " " +
                            ksiazka_pom.getAutor().getNazwisko() + " " + ksiazka_pom.getCena());
                }


                label.add(autorBox);
            }

            if (e.getSource() == buttonCzasopisma) {
                BazoweUstawieniaDziałow.ukryjWszyskiePrzyciski(label);
                buttoncofanie.setVisible(true);
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
        }
    }



