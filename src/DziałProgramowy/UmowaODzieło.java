package DziałProgramowy;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;

public class UmowaODzieło extends Umowy{

	private String nazwa;
	private double wynagrodzenie;
	private int terminRealizacji;
	private Ksiązka książka;
	private Czasopismo czasopismo;

	public UmowaODzieło(double wynagrodzenie, int terminRealizacji)
	{
		nazwa="Umowa o dzieło";
		this.terminRealizacji=terminRealizacji;
		this.wynagrodzenie=wynagrodzenie;
	}
	public void setKsiążka(Ksiązka książka)
	{
		this.książka=książka;
	}
	public void setCzasopismo(Czasopismo czasopismo){
		this.czasopismo=czasopismo;
	}
	public String getNazwa()
	{
		return nazwa;
	}

}
