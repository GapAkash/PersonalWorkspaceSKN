package com.skillnetinc.marker.utility;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class OpsUtility {

	
	public static Component consoleOps() {
		JTextArea consoleText = new JTextArea();
		consoleText.setEditable(false);
		//consoleText.setCaretPosition(consoleText.getText().length() - 1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//ConsoleRedirectUtility.redirectOut(consoleText);
				
				String marker[] = InputUtility.markerDesc.getText().split("\n");
				List<String> listMarker = new ArrayList<String>(Arrays.asList(marker));
				listMarker.removeIf(n -> n.contains("appears to be offline"));
				marker = new String[listMarker.size()];
				marker = listMarker.toArray(marker);
				
				consoleText.append("\nChecking for marker inside " );
				
				for (int i = 0; i < marker.length; i++) {
					String posName = marker[i].split(" ")[0];

					File file = new File("\\\\" + posName + "\\C$\\environment\\marker");
					consoleText.append("\nChecking for marker inside " + file);
					System.out.println("\nChecking for marker inside " + file);

					File[] files = file.listFiles();
					if (file.canRead()) {
						consoleText.append("Found Total " + files.length + " markers inside " + file);
						System.out.println("Found Total " + files.length + " markers inside " + file);

						for (int j = 0; j < files.length; j++) {
							consoleText.append("Deleting " + files[j].getName() + " at " + posName);
							System.out.println("Deleting " + files[j].getName() + " at " + posName);

							files[j].delete();
						}
						consoleText.append("Checking if markers are cleared at " + posName);
						System.out.println("Checking if markers are cleared at " + posName);

						files = file.listFiles();
						consoleText.append("Total markers = " + files.length);
						System.out.println("Total markers = " + files.length);

					} else {
						consoleText.append("Directory " + posName + " is not accessible");
						System.out.println("Directory " + posName + " is not accessible");

					}

				}
			}
		});
		return consoleText;
	}

	public static Component readMeOps() {
		return null;
	}

}
