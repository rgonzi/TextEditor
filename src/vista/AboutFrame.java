package vista;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class AboutFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextPane txtAbout;

	public AboutFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutFrame.class.getResource("/res/icon.jpg")));
		setTitle("About");
		setResizable(false);
		setAlwaysOnTop(true);
		setSize(350, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		init();
		
	}
	
	private void init() {
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtAbout = new JTextPane();
		txtAbout.setOpaque(false);
		txtAbout.setText("TextEditor ©"
				+ "\nVersion: 1.0"
				+ "\nRelease Date: 12/07/2024"
				+ "\n\nDeveloped by: Roger González Acosta [rgonzi]"
				+ "\nEmail: rogergonzalezacosta@gmail.com"
				+ "\nGitHub: https://github.com/rgonzi");
		txtAbout.setEditable(false);
		panel.add(txtAbout);
		
	}

}
