package com.skillnet.marker.mainApp;

import java.io.File;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("Please Copy Paste All The Markers : ");
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			String markerLine = sc.nextLine();
			String posName = markerLine.split(" ")[0];
			
			if (!markerLine.contains("appears to be offline")) {
				File file = new File("\\\\"+posName+"\\C$\\environment\\marker");
				System.out.println("\nChecking for marker inside "+file);
				File[] files = file.listFiles();
				if (file.canRead()) {
					System.out.println("Found Total "+files.length+" markers inside "+file);
					for (int i = 0; i < files.length; i++) {
						System.out.println("Deleting "+files[i].getName()+" at "+posName);
						files[i].delete();
					}
					System.out.println("Checking if markers are cleared at "+posName);
					files = file.listFiles();
					System.out.println("Total markers = "+files.length);
				} else {
					System.out.println("Directory "+posName+" is not readable");
				}
			}
		}
		sc.close();
		System.exit(0);
	}
}