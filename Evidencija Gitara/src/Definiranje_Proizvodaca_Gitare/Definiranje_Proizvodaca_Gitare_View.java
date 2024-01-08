package Definiranje_Proizvodaca_Gitare;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import Definiranje_Tipa_Gitare.Definiranje_Tipa_Gitare_CTRL;
import Definiranje_Tipa_Gitare.Tip_Gitare_Model;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Definiranje_Proizvodaca_Gitare_View extends Dialog {

	protected Object result;
	protected Shell shlDefiniranjeProizvodacaGitare;
	private Text text_Novi_Proizvodac_Gitare;
	
	private List <Proizvodac_Gitare_Model> lista_Proizvodaca_Gitara; // sttvaranje liste
	
	private Definiranje_Proizvodaca_Gitare_CTRL definiranje_proizvodaca_gitare_CTRL = new Definiranje_Proizvodaca_Gitare_CTRL(); // stvaranje objekta CTRL
	
	private Proizvodac_Gitare_Model korisnicki_unos = new Proizvodac_Gitare_Model(); // stvaranje objekta MODELA
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Definiranje_Proizvodaca_Gitare_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDefiniranjeProizvodacaGitare.open();
		shlDefiniranjeProizvodacaGitare.layout();
		Display display = getParent().getDisplay();
		while (!shlDefiniranjeProizvodacaGitare.isDisposed()) {
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
		shlDefiniranjeProizvodacaGitare = new Shell(getParent(), getStyle());
		shlDefiniranjeProizvodacaGitare.setSize(450, 300);
		shlDefiniranjeProizvodacaGitare.setText("Definiranje Proizvo\u0111a\u010Da gitare");
		
		Label lblProizvodacGitare = new Label(shlDefiniranjeProizvodacaGitare, SWT.NONE);
		lblProizvodacGitare.setBounds(10, 10, 126, 15);
		lblProizvodacGitare.setText("Proizvo\u0111a\u010D gitare");
		
		Button btnObrisi_Proizvodac_Gitare = new Button(shlDefiniranjeProizvodacaGitare, SWT.NONE);
		btnObrisi_Proizvodac_Gitare.setEnabled(false);
		
		Combo combo_Proizvodac_Gitare = new Combo(shlDefiniranjeProizvodacaGitare, SWT.READ_ONLY);
		combo_Proizvodac_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				korisnicki_unos = lista_Proizvodaca_Gitara.get(combo_Proizvodac_Gitare.getSelectionIndex()); // prikaz iz comba u text
				text_Novi_Proizvodac_Gitare.setText(korisnicki_unos.getNaziv_Proizvodac_Gitare());
				
				btnObrisi_Proizvodac_Gitare.setEnabled(true);
				
			}
		});
		combo_Proizvodac_Gitare.setBounds(10, 31, 424, 23);
		

		lista_Proizvodaca_Gitara = definiranje_proizvodaca_gitare_CTRL.dohvati_datoteku_u_combo();  //PRIKAZ U COMBU
		
		
		for (int index = 0; index < lista_Proizvodaca_Gitara.size(); index++) {
			combo_Proizvodac_Gitare.add(lista_Proizvodaca_Gitara.get(index).getNaziv_Proizvodac_Gitare(), index);	
			
			
		}
		
		
		Label lblNoviProizvodacGitare = new Label(shlDefiniranjeProizvodacaGitare, SWT.NONE);
		lblNoviProizvodacGitare.setBounds(10, 60, 126, 15);
		lblNoviProizvodacGitare.setText("Novi Proizvo\u0111a\u010D Gitare");
		
		text_Novi_Proizvodac_Gitare = new Text(shlDefiniranjeProizvodacaGitare, SWT.BORDER);
		text_Novi_Proizvodac_Gitare.setBounds(10, 81, 424, 21);
		
		Button btnSpremi_Proizvodac_Gitare = new Button(shlDefiniranjeProizvodacaGitare, SWT.NONE);
		btnSpremi_Proizvodac_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if (text_Novi_Proizvodac_Gitare.getText().isEmpty()) {
					MessageBox messageBox = new MessageBox(shlDefiniranjeProizvodacaGitare, SWT.ICON_WARNING | SWT.OK );
			        
			        messageBox.setText("Greska");
			        messageBox.setMessage("Naziv Proizvodacaa ne moze biti prazan.");
			        messageBox.open();
			
				}
				
				else {
					korisnicki_unos.setNaziv_Proizvodac_Gitare(text_Novi_Proizvodac_Gitare.getText());
					
					definiranje_proizvodaca_gitare_CTRL.spremi(korisnicki_unos);
					
					combo_Proizvodac_Gitare.setText(korisnicki_unos.getNaziv_Proizvodac_Gitare());
					combo_Proizvodac_Gitare.setItem(combo_Proizvodac_Gitare.getSelectionIndex(), 
							korisnicki_unos.getNaziv_Proizvodac_Gitare());
				}
				
				
			}
		});
				
			
		
		btnSpremi_Proizvodac_Gitare.setBounds(10, 124, 75, 25);
		btnSpremi_Proizvodac_Gitare.setText("Spremi");
		
		Button btnNovi_Proizvodac_Gitare = new Button(shlDefiniranjeProizvodacaGitare, SWT.NONE);
		btnNovi_Proizvodac_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				korisnicki_unos = new Proizvodac_Gitare_Model();
				korisnicki_unos.setNaziv_Proizvodac_Gitare(text_Novi_Proizvodac_Gitare.getText());
				
				if(provjera_Proizvodac_Gitare(korisnicki_unos)) {
					
				definiranje_proizvodaca_gitare_CTRL.ubaci_korisnicki_unos(korisnicki_unos);

				combo_Proizvodac_Gitare.setText(korisnicki_unos.getNaziv_Proizvodac_Gitare());
				combo_Proizvodac_Gitare.add(korisnicki_unos.getNaziv_Proizvodac_Gitare());
				combo_Proizvodac_Gitare.select(combo_Proizvodac_Gitare.getItemCount() - 1);
				
						btnObrisi_Proizvodac_Gitare.setEnabled(true);	
						btnSpremi_Proizvodac_Gitare.setEnabled(true);
						
				}
				
				
				
			}
			
		
			
			
		});
		btnNovi_Proizvodac_Gitare.setBounds(112, 124, 75, 25);
		btnNovi_Proizvodac_Gitare.setText("Novi");
		
		
		btnObrisi_Proizvodac_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
		MessageBox messageBox = new MessageBox(shlDefiniranjeProizvodacaGitare, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        
		        messageBox.setMessage("Želite li obrisati izabranog proizvodaca gitare!?");
		        
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  definiranje_proizvodaca_gitare_CTRL.obrisi(korisnicki_unos);
						
		        	  combo_Proizvodac_Gitare.setText("");
		        	  combo_Proizvodac_Gitare.remove(combo_Proizvodac_Gitare.getSelectionIndex());
						
						text_Novi_Proizvodac_Gitare.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
		        
				
				
				
			}
		});
			
		btnObrisi_Proizvodac_Gitare.setBounds(345, 124, 75, 25);
		btnObrisi_Proizvodac_Gitare.setText("Obri\u0161i");
		
		Button btnZatvori_Proizvodac_Gitare = new Button(shlDefiniranjeProizvodacaGitare, SWT.NONE);
		btnZatvori_Proizvodac_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDefiniranjeProizvodacaGitare.close();
			}
		});
		btnZatvori_Proizvodac_Gitare.setBounds(345, 220, 75, 25);
		btnZatvori_Proizvodac_Gitare.setText("Zatvori");
		
		
		
		
		

	}
	
	

boolean provjera_Proizvodac_Gitare (Proizvodac_Gitare_Model Unos) {
		
		if (Unos.getNaziv_Proizvodac_Gitare().isEmpty()) {// PROVJERA ISTOG UNOSA
			MessageBox messageBox = new MessageBox(shlDefiniranjeProizvodacaGitare, SWT.ICON_WARNING | SWT.OK );
			
	        messageBox.setText("Greska");
	        messageBox.setMessage("Ime proizvodaca ne može biti prazan.");
	        messageBox.open();
	        
	        return false;

	        
		}
		
		
		for (int index = 0; index < lista_Proizvodaca_Gitara.size(); index ++) {// PROVJERA ISTOG IMENA
			if (lista_Proizvodaca_Gitara.get(index).getNaziv_Proizvodac_Gitare().equalsIgnoreCase(korisnicki_unos.getNaziv_Proizvodac_Gitare())) {
				MessageBox messageBox = new MessageBox(shlDefiniranjeProizvodacaGitare, SWT.ICON_WARNING | SWT.OK );

		        
		        messageBox.setText("Greška");
		        messageBox.setMessage("Naziv tipa gitare vec postoji.");
		        messageBox.open();
		       
		        return false;
			}	
		}
		return true;
	
	}

	
	

}
