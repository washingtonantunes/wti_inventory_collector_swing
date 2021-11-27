package application;

import javax.swing.SwingUtilities;

import controller.SearchData;

public class Program {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SearchData();
			}
		});
	}

}
