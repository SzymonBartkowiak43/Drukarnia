package Wydawnictwo;

import java.util.ArrayList;
import java.util.List;

public class DziałProgramowy {

    List<Autor> zatrudnieniAutorzy = new ArrayList<>();

    public void zatrudnijAutorow(Autorzy autorzy) 
    {
        List<Autor> listaWszystkichAutorow = autorzy.getAutorzy();
        for (Autor autor : listaWszystkichAutorow) {
            if (autor.getOcena() > 5.0 && autor.getIleChceZarabiać()< 5000) {
            	zatrudnieniAutorzy.add(autor);
            }
        }
    }
    public List<Autor> getZatrudnieniAutorzy() {
        return zatrudnieniAutorzy;
    }
}
