package com.skillnetinc.marker.utility;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InputUtility {

	public static JFrame tableFrame;
	public static JTextArea markerDesc, consoleText;
	public static JLabel labelMarkerDesc;

	public static void showUserInputFields(JFrame inputFrame) {
		labelMarkerDesc = new JLabel("<html>Marker<br>Issues</html>");
		labelMarkerDesc.setBounds(80, 115, 100, 30);
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
				consoleText = new JTextArea();
				consoleText.setEditable(false);
				consoleText.setVisible(true);
				JScrollPane sp = new JScrollPane(consoleText);

				tableFrame = new JFrame("Script Result");
				tableFrame.add(sp);
				tableFrame.setSize(800, 300);
				tableFrame.setVisible(true);
				tableFrame.setLocationRelativeTo(null);

				OpsUtility.consoleOps(consoleText);
//				OpsUtility.readMeOps();

			}

		});
		JButton clear = new JButton("CLEAR");
		clear.setBounds(520, 100, 150, 40);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				markerDesc.setText("");
			}
		});

		JButton howToUse = new JButton("HOW-TO-USE");
		howToUse.setBounds(520, 170, 150, 40);
		howToUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL(
							"https://skillnetsolutions-my.sharepoint.com/:f:/g/personal/akash_gupta_skillnetinc_com/EhHcEFKo6ZlAhkc3HLzjTUIBmIOt2FZ6ulVKLI_94Uy4eA?e=bbgHdV")
									.toURI());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		inputFrame.add(submit);
		inputFrame.add(clear);
		inputFrame.add(howToUse);
		inputFrame.getRootPane().setDefaultButton(submit);
	}
}
