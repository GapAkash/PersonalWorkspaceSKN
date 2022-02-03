package com.skillnet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.skillnet.util.encrypt.KeyEncrypter;

public class PropertiesUtil implements UtilConstants {
	
	
	private static PropertiesUtil object = null;
	
	//prevent instantiation 
	private PropertiesUtil() {
	}

	public static PropertiesUtil getInstance() {

		if (object == null) {
			
			object = new PropertiesUtil();
		}

		return object;

	}
	

	private static HashMap<String, Properties> propertiesMap = new HashMap<String, Properties>();

	public Properties getProperties(String propertyKey) throws FileNotFoundException, IOException {
		Properties selectedProperties = propertiesMap.get(propertyKey);

		if (selectedProperties == null) {

			StringBuilder resourceDir = new StringBuilder();
			resourceDir.append(RESOURCE_DIR).append(propertyKey).append(PROPERTIES_FILE_EXTENSION);

			selectedProperties = new Properties();

			selectedProperties.load(new FileInputStream(resourceDir.toString()));

			Set<Object> keySet = selectedProperties.keySet();
			boolean hasPasswordEncrypt = false;
			for (Object key : keySet) {
				String property = selectedProperties.getProperty((String) key);
				if (property.startsWith("!")) {
					String password = property.substring(1, property.length());
					password = KeyEncrypter.getInstance().encrypt(password);
					selectedProperties.setProperty(key.toString(), password);
					hasPasswordEncrypt = true;
				}
			}
			if (hasPasswordEncrypt) {
				selectedProperties.store(new FileOutputStream(resourceDir.toString()), "Password encrypted");
			}

			propertiesMap.put(propertyKey, selectedProperties);
		}

		return selectedProperties;
	}
}
