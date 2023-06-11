package Wydawnictwo;

import Wydawnictwo.Frame;

import javax.swing.*;
import java.awt.*;

public class PrzyciskDziałuDruku extends Frame {


    public PrzyciskDziałuDruku() {
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
}
