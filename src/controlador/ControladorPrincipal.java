package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import persistencia.GestorFitxers;
import vista.AboutFrame;
import vista.MenuPrincipal;

public class ControladorPrincipal extends KeyAdapter implements ActionListener {

	private MenuPrincipal finestra;
	private AboutFrame about;
	private GestorFitxers gestor;
	private boolean edit;
	private int paraules, caracters;
	
	
	public ControladorPrincipal() {
		//Construïm la finestra principal
		finestra = new MenuPrincipal();
		edit = false;
		
		finestra.setVisible(true);
		
		//Afegim els Listeners necessaris
		finestra.getItemOpen().addActionListener(this);
		finestra.getItemSave().addActionListener(this);
		finestra.getItemSaveAs().addActionListener(this);
		finestra.getItemExit().addActionListener(this);
		finestra.getItemAbout().addActionListener(this);
		finestra.getItemFullScreen().addActionListener(this);
		
		finestra.getTextPane().addKeyListener(this); //Per comprobar si hem modificat el text
		
		new ControladorFormatText(finestra);
		gestor = new GestorFitxers();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//En funció del nom del item dels menús realitzarem una acció
		seleccionarOpcio(e.getActionCommand());
	}
	
	private void seleccionarOpcio(String opcio) {
		JTextPane text = finestra.getTextPane();
		switch(opcio) {
		case "Open":
			gestor.openFile(text);
			break;
		case "Save":
			gestor.saveFile(text);
			//Ara el text actual s'ha guardat
			edit = false;
			break;
		case "Save as...":
			gestor.saveFileAs(text);
			edit = false;
			break;
		case "Exit":
			if (edit) {
				if (gestor.saveChangesBeforeExit(text) != JOptionPane.CANCEL_OPTION) {
					finestra.dispose();
				}
			}
			break;
		case "Full Screen":
			//TODO Fer gran la finestra
			break;
		case "About":
			about = new AboutFrame();
			about.setVisible(true);
			break;
		}
		updateStats();
	}
	
	@Override
	public void keyPressed (KeyEvent e) {
		edit = true;
	}
	
	@Override
	public void keyReleased (KeyEvent e) {
		updateStats();
	}
	
	//Mostra uns comptadors de paraules i caràcters i el nom del fitxer
	private void updateStats() {
		paraules = finestra.getTextPane().getText().split("\\s").length;
		caracters = finestra.getTextPane().getText().length();
		//Actualitzem comptadors de paraules i caràcters
		if (finestra.getTextPane().getText().equals("")) {
			finestra.getCounts().setText("Words: 0 Chars: 0");
		} else {
			finestra.getCounts().setText("Words: " + paraules + " Chars: " + caracters 
					+ gestor.getFileName() + saved());
		}
	}
	
	private String saved() {
		if (edit) {
			return "";
		} else {
			return " | Saved!";
		}
	}
}
