package com.skillnet.dataservice.transaction;

import org.apache.log4j.Logger;

import com.skillnet.dataservice.AbstractProcessor;

public class MissingTransactionProcessor extends AbstractProcessor {

	private static Logger logger = Logger.getLogger(MissingTransactionProcessor.class);

	@Override
	protected void executeProcess() {
		
		logger.info("need to do missing transaction process");

	}

	@Override
	protected String getUtilityName() {
		return "Missing Transaction";
	}

}
