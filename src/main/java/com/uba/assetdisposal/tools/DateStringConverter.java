package com.uba.assetdisposal.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateStringConverter {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static Date stringToDate(String date) throws ParseException {
		return simpleDateFormat.parse(date);
	}
	
	public static LocalDate stringToLocalDate(String date) throws ParseException {
		return LocalDate.parse( date, formatter);
	}
	
	public static String dateToString(Date date) {
		return simpleDateFormat.format(new Date());
	}

}
