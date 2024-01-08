package Izvjestaj_Dojmova_View;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Izvjestaj_Dojmova_View extends Dialog {

	protected Object result;
	protected Shell shlDojmoviOGitari;
	private Text text;
	private Text text_1;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Izvjestaj_Dojmova_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDojmoviOGitari.open();
		shlDojmoviOGitari.layout();
		Display display = getParent().getDisplay();
		while (!shlDojmoviOGitari.isDisposed()) {
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
		shlDojmoviOGitari = new Shell(getParent(), getStyle());
		shlDojmoviOGitari.setSize(450, 300);
		shlDojmoviOGitari.setText("Dojmovi o gitari");
		
		Label lblImeIPrezime = new Label(shlDojmoviOGitari, SWT.NONE);
		lblImeIPrezime.setBounds(10, 10, 91, 15);
		lblImeIPrezime.setText("Ime i prezime");
		
		text = new Text(shlDojmoviOGitari, SWT.BORDER);
		text.setEnabled(false);
		text.setBounds(10, 31, 221, 21);
		
		Label lblDojamOGitari = new Label(shlDojmoviOGitari, SWT.NONE);
		lblDojamOGitari.setBounds(10, 70, 91, 15);
		lblDojamOGitari.setText("Dojam o gitari");
		
		text_1 = new Text(shlDojmoviOGitari, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setBounds(10, 91, 410, 88);
		
		Button btnSljedeo = new Button(shlDojmoviOGitari, SWT.NONE);
		btnSljedeo.setBounds(137, 219, 75, 25);
		btnSljedeo.setText("Dalje");
		
		Button btnZatvori = new Button(shlDojmoviOGitari, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlDojmoviOGitari.close();
				
			}
		});
		btnZatvori.setBounds(326, 219, 75, 25);
		btnZatvori.setText("Zatvori");
		
		Button btnNazad = new Button(shlDojmoviOGitari, SWT.NONE);
		btnNazad.setBounds(26, 219, 75, 25);
		btnNazad.setText("Nazad");

	}

}
