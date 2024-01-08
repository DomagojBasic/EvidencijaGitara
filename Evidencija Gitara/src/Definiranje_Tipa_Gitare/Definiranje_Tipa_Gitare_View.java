package Definiranje_Tipa_Gitare;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Definiranje_Tipa_Gitare_View extends Dialog {

	protected Object result;
	protected Shell shlDefiniranjeTipaGitare;
	private Text text_Tip_Gitare;
	
	private List <Tip_Gitare_Model> lista_Tipova_Gitara;
	
	private Definiranje_Tipa_Gitare_CTRL definiranje_tipa_gitare_CTRL = new Definiranje_Tipa_Gitare_CTRL(); // stvaranje objekta CTRL
	
	private Tip_Gitare_Model korisnicki_unos = new Tip_Gitare_Model(); // stvaranje objekta MODELA
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Definiranje_Tipa_Gitare_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDefiniranjeTipaGitare.open();
		shlDefiniranjeTipaGitare.layout();
		Display display = getParent().getDisplay();
		while (!shlDefiniranjeTipaGitare.isDisposed()) {
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
		shlDefiniranjeTipaGitare = new Shell(getParent(), getStyle());
		shlDefiniranjeTipaGitare.setSize(450, 300);
		shlDefiniranjeTipaGitare.setText("Definiranje tipa Gitare");
		
		Label lblTipGitare = new Label(shlDefiniranjeTipaGitare, SWT.NONE);
		lblTipGitare.setBounds(10, 10, 55, 15);
		lblTipGitare.setText("Tip Gitare");
		
		Button btnObrisi_Tip_Gitare = new Button(shlDefiniranjeTipaGitare, SWT.NONE);
		Button btnSpremi_Tip_Gitare = new Button(shlDefiniranjeTipaGitare, SWT.NONE);
		
		Combo combo_Tip_Gitare = new Combo(shlDefiniranjeTipaGitare, SWT.READ_ONLY);
		combo_Tip_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				korisnicki_unos = lista_Tipova_Gitara.get(combo_Tip_Gitare.getSelectionIndex()); // prikaz iz comba u text
				text_Tip_Gitare.setText(korisnicki_unos.getNaziv_Tipa_Gitare());
				
				
				btnObrisi_Tip_Gitare.setEnabled(true);
				
				btnSpremi_Tip_Gitare.setEnabled(true);
				
				
			}
		});
		combo_Tip_Gitare.setBounds(10, 31, 424, 23);
		
		
		lista_Tipova_Gitara = definiranje_tipa_gitare_CTRL.dohvati_datoteku_u_combo();  //PRIKAZ U COMBU
		
		
		for (int index = 0; index < lista_Tipova_Gitara.size(); index++) {
			combo_Tip_Gitare.add(lista_Tipova_Gitara.get(index).getNaziv_Tipa_Gitare(), index);	
			
		}
		
		
		
		Label lblNoviTipGitare = new Label(shlDefiniranjeTipaGitare, SWT.NONE);
		lblNoviTipGitare.setBounds(10, 60, 90, 15);
		lblNoviTipGitare.setText("Novi Tip Gitare");
		
		text_Tip_Gitare = new Text(shlDefiniranjeTipaGitare, SWT.BORDER);
		text_Tip_Gitare.setBounds(10, 81, 424, 21);
		btnSpremi_Tip_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
								public void widgetSelected(SelectionEvent e) {
				
											if (text_Tip_Gitare.getText().isEmpty()) {
												MessageBox messageBox = new MessageBox(shlDefiniranjeTipaGitare, SWT.ICON_WARNING | SWT.OK );    
												messageBox.setText("Greška");
												messageBox.setMessage("Naziv tipa gitare ne može biti prazan.");
												messageBox.open();
			
																					}
				
											else {
												korisnicki_unos.setNaziv_Tipa_Gitare(text_Tip_Gitare.getText());
					
												definiranje_tipa_gitare_CTRL.spremi(korisnicki_unos);
					
												combo_Tip_Gitare.setText(korisnicki_unos.getNaziv_Tipa_Gitare());
												combo_Tip_Gitare.setItem(combo_Tip_Gitare.getSelectionIndex(), 
												korisnicki_unos.getNaziv_Tipa_Gitare());
													}
				
				
																			}
				
		});
		
		
		
		
		btnSpremi_Tip_Gitare.setBounds(10, 124, 75, 25);
		btnSpremi_Tip_Gitare.setText("Spremi");
	
		Button btnNovi_Tip_Gitare = new Button(shlDefiniranjeTipaGitare, SWT.NONE);
		btnNovi_Tip_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				korisnicki_unos = new Tip_Gitare_Model();
				
				korisnicki_unos.setNaziv_Tipa_Gitare(text_Tip_Gitare.getText()); 
				
				
				if (provjera_Tipa_Gitare(korisnicki_unos)) {
					
					
					definiranje_tipa_gitare_CTRL.ubaci_korisnicki_unos(korisnicki_unos);
				
					
				combo_Tip_Gitare.setText(korisnicki_unos.getNaziv_Tipa_Gitare());
						
						
						combo_Tip_Gitare.add(korisnicki_unos.getNaziv_Tipa_Gitare());
						
	
						combo_Tip_Gitare.select(combo_Tip_Gitare.getItemCount() - 1);
						
						
						btnObrisi_Tip_Gitare.setEnabled(true);
						
						btnSpremi_Tip_Gitare.setEnabled(true);
						
						
						
				}
			}
			
			
		});
		btnNovi_Tip_Gitare.setBounds(112, 124, 75, 25);
		btnNovi_Tip_Gitare.setText("Novi");
		
		
		btnObrisi_Tip_Gitare.setEnabled(false);
		btnObrisi_Tip_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				

				MessageBox messageBox = new MessageBox(shlDefiniranjeTipaGitare, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        
		        messageBox.setMessage("Želite li obrisati izabrani tip gitare!?");
		        
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  definiranje_tipa_gitare_CTRL.obrisi(korisnicki_unos);
						
						combo_Tip_Gitare.setText("");
						combo_Tip_Gitare.remove(combo_Tip_Gitare.getSelectionIndex());
						
						text_Tip_Gitare.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
		        
				
				
				
			}
		});
		
			
		btnObrisi_Tip_Gitare.setBounds(345, 124, 75, 25);
		btnObrisi_Tip_Gitare.setText("Obri\u0161i");
		
		Button btnZatvori_Tip_Gitare = new Button(shlDefiniranjeTipaGitare, SWT.NONE);
		btnZatvori_Tip_Gitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlDefiniranjeTipaGitare.close();
			}
		});
		btnZatvori_Tip_Gitare.setBounds(345, 220, 75, 25);
		btnZatvori_Tip_Gitare.setText("Zatvori");

	}
	

	//______________________________________________________________________________________________________________________________________
	

boolean provjera_Tipa_Gitare (Tip_Gitare_Model Unos) {
		
		if (Unos.getNaziv_Tipa_Gitare().isEmpty()) {// PROVJERA ISTOG UNOSA
			MessageBox messageBox = new MessageBox(shlDefiniranjeTipaGitare, SWT.ICON_WARNING | SWT.OK );
			
	        messageBox.setText("Greska");
	        messageBox.setMessage("Tip gitare ne može biti prazan.");
	        messageBox.open();
	        
	        return false;

	        
		}
		
		
		for (int index = 0; index < lista_Tipova_Gitara.size(); index ++) {// PROVJERA ISTOG IMENA
			if (lista_Tipova_Gitara.get(index).getNaziv_Tipa_Gitare().equalsIgnoreCase(korisnicki_unos.getNaziv_Tipa_Gitare())) {
				MessageBox messageBox = new MessageBox(shlDefiniranjeTipaGitare, SWT.ICON_WARNING | SWT.OK );

		        
		        messageBox.setText("Greška");
		        messageBox.setMessage("Naziv tipa gitare vec postoji.");
		        messageBox.open();
		       
		        return false;
			}	
		}
		return true;
	
	}



	
}
