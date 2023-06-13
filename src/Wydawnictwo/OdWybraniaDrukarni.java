package Wydawnictwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Wydawnictwo.Frame.działDruku;

public class OdWybraniaDrukarni implements ActionListener {
    private JComboBox comboBox;
    private JButton button;
    private JFrame frame2;
    private JLabel label;
    private JTextField textField;

    OdWybraniaDrukarni(JTextField textField) {
        this.textField = textField;
        frame2 = new JFrame("Drukarnie");
        frame2.setSize(300,150);

        button = new JButton("Zatwierdź");

        String[] drukarnie = {"Zwykla Drukarnia 1","Zwykla Drukarnia 2","Drukarnia Wszystkiego"};
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
            działDruku.wybierzDrukarnie(wyb);
            textField.setText("Aktualnie wybrana drukarnia: " + działDruku.getAktualnaDrukarnia());
            frame2.dispose();
        }

    }
}
