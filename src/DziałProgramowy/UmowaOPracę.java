package DziałProgramowy;

public class UmowaOPracę extends Umowy{
	private String nazwa;
	private double pensja;
	private String okresZatrudnienia;
	
	public UmowaOPracę(double pensja, String czasUmowy)
	{
		nazwa="Umowa o pracę";
		this.pensja=pensja;
		this.okresZatrudnienia=okresZatrudnienia;
	}
	public String getNazwa()
	{
		return nazwa;
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
