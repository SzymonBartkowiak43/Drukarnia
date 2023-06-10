package Wydawnictwo;

import DziałProgramowy.TymczasowiAutorzy;
import DziałProgramowy.Autor;
import DziałProgramowy.UmowaOPracę;
import DziałProgramowy.ZatrudnieniAutorzy;

import javax.lang.model.type.TypeMirror;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;

public class OdZatrudniania implements ChangeListener, ActionListener{
    protected JComboBox autorzy;
    protected JButton button;

    protected JFrame frame;
    protected JLabel napis;
    protected JLabel umowaLabel;
    protected JRadioButton umowaOPracę;
    protected JRadioButton umowaODzieło;

    protected JComboBox umowapom1;

    protected JSlider slider;
    protected JLabel slider_wartosc;
    protected JComboBox okresZatrudnienia;
    protected JLabel okresZatrudnienia_label;

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

        JPanel panel = new JPanel();

        slider=new JSlider(1000,6000,3000);

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1000);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(1000);
        slider.setPaintLabels(true);
        slider.setVisible(false);
        slider.addChangeListener(this);

        slider_wartosc=new JLabel();
        slider_wartosc.setText("Pensja: " + slider.getValue());
        slider_wartosc.setVisible(false);

        panel.add(slider);
        panel.add(slider_wartosc);

        okresZatrudnienia_label=new JLabel("Okres zatrudnienia: ");
        okresZatrudnienia_label.setVisible(false);

        okresZatrudnienia=new JComboBox();
        okresZatrudnienia.setEditable(true);
        okresZatrudnienia.setVisible(false);
        okresZatrudnienia.addActionListener(this);


        button= new JButton("Zatwierdz");

        String[] umowapom1text={"UmowaOPracę", "UmowaODzieło"};
        umowapom1 = new JComboBox(umowapom1text);



        button.addActionListener(this);

        frame.add(napis);
        frame.add(autorzy);
        frame.add(button);
        frame.add(umowaLabel);
        frame.add(umowaODzieło);
        frame.add(umowaOPracę);
        frame.add(panel);
        frame.add(okresZatrudnienia_label);
        frame.add(okresZatrudnienia);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==button)
        {
            Autor autorpom = TymczasowiAutorzy.getTymczasowiAutorzy().get(autorzy.getSelectedIndex());
            TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
            if(umowapom1.getSelectedItem().toString()=="UmowaODzieło")
            {


                System.out.println("umowa o dzielo ");

            }
            else if(umowapom1.getSelectedItem().toString()=="UmowaOPracę")
            {
                autorpom.wybierzUmowę(new UmowaOPracę(slider.getValue(), okresZatrudnienia.getSelectedItem().toString()));
                System.out.println("umowa o prace");

            }
            TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
            ZatrudnieniAutorzy.dodajAutora(autorpom);
            frame.dispose();
        }

        if(e.getSource()==umowaODzieło)
        {
            slider.setVisible(true);
            slider_wartosc.setVisible(true);
            umowapom1.setSelectedItem("UmowaODzieło");
        }

        if(e.getSource()==umowaOPracę)
        {
            slider.setVisible(true);
            slider_wartosc.setVisible(true);
            okresZatrudnienia.setVisible(true);
            umowapom1.setSelectedItem("UmowaOPracę");

        }



    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource()==slider)
        {
            slider_wartosc.setText("Pensja: " + slider.getValue());
        }

    }
}
