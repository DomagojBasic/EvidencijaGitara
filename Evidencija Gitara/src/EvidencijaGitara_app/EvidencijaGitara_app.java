package EvidencijaGitara_app;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import DefiniranjeVrsteGitara.DefVrstaView;
import Definiranje_Broja_Zica_Gitare.Definiranje_Broja_Zica_Gitare_CTRL;
import Definiranje_Broja_Zica_Gitare.Definiranje_Broja_Žica_Gitare_View;
import Definiranje_Godinu_Proizvodnje_Gitare.Definiranje_Godinu_Proizvodnje_Gitare_View;
import Definiranje_Proizvodaca_Gitare.Definiranje_Proizvodaca_Gitare_View;
import Definiranje_Tipa_Gitare.Definiranje_Tipa_Gitare_View;
import Definiranje_Vrste_Drveta_Gitare.Definiranje_Vrste_Drveta_Gitare_View;
import Izvjestaj.Izvjestaj_View;
import Korisnicki_Prikaz.Korisnicki_Prikaz_View;
import Korisnicki_Unos.Korisicki_Unos_View;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;




public class EvidencijaGitara_app {

	protected Shell shlEvidencijaGitara;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EvidencijaGitara_app window = new EvidencijaGitara_app();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlEvidencijaGitara.open();
		shlEvidencijaGitara.layout();
		while (!shlEvidencijaGitara.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEvidencijaGitara = new Shell();
		shlEvidencijaGitara.setSize(450, 300);
		shlEvidencijaGitara.setText("Evidencija Gitara");
		
		Menu menu = new Menu(shlEvidencijaGitara, SWT.BAR);
		shlEvidencijaGitara.setMenuBar(menu);
		
		MenuItem mntmGlavniIzbornik = new MenuItem(menu, SWT.CASCADE);
		mntmGlavniIzbornik.setText("Administrator");
		
		Menu menu_1 = new Menu(mntmGlavniIzbornik);
		mntmGlavniIzbornik.setMenu(menu_1);
		
		MenuItem mntmDefiniranjeVrsteGitara = new MenuItem(menu_1, SWT.NONE);
		mntmDefiniranjeVrsteGitara.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {  // OTVARANJE TIPA GITARE VIEW
				
			Definiranje_Tipa_Gitare_View Def_Tip_View = new Definiranje_Tipa_Gitare_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
			
			Def_Tip_View.open();
			
			}
		});
		mntmDefiniranjeVrsteGitara.setText("Definiranje Tipa gitare");
		
		MenuItem mntmDefiniranjeProizvoaaGitare = new MenuItem(menu_1, SWT.NONE);
		mntmDefiniranjeProizvoaaGitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {  // OTVARANJE PROIZVODACA GITARE VIEW
				
				Definiranje_Proizvodaca_Gitare_View Def_Proizvodac_View = new Definiranje_Proizvodaca_Gitare_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
				
				Def_Proizvodac_View.open();
			}
		});
		mntmDefiniranjeProizvoaaGitare.setText("Definiranje Proizvo\u0111a\u010Da gitare");
		
		MenuItem mntmDefiniranjeGodineProizvodnje = new MenuItem(menu_1, SWT.NONE);
		mntmDefiniranjeGodineProizvodnje.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { // OTVARANJE GODINE PROIZVODNJE GITARE VIEW
				
				Definiranje_Godinu_Proizvodnje_Gitare_View Def_Godine_View = new Definiranje_Godinu_Proizvodnje_Gitare_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
				
				Def_Godine_View.open();
			}
		});
		mntmDefiniranjeGodineProizvodnje.setText("Definiranje Godine proizvodnje gitare");
		
		MenuItem mntmDefiniranjeDrvetaGitare = new MenuItem(menu_1, SWT.NONE);
		mntmDefiniranjeDrvetaGitare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { // OTVARANJE DEFINIRANJE DRVETA GITARE VIEW
				
				Definiranje_Vrste_Drveta_Gitare_View Def_Drveta_View = new Definiranje_Vrste_Drveta_Gitare_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
				
				Def_Drveta_View.open();
			}
		});
		mntmDefiniranjeDrvetaGitare.setText("Definiranje vrste drveta gitare");
		
		MenuItem mntmDefiniranjeBrojaica = new MenuItem(menu_1, SWT.NONE);
		mntmDefiniranjeBrojaica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { // OTVARANJE DEFINIRANJE BROJA ZICA GITARE VIEW
				
				Definiranje_Broja_Žica_Gitare_View Def_Broj_Zica_View = new Definiranje_Broja_Žica_Gitare_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
				
				Def_Broj_Zica_View.open();
			}
		});
		mntmDefiniranjeBrojaica.setText("Definiranje broja \u017Eica gitare");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmZatvori = new MenuItem(menu_1, SWT.CHECK);
		mntmZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlEvidencijaGitara.close();
			}
		});
		mntmZatvori.setText("Zatvori");
		
		MenuItem mntmKorisnik = new MenuItem(menu, SWT.CASCADE);
		mntmKorisnik.setText("Korisnik");
		
		Menu menu_2 = new Menu(mntmKorisnik);
		mntmKorisnik.setMenu(menu_2);
		
		MenuItem mntmUnosDojmaO = new MenuItem(menu_2, SWT.NONE);
		mntmUnosDojmaO.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				Korisnicki_Prikaz_View korisniski_prikaz = new Korisnicki_Prikaz_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
				
				korisniski_prikaz.open();
				
				
				
				
				
			}
		});
		mntmUnosDojmaO.setText("Unos dojma o gitari");
		
		MenuItem mntmIzvjetaj = new MenuItem(menu, SWT.CASCADE);
		mntmIzvjetaj.setText("Izvje\u0161taj");
		
		Menu menu_3 = new Menu(mntmIzvjetaj);
		mntmIzvjetaj.setMenu(menu_3);
		
		MenuItem mntmDojmoviOGitari = new MenuItem(menu_3, SWT.NONE);
		mntmDojmoviOGitari.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				Izvjestaj_View  Izvjestaj = new Izvjestaj_View (shlEvidencijaGitara,SWT.DIALOG_TRIM);
				
				Izvjestaj.open();
				
				
			}
		});
		mntmDojmoviOGitari.setText("Dojmovi o gitari");

	}
}
