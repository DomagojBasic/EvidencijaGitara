package Definiranje_Godinu_Proizvodnje_Gitare;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AttributeSet.CharacterAttribute;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.impl.UResource.Value;

import Definiranje_Proizvodaca_Gitare.Proizvodac_Gitare_Model;
import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Definiranje_Godinu_Proizvodnje_Gitare_View extends Dialog {

	protected Object result;
	protected Shell shlDefiniranjeGodineProizvodnje;
	private Text text_Godina_Proizvodnje_Gitare;
	
	private Godina_Proizvodnje_Gitare_Model korisnicki_Unos = new Godina_Proizvodnje_Gitare_Model();// stvaranje objekta MODELA
	
	private Definiranje_Godinu_Proizvodnje_Gitare_CTRL definiranje_godinu_proizvodnje_gitare_CTRL = new Definiranje_Godinu_Proizvodnje_Gitare_CTRL();// stvaranje objekta CTRL
	
	private List <Godina_Proizvodnje_Gitare_Model> lista_godine_proizvodnje; 
	

	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Definiranje_Godinu_Proizvodnje_Gitare_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDefiniranjeGodineProizvodnje.open();
		shlDefiniranjeGodineProizvodnje.layout();
		Display display = getParent().getDisplay();
		while (!shlDefiniranjeGodineProizvodnje.isDisposed()) {
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
		shlDefiniranjeGodineProizvodnje = new Shell(getParent(), getStyle());
		shlDefiniranjeGodineProizvodnje.setSize(450, 300);
		shlDefiniranjeGodineProizvodnje.setText("Definiranje Godine Proizvodnje Gitare");
		
		Label lblGodinaProizvodnjeGitare = new Label(shlDefiniranjeGodineProizvodnje, SWT.NONE);
		lblGodinaProizvodnjeGitare.setBounds(10, 10, 163, 15);
		lblGodinaProizvodnjeGitare.setText("Godina Proizvodnje Gitare");
		
		Button btnObrisi_Godina_Proizvodnje_Gitare = new Button(shlDefiniranjeGodineProizvodnje, SWT.NONE);
		
		Combo combo_Godina_Proizvodnje_Gitare = new Combo(shlDefiniranjeGodineProizvodnje, SWT.READ_ONLY);
		combo_Godina_Proizvodnje_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				korisnicki_Unos = lista_godine_proizvodnje.get(combo_Godina_Proizvodnje_Gitare.getSelectionIndex()); // prikaz iz comba u text
				text_Godina_Proizvodnje_Gitare.setText(korisnicki_Unos.getGodina_Proizvodnje());
				
				
				btnObrisi_Godina_Proizvodnje_Gitare.setEnabled(true);
				
			}
		});
		combo_Godina_Proizvodnje_Gitare.setBounds(10, 31, 424, 23);
		
		lista_godine_proizvodnje = definiranje_godinu_proizvodnje_gitare_CTRL.dohvati_datoteku_u_combo(); //PRIKAZ U COMBU
	
		for (int index = 0; index < lista_godine_proizvodnje.size(); index++) {
			combo_Godina_Proizvodnje_Gitare.add(lista_godine_proizvodnje.get(index).getGodina_Proizvodnje(), index);	
			
			
			
		}
	
		
		
		Label lblNovaGodinaProizvodnjeGitare = new Label(shlDefiniranjeGodineProizvodnje, SWT.NONE);
		lblNovaGodinaProizvodnjeGitare.setBounds(10, 60, 167, 15);
		lblNovaGodinaProizvodnjeGitare.setText("Nova Godina proizvodnje gitare");
		
		text_Godina_Proizvodnje_Gitare = new Text(shlDefiniranjeGodineProizvodnje, SWT.BORDER);
		text_Godina_Proizvodnje_Gitare.setBounds(10, 81, 424, 21);
		
		Button btnSpremi_Godina_Proizvodnje_Gitare = new Button(shlDefiniranjeGodineProizvodnje, SWT.NONE);
		btnSpremi_Godina_Proizvodnje_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if (text_Godina_Proizvodnje_Gitare.getText().isEmpty()) {
					MessageBox messageBox = new MessageBox(shlDefiniranjeGodineProizvodnje, SWT.ICON_WARNING | SWT.OK );    
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv godine proizvodnje ne može biti prazan.");
					messageBox.open();

														}

				else {
					korisnicki_Unos.setGodina_Proizvodnje(text_Godina_Proizvodnje_Gitare.getText());

					definiranje_godinu_proizvodnje_gitare_CTRL.spremi(korisnicki_Unos);

					combo_Godina_Proizvodnje_Gitare.setText(korisnicki_Unos.getGodina_Proizvodnje());
					combo_Godina_Proizvodnje_Gitare.setItem(combo_Godina_Proizvodnje_Gitare.getSelectionIndex(), 
					korisnicki_Unos.getGodina_Proizvodnje());
					
						}


												}
				
		});
		
		
		btnSpremi_Godina_Proizvodnje_Gitare.setBounds(10, 124, 75, 25);
		btnSpremi_Godina_Proizvodnje_Gitare.setText("Spremi");
		
		Button btnNovi_Godina_Proizvodnje_Gitare = new Button(shlDefiniranjeGodineProizvodnje, SWT.NONE);
		btnNovi_Godina_Proizvodnje_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
			
				korisnicki_Unos = new Godina_Proizvodnje_Gitare_Model();
				
				korisnicki_Unos.setGodina_Proizvodnje(text_Godina_Proizvodnje_Gitare.getText());
				
		if(provjera_Godine_Gitare(korisnicki_Unos)) {
			
				definiranje_godinu_proizvodnje_gitare_CTRL.ubaci_korisnicki_unos(korisnicki_Unos);
				
				
				
			
				combo_Godina_Proizvodnje_Gitare.setText(korisnicki_Unos.getGodina_Proizvodnje());
						
						
				combo_Godina_Proizvodnje_Gitare.add(korisnicki_Unos.getGodina_Proizvodnje());
						
	
				combo_Godina_Proizvodnje_Gitare.select(combo_Godina_Proizvodnje_Gitare.getItemCount() - 1);
						
						
						btnObrisi_Godina_Proizvodnje_Gitare.setEnabled(true);
						
						btnSpremi_Godina_Proizvodnje_Gitare.setEnabled(true);
						
		}
				
						
				
			}
		});
		btnNovi_Godina_Proizvodnje_Gitare.setBounds(112, 124, 75, 25);
		btnNovi_Godina_Proizvodnje_Gitare.setText("Novi");
		
		
		btnObrisi_Godina_Proizvodnje_Gitare.setEnabled(false);
		btnObrisi_Godina_Proizvodnje_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				


				MessageBox messageBox = new MessageBox(shlDefiniranjeGodineProizvodnje, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        
		        messageBox.setMessage("Želite li obrisati izabranu godinu gitare!?");
		        
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  definiranje_godinu_proizvodnje_gitare_CTRL.obrisi(korisnicki_Unos);
						
						combo_Godina_Proizvodnje_Gitare.setText("");
						combo_Godina_Proizvodnje_Gitare.remove(combo_Godina_Proizvodnje_Gitare.getSelectionIndex());
						
						text_Godina_Proizvodnje_Gitare.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
		        
				
				
				
			}
		});
			
		btnObrisi_Godina_Proizvodnje_Gitare.setBounds(345, 124, 75, 25);
		btnObrisi_Godina_Proizvodnje_Gitare.setText("Obri\u0161i");
		
		Button btnZatvori_Godina_Proizvodnje_Gitare = new Button(shlDefiniranjeGodineProizvodnje, SWT.NONE);
		btnZatvori_Godina_Proizvodnje_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlDefiniranjeGodineProizvodnje.close();
			}
		});
		btnZatvori_Godina_Proizvodnje_Gitare.setBounds(345, 220, 75, 25);
		btnZatvori_Godina_Proizvodnje_Gitare.setText("Zatvori");

	}

	
