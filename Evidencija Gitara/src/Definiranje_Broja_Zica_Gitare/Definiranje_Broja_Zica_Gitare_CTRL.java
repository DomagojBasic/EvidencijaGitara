package Definiranje_Broja_Zica_Gitare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Definiranje_Godinu_Proizvodnje_Gitare.Godina_Proizvodnje_Gitare_Model;

public class Definiranje_Broja_Zica_Gitare_CTRL {
	
	private List < Broj_Zica_Gitare_Model > lista_broj_zica = new ArrayList<Broj_Zica_Gitare_Model>();


	public void ubaci_korisnicki_unos (Broj_Zica_Gitare_Model korisnickiUnos ) { //ubacivanje brojeva u listu
		
		
		lista_broj_zica.add(korisnickiUnos);
		
		spremanje_u_datoteku();
		
			
	}

	

	public void spremi_iz_modela_u_datoteku (Broj_Zica_Gitare_Model korisnickiUnos ) { // spremanje iz modela u listu
		
		spremanje_u_datoteku();
			

		}



	private void spremanje_u_datoteku (){ //spremanje iz modela u datoteku
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("Broj_zica_gitara_dobro.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (lista_broj_zica);
		} catch (IOException e){
			e.printStackTrace();
		}

	}

	//__________________________________________________________________________________________________________________________

	


public List <Broj_Zica_Gitare_Model> dohvati_datoteku_u_combo() {  //pozivanjem ove funkcije stvaramo prikaz u kombu
	
	ucitajIzDatoteke();
	
	return lista_broj_zica;
		
}


private void ucitajIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("Broj_zica_gitara_dobro.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			lista_broj_zica = (List <Broj_Zica_Gitare_Model>) citajObjekt.readObject();
		}
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
}

//________________________________________________________________________________________________________________________________


public void obrisi(Broj_Zica_Gitare_Model korisnickiUnos) {
	
	
	int index = lista_broj_zica.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_broj_zica.remove(index);
		
		spremanje_u_datoteku();

	}
}




//________________________________________________________________________________________________________________________________

public void spremi(Broj_Zica_Gitare_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI
	
	
	int index = lista_broj_zica.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_broj_zica.set(index, korisnickiUnos);
		
		spremanje_u_datoteku();

	}
}
	

	}

	
	


