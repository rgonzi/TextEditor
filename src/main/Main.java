package main;

import javax.swing.SwingUtilities;

import vista.MenuPrincipal;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MenuPrincipal();
					//new ControladorPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
