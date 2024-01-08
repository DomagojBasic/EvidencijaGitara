package Definiranje_Tipa_Gitare;

import java.io.Serializable;

public class Tip_Gitare_Model implements Serializable {
	
	private String naziv_Tipa_Gitare  ;

	public String getNaziv_Tipa_Gitare() {
		return naziv_Tipa_Gitare;
	}

	public void setNaziv_Tipa_Gitare(String naziv_Tipa_Gitare) {
		this.naziv_Tipa_Gitare = naziv_Tipa_Gitare;
	}

}
