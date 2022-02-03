package com.skillnet.dataservice;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;

public class ProcessorController {

	private static Logger logger = Logger.getLogger(ProcessorController.class);

	public static void main(String[] args) {

		Class<ProcessorController> clazz = ProcessorController.class;
		String className = clazz.getSimpleName() + ".class";
		String classPath = clazz.getResource(className).toString();
		String version = "";
		String buildDate = "";
		if (classPath.startsWith("jar")) {

			String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
			Manifest manifest = null;
			try {
				manifest = new Manifest(new URL(manifestPath).openStream());
				Attributes attr = manifest.getMainAttributes();
				version = attr.getValue("Manifest-Version");
				buildDate = attr.getValue("Build-Timestamp");
			} catch (Exception e) {
				logger.error("Unable to get utility version info.");
			}
		}

		logger.info("######################################################################################");
		logger.info("#\t\t\t\t\tData_service Utility\t\t\t\t\t\t#");
		logger.info("#\t\t\tSkillNet  Tool\t\t\t\t#");
		logger.info("#\t\t\tVersion:" + version + "   Build Date:" + buildDate + "\t\t\t#");
		logger.info("######################################################################################");

		if (args == null || args.length != 1) {
			System.out.println("Arguments need to be provided: ");
			System.out.println("ProcessExecutor [Process Class Name]");
			System.out.println("where arguments are");
			System.out.println("   -Fully qualified process class name");

			logger.error("Arguments need to be provided: ");
			logger.error("ProcessExecutor [Process Class Name]");
			logger.error("where arguments are");
			logger.error("   -Fully qualified process class name");

			System.exit(0);
		}

		String classNameArg = args[0];

		logger.info("Processor Class: " + classNameArg);

		Class<AbstractProcessor> processorClass = null;

		try {
			processorClass = (Class<AbstractProcessor>) Class.forName(classNameArg);
		
			Constructor<AbstractProcessor> constructor = processorClass.getConstructor();

			AbstractProcessor processor = constructor.newInstance();

		} catch (Exception e) {
			System.out.println("ERROR - Invalid  Processor class name");
			logger.error("ERROR - Invalid  Processor class name", e);
			System.exit(0);
		}

	}

}
