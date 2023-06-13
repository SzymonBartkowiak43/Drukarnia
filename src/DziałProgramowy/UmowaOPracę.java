package DziałProgramowy;

public class UmowaOPracę extends Umowy{
	private double pensja;
	private String okresZatrudnienia;

	private String nazwa;
	public UmowaOPracę(double pensja, String czasUmowy)
	{
		this.nazwa="Umowa o pracę";
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
