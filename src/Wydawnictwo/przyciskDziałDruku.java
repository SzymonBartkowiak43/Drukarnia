package Wydawnictwo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class przyciskDziałDruku extends JFrame implements ActionListener {

    JLabel label;
    ImageIcon drukIkona;
    przyciskDziałDruku() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setName("Wydawnictwo");
        this.setSize(800,800);
        this.setLocationRelativeTo(null);

        label = new JLabel();
        drukIkona = new ImageIcon("Drukarnia.png");
        label.setIcon(drukIkona);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
