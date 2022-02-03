package com.burberry.mnt.mainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.burberry.mnt.util.UtilConstants;

public class MainApp {
	
	static String xstoreLastModifiedName;
	static String xstoreLastModifiedDate;
	static String dateToComapre;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		welcomeMsg();
		getLastMntProcessedDate();
	}

	private static void getLastMntProcessedDate() {
		System.out.println("Finding the last modified NAME and DATE of the folder inside "+UtilConstants.XSTORE_ARCHIVE_DIR);
		
		File folder = new File(UtilConstants.XSTORE_ARCHIVE_DIR);
		File[] files = folder.listFiles();
		Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		xstoreLastModifiedName = files[0].getName();
		xstoreLastModifiedDate = sdf.format(files[0].lastModified());
		System.out.println("NAME - "+xstoreLastModifiedName);
		System.out.println("DATE - "+xstoreLastModifiedDate);
		
		String dateMaker [] = xstoreLastModifiedName.split("_");
		System.out.println(dateMaker[0]);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df.parse(dateMaker[0]));
			cal.add(Calendar.DAY_OF_MONTH, -1);
		    dateToComapre = df.format(cal.getTime());
		    System.out.println(dateToComapre);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		getFilesInImmediate(dateToComapre);
	}

	private static void getFilesInImmediate(String dateToComapre2) {
		System.out.println("Finding all the files inside "+UtilConstants.DATA_IMMEDIATE_DIR+" which contains "+dateToComapre2);
		File folder = new File(UtilConstants.DATA_IMMEDIATE_DIR);
		File[] files = folder.listFiles();
		
	//	System.out.println("Found total "+files.length+" zipped files containing "+ dateToComapre2+" inside "+UtilConstants.DATA_IMMEDIATE_DIR);
		for (int i = 0; i < files.length; i++) {
			while (files[i].getName().contains(dateToComapre2)) {
				System.out.println(files[i].getName());
				unzip(files[i].getName());
				break;
			}
		}
		
	}
	
    private static void unzip(String zipFileName) {
    	String zipFilePath = UtilConstants.DATA_IMMEDIATE_DIR+"\\"+zipFileName;
    	
        File dir = new File(UtilConstants.XSTORE_DOWNLOAD_DIR);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(UtilConstants.XSTORE_DOWNLOAD_DIR + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


	private static void welcomeMsg() {
		
	}
}
