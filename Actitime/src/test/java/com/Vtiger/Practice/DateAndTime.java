package com.Vtiger.Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class DateAndTime {
	
	@Test
	public void getData() {
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
//		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String value = sdf.format(date);
		System.out.println(value);
		
		
		
		
	}
	
	
	
	
	

}
