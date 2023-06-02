package Wydawnictwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdWybraniaDrukarni implements ActionListener {
    private JComboBox comboBox;
    private JButton button;
    private JFrame frame2;
    private JLabel label;

    OdWybraniaDrukarni() {
        frame2 = new JFrame("Drukarnie");
        frame2.setSize(300,150);

        button = new JButton("Zatwierdź");

        String[] drukarnie = {"pierwsza Drukarnia","druga Drukarnia","lepsza Drukarnia"};
        comboBox = new JComboBox(drukarnie);
        button.addActionListener(this);
        button.setBounds(10,10,100,40);
        comboBox.setBounds(120,10,150,40);

        label = new JLabel();

        label.add(button);
        label.add(comboBox);
        frame2.add(label);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            int wyb = comboBox.getSelectedIndex() +1;
            Frame.działDruku.wybierzDrukarnie(wyb);
            frame2.dispose();
        }

    }
}
