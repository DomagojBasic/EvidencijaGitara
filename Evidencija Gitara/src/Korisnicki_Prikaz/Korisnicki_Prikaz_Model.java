package Korisnicki_Prikaz;

import java.io.Serializable;

import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

public class Korisnicki_Prikaz_Model implements Serializable {

	private String Ime_Prezime;
	private String Dojam;
	public String getIme_Prezime() {
		return Ime_Prezime;
	}
	public void setIme_Prezime(String ime_Prezime) {
		Ime_Prezime = ime_Prezime;
	}
	public String getDojam() {
		return Dojam;
	}
	public void setDojam(String dojam) {
		Dojam = dojam;
	}
	
	

	
}
