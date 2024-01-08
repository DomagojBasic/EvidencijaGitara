package Definiranje_Vrste_Drveta_Gitare;

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

import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Definiranje_Vrste_Drveta_Gitare_View extends Dialog {

	protected Object result;
	protected Shell shlDefiniranjeVrsteDrveta;
	private Text text_Vrsta_Drveta;
	
	private List <Vrste_Drveta_Gitare_Model> lista_Vrste_drveta = new ArrayList <Vrste_Drveta_Gitare_Model> ();
	private Definiranje_Vrste_Drveta_Gitare_CTRL definiranje_Vrste_Drveta_Gitare_CTRL = new Definiranje_Vrste_Drveta_Gitare_CTRL();
	
	private Vrste_Drveta_Gitare_Model korisnickiUnos = new Vrste_Drveta_Gitare_Model();
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Definiranje_Vrste_Drveta_Gitare_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDefiniranjeVrsteDrveta.open();
		shlDefiniranjeVrsteDrveta.layout();
		Display display = getParent().getDisplay();
		while (!shlDefiniranjeVrsteDrveta.isDisposed()) {
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
		shlDefiniranjeVrsteDrveta = new Shell(getParent(), getStyle());
		shlDefiniranjeVrsteDrveta.setSize(450, 300);
		shlDefiniranjeVrsteDrveta.setText("Definiranje Vrste Drveta Gitare");
		
		Label lblVrstaDrveta = new Label(shlDefiniranjeVrsteDrveta, SWT.NONE);
		lblVrstaDrveta.setBounds(10, 10, 81, 15);
		lblVrstaDrveta.setText("Vrsta Drveta");
		
		Button btnObrisi_Vrsta_Drveta = new Button(shlDefiniranjeVrsteDrveta, SWT.NONE);
		
		Combo combo_Vrsta_Drveta = new Combo(shlDefiniranjeVrsteDrveta, SWT.READ_ONLY);
		combo_Vrsta_Drveta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				korisnickiUnos = lista_Vrste_drveta.get(combo_Vrsta_Drveta.getSelectionIndex()); // prikaz iz comba u text
				text_Vrsta_Drveta.setText(korisnickiUnos.getNaziv_Vrsta_Drveta());
				
					btnObrisi_Vrsta_Drveta.setEnabled(true);
			}
			
		
			
		});
		combo_Vrsta_Drveta.setBounds(10, 31, 424, 23);
		
		lista_Vrste_drveta = definiranje_Vrste_Drveta_Gitare_CTRL.dohvati_datoteku_u_combo();  //PRIKAZ U COMBU
		
		
		for (int index = 0; index < lista_Vrste_drveta.size(); index++) {
			combo_Vrsta_Drveta.add(lista_Vrste_drveta.get(index).getNaziv_Vrsta_Drveta(), index);	
			
			
		}
		
		
		Label lblNovaVrstaDrveta = new Label(shlDefiniranjeVrsteDrveta, SWT.NONE);
		lblNovaVrstaDrveta.setBounds(10, 60, 131, 15);
		lblNovaVrstaDrveta.setText("Nova Vrsta Drveta");
		
		text_Vrsta_Drveta = new Text(shlDefiniranjeVrsteDrveta, SWT.BORDER);
		text_Vrsta_Drveta.setBounds(10, 81, 424, 21);
		
		Button btnSpremi_Vrsta_Drveta = new Button(shlDefiniranjeVrsteDrveta, SWT.NONE);
		btnSpremi_Vrsta_Drveta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
					if (text_Vrsta_Drveta.getText().isEmpty()) {
						MessageBox messageBox = new MessageBox(shlDefiniranjeVrsteDrveta, SWT.ICON_WARNING | SWT.OK );    
						messageBox.setText("Greška");
						messageBox.setMessage("Naziv vrsta drveta gitare ne može biti prazan.");
						messageBox.open();

															}

					else {
						korisnickiUnos.setNaziv_Vrsta_Drveta(text_Vrsta_Drveta.getText());

						definiranje_Vrste_Drveta_Gitare_CTRL.spremi(korisnickiUnos);

						combo_Vrsta_Drveta.setText(korisnickiUnos.getNaziv_Vrsta_Drveta());
						
						combo_Vrsta_Drveta.setItem(combo_Vrsta_Drveta.getSelectionIndex(), 
						korisnickiUnos.getNaziv_Vrsta_Drveta());
							}


													}


			
		});
		btnSpremi_Vrsta_Drveta.setBounds(10, 124, 75, 25);
		btnSpremi_Vrsta_Drveta.setText("Spremi");
		
		Button btnNovi_Vrsta_Drveta = new Button(shlDefiniranjeVrsteDrveta, SWT.NONE);
		btnNovi_Vrsta_Drveta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				
				korisnickiUnos = new Vrste_Drveta_Gitare_Model();
				
				korisnickiUnos.setNaziv_Vrsta_Drveta(text_Vrsta_Drveta.getText());
			
				
				if (provjera_Vrste_Drveta(korisnickiUnos)) {
					
					definiranje_Vrste_Drveta_Gitare_CTRL.ubaci_korisnicki_unos(korisnickiUnos);
					
				
					
				combo_Vrsta_Drveta.setText(korisnickiUnos.getNaziv_Vrsta_Drveta());
						
						
				combo_Vrsta_Drveta.add(korisnickiUnos.getNaziv_Vrsta_Drveta());
						
	
				combo_Vrsta_Drveta.select(combo_Vrsta_Drveta.getItemCount() - 1);
						
						
						btnNovi_Vrsta_Drveta.setEnabled(true);
						
						btnSpremi_Vrsta_Drveta.setEnabled(true);
				}
					
						
						
				
				
				
			}
		});
		btnNovi_Vrsta_Drveta.setBounds(112, 124, 75, 25);
		btnNovi_Vrsta_Drveta.setText("Novi");
		
		
		btnObrisi_Vrsta_Drveta.setEnabled(false);
		btnObrisi_Vrsta_Drveta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				MessageBox messageBox = new MessageBox(shlDefiniranjeVrsteDrveta, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        
		        messageBox.setMessage("Želite li obrisati izabrani tip gitare!?");
		        
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  definiranje_Vrste_Drveta_Gitare_CTRL.obrisi(korisnickiUnos);
						
						combo_Vrsta_Drveta.setText("");
						combo_Vrsta_Drveta.remove(combo_Vrsta_Drveta.getSelectionIndex());
						
						text_Vrsta_Drveta.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
		        
				
				
				
			}
				
				
			
		});
		btnObrisi_Vrsta_Drveta.setBounds(345, 124, 75, 25);
		btnObrisi_Vrsta_Drveta.setText("Obri\u0161i");
		
		Button btnZatvori_Vrsta_Drveta = new Button(shlDefiniranjeVrsteDrveta, SWT.NONE);
		btnZatvori_Vrsta_Drveta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDefiniranjeVrsteDrveta.close();
			}
		});
		btnZatvori_Vrsta_Drveta.setBounds(345, 220, 75, 25);
		btnZatvori_Vrsta_Drveta.setText("Zatvori");

	}


boolean provjera_Vrste_Drveta (Vrste_Drveta_Gitare_Model Unos) {
		
		if (Unos.getNaziv_Vrsta_Drveta().isEmpty()) {// PROVJERA ISTOG UNOSA
			MessageBox messageBox = new MessageBox(shlDefiniranjeVrsteDrveta, SWT.ICON_WARNING | SWT.OK );
			
	        messageBox.setText("Greska");
	        messageBox.setMessage("Vrsta drveta gitare ne može biti prazan.");
	        messageBox.open();
	        
	        return false;

	        
		}
		
		
		for (int index = 0; index < lista_Vrste_drveta.size(); index ++) {// PROVJERA ISTOG IMENA
			if (lista_Vrste_drveta.get(index).getNaziv_Vrsta_Drveta().equalsIgnoreCase(korisnickiUnos.getNaziv_Vrsta_Drveta())) {
				MessageBox messageBox = new MessageBox(shlDefiniranjeVrsteDrveta, SWT.ICON_WARNING | SWT.OK );

		        
		        messageBox.setText("Greška");
		        messageBox.setMessage("Naziv drveta gitare vec postoji.");
		        messageBox.open();
		       
		        return false;
			}	
		}
		return true;
	
	}




}
