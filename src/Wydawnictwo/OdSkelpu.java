package Wydawnictwo;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;
import DziałHandlu.Sklep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OdSkelpu implements ActionListener {
    JFrame frame;
    JPanel panel;
    JPanel panelGatunkow;
    JComboBox comboBox;
    JRadioButton czasopismoButton;
    JRadioButton ksiazkaButton;
    JRadioButton romanseButton;
    JRadioButton sensacyjneButton;
    JRadioButton albumyButton;
    JRadioButton tygodinkiButton;
    JRadioButton miesiecznikButton;
    ImageIcon czasopismoIcon;
    ImageIcon ksiazkaIcon;
    private String[] romanse;

    public OdSkelpu() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setLayout(new FlowLayout());


        czasopismoIcon = new ImageIcon("Czasopismo.png");
        ksiazkaIcon = new ImageIcon("Ksiazka.png");
        czasopismoButton = new JRadioButton("Czasopismo");
        ksiazkaButton = new JRadioButton("Ksiazka");
        czasopismoButton.setIcon(czasopismoIcon);
        ksiazkaButton.setIcon(ksiazkaIcon);
        ButtonGroup group = new ButtonGroup();
        group.add(czasopismoButton);
        group.add(ksiazkaButton);
        ksiazkaButton.addActionListener(this);
        czasopismoButton.addActionListener(this);


        romanseButton = new JRadioButton("Romanse");
        sensacyjneButton = new JRadioButton("Sensacyjne");
        albumyButton = new JRadioButton("Albumy");

        tygodinkiButton = new JRadioButton("Tygodniki");
        miesiecznikButton = new JRadioButton("Miesieczniki");
        panelGatunkow = new JPanel();

        ButtonGroup gatunkiGroup = new ButtonGroup();
        gatunkiGroup.add(romanseButton);
        gatunkiGroup.add(sensacyjneButton);
        gatunkiGroup.add(albumyButton);
        gatunkiGroup.add(tygodinkiButton);
        gatunkiGroup.add(miesiecznikButton);

        panelGatunkow.add(romanseButton);
        panelGatunkow.add(sensacyjneButton);
        panelGatunkow.add(albumyButton);
        panelGatunkow.add(tygodinkiButton);
        panelGatunkow.add(miesiecznikButton);

        romanseButton.addActionListener(this);
        tygodinkiButton.addActionListener(this);


        tygodinkiButton.setVisible(false);
        miesiecznikButton.setVisible(false);




        panel.add(ksiazkaButton);
        panel.add(czasopismoButton);
        panel.setBackground(Color.darkGray);


        List<Ksiązka> katalog = Sklep.zwrocRomanse();
        romanse =  new String[katalog.size()];

        for(int i = 0;i < katalog.size();i++) {
            Ksiązka ksiazka = (Ksiązka) katalog.get(i);
            String dodawnie = ksiazka.getTytul();
            romanse[i] = dodawnie;
        }

        comboBox = new JComboBox(romanse);
        comboBox.setVisible(false);




        frame.add(panel);
        frame.add(panelGatunkow);
        frame.add(comboBox);
        frame.setVisible(true);
        frame.setSize(350,600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == czasopismoButton) {
            tygodinkiButton.setVisible(true);
            miesiecznikButton.setVisible(true);
            romanseButton.setVisible(false);
            sensacyjneButton.setVisible(false);
            albumyButton.setVisible(false);
            comboBox.setVisible(false);
        }
        if (e.getSource() == ksiazkaButton) {
            tygodinkiButton.setVisible(false);
            miesiecznikButton.setVisible(false);
            romanseButton.setVisible(true);
            sensacyjneButton.setVisible(true);
            albumyButton.setVisible(true);
        }
        if(e.getSource() == romanseButton) {
            comboBox.setVisible(true);

            comboBox.removeAllItems();

            List<Ksiązka> katalog = Sklep.zwrocRomanse();;

            for(int i = 0;i < katalog.size();i++) {
                Ksiązka ksiazka = (Ksiązka) katalog.get(i);
                String dodawnie = ksiazka.getTytul();
                comboBox.addItem(dodawnie);
            }
        }
        if(e.getSource() == tygodinkiButton) {
            comboBox.setVisible(true);
            comboBox.removeAllItems();


            List<Czasopismo> katalog = Sklep.zwrocTygodniki();

            for(int i = 0;i < katalog.size();i++) {
                Czasopismo czasopismo = (Czasopismo) katalog.get(i);
                String dodawnie = czasopismo.getTytul();
                comboBox.addItem(dodawnie + " " + czasopismo.getNumer());
            }

        }

    }
}
