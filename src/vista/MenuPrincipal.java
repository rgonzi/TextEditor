package vista;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MenuPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, viewMenu, helpMenu;
	private JMenuItem open, save, saveAs, exit, copy, paste, fullscreen, about;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public MenuPrincipal() {
		setTitle("Text editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		initialize();
		
		this.setVisible(true);
	}
	
	private void initialize() {
		scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		open = new JMenuItem("Open");
		fileMenu.add(open);
		save = new JMenuItem("Save");
		fileMenu.add(save);
		saveAs = new JMenuItem("Save as...");
		fileMenu.add(saveAs);
		exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		
		editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		copy = new JMenuItem("Copy");
		editMenu.add(copy);
		paste = new JMenuItem("Paste");
		editMenu.add(paste);
		
		viewMenu = new JMenu("View");
		menuBar.add(viewMenu);
		fullscreen = new JMenuItem("Full Screen");
		viewMenu.add(fullscreen);
		
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		about = new JMenuItem("About");
		helpMenu.add(about);
	}
	
}
