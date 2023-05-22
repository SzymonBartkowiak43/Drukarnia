package Wydawnictwo;

import java.util.ArrayList;
import java.util.List;

public class Autorzy  {
    private List<Autor> autorzy = new ArrayList<>();


    public List<Autor> getAutorzy() {
        return autorzy;
    }

    public void dodajAutora(Autor autor) {
        autorzy.add(autor);
    }


}
