package Definiranje_Vrste_Drveta_Gitare;

import java.io.Serializable;

public class Vrste_Drveta_Gitare_Model implements Serializable  {
	
	private String Naziv_Vrsta_Drveta;

	public String getNaziv_Vrsta_Drveta() {
		return Naziv_Vrsta_Drveta;
	}

	public void setNaziv_Vrsta_Drveta(String naziv_Vrsta_Drveta) {
		Naziv_Vrsta_Drveta = naziv_Vrsta_Drveta;
	}
	

}
