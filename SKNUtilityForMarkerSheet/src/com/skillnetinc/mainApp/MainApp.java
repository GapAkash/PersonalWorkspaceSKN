package com.skillnetinc.mainApp;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.skillnetinc.utility.InputUtility;


public class MainApp {
	
	private static void showGUI() {
		JFrame inputFrame = new JFrame("Input Marker Details");
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inputFrame.setSize(800,300);//400 width and 500 height  
	    inputFrame.setLayout(null);//using no layout managers  
	    inputFrame.setVisible(true);//making the frame visible 
	    //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    //frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	    inputFrame.setLocationRelativeTo(null);
	    setIcon(inputFrame);
//	    
//		GetInput.getTitle(frame);
//		GetInput.getRemainingTime(frame);
//		GetInput.getRating(frame);
//		GetInput.getLink(frame);
//		GetInput.ButtonActivity(frame);
	    
	    InputUtility.showUserInputFields(inputFrame);
	    InputUtility.buttonActivity(inputFrame);
		
	}
	private static void setIcon(JFrame frame) {
		try {
			frame.setIconImage(ImageIO.read(new File("skillnet-icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image Canot Be Found");
		}
	    		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				showGUI();
			}
		});
	}
}
