package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GestorFitxers {
	
	private String fileName = "";
	private File fitxer = null;
	private JFileChooser selectFitxer;
	
	public GestorFitxers () {
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
				
				//Obtenim el nom del fitxer
				fileName = fitxer.getName();
				setFileName(fileName);
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
		
		//Si el textPane no està buit, demanar si es vol guardar abans d'obrir un nou fitxer.
		if (saveChangesBeforeExit(textPane) != JOptionPane.CANCEL_OPTION) {
		
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.txt, *.doc)", "txt", "doc");
			selectFitxer.setFileFilter(filter);
			
			if (selectFitxer.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					textPane.setText("");
					fitxer = selectFitxer.getSelectedFile();
					
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
				//Obtenim el nom del fitxer
				fileName = fitxer.getName();
				setFileName(fileName);
			}
		}
	}
	
	public int saveChangesBeforeExit (JTextPane textPane) {
		int result = 0;
		
		if (!textPane.getText().equals("")) {
			result = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "You have an unsaved file",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				saveFile(textPane);
			}
		}
		return result;
	}
	
	public String getFileName() {
		if (fitxer != null) {
			return fileName;
		}
		return "";
	}
	
	public void setFileName(String fileName) {
		this.fileName = " | " + fileName;
	}
}
