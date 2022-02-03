package com.skillnetinc.marker.utility;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class InputUtility {

	public static JFrame tableFrame;
	public static JTextArea markerDesc;
	public static JLabel labelMarkerDesc;
	public static JTabbedPane tableFrameTab;

	public static void showUserInputFields(JFrame inputFrame) {
		labelMarkerDesc = new JLabel("<html>Marker<br>Description</html>");
		labelMarkerDesc.setBounds(50, 115, 100, 30);
		markerDesc = new JTextArea(10, 20);
		markerDesc.setBounds(150, 15, 300, 230);
		markerDesc.setBorder(BorderFactory.createLineBorder(Color.gray));

		inputFrame.add(markerDesc);
		inputFrame.add(labelMarkerDesc);
	}

	public static void buttonActivity(JFrame inputFrame) {
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(520, 50, 150, 40);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				tableFrame = new JFrame("Script Result");
				tableFrameTab = new JTabbedPane(JTabbedPane.TOP);
				tableFrame.setSize(800, 300);
				tableFrame.setVisible(true);
				tableFrame.setLocationRelativeTo(null);
				tableFrame.getContentPane().setLayout(new GridLayout(1, 1));
				tableFrame.getContentPane().add(tableFrameTab);

				tableFrameTab.addTab("Console", OpsUtility.consoleOps());
				tableFrameTab.addTab("readMe", OpsUtility.readMeOps());

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

		inputFrame.add(submit);
		inputFrame.add(clear);
		inputFrame.add(howTo);
		inputFrame.getRootPane().setDefaultButton(submit);
	}

}
