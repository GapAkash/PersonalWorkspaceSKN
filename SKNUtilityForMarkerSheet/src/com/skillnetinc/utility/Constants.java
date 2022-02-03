package com.skillnetinc.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface Constants {
	
	Calendar cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat monthFormat = new SimpleDateFormat("MMMM");
	DateFormat yearFormat = new SimpleDateFormat("yyyy");

	
	public static final String ANALYST_NAME = "";
	
	public static final String OFFLINE_COMMENT = "OfflineComment";
	
	public static final String COMMENT = "Comment";
	
	public static final String PRIORITY = "3";
	
	public static final String ASSIGNED_BY = "AskIt";
	
	public static final String ISSUE_TYPE ="AskIT Marker Files";
	
	public static final String CURRENT_DATE = dateFormat.format(cal.getTime());
	
	public static final String CURRENT_MONTH = monthFormat.format(cal.getTime());
	
	public static final String CURRENT_YEAR = yearFormat.format(cal.getTime());
	
}
