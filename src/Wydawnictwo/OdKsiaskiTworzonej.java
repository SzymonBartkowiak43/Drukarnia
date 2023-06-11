package Wydawnictwo;

import DziałHandlu.Ksiązka;
import DziałHandlu.ListaDostepnychKsiazekDoDrukowania;
import DziałProgramowy.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OdKsiaskiTworzonej implements ActionListener{
    protected JFrame frame;
    protected JPanel panel;
    protected JRadioButton czasopismo;
    protected JRadioButton ksiazka;
    protected JButton button;
    protected JRadioButton romanseButton;
    protected JRadioButton albumyButton;
    protected JRadioButton sensacyjneButton;
    protected JRadioButton tygodinkiButton;
    protected JRadioButton miesiecznikButton;
    protected JPanel panelGatunki;
    protected JComboBox Tytulyy;
    protected JComboBox autorComboBox;
    OdKsiaskiTworzonej()
    {
        frame=new JFrame();
        panel=new JPanel();
        frame.setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon("sunset.png");

        czasopismo = new JRadioButton("Czasopismo");
        ksiazka = new JRadioButton("Ksiazka");

        panel.add(czasopismo);
        panel.add(ksiazka);
        panel.setBounds(140, 15, 200, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(czasopismo);
        group.add(ksiazka);

        ksiazka.addActionListener(this);
        czasopismo.addActionListener(this);

        romanseButton = new JRadioButton("Romanse");
        sensacyjneButton = new JRadioButton("Sensacyjne");
        albumyButton = new JRadioButton("Albumy");

        tygodinkiButton = new JRadioButton("Tygodniki");
        miesiecznikButton = new JRadioButton("Miesieczniki");

        group.add(romanseButton);
        group.add(sensacyjneButton);
        group.add(albumyButton);
        group.add(tygodinkiButton);
        group.add(miesiecznikButton);

        panelGatunki = new JPanel();
        panelGatunki.setBounds(100, 60, 500, 30);

        panelGatunki.add(romanseButton);
        panelGatunki.add(sensacyjneButton);
        panelGatunki.add(albumyButton);
        panelGatunki.add(tygodinkiButton);
        panelGatunki.add(miesiecznikButton);

        romanseButton.addActionListener(this);
        sensacyjneButton.addActionListener(this);
        albumyButton.addActionListener(this);

        tygodinkiButton.addActionListener(this);
        miesiecznikButton.addActionListener(this);

        tygodinkiButton.setVisible(true);

        List<String> Romanse = new ArrayList<>();

        for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
            if (ksiazkaTworzona.getGatunek() == "Romanse") {
                System.out.println(ksiazkaTworzona.getNazwa());
                Romanse.add(ksiazkaTworzona.getNazwa());
            }
        }

        Tytulyy = new JComboBox<>(Romanse.toArray());


        List<String> Autorzy = new ArrayList<>();
        int i=0;
        for (Autor autor : ZatrudnieniAutorzy.getZatrudnieniAutorzy()) {
            Autorzy.add(autor.getImie()+" "+autor.getNazwisko()+", Ocena: "+autor.getOcena());
        }

        autorComboBox= new JComboBox(Autorzy.toArray());
        autorComboBox.addActionListener(this);



        button = new JButton("Zatwierdź");
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.GREEN);

        frame.add(panel);
        frame.add(panelGatunki);
        frame.add(autorComboBox);
        frame.add(Tytulyy);
        frame.add(button);
        frame.setIconImage(icon.getImage());
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);


    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ksiazka)
        {
            tygodinkiButton.setVisible(false);
            miesiecznikButton.setVisible(false);
            romanseButton.setVisible(true);
            sensacyjneButton.setVisible(true);
            albumyButton.setVisible(true);
        }

        if(e.getSource()==czasopismo)
        {
            tygodinkiButton.setVisible(true);
            miesiecznikButton.setVisible(true);
            romanseButton.setVisible(false);
            sensacyjneButton.setVisible(false);
            albumyButton.setVisible(false);
        }

        if(e.getSource()==button)
        {
            Random random = new Random();
            int cena=random.nextInt(100)+20;
            int iloscStron= random.nextInt(423)+45;

            Ksiązka ksiazka_pom = new Ksiązka(Tytulyy.getSelectedItem().toString(),
                    ZatrudnieniAutorzy.getZatrudnieniAutorzy().get(autorComboBox.getSelectedIndex()),
                    cena, iloscStron);
            ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(ksiazka_pom);

            TytulyDoStworzenia.getTytuly().remove(Tytulyy.getSelectedIndex());

            frame.dispose();
        }

        if(e.getSource()==romanseButton)
        {


            Tytulyy.removeAllItems();
            List<String> Romanse = new ArrayList<>();

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Romanse") {
                    Romanse.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }

        }

        if(e.getSource()==sensacyjneButton)
        {
            Tytulyy.removeAllItems();
            List<String> Sensacyjne = new ArrayList<>();

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Sensacyjne") {
                    Sensacyjne.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }

        }

        if(e.getSource()==albumyButton)
        {
            Tytulyy.removeAllItems();
            List<String> Albumy = new ArrayList<>();

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Album") {
                    Albumy.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }
        }

        if(e.getSource()==miesiecznikButton)
        {
            Tytulyy.removeAllItems();
            List<String> miesięczniki = new ArrayList<>();

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Miesięcznik") {
                    miesięczniki.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }
        }
        if(e.getSource()==tygodinkiButton)
        {
            Tytulyy.removeAllItems();
            List<String> tygodinkiButton = new ArrayList<>();

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Tygodnik") {
                    tygodinkiButton.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }
        }


    }


}
