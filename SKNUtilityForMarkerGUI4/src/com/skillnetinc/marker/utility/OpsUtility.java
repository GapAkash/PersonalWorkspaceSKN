package com.skillnetinc.marker.utility;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;

public class OpsUtility {

	public static void consoleOps(JTextArea consoleText) {

		SwingWorker sw = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {

				String marker[] = InputUtility.markerDesc.getText().split("\n");
				StringBuilder alert = new StringBuilder();

				if (!(marker[0].equals(""))) {

					alert.append("Done");

					List<String> listMarker = new ArrayList<String>(Arrays.asList(marker));
					listMarker.removeIf(n -> n.contains("appears to be offline"));
					marker = new String[listMarker.size()];
					marker = listMarker.toArray(marker);

					consoleText.append(
							"Welcome to Marker Deletion Script - \nPlease click on HOW-TO-USE & go through the readMe to contribute in making this script bug free :)\n");

					for (int i = 0; i < marker.length; i++) {
						String posName = marker[i].split(" ")[0];

						File file = new File("\\\\" + posName + "\\C$\\environment\\marker");
						consoleText.append("\n" + posName + " - ");
						File[] files = file.listFiles();

						if (file.canRead()) {
							consoleText.append("Total Markers: " + files.length);
							if (files.length > 0) {
								consoleText.append(" - Deleting... - ");
								FileUtils.cleanDirectory(file);
								consoleText.append("Deleted - ");
								files = file.listFiles();
								consoleText.append("Total markers = " + files.length);
							} else if (files.length == 0) {
								consoleText.append(" - Nothing To Delete !");
							}

						} else {
							consoleText.append("Not Accessible");

						}

					}
					consoleText.append("\n\nDone...\nThank You For Using Marker Deletion Script");

				} else {
					alert.append("Marker Issue field cannot be NULL");
				}
				JOptionPane.showMessageDialog(null, alert, "ALERT", JOptionPane.INFORMATION_MESSAGE);
				return consoleText;
			}
		};
		sw.execute();

	}

//	public static JEditorPane readMeOps() {
//		JEditorPane ep = new JEditorPane();
//		ep.setText("lul");
//		return e;
//	}

}
