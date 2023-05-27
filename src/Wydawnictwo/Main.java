package Wydawnictwo;

import DziałDruku.*;

public class Main extends Thread {
    public static void main(String[] args) {

        ZarządzanieDziałemDruku dzialdruku = new ZarządzanieDziałemDruku();

        dzialdruku.zarzadzanie();
    }
}
