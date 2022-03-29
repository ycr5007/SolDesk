package api;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateEx1 {
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println("Date : " + date1); // Tue Mar 15 16:34:38 KST 2022
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
		/*
			SimpleDateFormat
				y : 연도
				M : 월
				d : 일
				h : 시
				m : 분
				s : 초
		*/
		
		System.out.println("SimpleDateFormat/Date : " + sdf.format(date1)); // 2022년 03월 15일 06:05:35
		
		LocalDate date2 = LocalDate.now();
		System.out.println("LocalDate : " + date2); // 2022-03-15

		LocalTime time1 = LocalTime.now();
		System.out.println("LocalTime : " + time1); // 16:44:02.703056100
		
		LocalDateTime date3 = LocalDateTime.now();
		System.out.println("LocalDateTime : " + date3); // 2022-03-15T16:42:39.731516800
		
		Calendar today = Calendar.	getInstance();
		System.out.print("올해 연도 : " + today.get(Calendar.YEAR) + "\t"); // 2022
		System.out.print("월(0 ~ 11월) : " + today.get(Calendar.MONTH) + "\t"); // 2 ( 0 ~ 11 )
		System.out.print("이 달의 몇째 주 : " + today.get(Calendar.WEEK_OF_MONTH) + "\t"); // 3 
		System.out.println("현재 시간 : " + today.get(Calendar.HOUR) + "\t"); // 4
		
	}
}
