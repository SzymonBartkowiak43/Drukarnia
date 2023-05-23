package DziałHandlu;

import java.util.Scanner;

import DziałProgramowy.Autor;
import DziałProgramowy.Autorzy;
import DziałProgramowy.DziałProgramowy;
import java.util.List;
public class main {

	public static void main(String[] args) {
		Autor autor1= new Autor("Cezary", "Babik", 6.2, 4572);
		Autor autor2= new Autor("Andrzej", "Duda", 1.2, 200);
		Autor autor3= new Autor("Sebastian", "Chec", 7.2, 4572);
		
		Autorzy lista_wszystkich= new Autorzy();
		lista_wszystkich.dodajAutora(autor1);
		lista_wszystkich.dodajAutora(autor2);
		lista_wszystkich.dodajAutora(autor3);
		
		int i=1;
		DziałProgramowy lista_zatrudnionych= new DziałProgramowy();
		lista_zatrudnionych.zatrudnijAutorow(lista_wszystkich);
		
		System.out.println("Wybierz autora do NAZWA_KSIAZKI ksiazki:");
		for(Autor autor: lista_zatrudnionych.getZatrudnieniAutorzy())
		{
			System.out.println(i + " " + autor.getImie() + " " + autor.getNazwisko() + 
					" Ocena: " + autor.getOcena() + " IleChceZarabiac: " + autor.getIleChceZarabiać() + "zl");
			i++;
		}
		
		Scanner scan=new Scanner(System.in);
		Ksiązka ksiazka = new Romanse("Dis nie mile widziany", lista_zatrudnionych.getZatrudnieniAutorzy().get(scan.nextInt(i)-1), 23.4, 123);

        System.out.println("Ksiazka: " + ksiazka.getTytul());
        System.out.println("Autor: " + ksiazka.getAutor().getImie() + " " + ksiazka.getAutor().getNazwisko() + " Ocena autora przez spolecznosc: "
        		+ ksiazka.getAutor().getOcena());
        System.out.println("IloscStron: " + ksiazka.getIlośćStron());
        System.out.println("Cena: " + ksiazka.getCena() + "zl");
		

	}

}
