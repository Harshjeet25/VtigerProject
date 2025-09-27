package com.Actitime.GenericLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public String getDateandTime(String pattern) {
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value = sdf.format(date);
		return value;
		
		
	}
	
	public int getRandom(int num) {
		Random r = new Random();
		int value = r.nextInt();
		return value;
		
		
		
	}
	
	

}
