package DziałProgramowy;

import DziałHandlu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OdKsiaskiTworzonej implements ActionListener{
    protected JFrame frame;
    protected JPanel panel;

    protected JRadioButton czasopismo;
    protected JRadioButton ksiazka;
    protected JButton button;
    protected JRadioButton romanseButton;
    protected JRadioButton albumyButton;
    protected JRadioButton sensacyjneButton;
    protected JRadioButton tygodinkiButton;
    protected JRadioButton miesiecznikButton;
    protected JPanel panelGatunki;
    protected JComboBox Tytulyy;
    protected JComboBox autorComboBox;
    protected JComboBox gatunkiPom;
    protected JComboBox typTekstu;
    protected List<String> Romanse;
    public OdKsiaskiTworzonej()
    {
        frame=new JFrame();
        panel=new JPanel();
        frame.setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon("sunset.png");

        czasopismo = new JRadioButton("Czasopismo");
        ksiazka = new JRadioButton("Ksiazka");
        ksiazka.setSelected(true);


        panel.add(czasopismo);
        panel.add(ksiazka);
        panel.setBounds(140, 15, 200, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(czasopismo);
        group.add(ksiazka);

        ksiazka.addActionListener(this);
        czasopismo.addActionListener(this);

        romanseButton = new JRadioButton("Romanse");
        sensacyjneButton = new JRadioButton("Sensacyjne");
        albumyButton = new JRadioButton("Albumy");


        tygodinkiButton = new JRadioButton("Tygodniki");
        miesiecznikButton = new JRadioButton("Miesieczniki");

        group.add(romanseButton);
        group.add(sensacyjneButton);
        group.add(albumyButton);
        group.add(tygodinkiButton);
        group.add(miesiecznikButton);

        panelGatunki = new JPanel();
        panelGatunki.setBounds(100, 60, 500, 30);

        panelGatunki.add(romanseButton);
        panelGatunki.add(sensacyjneButton);
        panelGatunki.add(albumyButton);
        panelGatunki.add(tygodinkiButton);
        panelGatunki.add(miesiecznikButton);

        romanseButton.addActionListener(this);
        sensacyjneButton.addActionListener(this);
        albumyButton.addActionListener(this);

        tygodinkiButton.addActionListener(this);
        miesiecznikButton.addActionListener(this);

        tygodinkiButton.setVisible(true);
        String[] gatunkiPomtabela={"Romanse","Sensacyjne", "Albumy", "Miesięczniki", "Tygodniki"};
        gatunkiPom = new JComboBox(gatunkiPomtabela);

        String[] typTekstuTabela={"Romanse","Sensacyjne", "Albumy", "Miesięczniki", "Tygodniki"};
        typTekstu = new JComboBox<>(typTekstuTabela);


        Romanse = new ArrayList<>();

        for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
            if (ksiazkaTworzona.getGatunek() == "Romanse") {
                System.out.println(ksiazkaTworzona.getNazwa());
                Romanse.add(ksiazkaTworzona.getNazwa());
            }
        }

        Tytulyy = new JComboBox<>(Romanse.toArray());


        List<String> Autorzy = new ArrayList<>();
        int i=0;
        for (Autor autor : ZatrudnieniAutorzy.getZatrudnieniAutorzy()) {
            Autorzy.add(autor.getImie()+" "+autor.getNazwisko()+", Ocena: "+autor.getOcena());
        }

        autorComboBox= new JComboBox(Autorzy.toArray());
        autorComboBox.addActionListener(this);



        button = new JButton("Zatwierdź");
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.GREEN);

        frame.add(panel);
        frame.add(panelGatunki);
        frame.add(autorComboBox);
        frame.add(Tytulyy);
        frame.add(button);
        frame.setIconImage(icon.getImage());
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);


    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ksiazka)
        {
            tygodinkiButton.setVisible(false);
            miesiecznikButton.setVisible(false);
            romanseButton.setVisible(true);
            sensacyjneButton.setVisible(true);
            albumyButton.setVisible(true);

        }

        if(e.getSource()==czasopismo)
        {
            tygodinkiButton.setVisible(true);
            miesiecznikButton.setVisible(true);
            romanseButton.setVisible(false);
            sensacyjneButton.setVisible(false);
            albumyButton.setVisible(false);
        }

        if(e.getSource()==button)
        {
            if(ZatrudnieniAutorzy.getZatrudnieniAutorzy().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Aktualnie nie mamy dostępnych autorów, lub książek",
                        "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                Random random = new Random();
                double cena = random.nextInt(100) + 20;
                int iloscStron = random.nextInt(423) + 45;
                int numer = random.nextInt(8) + 1;
                String tytuł = (String)Tytulyy.getSelectedItem();
                Autor autor = ZatrudnieniAutorzy.getZatrudnieniAutorzy().get(autorComboBox.getSelectedIndex());

                if(typTekstu.getSelectedItem().equals("Romanse"))  {
                    Ksiązka dziełoKsiążka = new Romanse(tytuł,autor,cena,iloscStron);
                    ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(dziełoKsiążka);
                } else if(typTekstu.getSelectedItem().equals("Albumy")) {
                    Ksiązka dziełoAlbum = new Album(tytuł,autor,cena,iloscStron);
                    ListaDostepnychKsiazekDoDrukowania.dodajAlbum(dziełoAlbum);
                } else if(typTekstu.getSelectedItem().equals("Sensacyjne")) {
                    Ksiązka dziełoKsiążka = new Sensacyjne(tytuł,autor,cena,iloscStron);
                    ListaDostepnychKsiazekDoDrukowania.dodajKsiazke(dziełoKsiążka);
                } else if(typTekstu.getSelectedItem().equals("Tygodniki")) {
                    Czasopismo dziełoCzasopismo = new Tygodnik(tytuł,autor,numer,cena);
                    ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(dziełoCzasopismo);
                } else if(typTekstu.getSelectedItem().equals("Miesięczniki")) {
                    Czasopismo dziełoCzasopismo = new Miesięczniki(tytuł,autor,numer,cena);
                    ListaDostepnychCzasopismDoDrukowania.dodajCzasopismo(dziełoCzasopismo);
                }




                List<String>  Wszystkie_ksiazki = new ArrayList<>();

                for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                    Wszystkie_ksiazki.add(ksiazkaTworzona.getNazwa()+" "+ksiazkaTworzona.getGatunek());
                }

                for(int i=0; i<Wszystkie_ksiazki.size(); i++)
                {
                    if(Wszystkie_ksiazki.get(i).equals(Tytulyy.getSelectedItem().toString()+" "+
                            gatunkiPom.getSelectedItem().toString()))
                    {
                        TytulyDoStworzenia.getTytuly().remove(i);
                    }

                }

                frame.dispose();
            }

        }

        if(e.getSource()==romanseButton)
        {
            Tytulyy.removeAllItems();
            List<String> Romanse = new ArrayList<>();
            gatunkiPom.setSelectedItem("Romanse");
            typTekstu.setSelectedItem("Książka");

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Romanse") {
                    Romanse.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }

        }

        if(e.getSource()==sensacyjneButton)
        {
            Tytulyy.removeAllItems();
            List<String> Sensacyjne = new ArrayList<>();
            gatunkiPom.setSelectedItem("Sensacyjne");
            typTekstu.setSelectedItem("Książka");

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Sensacyjne") {
                    Sensacyjne.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }

        }

        if(e.getSource()==albumyButton)
        {
            Tytulyy.removeAllItems();
            List<String> Albumy = new ArrayList<>();
            gatunkiPom.setSelectedItem("Albumy");
            typTekstu.setSelectedItem("Album");

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Albumy") {
                    Albumy.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }
        }

        if(e.getSource()==miesiecznikButton)
        {
            Tytulyy.removeAllItems();
            List<String> miesięczniki = new ArrayList<>();
            gatunkiPom.setSelectedItem("Miesięczniki");
            typTekstu.setSelectedItem("Czasopismo");

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Miesięczniki") {
                    miesięczniki.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }
        }

        if(e.getSource()==tygodinkiButton)
        {
            Tytulyy.removeAllItems();
            List<String> tygodinkiButton = new ArrayList<>();
            gatunkiPom.setSelectedItem("Tygodniki");
            typTekstu.setSelectedItem("Czasopismo");

            for (KsiazkaTworzona ksiazkaTworzona : TytulyDoStworzenia.getTytuly()) {
                if (ksiazkaTworzona.getGatunek() == "Tygodniki") {
                    tygodinkiButton.add(ksiazkaTworzona.getNazwa());
                    Tytulyy.addItem(ksiazkaTworzona.getNazwa());
                }
            }
        }
    }
}
