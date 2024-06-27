package controlador;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import vista.MenuPrincipal;

public class ControladorPrincipal implements ActionListener{

	private MenuPrincipal finestra;
	
	
	public ControladorPrincipal() {
		//Construïm la finestra principal
		finestra = new MenuPrincipal();
		finestra.setVisible(true);
		
		//Afegim els Listeners necessaris
		for (JMenuItem item: finestra.getMenuItems()) {
			item.addActionListener(this);
		}
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
			//TODO Guardar un fitxer sobreescrivint
			break;
		case "Save as...":
			//TODO Guardar en un fitxer diferent
			break;
		case "Exit":
			//TODO Tancar el programa preguntant si guardem canvis
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
			//TODO Implementar finestra About
			break;
		}
	}
}
