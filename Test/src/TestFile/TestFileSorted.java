package TestFile;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class TestFileSorted {
	public static void main(String[] args) {
		
		File folder = new File("\\\\192.168.3.50\\Temp-Tobe-Cleared-Every-1st\\BRB\\Test");
		File[] files = folder.listFiles();
		
		//Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		for (int i = 0; i < files.length; i++) {
			System.out.println("Before Delete "+files[i].getName());
			files[i].delete();
		}
		files = folder.listFiles();
		System.out.println("After Delete "+files.length);
	}
}
