package com.skillnetinc.marker.utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class OpsUtility {

	public static JTextArea markerDesc;
	public static JLabel labelMarkerDesc;

	public static JPanel guiOps(JTabbedPane tabbedPane) {

		JPanel guiPanel = new JPanel();

		labelMarkerDesc = new JLabel("<html>Marker<br>Description</html>");
		labelMarkerDesc.setBounds(50, 115, 100, 30);
		markerDesc = new JTextArea(10, 20);
		markerDesc.setBounds(150, 15, 300, 230);
		markerDesc.setBorder(BorderFactory.createLineBorder(Color.gray));

		buttonActivity(guiPanel, tabbedPane);
		
//		guiPanel.add(labelMarkerDesc);
//		guiPanel.add(markerDesc);

		return guiPanel;
	}

	public static void buttonActivity(JPanel guiPanel, JTabbedPane tabbedPane) {
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(520, 50, 150, 40);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				tabbedPane.setSelectedIndex(1);
//				tableFrameTab = new JTabbedPane(JTabbedPane.TOP);
//
//				tableFrameTab.addTab("Console", OpsUtility.consoleOps());
//
//				tableFrameTab.addTab("readMe", OpsUtility.readMeOps());
//
//				tableFrame.setSize(800, 300);
//				tableFrame.setVisible(true);
//				tableFrame.setLocationRelativeTo(null);
//				tableFrame.getContentPane().setLayout(new GridLayout(1, 1));
//				tableFrame.getContentPane().add(tableFrameTab);
				consoleOps();
			}
		});

		JButton clear = new JButton("CLEAR");
		clear.setBounds(520, 100, 150, 40);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				markerDesc.setText("");
				// incidentNum.setText("");
			}
		});

		JButton howTo = new JButton("HOW-TO-USE");
		howTo.setBounds(520, 170, 150, 40);
		howTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		guiPanel.add(labelMarkerDesc);
		guiPanel.add(markerDesc);
		guiPanel.add(submit);
		guiPanel.add(clear);
		guiPanel.add(howTo);
		//guiPanel.getRootPane().setDefaultButton(submit);
	}

	public static Component consoleOps() {

		JTextArea consoleText = new JTextArea();
		//consoleText.append("Hello World.");

		String marker[] = OpsUtility.markerDesc.getText().split("\n");
		List<String> listMarker = new ArrayList<String>(Arrays.asList(marker));
		listMarker.removeIf(n -> n.contains("appears to be offline"));
		marker = new String[listMarker.size()];
		marker = listMarker.toArray(marker);

		for (int i = 0; i < marker.length; i++) {
			String posName = marker[i].split(" ")[0];

			File file = new File("\\\\" + posName + "\\C$\\environment\\marker");
			consoleText.append("\nChecking for marker inside " + file);
			File[] files = file.listFiles();
			if (file.canRead()) {
				consoleText.append("Found Total " + files.length + " markers inside " + file);
				for (int j = 0; j < files.length; j++) {
					consoleText.append("Deleting " + files[j].getName() + " at " + posName);
					files[j].delete();
				}
				consoleText.append("Checking if markers are cleared at " + posName);
				files = file.listFiles();
				consoleText.append("Total markers = " + files.length);
			} else {
				consoleText.append("Directory " + posName + " is not accessible");
			}

		}

		return consoleText;
	}

	public static Component readMeOps() {
		// TODO Auto-generated method stub
		return null;
	}

}
