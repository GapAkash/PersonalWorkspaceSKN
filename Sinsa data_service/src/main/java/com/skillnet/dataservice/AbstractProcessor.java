package com.skillnet.dataservice;

import org.apache.log4j.Logger;

public abstract class AbstractProcessor {

	private static Logger logger = Logger.getLogger(AbstractProcessor.class);

	public AbstractProcessor() {
		try {

			executeProcess();

		} catch (Exception e) {

			System.out.println("FATAL ERROR - Application terminated");
			logger.error("FATAL ERROR - Application terminated", e);
			e.printStackTrace();
		} finally {
			logger.info("Done running " + getUtilityName() + " utility");
		}
	}

	protected abstract void executeProcess();

	protected abstract String getUtilityName();

}
