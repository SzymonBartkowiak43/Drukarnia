package DziałProgramowy;

public class UmowaODzieło extends Umowy{
	private double wynagrodzenie;
	private String terminRealizacji;

	public UmowaODzieło(double wynagrodzenie, String terminRealizacji)
	{
		this.terminRealizacji=terminRealizacji;
		this.wynagrodzenie=wynagrodzenie;
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
