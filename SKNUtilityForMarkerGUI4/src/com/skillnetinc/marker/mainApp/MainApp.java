package com.skillnetinc.marker.mainApp;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.skillnetinc.marker.utility.InputUtility;

public class MainApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				showGUI();
			}
		});
	}

	protected static void showGUI() {
		JFrame inputFrame = new JFrame("Marker Deletion Script");
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		inputFrame.setSize(800, 300);// 800 width and 500 height
		inputFrame.setLayout(null);// using no layout managers
		inputFrame.setVisible(true);// making the frame visible

		inputFrame.setLocationRelativeTo(null);

		InputUtility.showUserInputFields(inputFrame);
		InputUtility.buttonActivity(inputFrame);

	}

}
