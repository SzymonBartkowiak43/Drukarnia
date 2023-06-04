package Wydawnictwo;

import DziałDruku.*;
import DziałHandlu.ListaDostepnychKsiazek;

public class Main extends Thread {
    public static void main(String[] args) {

        ListaDostepnychKsiazek.StartoweKsiazki();
        new Frame();

//        ZarządzanieDziałemDruku dzialdruku = new ZarządzanieDziałemDruku();
//
//        dzialdruku.zarzadzanie();
    }
}
