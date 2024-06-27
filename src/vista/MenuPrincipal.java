package vista;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MenuPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, viewMenu, helpMenu;
	private JMenuItem[] menuItems = new JMenuItem[8]; // open, save, saveAs, exit, copy, paste, fullscreen, about
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public MenuPrincipal() {
		//Iniciem la finestra amb una mida predefinida i la centrem
		setTitle("Text editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		//Iniciem la resta d'elements
		initialize();
	}
	
	private void initialize() {
		//Creem un JScrollPane que contindrà un JTextArea
		scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		//Creació del menuBar amb tots els menus
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		viewMenu = new JMenu("View");
		helpMenu = new JMenu("Help");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		
		//Creem els menuItems dels menus i els afegim als seus menus corresponents
		menuItems[0] = new JMenuItem("Open");
		menuItems[1] = new JMenuItem("Save");
		menuItems[2] = new JMenuItem("Save as...");
		menuItems[3] = new JMenuItem("Exit");
		
		menuItems[4] = new JMenuItem("Copy");
		menuItems[5] = new JMenuItem("Paste");
		
		menuItems[6] = new JMenuItem("Full Screen");
		
		menuItems[7] = new JMenuItem("About");
		
		for(int i = 0; i < 4; i++) {
			fileMenu.add(menuItems[i]);
		}
		
		editMenu.add(menuItems[4]);
		editMenu.add(menuItems[5]);
		viewMenu.add(menuItems[6]);
		helpMenu.add(menuItems[7]);
		
	}
	
	//Getters i setters

	public JTextArea getTextArea() {
		return textArea;
	}

	public JMenuItem[] getMenuItems() {
		return menuItems;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public void setMenuItems(JMenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
	
}
