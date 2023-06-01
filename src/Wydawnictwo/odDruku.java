package Wydawnictwo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class odDruku implements ChangeListener, ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    JComboBox comboBox;
    JButton button;

    odDruku() {
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


        String[] Ksiazki = {"Ania z Zielonego wzogrza", "Hary Pota", "Hobbit "};
        comboBox = new JComboBox(Ksiazki);


        button = new JButton("Zatwierdź");
        button.setBounds(100,100,250,500);
        button.addActionListener(this);
        button.setFont(new Font("Comic Sans", Font.BOLD,25));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEtchedBorder());


        frame.add(button);
        frame.add(comboBox);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.pack();
        frame.setSize(500,500);
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
            frame.dispose();

        }
    }
}
