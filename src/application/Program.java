package application;

import javax.swing.SwingUtilities;

import model.controller.Window;

public class Program {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window().setVisible(true);
			}
		});
	}

}
