package com.skillnetinc.ops;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.skillnetinc.utility.Constants;
import com.skillnetinc.utility.InputUtility;

public class OpsUtility {

	public static JScrollPane getSheetOne() {
//		String column[] = { "INCIDENT#", "ASSIGNED TO", "ASSIGNED DATE", "TEAM UPDATE", "RESOLUTION", "RESOLUTION DATE",
//				"COMMENTS", "ESCALATED TO POS TEAM", "PRIORITY#", "REGION", "COUNTRY", "STORE#", "ASSIGNED BY", "ISSUE TYPE",
//				"ISSUE SUB-TYPE", "DESCRIPTION" };

		String column[] = { "INCIDENT#", "ASSIGNED TO", "ASSIGNED DATE", "TEAM UPDATE", "INFORMATION",
				"DATA", "COMMENTS", "ESCALATED TO POS TEAM", "PRIORITY#", "STORE#", "REGISTER#",
				"VERSION", "REGION", "COUNTRY", "ASSIGNED BY", "ISSUE TYPE", "ISSUE SUB-TYPE", "TILL ACCESS",
				"DESCRIPTION" };

		String row[][] = {};
		DefaultTableModel listTableModel = new DefaultTableModel(row, column);

		String marker[] = InputUtility.markerDesc.getText().split("\n");
		List<String> listMarker = new ArrayList<String>(Arrays.asList(marker));
		listMarker.removeIf(n -> n.contains("appears to be offline"));
		marker = new String[listMarker.size()];
		marker = listMarker.toArray(marker);

		StringBuilder incDesc = new StringBuilder();
		String notMatchedMarker[] = {};
		List<String> listMatchedMarker = new ArrayList<String>();
		List<String> listNotMatchedMarker = new ArrayList<String>();
		String comment = InputUtility.incidentDate.getText() + ":[" + InputUtility.analystName.getSelectedItem() + "]: "
				+ "Hello GSD,\r\n" + "\r\n" + "Markers are cleared.\r\n" + "Please look into offline alerts.\r\n"
				+ "\r\n" + "Thanks & Regards,\r\n" + InputUtility.analystName.getSelectedItem();

		for (int i = 0; i < marker.length; i++) {
			for (int j = 0; j < marker.length; j++) {
				if (marker[i].substring(0, 7).equals(marker[j].substring(0, 7))) {
					listMatchedMarker.add(marker[j]);
				} else {
					listNotMatchedMarker.add(marker[j]);
				}
			}

			for (String string : listMatchedMarker) {
				incDesc.append(string + " ");
			}

			listMatchedMarker.clear();

// "INCIDENT#", "ASSIGNED TO", "ASSIGNED DATE", "TEAM UPDATE", "REASSIGNED DATE",
//				"COMMENTS", "ESCALATED TO POS TEAM", "PRIORITY#", "STORE#", "REGISTER#", "VERSION", "REGION", "COUNTRY", "ASSIGNED BY", 
			// "ISSUE TYPE",
//				"ISSUE SUB-TYPE", "TILL ACCESS", "DESCRIPTION" 

			listTableModel.addRow(new Object[] { InputUtility.incidentNum.getText(),
					InputUtility.analystName.getSelectedItem(), InputUtility.incidentDate.getText(), null, null, null,
					comment, null, Constants.PRIORITY, marker[i].substring(3, 7), marker[i].substring(9, 11), "16",
					getRegion(marker[i]), getCountry(marker[i].substring(0, 2)), Constants.ASSIGNED_BY,
					Constants.ISSUE_TYPE, getSubIssueType(marker[i]), "No", incDesc });

			marker = listNotMatchedMarker.toArray(notMatchedMarker);
			listNotMatchedMarker.clear();
			incDesc = new StringBuilder();
			i--;
		}

		JTable jt = new JTable(listTableModel);
		JScrollPane sp = new JScrollPane(jt);
		sp.setFont(new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 10));
		return sp;
	}

	// *********SHEET TWO DISABLED*********

