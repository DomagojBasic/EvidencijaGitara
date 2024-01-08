package Definiranje_Vrste_Drveta_Gitare;

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

public class Definiranje_Vrste_Drveta_Gitare_CTRL {
	
	private List <Vrste_Drveta_Gitare_Model> lista_Vrste_drveta = new ArrayList <Vrste_Drveta_Gitare_Model> ();
	
	

	
public void ubaci_korisnicki_unos (Vrste_Drveta_Gitare_Model korisnickiUnos) {  //  Ubacivanje korisnickog unosa u model
		
	lista_Vrste_drveta.add(korisnickiUnos);
	
	spremanje_u_datoteku();
	
	}




public void spremi_iz_modela_u_datoteku (Vrste_Drveta_Gitare_Model korisnickiUnos ) { // spremanje iz modela u listu
	
	spremanje_u_datoteku();
		

	}





private void spremanje_u_datoteku (){ //spremanje iz modela u datoteku
	try {
		FileOutputStream upisUDatoteku = new FileOutputStream("Vrsta_Drveta_Gitara.dat");
		ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
		upisObjekta.writeObject (lista_Vrste_drveta);
	} catch (IOException e){
		e.printStackTrace();
	}

}

	









public List <Vrste_Drveta_Gitare_Model> dohvati_datoteku_u_combo() {  //pozivanjem ove funkcije stvaramo prikaz u kombu
	
	ucitajIzDatoteke();
	
	return lista_Vrste_drveta;
		
}

private void ucitajIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("Vrsta_Drveta_Gitara.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			lista_Vrste_drveta = (List <Vrste_Drveta_Gitare_Model>) citajObjekt.readObject();
		}
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
}

//______________________________________________________________________________________________________________________________-



public void spremi(Vrste_Drveta_Gitare_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI
	
	
	int index = lista_Vrste_drveta.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_Vrste_drveta.set(index, korisnickiUnos);
		
		spremanje_u_datoteku();

	}
}



//_________________________________________________________________________________________________________________________________--

public void obrisi(Vrste_Drveta_Gitare_Model korisnickiUnos) {
	
	
	int index = lista_Vrste_drveta.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_Vrste_drveta.remove(index);
		
		spremanje_u_datoteku();

	}
}




	




	
}

	


