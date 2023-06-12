package Wydawnictwo;

import DziałDruku.DziałDruku;
import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;
import DziałHandlu.ListaDostepnychCzasopismDoDrukowania;
import DziałHandlu.ListaDostepnychKsiazekDoDrukowania;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OdDruku implements ChangeListener, ActionListener {
    JFrame frame;
    JPanel panel;
    JPanel panel2;
    JLabel label;
    JSlider slider;
    JComboBox comboBox;
    JButton button;
    ImageIcon czasopismoIcon;
    ImageIcon ksiazkaIcon;
    JRadioButton czasopismoButton;
    JRadioButton ksiazkaButton;

    private List<Object> katalog;

    OdDruku() {

        frame = new JFrame("Drukarnia");
        panel = new JPanel();
        panel2 = new JPanel();
        label = new JLabel();

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

        panel2.add(ksiazkaButton);
        panel2.add(czasopismoButton);

        ksiazkaButton.setSelected(true);

        slider = new JSlider(0,1000,200);

        slider.setPreferredSize(new Dimension(200,100));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(100);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(250);

        slider.setPaintLabels(true);

        slider.setFont(new Font("MV BOli", Font.PLAIN,15));
        label.setFont(new Font("MV BOli", Font.PLAIN,25));
        slider.setOrientation(SwingConstants.HORIZONTAL);

        slider.addChangeListener(this);
        label.setText("Sztuk =  " + slider.getValue());;


        panel.add(slider);
        panel.add(label);


        ListaDostepnychKsiazekDoDrukowania tymKsiazki = new ListaDostepnychKsiazekDoDrukowania();
        katalog =  tymKsiazki.getKatalog();
        comboBox = new JComboBox();

        for(int i = 0;i < katalog.size();i++) {
            Ksiązka ksiazka = (Ksiązka) katalog.get(i);
            String dodawnie = ksiazka.getTytul();
            comboBox.addItem(dodawnie);
        }

        button = new JButton("Zatwierdź");
        button.addActionListener(this);
        button.setFont(new Font("Comic Sans", Font.BOLD,25));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEtchedBorder());



        label.setBackground(Color.pink);
        frame.setBackground(Color.pink);
        frame.add(button);
        frame.add(comboBox);
        frame.setLayout(new FlowLayout());
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.add(panel2);
        frame.add(panel);


        frame.setVisible(true);


    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == slider) {
            label.setText("Sztuk =  " + slider.getValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println(slider.getValue());
            System.out.println(comboBox.getSelectedItem());
            int index = comboBox.getSelectedIndex();

            if(ksiazkaButton.isSelected()) {
                Frame.działDruku.zlecDrukowanie((Ksiązka) katalog.get(index), slider.getValue());
            } else {
                Frame.działDruku.zlecDrukowanie((Czasopismo) katalog.get(index), slider.getValue());
            }
            frame.dispose(); // zamyka okno
        }

        if(e.getSource() == czasopismoButton) {
            comboBox.removeAllItems();

            ListaDostepnychCzasopismDoDrukowania tymCzasopisma = new ListaDostepnychCzasopismDoDrukowania();
            katalog =  tymCzasopisma.getKatalogCzasopism();

            for(int i = 0;i < katalog.size();i++) {
                Czasopismo czasopismo = (Czasopismo) katalog.get(i);
                String dodawnie = czasopismo.getTytul();
                comboBox.addItem(dodawnie);
            }
        }

        if(e.getSource() == ksiazkaButton) {
            comboBox.removeAllItems();

            ListaDostepnychKsiazekDoDrukowania tymKsiazki = new ListaDostepnychKsiazekDoDrukowania();
            katalog =  tymKsiazki.getKatalog();

            for(int i = 0;i < katalog.size();i++) {
                Ksiązka ksiazka = (Ksiązka) katalog.get(i);
                String dodawnie = ksiazka.getTytul();
                comboBox.addItem(dodawnie);
            }

        }
    }
}
