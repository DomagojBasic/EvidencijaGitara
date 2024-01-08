package Definiranje_Tipa_Gitare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Definiranje_Tipa_Gitare_CTRL {

	private List <Tip_Gitare_Model> lista_Tipova_Gitara = new ArrayList <Tip_Gitare_Model >(); // NAPRAVLJENA LISTA TIPOVA GITARA
	
	protected Shell shlDefiniranjeTipaGitare;
	
	private Tip_Gitare_Model korisnicki_unos = new Tip_Gitare_Model();
	
			
	
	
public void ubaci_korisnicki_unos (Tip_Gitare_Model korisnickiUnos) {  //  Ubacivanje korisnickog unosa u model
		
	lista_Tipova_Gitara.add(korisnickiUnos);
	
	spremanje_u_datoteku();
	
	}




public void spremi_iz_modela_u_datoteku (Tip_Gitare_Model korisnickiUnos ) { // spremanje iz modela u listu
	
	spremanje_u_datoteku();
		

	}





private void spremanje_u_datoteku (){ //spremanje iz modela u datoteku
	try {
		FileOutputStream upisUDatoteku = new FileOutputStream("Tipovi_Gitara.dat");
		ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
		upisObjekta.writeObject (lista_Tipova_Gitara);
	} catch (IOException e){
		e.printStackTrace();
	}

}


//________________________________________________________________________________________________________________________________



public List <Tip_Gitare_Model> dohvati_datoteku_u_combo() {  //pozivanjem ove funkcije stvaramo prikaz u kombu
	
	ucitajIzDatoteke();
	
	return lista_Tipova_Gitara;
		
}

private void ucitajIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("Tipovi_Gitara.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			lista_Tipova_Gitara = (List <Tip_Gitare_Model>) citajObjekt.readObject();
		}
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
}


//________________________________________________________________________________________________________________________________

public void spremi(Tip_Gitare_Model korisnickiUnos) { // IZMJENA NA TIPKI SPREMI
	
	
	int index = lista_Tipova_Gitara.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_Tipova_Gitara.set(index, korisnickiUnos);
		
		spremanje_u_datoteku();

	}
}


//_________________________________________________________________________________________________________________________________--

public void obrisi(Tip_Gitare_Model korisnickiUnos) {
	
	
	int index = lista_Tipova_Gitara.indexOf(korisnickiUnos);
	
	if (index >= 0) {
		
		lista_Tipova_Gitara.remove(index);
		
		spremanje_u_datoteku();

	}
}

}








	






