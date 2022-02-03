package com.skillnetinc.marker.mainApp;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.skillnetinc.marker.utility.InputUtility;

public class MainApp {
	public static void main(String[] args) {
//		EventQueue.invokeLater( () -> showGUI() );
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
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// frame.setLocation(dim.width/2-frame.getSize().width/2,
		// dim.height/2-frame.getSize().height/2);
		inputFrame.setLocationRelativeTo(null);
		setIcon(inputFrame);

		InputUtility.showUserInputFields(inputFrame);
		InputUtility.buttonActivity(inputFrame);

	}

	private static void setIcon(JFrame inputFrame) {
		try {
			inputFrame.setIconImage(ImageIO.read(new File("skillnet-icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image Canot Be Found");
		}

	}
}
