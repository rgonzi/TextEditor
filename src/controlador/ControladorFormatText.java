package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import vista.MenuPrincipal;

public class ControladorFormatText implements ActionListener {
	
	private MenuPrincipal finestra;
	
	ControladorFormatText(MenuPrincipal finestra) {
		this.finestra = finestra;
		
		finestra.getBtnBold().addActionListener(this);
		finestra.getBtnItalic().addActionListener(this);
		finestra.getComboFont().addActionListener(this);
		finestra.getComboSize().addActionListener(this);
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		seleccionarOpcio (e.getSource());
	}
	
	private void seleccionarOpcio (Object obj) {
		
		// Obtenim el TextArea i l'estil actual
		JTextArea textArea = finestra.getTextArea();
		Font fontActual = textArea.getFont();
		Font nouEstil = null;

		//Comprovem el botó apretat i definim comportament segons els estils inicials
		if (obj == finestra.getBtnBold()) {
			switch (fontActual.getStyle()) {
		        case Font.PLAIN -> nouEstil = fontActual.deriveFont(Font.BOLD);
		        case Font.ITALIC -> nouEstil = fontActual.deriveFont(Font.BOLD + Font.ITALIC);
		        case Font.BOLD -> nouEstil = fontActual.deriveFont(Font.PLAIN);
		        case Font.BOLD + Font.ITALIC -> nouEstil = fontActual.deriveFont(Font.ITALIC);
		    }
			
			
		} else if (obj == finestra.getBtnItalic()) {
			switch (fontActual.getStyle()) {
		        case Font.PLAIN -> nouEstil = fontActual.deriveFont(Font.ITALIC);
		        case Font.ITALIC -> nouEstil = fontActual.deriveFont(Font.PLAIN);
		        case Font.BOLD -> nouEstil = fontActual.deriveFont(Font.BOLD + Font.ITALIC);
		        case Font.BOLD + Font.ITALIC -> nouEstil = fontActual.deriveFont(Font.BOLD);
			}
		} else if (obj == finestra.getComboSize()) {
			//Obtenim la mida seleccionada, la transformem a Float i l'apliquem al nou estil
			String mida = finestra.getComboSize().getSelectedItem().toString();
			Float novaMida = Float.parseFloat(mida);
			nouEstil = fontActual.deriveFont(novaMida);
			
		} else if (obj == finestra.getComboFont() ) {
			//Obtenim el nom de la nova font
			String estil = finestra.getComboFont().getSelectedItem().toString();
			//
		}
		
		if (nouEstil != null) {
			textArea.setFont(nouEstil);
		}
	}
}
