package Izvjestaj;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import Izvjestaj_Dojmova_View.Izvjestaj_Dojmova_View;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Izvjestaj_View extends Dialog {

	protected Object result;
	protected Shell shlIzvjetajDojmovaO;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Izvjestaj_View(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlIzvjetajDojmovaO.open();
		shlIzvjetajDojmovaO.layout();
		Display display = getParent().getDisplay();
		while (!shlIzvjetajDojmovaO.isDisposed()) {
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
		shlIzvjetajDojmovaO = new Shell(getParent(), getStyle());
		shlIzvjetajDojmovaO.setSize(450, 300);
		shlIzvjetajDojmovaO.setText("Izvje\u0161taj dojmova o gitari");
		
		Label lblGitara = new Label(shlIzvjetajDojmovaO, SWT.NONE);
		lblGitara.setBounds(10, 10, 55, 15);
		lblGitara.setText("Gitara");
		
		Label lblTip = new Label(shlIzvjetajDojmovaO, SWT.NONE);
		lblTip.setBounds(71, 26, 55, 15);
		lblTip.setText("Tip gitare");
		
		Combo combo = new Combo(shlIzvjetajDojmovaO, SWT.NONE);
		combo.setBounds(132, 23, 91, 23);
		
		Label lblProizvoa = new Label(shlIzvjetajDojmovaO, SWT.NONE);
		lblProizvoa.setBounds(239, 26, 66, 15);
		lblProizvoa.setText("Proizvo\u0111a\u010D");
		
		Combo combo_1 = new Combo(shlIzvjetajDojmovaO, SWT.NONE);
		combo_1.setBounds(311, 23, 91, 23);
		
		Label lblGodinaProizvodnje = new Label(shlIzvjetajDojmovaO, SWT.NONE);
		lblGodinaProizvodnje.setBounds(22, 52, 104, 15);
		lblGodinaProizvodnje.setText("Godina proizvodnje");
		
		Combo combo_2 = new Combo(shlIzvjetajDojmovaO, SWT.NONE);
		combo_2.setBounds(132, 52, 91, 23);
		
		Label lblVrstaDrveta = new Label(shlIzvjetajDojmovaO, SWT.NONE);
		lblVrstaDrveta.setBounds(239, 52, 66, 23);
		lblVrstaDrveta.setText("Vrsta drveta");
		
		Combo combo_3 = new Combo(shlIzvjetajDojmovaO, SWT.NONE);
		combo_3.setBounds(311, 52, 91, 23);
		
		Label lblBrojica = new Label(shlIzvjetajDojmovaO, SWT.NONE);
		lblBrojica.setBounds(71, 84, 55, 15);
		lblBrojica.setText("Broj \u017Eica");
		
		Combo combo_4 = new Combo(shlIzvjetajDojmovaO, SWT.NONE);
		combo_4.setBounds(132, 81, 91, 23);
		
		Button btnPregledajDojmoveZa = new Button(shlIzvjetajDojmovaO, SWT.NONE);
		btnPregledajDojmoveZa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				Izvjestaj_Dojmova_View  izvjestaj_Dojmova_View = new Izvjestaj_Dojmova_View (shlIzvjetajDojmovaO,SWT.DIALOG_TRIM);
				
				izvjestaj_Dojmova_View.open();
				
				
				
				
				
			}
		});
		btnPregledajDojmoveZa.setBounds(108, 133, 213, 25);
		btnPregledajDojmoveZa.setText("Pregledaj dojmove za gitaru");

	}

}
