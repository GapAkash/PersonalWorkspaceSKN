package mainApp;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import userInput.GetInput;

public class MainApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				showGUI();
			}
		});
	}

	private static void showGUI() {
		JFrame frame = new JFrame("Input Details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(400,250);//400 width and 500 height  
	    frame.setLayout(null);//using no layout managers  
	    frame.setVisible(true);//making the frame visible 
	    //frame.setLocationRelativeTo(null);
	    setIcon(frame);
	    
		GetInput.getTitle(frame);
		GetInput.getRemainingTime(frame);
		GetInput.getRating(frame);
		GetInput.getLink(frame);
		GetInput.ButtonActivity(frame);
		
	}

	private static void setIcon(JFrame frame) {
		try {
			frame.setIconImage(ImageIO.read(new File("D:\\Sample Workspace\\UDM_App\\UDM_app.png")));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image Canot Be Found");
		}
	    		
	}
}
