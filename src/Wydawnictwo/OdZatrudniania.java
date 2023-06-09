package Wydawnictwo;

import DziałProgramowy.TymczasowiAutorzy;
import DziałProgramowy.Autor;

import javax.lang.model.type.TypeMirror;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class OdZatrudniania {
    protected JComboBox autorzy;
    OdZatrudniania() {
        JFrame frame= new JFrame();



        List<String> Autorzy_pom=new ArrayList<>();

        TymczasowiAutorzy autorzy_pom1=new TymczasowiAutorzy();

        for(Autor autor: autorzy_pom1.getTymczasowiAutorzy())
        {
            Autorzy_pom.add(autor.getImie()+autor.getNazwisko()+autor.getOcena()+autor.getIleChceZarabiać());
        }

        autorzy=new JComboBox<>(Autorzy_pom.toArray());


        frame.add(autorzy);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {

    }
}