//	public static JScrollPane getSheetTwo() {
//		String column[] = { "INCIDENT#", "REGION", "COUNTRY", "STORE#", "TILL#", "DATE", "ISSUE TYPE", "ISSUE SUB-TYPE",
//				"DESCRIPTION" };
//		String row[][] = {};
//		DefaultTableModel listTableModel = new DefaultTableModel(row, column);
//		
//		String marker[] = InputUtility.markerDesc.getText().split("\n");
//		List<String> listMarker = new ArrayList<String>(Arrays.asList(marker));
//		listMarker.removeIf(n -> n.contains("appears to be offline"));
//		marker = new String[listMarker.size()];
//		marker = listMarker.toArray(marker);
//		
//		StringBuilder incDesc = new StringBuilder();
//		String notMatchedMarker[] = {};
//		List<String> listMatchedMarker = new ArrayList<String>();
//		List<String> listNotMatchedMarker = new ArrayList<String>();
//		
//		
//		
//		for (int i = 0; i < marker.length; i++) {
//			for (int j = 0; j < marker.length; j++) {
//				if (marker[i].substring(0, 11).equals(marker[j].substring(0, 11))) {
//					listMatchedMarker.add(marker[j]);
//				} else {
//					listNotMatchedMarker.add(marker[j]);
//				}
//			}
//			
//			for (String string : listMatchedMarker) {
//				incDesc.append(string+" ");
//			}
//			
//			
//			listMatchedMarker.clear();
//			listTableModel.addRow(new Object[] { InputUtility.incidentNum.getText(), getRegion(marker[i]),
//					getCountry(marker[i].substring(0, 2)), marker[i].substring(3, 7), marker[i].substring(8, 12),
//					Constants.CURRENT_DATE, Constants.ISSUE_TYPE, getSubIssueType(marker[i]),
//					incDesc });
//			
//			marker = listNotMatchedMarker.toArray(notMatchedMarker);
//			listNotMatchedMarker.clear();
//			incDesc = new StringBuilder();
//			i--;
//	}
//
//		JTable jt = new JTable(listTableModel);
//		JScrollPane sp = new JScrollPane(jt);
//		return sp;
//
//	}	

	public static JScrollPane getSheetThree() {
		String column[] = { "REGION", "COUNTRY", "STORE#", "TILL#", "DATE", "DESCRIPTION" };
		String row[][] = {};
		DefaultTableModel listTableModel = new DefaultTableModel(row, column);

		String marker[] = InputUtility.markerDesc.getText().split("\n");

		for (int i = 0; i < marker.length; i++) {

			listTableModel.addRow(new Object[] { getRegion(marker[i]), getCountry(marker[i].substring(0, 2)),
					marker[i].substring(3, 7), marker[i].substring(8, 12), InputUtility.incidentDate.getText(),
					marker[i] });
		}

		JTable jt = new JTable(listTableModel);
		JScrollPane sp = new JScrollPane(jt);

		return sp;

	}

	private static String getRegion(String desc) {
		String emeiaCountries[] = { "UK", "AT", "BH", "BE", "CZ", "FR", "DE", "HU", "IT", "KW", "NL", "PT", "QA", "RU",
				"SA", "ES", "CH", "AE" };
		String amerCountries[] = { "US", "CA", "MX", "BR" };
		String asiaCountries[] = { "AU", "JP", "MY", "SG", "KR", "TH", "HK", "CN", "MO" };
		String region = null;
		String country = desc.substring(0, 2);

		for (int j = 0; j < asiaCountries.length; j++) {
			for (int k = 0; k < amerCountries.length; k++) {
				for (int l = 0; l < emeiaCountries.length; l++) {
					if (country.contains(asiaCountries[j])) {
						region = "Asia Pacific";
					} else if (country.contains(amerCountries[k])) {
						region = "Americas";
					} else if (country.contains(emeiaCountries[l])) {
						region = "EMEIA";
					}
				}
			}
		}
		return region;
	}

	private static String getCountry(String argCountry) {
		String country = null;
		Locale locale = new Locale("", argCountry);
		if (argCountry != null & argCountry.equalsIgnoreCase("UK")) {
			country = "United Kingdom";
		} else {
			country = locale.getDisplayCountry();
		}
		return country;
	}

	private static String getSubIssueType(String subIssueType) {
		String issueSubType = null;

		if (subIssueType.contains("startup.err") || subIssueType.contains("upload-pospolls.err")) {
			issueSubType = "Start up error";
		} else if (subIssueType.contains("get-remote-sql-server-backup.err")) {
			issueSubType = "Download error";
		} else if (subIssueType.contains("restore-xstore-db.err") || subIssueType.contains("unzipdbbackup.err")) {
			issueSubType = "Database restore Error";
		} else {
			issueSubType = "Close error";
		}
		return issueSubType;
	}

//	private static void writeToExcell(JTable table, Path path) throws FileNotFoundException, IOException {
//	    new WorkbookFactory();
//	    Workbook wb = new XSSFWorkbook(); //Excell workbook
//	    Sheet sheet = wb.createSheet(); //WorkSheet
//	    Row row = sheet.createRow(2); //Row created at line 3
//	    TableModel model = table.getModel(); //Table model
//
//
//	    Row headerRow = sheet.createRow(0); //Create row at line 0
//	    for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
//	        headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
//	    }
//
//	    for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
//	        for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
//	            row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
//	        }
//
//	        //Set the row to the next one in the sequence 
//	        row = sheet.createRow((rows + 3)); 
//	    }
//	    wb.write(new FileOutputStream(path.toString()));//Save the file     
//	}

}
