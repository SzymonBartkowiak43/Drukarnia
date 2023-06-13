package DziałProgramowy;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;
import DziałHandlu.ListaDostepnychCzasopismDoDrukowania;
import DziałHandlu.ListaDostepnychKsiazekDoDrukowania;
import DziałProgramowy.*;

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
import java.util.Random;

public class OdZatrudniania implements ChangeListener, ActionListener{
    protected JComboBox autorzy;
    protected JButton button;

    protected JFrame frame;
    protected JLabel napis;
    protected JLabel umowaLabel;
    protected JRadioButton umowaOPracę;
    protected JRadioButton umowaODzieło;
    protected JLabel okresNapisania_label;
    protected JComboBox umowapom1;

    protected JSlider slider;
    protected JLabel slider_wartosc;
    protected JComboBox okresZatrudnienia;
    protected JLabel okresZatrudnienia_label;
    protected JComboBox tytułDzieła;
    protected JComboBox gatunekDzieła;
    protected JLabel tlo;

    public OdZatrudniania() {
        frame = new JFrame();
        napis = new JLabel();
        tlo = new JLabel();
        ImageIcon icon = new ImageIcon("sunset.png");
        tlo.setIcon(icon);

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

        String[] data={"Ile dni?"};

        okresZatrudnienia=new JComboBox(data);
        okresZatrudnienia.setEditable(true);
        okresZatrudnienia.setVisible(false);
        okresZatrudnienia.addActionListener(this);

        okresNapisania_label=new JLabel("Okres na napisanie: ");
        okresNapisania_label.setVisible(false);

        String[] tytuł={"Podaj tytuł dzieła"};
        tytułDzieła=new JComboBox(tytuł);
        tytułDzieła.setEditable(true);
        tytułDzieła.setVisible(false);
        tytułDzieła.addActionListener(this);

        String[] gatunek={"Romanse","Sensacyjne","Albumy", "Miesięczniki", "Tygodniki"};
        gatunekDzieła=new JComboBox(gatunek);
        gatunekDzieła.setVisible(false);
        gatunekDzieła.addActionListener(this);


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
        frame.add(okresNapisania_label);
        frame.add(okresZatrudnienia);
        frame.add(tytułDzieła);
        frame.add(gatunekDzieła);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==button)
        {
            if(TymczasowiAutorzy.getTymczasowiAutorzy().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Nikt nie złożył CV",
                        "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                Autor autorpom = TymczasowiAutorzy.getTymczasowiAutorzy().get(autorzy.getSelectedIndex());
                TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
                if (umowapom1.getSelectedItem().toString() == "UmowaODzieło") {
                    Random random = new Random();
                    double cena = random.nextDouble(200) + 40;
                    int iloscStron = random.nextInt(300) + 40;
                    int numer = random.nextInt(8) + 1;
                    CzasZatrudnienia t = new CzasZatrudnienia(okresZatrudnienia.getSelectedIndex());
                    t.start();

                    if (gatunekDzieła.getSelectedItem().equals("Albumy")) {
                        Ksiązka albumTworzony = new Ksiązka(tytułDzieła.getSelectedItem().toString(), autorpom, cena, iloscStron);

                        UmowaODzieło umowa = new UmowaODzieło(slider.getValue(), okresZatrudnienia.getSelectedItem().toString());

                        albumTworzony.ustawGatunek("Album");

                        umowa.setKsiążka(albumTworzony);
                        autorpom.wybierzUmowę(umowa);
                        ListaDostepnychKsiazekDoDrukowania.dodajAlbum(albumTworzony);
                        System.out.println("Album ");
                    } else if (gatunekDzieła.getSelectedItem().equals("Romanse") || gatunekDzieła.getSelectedItem().equals("Sensacyjne")) {

                        Ksiązka ksiazkaTworzona = new Ksiązka(tytułDzieła.getSelectedItem().toString(), autorpom, cena, iloscStron);

                        if (gatunekDzieła.getSelectedItem().equals("Romanse"))
                            ksiazkaTworzona.ustawGatunek("Romans");
                        else if (gatunekDzieła.getSelectedItem().equals("Sensacyjne"))
                            ksiazkaTworzona.ustawGatunek("Sensacyjne");

                        UmowaODzieło umowa = new UmowaODzieło(slider.getValue(), okresZatrudnienia.getSelectedItem().toString());
                        umowa.setKsiążka(ksiazkaTworzona);

                        autorpom.wybierzUmowę(umowa);
                        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(ksiazkaTworzona);
                        System.out.println("Ksiązka ");
                    } else if (gatunekDzieła.getSelectedItem().equals("Miesięczniki") || gatunekDzieła.getSelectedItem().equals("Tygodniki")) {
                        Czasopismo czasopismoTworzone = new Czasopismo(tytułDzieła.getSelectedItem().toString(), autorpom, numer, cena);

                        if (gatunekDzieła.getSelectedItem().equals("Miesięczniki"))
                            czasopismoTworzone.ustawGatunek("Miesięcznik");
                        else if (gatunekDzieła.getSelectedItem().equals("Tygodniki"))
                            czasopismoTworzone.ustawGatunek("Tygodnik");

                        UmowaODzieło umowa = new UmowaODzieło(slider.getValue(), okresZatrudnienia.getSelectedItem().toString());
                        umowa.setCzasopismo(czasopismoTworzone);

                        autorpom.wybierzUmowę(umowa);
                        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(czasopismoTworzone);
                        System.out.println("Czasopismo ");

                    }
                    TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());

                } else if (umowapom1.getSelectedItem().toString() == "UmowaOPracę") {
                    autorpom.wybierzUmowę(new UmowaOPracę(slider.getValue(), okresZatrudnienia.getSelectedItem().toString()));
                    System.out.println("umowa o prace");

                }
                TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
                ZatrudnieniAutorzy.dodajAutora(autorpom);
                frame.dispose();
            }
        }

        if(e.getSource()==umowaODzieło)
        {
            slider.setVisible(true);
            slider_wartosc.setVisible(true);
            okresZatrudnienia.setVisible(true);
            okresZatrudnienia_label.setVisible(false);
            okresNapisania_label.setVisible(true);
            tytułDzieła.setVisible(true);
            gatunekDzieła.setVisible(true);

            umowapom1.setSelectedItem("UmowaODzieło");
        }

        if(e.getSource()==umowaOPracę)
        {
            slider.setVisible(true);
            slider_wartosc.setVisible(true);
            okresZatrudnienia.setVisible(true);
            okresZatrudnienia_label.setVisible(true);
            okresNapisania_label.setVisible(false);
            tytułDzieła.setVisible(false);
            gatunekDzieła.setVisible(false);

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
