package Wydawnictwo;

import java.util.ArrayList;
import java.util.List;

public class DziałProgramowy {

    List<Autor> zatrudnieniAutorzy = new ArrayList<>();
    List<Autor> dostępniAutorzy = new ArrayList<>();

    Autorzy au = new Autorzy();

    public void zatrudenie(Autor autor) {
        zatrudnieniAutorzy.add(autor);
    }
    public void sprawdzenieAutorow() {
        dostępniAutorzy = au.getAutorzy();

    }
}
