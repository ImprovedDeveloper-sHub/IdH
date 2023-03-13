package com.sbs.IdH.command;

import java.util.Calendar;
import java.util.Date;

public class DateMaker {

	
	public static Date make(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
	   	cal.set(year, month-1, day);
		return new Date(cal.getTimeInMillis());
	}
}
