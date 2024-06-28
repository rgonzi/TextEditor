package vista;
 
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MenuPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, viewMenu, helpMenu;
	private JMenuItem[] menuItems = new JMenuItem[8];
	private JPanel panel;
	private JToolBar toolBar;
	private JButton btnBold, btnItalic;
	private JComboBox comboFont;
	private JSeparator separator2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField counts;
	private JComboBox comboSize;
	private JSeparator separator3;
	private JSeparator separator1;
	

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
		
		counts = new JTextField();
		counts.setEditable(false);
		getContentPane().add(counts, BorderLayout.SOUTH);
		counts.setColumns(10);
		
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
		
		menuItems[4] = new JMenuItem(new DefaultEditorKit.CopyAction());
		menuItems[4].setText("Copy");
		menuItems[5] = new JMenuItem(new DefaultEditorKit.PasteAction());
		menuItems[5].setText("Paste");
		
		menuItems[6] = new JMenuItem("Full Screen");
		
		menuItems[7] = new JMenuItem("About");
		
		for(int i = 0; i < 4; i++) {
			fileMenu.add(menuItems[i]);
		}
		
		editMenu.add(menuItems[4]);
		editMenu.add(menuItems[5]);
		viewMenu.add(menuItems[6]);
		helpMenu.add(menuItems[7]);
		
		//Iniciem el camp de text dels comptadors
		this.counts.setText("Words: 0 Chars: 0");
		
		
		//Creem un panel per afegit un JToolBar i les opcions per formatar el text
		//TODO Implementar la barra i els seus ActionListeners
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		panel.add(toolBar);
		
		btnBold = new JButton("  B  ");
		btnBold.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnBold);
		
		btnItalic = new JButton("  K  ");
		btnItalic.setFont(new Font("Tahoma", Font.ITALIC, 11));
		toolBar.add(btnItalic);
		
		separator1 = new JSeparator();
		separator1.setMaximumSize(new Dimension(4000, 32767));
		toolBar.add(separator1);
		
		comboSize = new JComboBox();
		comboSize.setMaximumSize(new Dimension(3000, 32767));
		toolBar.add(comboSize);
		
		separator2 = new JSeparator();
		separator2.setMaximumSize(new Dimension(4000, 32767));
		toolBar.add(separator2);
		
		comboFont = new JComboBox();
		toolBar.add(comboFont);
		
		separator3 = new JSeparator();
		separator3.setPreferredSize(new Dimension(400, 2));
		toolBar.add(separator3);
		
	}
	
	//Getters i setters

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public JMenuItem[] getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(JMenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	public JTextField getCounts() {
		return counts;
	}

	public void setCounts(JTextField counts) {
		this.counts = counts;
	}
	
}
