package Definiranje_Proizvodaca_Gitare;

import java.io.Serializable;

public class Proizvodac_Gitare_Model implements Serializable {

	private String Naziv_Proizvodac_Gitare;

	public String getNaziv_Proizvodac_Gitare() {
		return Naziv_Proizvodac_Gitare;
	}

	public void setNaziv_Proizvodac_Gitare(String naziv_Proizvodac_Gitare) {
		Naziv_Proizvodac_Gitare = naziv_Proizvodac_Gitare;
	}
	
}
