package Wydawnictwo;

import DziałHandlu.*;
import DziałProgramowy.Autor;
import DziałProgramowy.TymczasowiAutorzy;
import DziałProgramowy.TytulyDoStworzenia;
import DziałProgramowy.ZatrudnieniAutorzy;

public class Main extends Thread {
    public static void main(String[] args) {

        new UstawieniaStartowe();


        new Frame();
    }
}
