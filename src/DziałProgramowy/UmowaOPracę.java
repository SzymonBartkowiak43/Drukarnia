package DziałProgramowy;

public class UmowaOPracę extends Umowy{
	private double pensja;
	private String okresZatrudnienia;
	
	public UmowaOPracę(double pensja, String czasUmowy)
	{
		this.pensja=pensja;
		this.okresZatrudnienia=okresZatrudnienia;
	}
	public double getPensja()
	{
		return pensja;
	}
	public String getokresZatrudnienia()
	{
		return okresZatrudnienia;
	}

}
