package DziałProgramowy;

public class UmowaODzieło extends Umowy{

	private String nazwa;
	private double wynagrodzenie;
	private String terminRealizacji;

	public UmowaODzieło(double wynagrodzenie, String terminRealizacji)
	{
		nazwa="Umowa o dzieło";
		this.terminRealizacji=terminRealizacji;
		this.wynagrodzenie=wynagrodzenie;
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
