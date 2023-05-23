package DziałProgramowy;

public class UmowaOPracę extends Umowy{
	private double pensja;
	private String czasUmowy;
	private String typEtatu;
	
	public UmowaOPracę(double pensja, String czasUmowy, String typEtatu)
	{
		this.pensja=pensja;
		this.czasUmowy=czasUmowy;
		this.typEtatu=typEtatu;
	}
	public double getPensja()
	{
		return pensja;
	}
	public String getCzasUmowy()
	{
		return czasUmowy;
	}
	public String getTypEtatu()
	{
		return typEtatu;
	}

}
