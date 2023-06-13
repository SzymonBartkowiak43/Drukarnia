package DziałProgramowy;

import DziałHandlu.Czasopismo;
import DziałHandlu.Ksiązka;

public class UmowaODzieło extends Umowy{

	private String nazwa;
	private double wynagrodzenie;
	private String terminRealizacji;
	private Ksiązka książka;
	private Czasopismo czasopismo;

	public UmowaODzieło(double wynagrodzenie, String terminRealizacji)
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

	public String getTerminRealizacji()
	{
		return terminRealizacji;
	}

	public  double getWynagrodzenie()
	{
		return wynagrodzenie;
	}

}
