package bookstore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月8日
 */

public class Test {

	public static String markName(){
		LocalDateTime now = LocalDateTime.now();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int minute = now.getMinute();
		int second = now.getSecond();
		int hour = now.getHour();
		String m = "";
		String d = "";
		String mi = "";
		String s = "";
		String h = "";
		if (month<10) {
			m = "0" + month;
		}else {
			m = month + "";
		}
		if (day < 10) {
			d = "0" + day;
		}else {
			d = day + "";
		}
		if (minute < 10) {
			mi = "0" + minute;
		}else {
			mi = "" + minute;
		}
		if (second < 10) {
			s = "0" + second;
		}else {
			s = "" + second;
		}
		if (hour < 10) {
			h = "0" + hour;
		}else {
			h = "" + hour;
		}
		Integer random = (int) (Math.random() * 90 + 10);
		return now.getYear()+m+d+h+mi+s+random.toString();
	}
	
}
