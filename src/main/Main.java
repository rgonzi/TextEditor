package main;

import javax.swing.SwingUtilities;
import controlador.ControladorPrincipal;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new ControladorPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
