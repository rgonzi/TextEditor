package vista;
 
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, viewMenu, helpMenu;
	JMenuItem itemOpen, itemSave, itemSaveAs, itemExit, itemCopy, itemPaste, itemCut, itemFullScreen, itemAbout;
	private JPanel panel;
	private JToolBar toolBar;
	private JButton btnBold, btnItalic;
	private JComboBox<String> comboStyle;
	private JComboBox<Integer> comboSize;
	private JSeparator separator1, separator2, separator3;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	private JTextField counts;
	

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
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
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
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemSaveAs = new JMenuItem("Save as...");
		itemExit = new JMenuItem("Exit");
		
		itemCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		itemCopy.setText("Copy");
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		itemPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		itemPaste.setText("Paste");
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		editMenu.add(new JSeparator());
		itemCut = new JMenuItem(new DefaultEditorKit.CutAction());
		itemCut.setText("Cut");
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		
		
		itemFullScreen = new JMenuItem("Full Screen");
		itemFullScreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		
		itemAbout = new JMenuItem("About");
		
		fileMenu.add(itemOpen);
		fileMenu.add(itemSave);
		fileMenu.add(itemSaveAs);
		fileMenu.add(itemExit);
		
		editMenu.add(itemCopy);
		editMenu.add(itemPaste);
		editMenu.add(itemCut);
		editMenu.add(new JSeparator());
		
		viewMenu.add(itemFullScreen);
		
		helpMenu.add(itemAbout);
		
		//Iniciem el camp de text dels comptadors
		this.counts.setText("Words: 0 Chars: 0");
		
		
		//Creem un panel per afegit un JToolBar i les opcions per formatar el text
		//TODO Implementar la barra i els seus ActionListeners
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		panel.add(toolBar);
		
		btnBold = new JButton("B");
		btnBold.setToolTipText("Bold");
		btnBold.setFocusable(false);
		btnBold.setPreferredSize(new Dimension(23, 23));
		btnBold.setMinimumSize(new Dimension(23, 23));
		btnBold.setMaximumSize(new Dimension(23, 23));
		btnBold.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnBold);
		
		btnItalic = new JButton("K");
		btnItalic.setToolTipText("Italic");
		btnItalic.setFocusable(false);
		btnItalic.setMinimumSize(new Dimension(23, 23));
		btnItalic.setMaximumSize(new Dimension(23, 23));
		btnItalic.setPreferredSize(new Dimension(23, 23));
		btnItalic.setFont(new Font("Tahoma", Font.ITALIC, 11));
		toolBar.add(btnItalic);
		
		separator1 = new JSeparator();
		separator1.setMinimumSize(new Dimension(10, 0));
		separator1.setPreferredSize(new Dimension(10, 23));
		separator1.setMaximumSize(new Dimension(15, 23));
		toolBar.add(separator1);
		
		comboSize = new JComboBox<Integer>();
		comboSize.setEditable(true);
		comboSize.setToolTipText("Size");
		comboSize.setFocusable(false);
		comboSize.setPreferredSize(new Dimension(45, 22));
		comboSize.setMaximumSize(new Dimension(45, 22));
		initComboSize();
		comboSize.setSelectedIndex(1);
		toolBar.add(comboSize);
		
		separator2 = new JSeparator();
		separator2.setPreferredSize(new Dimension(15, 23));
		separator2.setMinimumSize(new Dimension(15, 23));
		separator2.setMaximumSize(new Dimension(20, 23));
		toolBar.add(separator2);
		
		comboStyle = new JComboBox<String>();
		comboStyle.setEditable(true);
		comboStyle.setToolTipText("Style");
		comboStyle.setFocusable(false);
		comboStyle.setMinimumSize(new Dimension(30, 23));
		comboStyle.setPreferredSize(new Dimension(150, 23));
		comboStyle.setMaximumSize(new Dimension(170, 23));
		initComboStyle();
		toolBar.add(comboStyle);
		
		separator3 = new JSeparator();
		separator3.setPreferredSize(new Dimension(400, 2));
		toolBar.add(separator3);
		
	}
	
	private void initComboSize() {
		for (int i = 8; i <= 64; i = i + 2) {
			comboSize.addItem(i);
		}
		
	}
	
	private void initComboStyle() {
		//Obtenim els estils disponibles al sistema
		String[] styles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		int posDefaultFont = 0;
		//Afegim les fonts al nostre comboBox
		for (int i = 0; i < styles.length; i++) {
			comboStyle.addItem(styles[i]);
			
			if (styles[i].equals("Times New Roman")) {
				posDefaultFont = i;
			}
			comboStyle.setSelectedIndex(posDefaultFont);
		}
		
	}
	
	//Getters i setters

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	public JTextField getCounts() {
		return counts;
	}

	public void setCounts(JTextField counts) {
		this.counts = counts;
	}

	public JButton getBtnBold() {
		return btnBold;
	}

	public void setBtnBold(JButton btnBold) {
		this.btnBold = btnBold;
	}

	public JButton getBtnItalic() {
		return btnItalic;
	}

	public void setBtnItalic(JButton btnItalic) {
		this.btnItalic = btnItalic;
	}

	public JComboBox<String> getComboFont() {
		return comboStyle;
	}

	public void setComboFont(JComboBox<String> comboFont) {
		this.comboStyle = comboFont;
	}

	public JComboBox<Integer> getComboSize() {
		return comboSize;
	}

	public void setComboSize(JComboBox<Integer> comboSize) {
		this.comboSize = comboSize;
	}
	
	
	
}
