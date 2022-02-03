package com.skillnet.util.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.skillnet.util.UtilConstants;

public class ExcelUtil implements UtilConstants {

	private static ExcelUtil object = null;
	
	
	//prevent instantiation 
	private ExcelUtil() {
	}
	
	
	public static ExcelUtil getInstance() {

		if (object == null) {
			
			object = new ExcelUtil();
		}

		return object;

	}

	private static HashMap<String, XSSFWorkbook> xlxsFileMap = new HashMap<String, XSSFWorkbook>();

	public XSSFWorkbook getWorkbook(String fileName) throws IOException {

		XSSFWorkbook workbook = xlxsFileMap.get(fileName);

		if (workbook == null) {

			StringBuilder resourceDir = new StringBuilder();
			resourceDir.append(DOWNLOAD_DIR).append(fileName).append(EXCEL_FILE_EXTENSION);

			FileInputStream file = new FileInputStream(resourceDir.toString());

			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);

			xlxsFileMap.put(fileName, workbook);
		}

		return workbook;

	}

}
