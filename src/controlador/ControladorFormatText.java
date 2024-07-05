package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

import vista.MenuPrincipal;

public class ControladorFormatText implements ActionListener {
	
	private MenuPrincipal finestra;
	
	ControladorFormatText(MenuPrincipal finestra) {
		this.finestra = finestra;
		
		finestra.getBtnBold().addActionListener(this);
		finestra.getBtnItalic().addActionListener(this);
		finestra.getComboFont().addActionListener(this);
		finestra.getComboSize().addActionListener(this);
		finestra.getItemSelectAll().addActionListener(this);
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		seleccionarOpcio (e.getSource());
	}
	
	private void seleccionarOpcio (Object obj) {
		JTextPane text = finestra.getTextPane();

		
			//Comprovem el botó apretat i definim comportament segons els estils inicials
		StyledDocument doc = text.getStyledDocument();
        int start = text.getSelectionStart();
        int end = text.getSelectionEnd();
        Element element = doc.getCharacterElement(start);
        AttributeSet as = element.getAttributes();
        
        //Creem un conjunt d'atributs que després podem modificar
        SimpleAttributeSet sas = new SimpleAttributeSet();
        
        if (start != end) { // Comprovem si hi ha text seleccionat
			if (obj == finestra.getBtnBold()) {
				
             	// Determinem si el text seleccionat està actualment negreta
                boolean isBold = StyleConstants.isBold(as);
                StyleConstants.setBold(sas, !isBold); // Alternem l'estat de negreta

	        } else if (obj == finestra.getBtnItalic()) {
	        	
	        	boolean isItalic = StyleConstants.isItalic(as);
	            StyleConstants.setItalic(sas, !isItalic);

	        } else if (obj == finestra.getBtnUnderline()) {
		        
	        	boolean isUnderLine = StyleConstants.isUnderline(as);
	        	StyleConstants.setUnderline(sas, !isUnderLine);
	        	
	        } else if (obj == finestra.getComboSize()) {
	        	
				int mida = (int) finestra.getComboSize().getSelectedItem();
				StyleConstants.setFontSize(sas, mida); //Definim nova mida
			} else if (obj == finestra.getComboFont()) {
				String font = finestra.getComboFont().getSelectedItem().toString();
				StyleConstants.setFontFamily(sas, font);
			} else if (obj == finestra.getItemSelectAll()) {
				text.selectAll();
			}
			
			// Apliquem els nous atributs al text seleccionat
            doc.setCharacterAttributes(start, end - start, sas, false);
        }
	}
}
