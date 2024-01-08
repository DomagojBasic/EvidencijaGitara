package Korisnicki_Prikaz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

public class Korisnicki_Prikaz_CTRL {
	
	//_________________________________________________________________________________________________________________________________________________
	//_________________________________________________________________________________________________________________________________________________
	// CONTROLER ZA SPREMANJE DOJMA O GITARI

	private List <Korisnicki_Prikaz_Model> lista_ImeIPrezime = new ArrayList<Korisnicki_Prikaz_Model>(); // NOVA LISTA

	
	
	
	

	
public void ubaci_korisnicki_unos (Korisnicki_Prikaz_Model korisnickiUnos) {  //  Ubacivanje korisnickog unosa u model
		
	lista_ImeIPrezime.add(korisnickiUnos);
	
	spremanje_u_datoteku();
	
	}




public void spremi_iz_modela_u_datoteku (Korisnicki_Prikaz_Model korisnickiUnos ) { // spremanje iz modela u listu
	
	spremanje_u_datoteku();
		

	}





private void spremanje_u_datoteku (){ //spremanje iz modela u datoteku
	try {
		FileOutputStream upisUDatoteku = new FileOutputStream("Ime_Prezime_korisnika.dat");
		ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
		upisObjekta.writeObject (lista_ImeIPrezime);
	} catch (IOException e){
		e.printStackTrace();
	}

}


//________________________________________________________________________________________________________________________________



public List <Korisnicki_Prikaz_Model> dohvati_datoteku_u_combo() {  //pozivanjem ove funkcije stvaramo prikaz u kombu
	
	ucitajIzDatoteke();
	
	return lista_ImeIPrezime;
		
}

private void ucitajIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("Ime_Prezime_korisnika.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			lista_ImeIPrezime = (List <Korisnicki_Prikaz_Model>) citajObjekt.readObject();
		}
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
}


//________________________________________________________________________________________________________________________________

public void spremi(Korisnicki_Prikaz_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI
	
	
	int index = lista_ImeIPrezime.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_ImeIPrezime.set(index, korisnickiUnos);
		
		spremanje_u_datoteku();

	}
}


//_________________________________________________________________________________________________________________________________--

public void obrisi(Tip_Gitare_Model korisnickiUnos) {
	
	
	int index = lista_ImeIPrezime.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_ImeIPrezime.remove(index);
		
		spremanje_u_datoteku();

	}
}

//_________________________________________________________________________________________________________________________________________________
//_________________________________________________________________________________________________________________________________________________
// CONTROLER ZA SPREMANJE DOJMA O GITARI



private List <Korisnicki_Prikaz_Model> lista_Dojmova = new ArrayList<Korisnicki_Prikaz_Model>(); // NOVA LISTA DOJMOVA







public void ubaci_korisnicki_unos_Dojma (Korisnicki_Prikaz_Model korisnickiUnos) {  //  Ubacivanje korisnickog unosa u model
	
	lista_Dojmova.add(korisnickiUnos);

	spremanje_u_datoteku_Dojam();

}




public void spremi_iz_modela_u_datoteku_Dojam (Korisnicki_Prikaz_Model korisnickiUnos ) { // spremanje iz modela u listu

	spremanje_u_datoteku_Dojam();
	

}





private void spremanje_u_datoteku_Dojam (){ //spremanje iz modela u datoteku
try {
	FileOutputStream upisUDatoteku = new FileOutputStream("Dojam.dat");
	ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
	upisObjekta.writeObject (lista_Dojmova);
} catch (IOException e){
	e.printStackTrace();
}

}


//________________________________________________________________________________________________________________________________





public List <Korisnicki_Prikaz_Model> dohvati_datoteku_u_combo_Dojam() {  //pozivanjem ove funkcije stvaramo prikaz u kombu

	ucitajIzDatoteke_Dojam();

return lista_Dojmova;
	
}

private void ucitajIzDatoteke_Dojam() {

try {
	FileInputStream citanjeDatoteke = new FileInputStream("Dojam.dat");
	if (citanjeDatoteke.available() > 0) {
		ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
		lista_Dojmova = (List <Korisnicki_Prikaz_Model>) citajObjekt.readObject();
	}
} catch (ClassNotFoundException e){
	e.printStackTrace();
} catch (IOException e){
	e.printStackTrace();
}
}


//________________________________________________________________________________________________________________________________

public void spremi_Dojam(Korisnicki_Prikaz_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI


int index = lista_Dojmova.indexOf(korisnickiUnos);

if (index >= 0) {
	
	lista_Dojmova.set(index, korisnickiUnos);
	
	spremanje_u_datoteku_Dojam();

}
}


//_________________________________________________________________________________________________________________________________--

public void obrisi_Dojam(Tip_Gitare_Model korisnickiUnos) {


int index = lista_Dojmova.indexOf(korisnickiUnos);

if (index >= 0) {
	
	lista_Dojmova.remove(index);
	
	spremanje_u_datoteku_Dojam();

}
}


}