boolean provjera_Godine_Gitare (Godina_Proizvodnje_Gitare_Model Unos) {
		
		if (Unos.getGodina_Proizvodnje().isEmpty() || 	Unos.getGodina_Proizvodnje().startsWith("3")||
														Unos.getGodina_Proizvodnje().startsWith("4")||
														Unos.getGodina_Proizvodnje().startsWith("5")||
														Unos.getGodina_Proizvodnje().startsWith("6")||
														Unos.getGodina_Proizvodnje().startsWith("7")||
														Unos.getGodina_Proizvodnje().startsWith("8")||
														Unos.getGodina_Proizvodnje().startsWith("9")||
														Unos.getGodina_Proizvodnje().startsWith("0")
													
																											) {// PROVJERA ISTOG UNOSA
			
			MessageBox messageBox = new MessageBox(shlDefiniranjeGodineProizvodnje, SWT.ICON_WARNING | SWT.OK );
			
	        messageBox.setText("Greska");
	        messageBox.setMessage("Godina proizvodnje gitare ne može biti prazan.");
	        messageBox.open();
	        
	        return false;

	        
		}
		
		
		for (int index = 0; index < lista_godine_proizvodnje.size(); index ++) {// PROVJERA ISTOG IMENA
			if (lista_godine_proizvodnje.get(index).getGodina_Proizvodnje().equalsIgnoreCase(korisnicki_Unos.getGodina_Proizvodnje())) {
				MessageBox messageBox = new MessageBox(shlDefiniranjeGodineProizvodnje, SWT.ICON_WARNING | SWT.OK );

		        
		        messageBox.setText("Greška");
		        messageBox.setMessage("Godina gitare vec postoji.");
		        messageBox.open();
		       
		        return false;
			}	
		}
		
		if(Unos.getGodina_Proizvodnje().startsWith("1")) {
			
			
			
			
			
			
		}
		
		
		
		
		return true;
	
	}






	
	
	
	
}
