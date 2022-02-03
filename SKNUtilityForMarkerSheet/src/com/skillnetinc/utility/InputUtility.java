package com.skillnetinc.utility;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.skillnetinc.ops.OpsUtility;

public class InputUtility {
	
	public static JFrame tableFrame;
	public static JTabbedPane tableFrameTab;
	public static JTextArea markerDesc;
	public static JTextField incidentNum, incidentDate;
	public static String analysts[] = {"SUDIP", "PRATIK", "ONKAR", "CHANDAN", "NISHA", "AKASH", "SAYALI", "MAYUR", "NIRANJAN"};
	public static JComboBox<String> analystName;
	public static JLabel labelMarkerDesc, labelIncidentNum, labelIncidentDate, labelAnalystName;
	
	
	public static void showUserInputFields(JFrame inputFrame) {
//		userInput.getDate().setBounds(110, 15, 200, 30);
//
//		
//		inputFrame.add(userInput.getDate());
		labelMarkerDesc = new JLabel("<html>Marker<br>Description</html>");
		labelMarkerDesc.setBounds(50, 115, 100, 30);
		markerDesc = new JTextArea(10,20);
		markerDesc.setBounds(150, 15, 200, 230);
		markerDesc.setBorder(BorderFactory.createLineBorder(Color.gray));

		//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
//		JTextField markerDesc = new JTextField();
//		markerDesc.setBounds(110, 15, 200, 100);
		
		labelIncidentNum = new JLabel("<html>Incident<br>Num</html>");
		labelIncidentNum.setBounds(450, 15, 100,30);
		incidentNum = new JTextField();
		incidentNum.setBounds(500, 15, 200, 30);
		
		labelIncidentDate = new JLabel("<html>Incident<br>Date</html>");
		labelIncidentDate.setBounds(450,65, 100,30);
		incidentDate = new JTextField();
		incidentDate.setBounds(500, 65, 200, 30);
		incidentDate.setText(Constants.CURRENT_DATE);
		
		labelAnalystName = new JLabel("<html>Analyst<br>Name</html>");
		labelAnalystName.setBounds(450, 115, 100,30);
		analystName = new JComboBox<String>(analysts);
		analystName.setBounds(500, 115, 200, 30);
		analystName.setEditable(true);
		//analystName.setToolTipText(OpsUtility.getCommonDetails().getAnalystName());
		analystName.setSelectedItem(Constants.ANALYST_NAME);
		
		inputFrame.add(markerDesc);
		inputFrame.add(incidentDate);
		inputFrame.add(incidentNum);
		inputFrame.add(analystName);
		
		inputFrame.add(labelMarkerDesc);
		inputFrame.add(labelIncidentDate);
		inputFrame.add(labelIncidentNum);
		inputFrame.add(labelAnalystName);
	}
	
	public static void buttonActivity(JFrame inputFrame) {
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(480, 180, 100, 40);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 
		        tableFrame = new JFrame("Marker Tables");
		        tableFrameTab = new JTabbedPane(JTabbedPane.TOP);
		        
		 
		        tableFrameTab.addTab(Constants.CURRENT_MONTH+"_"+Constants.CURRENT_YEAR, OpsUtility.getSheetOne());
		        
									//*********SHEET TWO DISABLED*********
//		        tableFrameTab.addTab(Constants.CURRENT_MONTH+"_Till_Details_"+Constants.CURRENT_YEAR, OpsUtility.getSheetTwo());
		 
		        tableFrameTab.addTab(Constants.CURRENT_MONTH+"_Marker_Alerts_"+Constants.CURRENT_YEAR, OpsUtility.getSheetThree());
		 
		        tableFrame.setSize(800, 300);
		        tableFrame.setVisible(true);
		        tableFrame.setLocationRelativeTo(null);
		        tableFrame.getContentPane().setLayout(new GridLayout(1, 1));
		        tableFrame.getContentPane().add(tableFrameTab);
		 
		    }
		});
		
		JButton clear = new JButton("CLEAR");
		clear.setBounds(620,180,100,40);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				markerDesc.setText("");
				incidentNum.setText("");
			}
		});
		inputFrame.add(submit);
		inputFrame.add(clear);
		inputFrame.getRootPane().setDefaultButton(submit);
	}

}
