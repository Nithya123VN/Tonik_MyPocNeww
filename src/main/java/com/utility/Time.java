package com.utility;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import com.helger.css.parser.ParseException;

public class Time{

	public static String formattedDate;

	public static void main(String[] args) {
		
		 ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC).plusHours(8);
	     System.out.println(utc.format(DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm:ss")));
	     return;
	}
		/*LocalDateTime myDateObj = LocalDateTime.now(ZoneId.of("UTC+08:00"));
		System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM YYYY");
		formattedDate= myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);
		ZoneId zone = ZoneId.of("UTC+08:00");
		ZonedDateTime zdt = myDateObj.atZone(zone);
		Instant instant = zdt.toInstant();
		instant.toString();
		return;*/
}