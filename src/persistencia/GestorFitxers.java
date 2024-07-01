package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GestorFitxers {
	
	private String nomFitxer;
	private File fitxer = null;
	private JTextPane text;
	private JFileChooser selectFitxer;
	
	public GestorFitxers {
		selectFitxer = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.txt, *.doc)", "txt", "doc");
		selectFitxer.setFileFilter(filter);
	}
	
	public void saveFile (JTextPane textPane) {
		
		if (fitxer == null) {
			saveFileAs(textPane);
		} else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fitxer));
				bw.write(textPane.getText());
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveFileAs (JTextPane textPane) {
		
		selectFitxer = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.txt, *.doc)", "txt", "doc");
		selectFitxer.setFileFilter(filter);
		
		if (selectFitxer.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				fitxer = selectFitxer.getSelectedFile();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(fitxer));
				bw.write(textPane.getText());
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void openFile (JTextPane textPane) {
		selectFitxer = new JFileChooser();
		
		//TODO Si el textPane no està buit, demanar si es vol guardar abans d'obrir un nou fitxer.
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.txt, *.doc)", "txt", "doc");
		selectFitxer.setFileFilter(filter);
		
		if (selectFitxer.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				textPane.setText("");
				fitxer = selectFitxer.getSelectedFile();
				
				//TODO Implementar el nom del fitxer al titol del JFrame principal
				
				BufferedReader br = new BufferedReader(new FileReader(fitxer));
				StringBuilder sb = new StringBuilder();
				String line;
				//Construïm un String amb tot el contingut del text
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				
				//Escrivim el String creat en el textPane
				textPane.setText(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
