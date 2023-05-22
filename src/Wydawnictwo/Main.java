package Wydawnictwo;

import DziałDruku.Drukarnie;
import DziałDruku.ZwykłaDrukarnia;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) {
//       Autor adam = new Autor("Adam", "Rogowski", 8.2, 4000);
//       Autor Bartek = new Autor("Bartek", "Godlewski", 5.2, 6000);
//       Autor Czarek = new Autor("Cezary", "Bąk", 6.2, 4000);
//
//       Autorzy au = new Autorzy();
//
//       au.dodajAutora(adam);
//       au.dodajAutora(Bartek);
//       au.dodajAutora(Czarek);
//
//       for(Autor autor : au.getAutorzy()){
//           System.out.println( autor.getImie()  + " " +
//                  autor.getNazwisko() + " Ocena: " + autor.getOcena() +
//                   " Chce zarabiać: " + autor.getIleChceZarabiać() );
//       }
//
//       DziałProgramowy an= new DziałProgramowy();
//       an.zatrudnijAutorow(au);
//       for(Autor autor1 : an.getZatrudnieniAutorzy())
//    	   System.out.println( "Zatrudnieni "+ autor1.getImie()  + " " +
//                   autor1.getNazwisko() + " Ocena: " + autor1.getOcena() +
//                    " Chce zarabiać: " + autor1.getIleChceZarabiać() );


        Drukarnie ZD = new ZwykłaDrukarnia();

        ZD.zacznijDrukować("Ania", 100);

        Scanner sc = new Scanner(System.in);

        ZD.wypiszStanDruku();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ZD.wypiszStanDruku();
        ZD.wypiszStanDruku();
        ZD.wypiszStanDruku();
        ZD.wypiszStanDruku();




    }
}