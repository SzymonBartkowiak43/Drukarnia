package Wydawnictwo;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;
import DziałHandlu.MagazynSklepu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OdSkelpu implements ActionListener, ChangeListener {
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
    JRadioButton kwartalnikButton;
    ImageIcon czasopismoIcon;
    ImageIcon ksiazkaIcon;
    JSlider slider;
    JLabel label;
    JButton kupButton;
    private String[] romanse;
    List<Ksiązka> katalogKs;
    List<Czasopismo> katalogCz;

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
        kwartalnikButton = new JRadioButton("Kwartalniki");
        panelGatunkow = new JPanel();

        ButtonGroup gatunkiGroup = new ButtonGroup();
        gatunkiGroup.add(romanseButton);
        gatunkiGroup.add(sensacyjneButton);
        gatunkiGroup.add(albumyButton);
        gatunkiGroup.add(tygodinkiButton);
        gatunkiGroup.add(miesiecznikButton);
        gatunkiGroup.add(kwartalnikButton);

        panelGatunkow.add(romanseButton);
        panelGatunkow.add(sensacyjneButton);
        panelGatunkow.add(albumyButton);
        panelGatunkow.add(tygodinkiButton);
        panelGatunkow.add(miesiecznikButton);
        panelGatunkow.add(kwartalnikButton);

        romanseButton.addActionListener(this);
        sensacyjneButton.addActionListener(this);
        albumyButton.addActionListener(this);

        tygodinkiButton.addActionListener(this);
        miesiecznikButton.addActionListener(this);
        kwartalnikButton.addActionListener(this);


        tygodinkiButton.setVisible(false);
        miesiecznikButton.setVisible(false);
        kwartalnikButton.setVisible(false);




        panel.add(ksiazkaButton);
        panel.add(czasopismoButton);
        panel.setBackground(Color.darkGray);



        comboBox = new JComboBox();
        comboBox.setVisible(true);
        romanseButton.setSelected(true);
        comboBox.setVisible(true);

        comboBox.removeAllItems();

        katalogKs = MagazynSklepu.zwrocKsiazki("Romanse");

        for(int i = 0;i < katalogKs.size();i++) {
            Ksiązka ksiazka = (Ksiązka) katalogKs.get(i);
            String dodawnie = ksiazka.getTytul();
            comboBox.addItem(dodawnie);
        }


        label = new JLabel();
        slider = new JSlider(0,100,20);

        slider.setPreferredSize(new Dimension(250,100));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);

        slider.setFont(new Font("MV BOli", Font.PLAIN,15));
        label.setFont(new Font("MV BOli", Font.PLAIN,20));
        slider.setOrientation(SwingConstants.HORIZONTAL);

        slider.addChangeListener(this);
        label.setText("Sztuk =  " + slider.getValue());


        label.add(slider);
        label.setVisible(true);
        slider.setVisible(true);


        kupButton = new JButton("Zatwierdz");
        kupButton.setFont(new Font("MV BOli", Font.PLAIN,50));
        kupButton.setSize(350,100);
        kupButton.setVisible(true);
        kupButton.addActionListener(this);
        kupButton.setBackground(Color.WHITE);
        kupButton.setForeground(Color.BLACK);



        ksiazkaButton.setSelected(true);


        frame.add(panel);
        frame.add(panelGatunkow);
        frame.add(comboBox);
        frame.add(slider);
        frame.add(label);
        frame.add(kupButton);
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
            kwartalnikButton.setVisible(true);
            romanseButton.setVisible(false);
            sensacyjneButton.setVisible(false);
            albumyButton.setVisible(false);
            comboBox.setVisible(false);

            comboBox.setVisible(true);
            comboBox.removeAllItems();
            tygodinkiButton.setSelected(true);

            comboBox.removeAllItems();


            katalogCz = MagazynSklepu.zwrocCzasopisma("Tygodnik");

            for(int i = 0;i < katalogCz.size();i++) {
                Czasopismo czasopismo = (Czasopismo) katalogCz.get(i);
                String dodawnie = czasopismo.getTytul();
                comboBox.addItem(dodawnie);
            }
        }
        if (e.getSource() == ksiazkaButton) {
            tygodinkiButton.setVisible(false);
            miesiecznikButton.setVisible(false);
            kwartalnikButton.setVisible(false);
            romanseButton.setVisible(true);
            sensacyjneButton.setVisible(true);
            albumyButton.setVisible(true);

            comboBox.setVisible(true);
            comboBox.removeAllItems();
            romanseButton.setSelected(true);

            comboBox.removeAllItems();

            katalogKs = MagazynSklepu.zwrocKsiazki("Romanse");

            for(int i = 0;i < katalogKs.size();i++) {
                Ksiązka ksiazka = (Ksiązka) katalogKs.get(i);
                String dodawnie = ksiazka.getTytul();
                comboBox.addItem(dodawnie);
            }
        }


        if(e.getSource() == romanseButton) {
            comboBox.setVisible(true);

            comboBox.removeAllItems();

            katalogKs = MagazynSklepu.zwrocKsiazki("Romanse");

            for(int i = 0;i < katalogKs.size();i++) {
                Ksiązka ksiazka = (Ksiązka) katalogKs.get(i);
                String dodawnie = ksiazka.getTytul();
                comboBox.addItem(dodawnie);
            }
        }
        if(e.getSource() == sensacyjneButton) {
            comboBox.setVisible(true);
            comboBox.removeAllItems();


            katalogKs = MagazynSklepu.zwrocKsiazki("Sensacyjne");

            for(int i = 0;i < katalogKs.size();i++) {
                Ksiązka ksiazka = (Ksiązka) katalogKs.get(i);
                String dodawnie = ksiazka.getTytul();
                comboBox.addItem(dodawnie);
            }

        }
        if(e.getSource() == albumyButton) {
            comboBox.setVisible(true);
            comboBox.removeAllItems();

            List<Ksiązka> katalogKs = MagazynSklepu.zwrocKsiazki("Album");

            for(int i = 0;i < katalogKs.size();i++) {
                Ksiązka ksiazka = (Ksiązka)katalogKs.get(i);
                String dodawnie = ksiazka.getTytul();
                comboBox.addItem(dodawnie);
            }
        }



        if(e.getSource() == tygodinkiButton) {
            comboBox.setVisible(true);
            comboBox.removeAllItems();


            katalogCz = MagazynSklepu.zwrocCzasopisma("Tygodnik");

            for(int i = 0;i < katalogCz.size();i++) {
                Czasopismo czasopismo = (Czasopismo) katalogCz.get(i);
                String dodawnie = czasopismo.getTytul();
                comboBox.addItem(dodawnie);
            }
        }
        if(e.getSource() == miesiecznikButton) {
            comboBox.setVisible(true);
            comboBox.removeAllItems();


            katalogCz = MagazynSklepu.zwrocCzasopisma("Miesiecznik");

            for(int i = 0;i < katalogCz.size();i++) {
                Czasopismo czasopismo = (Czasopismo) katalogCz.get(i);
                String dodawnie = czasopismo.getTytul();
                comboBox.addItem(dodawnie);
            }
        }
        if(e.getSource() == kwartalnikButton) {
            comboBox.setVisible(true);
            comboBox.removeAllItems();

            katalogCz = MagazynSklepu.zwrocCzasopisma("Kwartalnik");

            for(int i = 0;i < katalogCz.size();i++) {
                Czasopismo czasopismo = (Czasopismo) katalogCz.get(i);
                String dodawnie = czasopismo.getTytul();
                comboBox.addItem(dodawnie);
            }
        }
        if(e.getSource() == kupButton) {

           int answer = JOptionPane.showOptionDialog(null,
                    "Napewno chcesz dokonać zakupu " + slider.getValue() + " sztuk?",
                    "Zatwierdz",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    null,
                    0 );

            boolean czyWystarczy = false;
            Ksiązka wybranaKs = null;
            Czasopismo wybraneCz = null;
            int ilosc = slider.getValue();

           if(answer == 0) {
               String tytul = (String)comboBox.getSelectedItem();

               if(ksiazkaButton.isSelected()) {
                   for (Ksiązka książka : katalogKs) {
                       if (książka.getTytul().equals(tytul)) {
                           wybranaKs = książka;
                           czyWystarczy = MagazynSklepu.sprawdzCzyjestTyleSztuk(książka, ilosc);
                       }
                   }
               } else {
                   for (Czasopismo czasopismo : katalogCz) {
                       if (czasopismo.getTytul().equals(tytul)) {
                           wybraneCz = czasopismo;
                           czyWystarczy = MagazynSklepu.sprawdzCzyjestTyleSztuk(czasopismo, ilosc);
                       }
                   }
               }

           }

           if(czyWystarczy) {
               JOptionPane.showMessageDialog(null,"Gratulacje, wszystko przebiegło pomyslnie", "JEJ", JOptionPane.INFORMATION_MESSAGE);

               if(ksiazkaButton.isSelected()) {
                   MagazynSklepu.kup(wybranaKs, ilosc);
               } else
                   MagazynSklepu.kup(wybraneCz,ilosc);
               frame.dispose();

           } else {
               if(ksiazkaButton.isSelected()) {
                   JOptionPane.showMessageDialog(null, "Przepraszamy w magazynie mam tylko " + MagazynSklepu.ileDostepnychSztuk(wybranaKs) + " sztuk", "O nie", JOptionPane.ERROR_MESSAGE);
               } else {
                   JOptionPane.showMessageDialog(null, "Przepraszamy w magazynie mam tylko " + MagazynSklepu.ileDostepnychSztuk(wybraneCz) + " sztuk", "O nie", JOptionPane.ERROR_MESSAGE);
               }
               }

        }




    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == slider) {
            label.setText("Sztuk =  " + slider.getValue());
        }
    }
}
