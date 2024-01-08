package Definiranje_Proizvodaca_Gitare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

public class Definiranje_Proizvodaca_Gitare_CTRL {
	

	
	private List <Proizvodac_Gitare_Model> lista_Proizvodaca_Gitara = new ArrayList <Proizvodac_Gitare_Model >(); // NAPRAVLJENA LISTA PROIZVODACA GITARA
	
	
	
	
	public void ubaci_korisnicki_unos (Proizvodac_Gitare_Model korisnickiUnos) {  //  Ubacivanje korisnickog unosa u model
		
		lista_Proizvodaca_Gitara.add(korisnickiUnos);
	
	spremanje_u_datoteku();
	
	}




public void spremi_iz_modela_u_datoteku (Proizvodac_Gitare_Model korisnickiUnos ) { // spremanje iz modela u listu
	
	spremanje_u_datoteku();
		

	}





private void spremanje_u_datoteku (){ //spremanje iz modela u datoteku
	try {
		FileOutputStream upisUDatoteku = new FileOutputStream("Proizvodaci_Gitara.dat");
		ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
		upisObjekta.writeObject (lista_Proizvodaca_Gitara);
	} catch (IOException e){
		e.printStackTrace();
	}

}



//_______________________________________________________________________________________________________________________________________________________




public List <Proizvodac_Gitare_Model> dohvati_datoteku_u_combo() {  //pozivanjem ove funkcije stvaramo prikaz u kombu
	
	ucitajIzDatoteke();
	
	return lista_Proizvodaca_Gitara;
		
}

private void ucitajIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("Proizvodaci_Gitara.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			lista_Proizvodaca_Gitara = (List <Proizvodac_Gitare_Model>) citajObjekt.readObject();
		}
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
}


//____________________________________________________________________________________________________________________________________-

public void spremi(Proizvodac_Gitare_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI
	
	
	int index = lista_Proizvodaca_Gitara.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_Proizvodaca_Gitara.set(index, korisnickiUnos);
		
		spremanje_u_datoteku();

	}
}

//_________________________________________________________________________________________________________________________________--

public void obrisi(Proizvodac_Gitare_Model korisnickiUnos) {
	
	
	int index = lista_Proizvodaca_Gitara.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_Proizvodaca_Gitara.remove(index);
		
		spremanje_u_datoteku();

	}
}




	




	
}
