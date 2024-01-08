package Definiranje_Broja_Zica_Gitare;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import Definiranje_Godinu_Proizvodnje_Gitare.Definiranje_Godinu_Proizvodnje_Gitare_CTRL;
import Definiranje_Godinu_Proizvodnje_Gitare.Godina_Proizvodnje_Gitare_Model;
import Definiranje_Vrste_Drveta_Gitare.Vrste_Drveta_Gitare_Model;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Definiranje_Broja_Žica_Gitare_View extends Dialog {

	protected Object result;
	protected Shell shlDefiniranjeBrojaZice;
	private Text text_Broj_Zica_Gitare;

	private List < Broj_Zica_Gitare_Model > lista_broja_zica;
	
	private Definiranje_Broja_Zica_Gitare_CTRL definiranje_Broja_Zica_Gitare_CTRL = new Definiranje_Broja_Zica_Gitare_CTRL();
	
	private Broj_Zica_Gitare_Model korisnickiUnos = new Broj_Zica_Gitare_Model(); // stvaranje objekta MODELA
	
	
	
	
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Definiranje_Broja_Žica_Gitare_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDefiniranjeBrojaZice.open();
		shlDefiniranjeBrojaZice.layout();
		Display display = getParent().getDisplay();
		while (!shlDefiniranjeBrojaZice.isDisposed()) {
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
		shlDefiniranjeBrojaZice = new Shell(getParent(), getStyle());
		shlDefiniranjeBrojaZice.setSize(450, 300);
		shlDefiniranjeBrojaZice.setText("Definiranje broja \u017Eice gitare");
		
		Label lblBrojZicaGitare = new Label(shlDefiniranjeBrojaZice, SWT.NONE);
		lblBrojZicaGitare.setBounds(10, 10, 122, 15);
		lblBrojZicaGitare.setText("Broj \u017Eica na gitari");
		
		Button btnObrisi_Broj_Zica_Gitare = new Button(shlDefiniranjeBrojaZice, SWT.NONE);		
		
		Combo combo_Broj_Zica_Gitare = new Combo(shlDefiniranjeBrojaZice, SWT.READ_ONLY);
		combo_Broj_Zica_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					
				korisnickiUnos = lista_broja_zica.get(combo_Broj_Zica_Gitare.getSelectionIndex()); // prikaz iz comba u text
				text_Broj_Zica_Gitare.setText(korisnickiUnos.getBroj_Zica());
				
				btnObrisi_Broj_Zica_Gitare.setEnabled(true);
			}
		});
		combo_Broj_Zica_Gitare.setBounds(10, 31, 424, 23);
		
		
		lista_broja_zica = definiranje_Broja_Zica_Gitare_CTRL.dohvati_datoteku_u_combo(); //PRIKAZ U COMBU
	
		for (int index = 0; index < lista_broja_zica.size(); index++) {
			
			combo_Broj_Zica_Gitare.add(lista_broja_zica.get(index).getBroj_Zica(), index);	
			
			
		}
		
		
			
		
		Label lblNoviBrojZica = new Label(shlDefiniranjeBrojaZice, SWT.NONE);
		lblNoviBrojZica.setBounds(10, 60, 122, 15);
		lblNoviBrojZica.setText("Novi Broj Zica");
		
		text_Broj_Zica_Gitare = new Text(shlDefiniranjeBrojaZice, SWT.BORDER);
		text_Broj_Zica_Gitare.setBounds(10, 81, 424, 21);
		
		Button btnSpremi_Broj_Zica_Gitare = new Button(shlDefiniranjeBrojaZice, SWT.NONE);
		btnSpremi_Broj_Zica_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if (text_Broj_Zica_Gitare.getText().isEmpty()) {
					MessageBox messageBox = new MessageBox(shlDefiniranjeBrojaZice, SWT.ICON_WARNING | SWT.OK );    
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv godine proizvodnje ne može biti prazan.");
					messageBox.open();

														}

				else {
					korisnickiUnos.setBroj_Zica(text_Broj_Zica_Gitare.getText());

					definiranje_Broja_Zica_Gitare_CTRL.spremi(korisnickiUnos);

					combo_Broj_Zica_Gitare.setText(korisnickiUnos.getBroj_Zica());
					combo_Broj_Zica_Gitare.setItem(combo_Broj_Zica_Gitare.getSelectionIndex(), 
					korisnickiUnos.getBroj_Zica());
					
						}


												}
				
			
			
		});
		btnSpremi_Broj_Zica_Gitare.setBounds(10, 124, 75, 25);
		btnSpremi_Broj_Zica_Gitare.setText("Spremi");
		
		Button btnNovi_Broj_Zica_Gitare = new Button(shlDefiniranjeBrojaZice, SWT.NONE);
		btnNovi_Broj_Zica_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
		
				korisnickiUnos = new Broj_Zica_Gitare_Model();
				
				korisnickiUnos.setBroj_Zica(text_Broj_Zica_Gitare.getText());
				
				
				if(provjera_Broja_Zica(korisnickiUnos)) {
					
					
					
				definiranje_Broja_Zica_Gitare_CTRL.ubaci_korisnicki_unos(korisnickiUnos);
				
				

				combo_Broj_Zica_Gitare.setText(korisnickiUnos.getBroj_Zica());
						
						
				combo_Broj_Zica_Gitare.add(korisnickiUnos.getBroj_Zica());
						
	
				combo_Broj_Zica_Gitare.select(combo_Broj_Zica_Gitare.getItemCount() - 1);
						
						
						btnObrisi_Broj_Zica_Gitare.setEnabled(true);
						
						btnSpremi_Broj_Zica_Gitare.setEnabled(true);
						
						
						
				
				
					
					
				}
		
				
				
			}
				
		});
		btnNovi_Broj_Zica_Gitare.setBounds(112, 124, 75, 25);
		btnNovi_Broj_Zica_Gitare.setText("Novi");
		
		
		btnObrisi_Broj_Zica_Gitare.setEnabled(false);
		btnObrisi_Broj_Zica_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				

				MessageBox messageBox = new MessageBox(shlDefiniranjeBrojaZice, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        
		        messageBox.setMessage("Želite li obrisati izabrani broj žica gitare!?");
		        
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  definiranje_Broja_Zica_Gitare_CTRL.obrisi(korisnickiUnos);
						
						combo_Broj_Zica_Gitare.setText("");
						combo_Broj_Zica_Gitare.remove(combo_Broj_Zica_Gitare.getSelectionIndex());
						
						text_Broj_Zica_Gitare.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
		        
				
		        
			}
		});
		btnObrisi_Broj_Zica_Gitare.setBounds(345, 124, 75, 25);
		btnObrisi_Broj_Zica_Gitare.setText("Obri\u0161i");
		
		Button btnZatvori_Broj_Zica_Gitare = new Button(shlDefiniranjeBrojaZice, SWT.NONE);
		btnZatvori_Broj_Zica_Gitare.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDefiniranjeBrojaZice.close();
			}
		});
		btnZatvori_Broj_Zica_Gitare.setBounds(345, 220, 75, 25);
		btnZatvori_Broj_Zica_Gitare.setText("Zatvori");

	}

	


boolean provjera_Broja_Zica (Broj_Zica_Gitare_Model Unos) {
		
		if (Unos.getBroj_Zica().isEmpty()) {// PROVJERA ISTOG UNOSA
			MessageBox messageBox = new MessageBox(shlDefiniranjeBrojaZice, SWT.ICON_WARNING | SWT.OK );
			
	        messageBox.setText("Greska");
	        messageBox.setMessage("Vrsta drveta gitare ne može biti prazan.");
	        messageBox.open();
	        
	        return false;

	        
		}
		
		
		for (int index = 0; index < lista_broja_zica.size(); index ++) {// PROVJERA ISTOG IMENA
			if (lista_broja_zica.get(index).getBroj_Zica().equalsIgnoreCase(korisnickiUnos.getBroj_Zica())) {
				MessageBox messageBox = new MessageBox(shlDefiniranjeBrojaZice, SWT.ICON_WARNING | SWT.OK );

		        
		        messageBox.setText("Greška");
		        messageBox.setMessage("Naziv drveta gitare vec postoji.");
		        messageBox.open();
		       
		        return false;
			}	
		}
		return true;
	
	}



}
