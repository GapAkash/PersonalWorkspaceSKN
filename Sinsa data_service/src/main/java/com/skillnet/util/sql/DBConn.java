package com.skillnet.util.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.skillnet.util.PropertiesUtil;
import com.skillnet.util.UtilConstants;
import com.skillnet.util.encrypt.KeyEncrypter;

public class DBConn implements UtilConstants {

	private static Logger logger = Logger.getLogger(DBConn.class);
	
	private static DBConn object = null;

	//prevent instantiation 
	private DBConn() {
	}

	public static DBConn getInstance() {

		if (object == null) {
			
			object = new DBConn();
		}

		return object;

	}
	
	

	public static Connection createConnection(String storeId, String regId) {

		Connection conn = null;
		try {
			Properties prop = PropertiesUtil.getInstance().getProperties(storeId);
			String url = "jdbc:oracle:thin:@//" + prop.get(regId + DATABASE_IP) + ":" + prop.get(regId + DATABASE_PORT)
					+ "/" + prop.get(regId + DATABASE_SID);

			logger.info(
					"Trying to connect to URL " + url.toString() + ":" + prop.get(regId + DATABASE_USERID).toString());
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, prop.get(regId + DATABASE_USERID).toString(),
					KeyEncrypter.getInstance().decrypt(prop.get(regId + DATABASE_PASSWORD).toString()));

		} catch (Exception e) {
			logger.error("error", e);
		}

		return conn;
	}

}
