package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JMenuItem;

import vista.AboutFrame;
import vista.MenuPrincipal;

public class ControladorPrincipal extends KeyAdapter implements ActionListener {

	private MenuPrincipal finestra;
	private AboutFrame about;
	private boolean edit = false;
	private int paraules, caracters;
	
	
	public ControladorPrincipal() {
		//Construïm la finestra principal
		finestra = new MenuPrincipal();
		finestra.setVisible(true);
		
		//Afegim els Listeners necessaris
		for (JMenuItem item: finestra.getMenuItems()) {
			item.addActionListener(this);
		}
		
		finestra.getTextArea().addKeyListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//En funció del nom del item dels menús realitzarem una acció
		seleccionarOpcio(e.getActionCommand());
	}
	
	private void seleccionarOpcio(String opcio) {
		switch(opcio) {
		case "Open":
			//TODO Obrir un fitxer
			break;
		case "Save":
			//TODO Guardar un fitxer sobreescrivint-lo
			break;
		case "Save as...":
			//TODO Guardar en un fitxer diferent
			break;
		case "Exit":
			//TODO Tancar el programa preguntant si guardem canvis
			if (edit) {
				//TODO Preguntar si volem guardar abans de tancar
			} else {
				finestra.dispose();
			}
			break;
		case "Copy":
			//TODO Copiar + shortcut
			break;
		case "Paste":
			//TODO Enganxar + shortcut
			break;
		case "Full Screen":
			//TODO Fer gran la finestra
			break;
		case "About":
			about = new AboutFrame();
			about.setVisible(true);
			
			break;
		}
	}
	
	@Override
	public void keyPressed (KeyEvent e) {
		edit = true;
	}
	
	@Override
	public void keyReleased (KeyEvent e) {
		
		paraules = finestra.getTextArea().getText().split("\\s").length;
		caracters = finestra.getTextArea().getText().length();
		//Actualitzem comptadors de paraules i caràcters
		finestra.getCounts().setText("Paraules: " + paraules + " Caràcters: " + caracters);
	}
}
