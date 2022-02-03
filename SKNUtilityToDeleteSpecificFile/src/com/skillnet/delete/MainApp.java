package com.skillnet.delete;

import java.io.File;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("Please Copy Paste All The POS Name : ");
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String markerLine = sc.nextLine();
			String posName = markerLine.split(" ")[0];
			if (!markerLine.contains("appears to be offline")) {
				File sysProp = new File("\\\\" + posName + "\\Temp-Tobe-Cleared-Every-1st\\Trupti\\Test\\system.properties");
				File sysPropTemp = new File("\\\\" + posName + "\\Temp-Tobe-Cleared-Every-1st\\Trupti\\Test\\system.properties_temp");
				// File[] files = file.listFiles();
				System.out.print("\n" + posName + " - ");
				if (sysProp.exists() && sysPropTemp.exists()) {
					System.out.print("Found both the files");
					sysProp.delete();
					System.out.print(" - DELETED = " + !(sysProp.exists()));

					boolean rename = sysPropTemp.renameTo(sysProp);
					System.out.print(" - RENAMED = " + rename);
				} else if (!(sysProp.exists()) || !(sysPropTemp.exists())) {
					System.out.print("One or both the files are missing");
				} else {
					System.out.print("POS not pingable");
				}
			}
		}
		sc.close();
		System.exit(0);
	}
}
