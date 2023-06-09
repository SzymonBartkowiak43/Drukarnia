package Wydawnictwo;

import DziałProgramowy.TymczasowiAutorzy;
import DziałProgramowy.Autor;
import DziałProgramowy.UmowaOPracę;

import javax.lang.model.type.TypeMirror;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OdZatrudniania implements ActionListener{
    protected JComboBox autorzy;
    protected JButton button;

    protected JFrame frame;
    protected JLabel napis;
    protected JLabel umowaLabel;
    protected JRadioButton umowaOPracę;
    protected JRadioButton umowaODzieło;
    protected JComboBox umowaComboBox;
    protected JSlider slider;

    OdZatrudniania() {
        frame = new JFrame();
        napis = new JLabel();
        napis.setText("Lista autorów do zatrudnienia:");

        umowaLabel = new JLabel();
        umowaLabel.setText("Wybierz umowę:");

        umowaODzieło = new JRadioButton("Umowa o dzieło");
        umowaOPracę = new JRadioButton("Umowa o pracę");

        umowaODzieło.addActionListener(this);
        umowaOPracę.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(umowaOPracę);
        group.add(umowaODzieło);

        List<String> Autorzy_pom = new ArrayList<>();

        for (Autor autor : TymczasowiAutorzy.getTymczasowiAutorzy()) {
            Autorzy_pom.add(autor.getImie() + " " + autor.getNazwisko() + " Ocena: "+ autor.getOcena() + " IleChceZarabiac "+ autor.getIleChceZarabiać());
            System.out.println(autor.getImie() + " " + autor.getNazwisko() + " Ocena: "+ autor.getOcena() + " IleChceZarabiac "+ autor.getIleChceZarabiać());
        }

        autorzy = new JComboBox<>(Autorzy_pom.toArray());

        slider=new JSlider(1000,6000,3000);

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1000);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(1000);
        slider.setPaintLabels(true);
        slider.setVisible(false);


        button= new JButton("Zatwierdz");


        button.addActionListener(this);
        frame.add(napis);
        frame.add(autorzy);
        frame.add(button);
        frame.add(umowaLabel);
        frame.add(umowaODzieło);
        frame.add(umowaOPracę);
        frame.add(slider);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e)
    {
        Autor autorpom = TymczasowiAutorzy.getTymczasowiAutorzy().get(autorzy.getSelectedIndex());
        TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
        if(e.getSource()==button)
        {
            if (umowaComboBox.getSelectedItem()=="Umowa o pracę")
            {

            }
            else
            {

            }
            TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
            frame.dispose();
        }

        if(e.getSource()==umowaODzieło)
        {
            slider.setVisible(true);

        }

        if(e.getSource()==umowaOPracę)
        {
            slider.setVisible(true);
        }

    }
}
