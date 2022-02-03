package com.skillnetinc.marker.mainApp;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import com.skillnetinc.marker.utility.OpsUtility;

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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel guiPanel = OpsUtility.guiOps(tabbedPane);
		
		
		tabbedPane.addTab("GUI", guiPanel);
		tabbedPane.addTab("Console", OpsUtility.consoleOps());
		tabbedPane.addTab("readMe", OpsUtility.readMeOps());
		
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputFrame.setSize(800, 300);// 800 width and 500 height
		inputFrame.setLayout(null);// using no layout managers
		inputFrame.setVisible(true);// making the frame visible
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// frame.setLocation(dim.width/2-frame.getSize().width/2,
		// dim.height/2-frame.getSize().height/2);
		inputFrame.setLocationRelativeTo(null);
		inputFrame.getContentPane().setLayout(new GridLayout(1, 1));
		inputFrame.getContentPane().add(tabbedPane);
		setIcon(inputFrame);

//		InputUtility.showUserInputFields(inputFrame);
//		InputUtility.buttonActivity(inputFrame);

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
