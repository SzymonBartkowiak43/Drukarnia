package DziałHandlu;
import java.util.List;
import java.util.ArrayList;
public class DziałHandlowy {

	 private List<Object> katalog= new ArrayList<>();

	    public void pokazKatalog() {
	        for (Object pozycja : katalog) {
	            if (pozycja instanceof Ksiązka) 
	            {
	            	Ksiązka ksiazka = (Ksiązka) pozycja;
	                System.out.println("Książka: " + ksiazka.getTytul() + " Cena: "+ ksiazka.getCena()+"zl" + " Ilosc Stron: "+ ksiazka.getIlośćStron() + ", Autor: " + ksiazka.getAutor().getImie() + " " + ksiazka.getAutor().getNazwisko());
	            } 
	            else if (pozycja instanceof Czasopismo) 
	            {
	                Czasopismo czasopismo = (Czasopismo) pozycja;
	                System.out.println("Czasopismo: " + czasopismo.getTytul()+ " Cena: "+ czasopismo.getCena()+"zl"+" Numer: "+ czasopismo.getNumer()+ ", Autor: " + czasopismo.getAutor().getImie() + " " + czasopismo.getAutor().getNazwisko() + ", Numer: " + czasopismo.getNumer());
	            }
	        }
	    }

	    public void dodajPozycje(Object pozycja) {
	        katalog.add(pozycja);
	    }




}
