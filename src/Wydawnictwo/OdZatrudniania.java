package Wydawnictwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class OdZatrudniania {
    protected JButton button;
    OdZatrudniania() {
        JFrame frame= new JFrame();
        button=new JButton();
        frame.add(button);
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}

