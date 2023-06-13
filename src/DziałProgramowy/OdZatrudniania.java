package DziałProgramowy;

import DziałHandlu.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OdZatrudniania implements ChangeListener, ActionListener {
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
            Autorzy_pom.add(autor.getImie() + " " + autor.getNazwisko() + " Ocena: " + autor.getOcena() + " IleChceZarabiac " + autor.getIleChceZarabiać());
            System.out.println(autor.getImie() + " " + autor.getNazwisko() + " Ocena: " + autor.getOcena() + " IleChceZarabiac " + autor.getIleChceZarabiać());
        }

        autorzy = new JComboBox<>(Autorzy_pom.toArray());

        JPanel panel = new JPanel();

        slider = new JSlider(1000, 6000, 3000);

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1000);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(1000);
        slider.setPaintLabels(true);
        slider.setVisible(false);
        slider.addChangeListener(this);

        slider_wartosc = new JLabel();
        slider_wartosc.setText("Pensja: " + slider.getValue());
        slider_wartosc.setVisible(false);

        panel.add(slider);
        panel.add(slider_wartosc);

        okresZatrudnienia_label = new JLabel("Okres zatrudnienia: ");
        okresZatrudnienia_label.setVisible(false);

        String[] data = {"Ile dni?"};

        okresZatrudnienia = new JComboBox(data);
        okresZatrudnienia.setEditable(true);
        okresZatrudnienia.setVisible(false);
        okresZatrudnienia.addActionListener(this);

        okresNapisania_label = new JLabel("Okres na napisanie: ");
        okresNapisania_label.setVisible(false);

        String[] tytuł = {"Podaj tytuł dzieła"};
        tytułDzieła = new JComboBox(tytuł);
        tytułDzieła.setEditable(true);
        tytułDzieła.setVisible(false);
        tytułDzieła.addActionListener(this);

        String[] gatunek = {"Romanse", "Sensacyjne", "Albumy", "Miesięczniki", "Tygodniki"};
        gatunekDzieła = new JComboBox(gatunek);
        gatunekDzieła.setVisible(false);
        gatunekDzieła.addActionListener(this);


        button = new JButton("Zatwierdz");

        String[] umowapom1text = {"UmowaOPracę", "UmowaODzieło"};
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

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            if (TymczasowiAutorzy.getTymczasowiAutorzy().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nikt nie złożył CV",
                        "ERROR", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
            else {
                int czasZatrudnieniaNapisania = Integer.parseInt(okresZatrudnienia.getSelectedItem().toString());
                Random random = new Random();
                double cena = random.nextDouble(200) + 40;
                int iloscStron = random.nextInt(300) + 40;
                int numer = random.nextInt(8) + 1;
                String tytul = tytułDzieła.getSelectedItem().toString();
                double pensja=slider.getValue();

                UmowaODzieło umowa = new UmowaODzieło(pensja, czasZatrudnieniaNapisania);

                Autor autorpom = TymczasowiAutorzy.getTymczasowiAutorzy().get(autorzy.getSelectedIndex());

                CzasZatrudnienia t = new CzasZatrudnienia(czasZatrudnieniaNapisania);
                t.setAutorpom(autorpom);
                t.setPensja(slider.getValue());
                t.setIndexAutora(autorzy.getSelectedIndex());

                if (umowapom1.getSelectedItem().toString() == "UmowaODzieło") {
                    t.setUmowa("Umowa o dzieło");
                    t.start();
                    if (gatunekDzieła.getSelectedItem().equals("Albumy")) {
                        Ksiązka albumTworzony = new Ksiązka(tytul, autorpom, cena, iloscStron);
                        umowa.setKsiążka(albumTworzony);
                        ListaDostepnychKsiazekDoDrukowania.dodajAlbum(albumTworzony);
                        System.out.println("Album ");
                    } else if (gatunekDzieła.getSelectedItem().equals("Romanse")) {
                        Ksiązka romansTworzony = new Romanse(tytul, autorpom, cena, iloscStron);
                        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(romansTworzony);
                        umowa.setKsiążka(romansTworzony);
                    } else if (gatunekDzieła.getSelectedItem().equals("Sensacyjne")) {
                        Ksiązka sensacyjnaTworzona = new Sensacyjne(tytul, autorpom, cena, iloscStron);
                        ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(sensacyjnaTworzona);
                        umowa.setKsiążka(sensacyjnaTworzona);
                    } else if (gatunekDzieła.getSelectedItem().equals("Miesięczniki")) {
                        Czasopismo miesięcznikTworzony = new Miesięczniki(tytul, autorpom, numer, cena);
                        umowa.setCzasopismo(miesięcznikTworzony);
                        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(miesięcznikTworzony);
                    } else if (gatunekDzieła.getSelectedItem().equals("Tygodniki")) {
                        Czasopismo tygodnikTworzony = new Tygodnik(tytul, autorpom, numer, cena);
                        umowa.setCzasopismo(tygodnikTworzony);
                        ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(tygodnikTworzony);
                    }
                    TymczasowiAutorzy.getTymczasowiAutorzy().remove(autorzy.getSelectedIndex());
                    autorpom.wybierzUmowę(umowa);

                }
                else if (umowapom1.getSelectedItem().toString() == "UmowaOPracę") {

                    int ilośćDni=90;
                    if (czasZatrudnieniaNapisania<ilośćDni)
                    {
                        JOptionPane.showMessageDialog(null, "Okres trawania umowy musi być dłuższy niż 90 dni",
                                "ERROR", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        t.setUmowa("Umowa o pracę");
                        t.start();
                        autorpom.wybierzUmowę(new UmowaOPracę(pensja, czasZatrudnieniaNapisania));
                        ZatrudnieniAutorzy.dodajAutora(autorpom);
                        System.out.println("umowa o prace");
                    }
                }

                frame.dispose();
            }
        }


            if (e.getSource() == umowaODzieło) {
                slider.setVisible(true);
                slider_wartosc.setVisible(true);
                okresZatrudnienia.setVisible(true);
                okresZatrudnienia_label.setVisible(false);
                okresNapisania_label.setVisible(true);
                tytułDzieła.setVisible(true);
                gatunekDzieła.setVisible(true);

                umowapom1.setSelectedItem("UmowaODzieło");
            }

            if (e.getSource() == umowaOPracę) {
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
        public void stateChanged (ChangeEvent e)
        {
            if (e.getSource() == slider) {
                slider_wartosc.setText("Pensja: " + slider.getValue());
            }

        }

}
