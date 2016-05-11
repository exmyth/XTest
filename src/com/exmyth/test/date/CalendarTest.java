package com.exmyth.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalendarTest {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		/*
		String str = new String("2016-02-50");
		try {
			Date date = sdf.parse(str);
			String format = sdf.format(date);
			System.out.println(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		
		try {
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");   
			java.util.Date beginDate= format.parse("2007-02-40");   
			java.util.Date endDate= format.parse("2007-02-25");   
			long day=(beginDate.getTime()-endDate.getTime())/(24*60*60*1000);   
			System.out.println("相隔的天数="+day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
