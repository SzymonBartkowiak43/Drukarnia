package DziałProgramowy;

public class UmowaOPracę extends Umowy{
	private double pensja;
	private int okresZatrudnienia;
	private String nazwa;
	public UmowaOPracę(double pensja, int czasUmowy)
	{
		this.nazwa="Umowa o pracę";
		this.pensja=pensja;
		this.okresZatrudnienia=okresZatrudnienia;
	}
	public String getNazwa()
	{
		return nazwa;
	}


}
