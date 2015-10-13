package org.cx.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ClendarUtil {
	public static void main(String[] args) throws ParseException {
		Calendar c = Calendar.getInstance();
		
		SimpleDateFormat parse = new SimpleDateFormat("h:mm a",Locale.US);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date d = parse.parse("10:20 AM");
		
//		System.out.println(parse.format(new Date()));
		System.out.println(format.format(d));
		
	}
	
		
}
