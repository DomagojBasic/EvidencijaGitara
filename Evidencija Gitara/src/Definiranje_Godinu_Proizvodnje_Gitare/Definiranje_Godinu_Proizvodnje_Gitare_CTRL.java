package Definiranje_Godinu_Proizvodnje_Gitare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Definiranje_Proizvodaca_Gitare.Proizvodac_Gitare_Model;
import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

public class Definiranje_Godinu_Proizvodnje_Gitare_CTRL {
	
	
	
	private List < Godina_Proizvodnje_Gitare_Model > lista_godine_proizvodnje = new  ArrayList<Godina_Proizvodnje_Gitare_Model>();// NAPRAVLJENA LISTA GODINE PROIZVODNJE GITARA
	
	
	
public void ubaci_korisnicki_unos (Godina_Proizvodnje_Gitare_Model korisnickiUnos) {  //  Ubacivanje korisnickog unosa u model
		
	lista_godine_proizvodnje.add(korisnickiUnos);
	
	spremanje_u_datoteku();
	
	}





public void spremi_iz_modela_u_datoteku (Godina_Proizvodnje_Gitare_Model korisnickiUnos ) { // spremanje iz modela u listu
	
	spremanje_u_datoteku();
		

	}





private void spremanje_u_datoteku (){ //spremanje iz modela u datoteku
	try {
		FileOutputStream upisUDatoteku = new FileOutputStream("Godina_proizvodnje_Gitara.dat");
		ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
		upisObjekta.writeObject (lista_godine_proizvodnje);
	} catch (IOException e){
		e.printStackTrace();
	}

}





public List <Godina_Proizvodnje_Gitare_Model> dohvati_datoteku_u_combo() {  //pozivanjem ove funkcije stvaramo prikaz u kombu
	
	ucitajIzDatoteke();
	
	return lista_godine_proizvodnje;
		
}


private void ucitajIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("Godina_proizvodnje_Gitara.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			lista_godine_proizvodnje = (List <Godina_Proizvodnje_Gitare_Model>) citajObjekt.readObject();
		}
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
}
//______________________________________________________________________________________________________________________


public void obrisi(Godina_Proizvodnje_Gitare_Model korisnickiUnos) {
	
	
	int index = lista_godine_proizvodnje.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_godine_proizvodnje.remove(index);
		
		spremanje_u_datoteku();

	}
}

//________________________________________________________________________________________________________________________________

public void spremi(Godina_Proizvodnje_Gitare_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI
	
	
	int index = lista_godine_proizvodnje.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_godine_proizvodnje.set(index, korisnickiUnos);
		
		spremanje_u_datoteku();

	}
}

}
