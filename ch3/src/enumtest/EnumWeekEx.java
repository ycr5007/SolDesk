package enumtest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EnumWeekEx {
	public static void main(String[] args) {
		Week today = null;
		
		LocalDate now = LocalDate.now();
		/*
			Obtains the current date from the system clock in the default time-zone.
		*/
		System.out.println(now);

		DayOfWeek week = now.getDayOfWeek();
		// 요일에 따라서 숫자를 리턴 ( 1(월) ~ 7(일) )
		System.out.println(week.getValue());
		
		switch (week.getValue()) {
		case 1 :
			today = Week.MONDAY;
			break;
		case 2 :
			today = Week.TUESDAY;
			break;
		case 3 :
			today = Week.WEDNESDAY;
			break;
		case 4 :
			today = Week.THURSDAY;
			break;
		case 5 :
			today = Week.FRIDAY;
			break;
		case 6 :
			today = Week.SATURDAY;
			break;
		case 7 :
			today = Week.SUNDAY;
			break;
		default:
			break;
		}
		System.out.println(now + " 의 요일은 " + today  + "입니다.");
	}
}
