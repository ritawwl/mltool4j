package edu.thu.mltool4j.utils;

import org.apache.log4j.Logger;

public class ErrorReport
{
	private static Logger logger = Logger
			.getLogger(ErrorReport.class.getName());

	public static void showMessage(Object errobj, String methodName)
	{
		logger.error("Error in class: " + errobj.getClass().getName()
				+ "\t Method: " + methodName);
	}

	public static void showMessage(Object errobj, String methodName,
			String addition)
	{
		logger.error("ERROR IN CLASS: " + errobj.getClass().getName()
				+ "\t METHOD: " + methodName + "\tADDITION: " + addition);
	}
}
