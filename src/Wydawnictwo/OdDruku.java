package Wydawnictwo;

import DziałHandlu.Ksiązka;
import DziałHandlu.ListaDostepnychKsiazek;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OdDruku implements ChangeListener, ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    JComboBox comboBox;
    JButton button;

    private List<Object> katalog;

    OdDruku() {

        frame = new JFrame("Drukarnia");
        panel = new JPanel();
        label = new JLabel();
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


        ListaDostepnychKsiazek tym = new ListaDostepnychKsiazek();
        katalog =  tym.getKatalog();
        String[] Ksiazki =  new String[katalog.size()];

        for(int i = 0;i < katalog.size();i++) {
            Ksiązka ksiazka = (Ksiązka) katalog.get(i);
            String dodawnie = ksiazka.getTytul();
            Ksiazki[i] = dodawnie;
        }
        comboBox = new JComboBox(Ksiazki);


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
        frame.setSize(500,200);
        frame.setLocationRelativeTo(null);
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
            Frame.działDruku.zlecDrukowanie((Ksiązka)katalog.get(index), slider.getValue() );

            frame.dispose(); // zamyka okno
        }
    }
}
