package com.skillnet.dataservice.transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.skillnet.dataservice.AbstractProcessor;
import com.skillnet.util.excel.ExcelUtil;
import com.skillnet.util.excel.bean.RevertTransaction;

public class RevertTransactionProcessor extends AbstractProcessor {

	private static Logger logger = Logger.getLogger(RevertTransactionProcessor.class);

	@Override
	protected void executeProcess() {

		logger.info("need to do Revert Transaction process");

	}

	public List<RevertTransaction> getRevertTransactionInfo(String argFileName) {

		List<RevertTransaction> revertTransactions = new ArrayList<RevertTransaction>();

		try {
			XSSFWorkbook workbook = ExcelUtil.getInstance().getWorkbook(argFileName);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				//skip the header
				if (row.getRowNum() != 0) {

					revertTransactions.add(new RevertTransaction(row));
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return revertTransactions;

	}

	@Override
	protected String getUtilityName() {

		return "Revert Transaction";
	}

}
