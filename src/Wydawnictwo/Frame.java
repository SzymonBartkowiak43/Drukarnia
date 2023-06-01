package Wydawnictwo;

import DziałHandlu.Ksiązka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    protected ImageIcon miastoIcon;
    protected ImageIcon drukIkona;
    protected JButton buttonDD;
    protected JButton buttonDH;
    protected JButton buttonDP;
    protected JLabel label;
    protected JButton buttonZlecD;
    protected JButton buttonPokCoDrukuje;
    protected JButton buttonPokKolejke;
    protected JButton buttonPozGotoweDoOdbioru;
    protected JButton buttonWybDrukarnie;
    protected  int ileSztuk;
    protected String ksiazka;
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

        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDD) {
            System.out.println("*Myk przechodze do działu druku*");
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

            buttonPokKolejke = new JButton("Pokaz kolejke drukowania");
            buttonPokKolejke.setVisible(true);
            buttonPokKolejke.setBounds(0,250,300,50);

            buttonPozGotoweDoOdbioru = new JButton("Pokaz pozycje gotowe do odbioru");
            buttonPozGotoweDoOdbioru.setVisible(true);
            buttonPozGotoweDoOdbioru.setBounds(0,350,300,50);

            buttonWybDrukarnie = new JButton("Wybierz Drukarnie");
            buttonWybDrukarnie.setVisible(true);
            buttonWybDrukarnie.setBounds(0,450,300,50);

            drukIkona = new ImageIcon("Drukarnia.png");

            label.setIcon(drukIkona);
            label.add(buttonZlecD);
            label.add(buttonPokCoDrukuje);
            label.add(buttonPokKolejke);
            label.add(buttonPozGotoweDoOdbioru);
            label.add(buttonWybDrukarnie);

            this.setVisible(true);
        }
        if(e.getSource() == buttonDH) {
            System.out.println("*Myk przechodze do działu hadnlu*");
        }
        if(e.getSource() == buttonDP) {
            System.out.println("*Myk przechodze do działu programowego*");
        }

        if(e.getSource() == buttonZlecD) {
            System.out.println("Zlecam Drukowanie");
            new odDruku();
        }
    }
}
