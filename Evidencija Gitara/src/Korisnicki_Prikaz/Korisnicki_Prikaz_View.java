package Korisnicki_Prikaz;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import Definiranje_Broja_Zica_Gitare.Broj_Zica_Gitare_Model;
import Definiranje_Broja_Zica_Gitare.Definiranje_Broja_Zica_Gitare_CTRL;
import Definiranje_Godinu_Proizvodnje_Gitare.Definiranje_Godinu_Proizvodnje_Gitare_CTRL;
import Definiranje_Godinu_Proizvodnje_Gitare.Godina_Proizvodnje_Gitare_Model;
import Definiranje_Proizvodaca_Gitare.Definiranje_Proizvodaca_Gitare_CTRL;
import Definiranje_Proizvodaca_Gitare.Proizvodac_Gitare_Model;
import Definiranje_Tipa_Gitare.Definiranje_Tipa_Gitare_CTRL;
import Definiranje_Tipa_Gitare.Tip_Gitare_Model;
import Definiranje_Vrste_Drveta_Gitare.Definiranje_Vrste_Drveta_Gitare_CTRL;
import Definiranje_Vrste_Drveta_Gitare.Vrste_Drveta_Gitare_Model;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Korisnicki_Prikaz_View extends Dialog {

	protected Object result;
	protected Shell shlKorisnickiUnos;
	
	
	private Korisnicki_Prikaz_Model korisniski_unos = new Korisnicki_Prikaz_Model();
	private Korisnicki_Prikaz_CTRL definiranje_korisnickog_prikaza_CTRL = new Korisnicki_Prikaz_CTRL();
	private List <Korisnicki_Prikaz_Model> lista_ImeIPrezim ;
	
	
	private List <Korisnicki_Prikaz_Model> lista_Dojmova ; // LISTA DOJMOVA
	
	

	private List <Tip_Gitare_Model> lista_Tipova_Gitara ;
	private Definiranje_Tipa_Gitare_CTRL definiranje_tipa_gitare_CTRL = new Definiranje_Tipa_Gitare_CTRL(); // OBJEKT ZA TIP GITARE OD ADMINISTRATORA
	//_____________________________________________________________________________________________________________________________________________
	
	private List <Proizvodac_Gitare_Model> lista_Proizvodaca_Gitara;
	private Definiranje_Proizvodaca_Gitare_CTRL definiranje_proizvodaca_gitare_CTRL = new Definiranje_Proizvodaca_Gitare_CTRL(); // OBJEKT ZA PROIZVODACA GITARE OD ADMINISTRATORA
	//_____________________________________________________________________________________________________________________________________________
	
	private Definiranje_Vrste_Drveta_Gitare_CTRL definiranje_Vrste_Drveta_Gitare_CTRL = new Definiranje_Vrste_Drveta_Gitare_CTRL();
	private List <Vrste_Drveta_Gitare_Model> lista_Vrste_drveta;
	//_____________________________________________________________________________________________________________________________________________
	
	private Definiranje_Godinu_Proizvodnje_Gitare_CTRL definiranje_godinu_proizvodnje_gitare_CTRL = new Definiranje_Godinu_Proizvodnje_Gitare_CTRL();// stvaranje objekta CTRL
	private List <Godina_Proizvodnje_Gitare_Model> lista_godine_proizvodnje; 
	//_____________________________________________________________________________________________________________________________________________
	
	private List < Broj_Zica_Gitare_Model > lista_broja_zica;
	private Definiranje_Broja_Zica_Gitare_CTRL definiranje_Broja_Zica_Gitare_CTRL = new Definiranje_Broja_Zica_Gitare_CTRL();

	//_____________________________________________________________________________________________________________________________________________

	private Text text_Dojam;
	private Text text_ImePrezime;
	
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Korisnicki_Prikaz_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlKorisnickiUnos.open();
		shlKorisnickiUnos.layout();
		Display display = getParent().getDisplay();
		while (!shlKorisnickiUnos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlKorisnickiUnos = new Shell(getParent(), getStyle());
		shlKorisnickiUnos.setSize(450, 300);
		shlKorisnickiUnos.setText("Korisnicki Unos");
		
		Combo combo_tip_gitare = new Combo(shlKorisnickiUnos, SWT.READ_ONLY);
		combo_tip_gitare.setBounds(91, 53, 200, 23);
		

		
		Label lblOdabirGitare = new Label(shlKorisnickiUnos, SWT.NONE);
		lblOdabirGitare.setBounds(10, 10, 79, 15);
		lblOdabirGitare.setText("Odabir gitare");
		
		Label lblNewLabel = new Label(shlKorisnickiUnos, SWT.NONE);
		lblNewLabel.setBounds(15, 56, 63, 15);
		lblNewLabel.setText("Tip gitare");
		
		Label lblProizvodacGitare = new Label(shlKorisnickiUnos, SWT.NONE);
		lblProizvodacGitare.setBounds(207, 85, 91, 15);
		lblProizvodacGitare.setText("Proizvodac gitare");
		
		Combo combo_Proizvodac = new Combo(shlKorisnickiUnos, SWT.READ_ONLY);
		combo_Proizvodac.setBounds(316, 82, 106, 23);
		
		Label lblVrstaDrveta = new Label(shlKorisnickiUnos, SWT.NONE);
		lblVrstaDrveta.setBounds(10, 85, 75, 15);
		lblVrstaDrveta.setText("Vrsta drveta");
		
		Combo combo_Vrsta_drveta = new Combo(shlKorisnickiUnos, SWT.READ_ONLY);
		combo_Vrsta_drveta.setBounds(91, 82, 110, 23);
		
		Label lblGodinaProizvodnje = new Label(shlKorisnickiUnos, SWT.NONE);
		lblGodinaProizvodnje.setBounds(197, 114, 113, 15);
		lblGodinaProizvodnje.setText("Godina proizvodnje");
		
		Combo combo_Godina_Proizvodnje = new Combo(shlKorisnickiUnos, SWT.READ_ONLY);
		combo_Godina_Proizvodnje.setBounds(316, 111, 91, 23);
		
		Label lblBrojica = new Label(shlKorisnickiUnos, SWT.NONE);
		lblBrojica.setBounds(29, 114, 55, 15);
		lblBrojica.setText("Broj \u017Eica");
		
		Combo combo_broj_Zica = new Combo(shlKorisnickiUnos, SWT.READ_ONLY);
		combo_broj_Zica.setBounds(91, 111, 91, 23);
		
		Label lblDojamOGitari = new Label(shlKorisnickiUnos, SWT.NONE);
		lblDojamOGitari.setBounds(5, 169, 84, 15);
		lblDojamOGitari.setText("Dojam o gitari");
		
		text_ImePrezime = new Text(shlKorisnickiUnos, SWT.BORDER);
		
		text_Dojam = new Text(shlKorisnickiUnos, SWT.BORDER);
		text_Dojam.setBounds(91, 155, 310, 64);
		
		Button btnSpremi = new Button(shlKorisnickiUnos, SWT.NONE);
		btnSpremi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
						definiranje_korisnickog_prikaza_CTRL.spremi(korisniski_unos);
			

				if (text_ImePrezime.getText().isEmpty() || text_Dojam.getText().isEmpty()) {
					MessageBox messageBox = new MessageBox(shlKorisnickiUnos, SWT.ICON_WARNING | SWT.OK );    
					messageBox.setText("Greška");
					messageBox.setMessage("Ime i prezime moraju biti ispunjeni");
					messageBox.open();

														}

				else {
					
					korisniski_unos = new Korisnicki_Prikaz_Model();
					
					korisniski_unos.setIme_Prezime(text_ImePrezime.getText());
					definiranje_korisnickog_prikaza_CTRL.ubaci_korisnicki_unos(korisniski_unos);
					
					

					korisniski_unos = new Korisnicki_Prikaz_Model();
					
					korisniski_unos.setDojam(text_Dojam.getText());
					
					definiranje_korisnickog_prikaza_CTRL.ubaci_korisnicki_unos_Dojma(korisniski_unos);
					
					
					
				
			}
				
			}
			
		});
		btnSpremi.setBounds(91, 237, 75, 25);
		btnSpremi.setText("Spremi");
		
		Button btnZatvori = new Button(shlKorisnickiUnos, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlKorisnickiUnos.close();
				
				
			}
		});
		btnZatvori.setBounds(332, 237, 75, 25);
		btnZatvori.setText("Zatvori");
		
		
		
		
		text_ImePrezime.setBounds(207, 7, 200, 21);
		
		Label lblImeIPrezime = new Label(shlKorisnickiUnos, SWT.NONE);
		lblImeIPrezime.setBounds(115, 10, 91, 15);
		lblImeIPrezime.setText("Ime i prezime");

		
	lista_Tipova_Gitara = definiranje_tipa_gitare_CTRL.dohvati_datoteku_u_combo();  //PRIKAZ TIPA GITARE U COMBU KORISNIKA
		
		
		for (int index = 0; index < lista_Tipova_Gitara.size(); index++) {
			combo_tip_gitare.add(lista_Tipova_Gitara.get(index).getNaziv_Tipa_Gitare(), index);	
			
		}
		
		

		lista_Proizvodaca_Gitara = definiranje_proizvodaca_gitare_CTRL.dohvati_datoteku_u_combo();  //PRIKAZ PROIZVODACA GITARE U COMBU KORISNIKA
		
		
		for (int index = 0; index < lista_Proizvodaca_Gitara.size(); index++) {
			combo_Proizvodac.add(lista_Proizvodaca_Gitara.get(index).getNaziv_Proizvodac_Gitare(), index);	
			
			
		}
		
		
	lista_Vrste_drveta = definiranje_Vrste_Drveta_Gitare_CTRL.dohvati_datoteku_u_combo();  ///PRIKAZ VRSTE DRVETA GITARE U COMBU KORISNIKA
		
		
		for (int index = 0; index < lista_Vrste_drveta.size(); index++) {
			combo_Vrsta_drveta.add(lista_Vrste_drveta.get(index).getNaziv_Vrsta_Drveta(), index);	
			
			
		}
		
		
		
		lista_godine_proizvodnje = definiranje_godinu_proizvodnje_gitare_CTRL.dohvati_datoteku_u_combo(); ///PRIKAZ GODINE PROIZVODNJE GITARE U COMBU KORISNIKA
		
		for (int index = 0; index < lista_godine_proizvodnje.size(); index++) {
			combo_Godina_Proizvodnje.add(lista_godine_proizvodnje.get(index).getGodina_Proizvodnje(), index);	
			
			
			
		}
	
		
		lista_broja_zica = definiranje_Broja_Zica_Gitare_CTRL.dohvati_datoteku_u_combo(); ///PRIKAZ BROJA ŽICA GITARE U COMBU KORISNIKA
		for (int index = 0; index < lista_broja_zica.size(); index++) {
			
			combo_broj_Zica.add(lista_broja_zica.get(index).getBroj_Zica(), index);	
			
			
		}
		
		
		
		
	}
}
