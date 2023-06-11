package Wydawnictwo;

import DziałProgramowy.Autor;
import DziałProgramowy.ZatrudnieniAutorzy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class OdZwalniania implements ActionListener {

    protected JFrame frame;
    protected JComboBox autorzyComboBox;
    protected JButton button;

    public OdZwalniania()
    {
        frame = new JFrame();
        List<String> autorzyLista = new ArrayList<>();

        for(Autor autor : ZatrudnieniAutorzy.getZatrudnieniAutorzy())
        {
            autorzyLista.add(autor.getImie()+" "+autor.getNazwisko()+" Ocena: "+autor.getOcena()+" Umowa: "+autor.getUmowa().toString());
        }

        autorzyComboBox=new JComboBox(autorzyLista.toArray());
        autorzyComboBox.addActionListener(this);

        button = new JButton("Zwolnij");
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.GREEN);

        frame.add(autorzyComboBox);
        frame.add(button);
        frame.setSize(600,700);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);

    }



    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button)
        {
            ZatrudnieniAutorzy.getZatrudnieniAutorzy().remove(autorzyComboBox.getSelectedIndex());
            frame.dispose();
        }

    }
}
