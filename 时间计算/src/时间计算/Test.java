package 时间计算;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println("now:" + now);
		SimpleDateFormat df = new SimpleDateFormat();
		String dateStr = df.format(now);
		System.out.println(dateStr);
		String dateStr2 = "2000-10-4";
		Date btd = null;
		try {
			btd = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(btd);
		calendar.add(Calendar.DAY_OF_YEAR, 20000);
		Date date2 = calendar.getTime();
		System.out.println(date2);
		System.out.println(df.format(date2));
		
		
//		LocalDate now = LocalDate.now();
//		System.out.println("now" + now);
//		LocalDate btd = LocalDate.parse("1976-11-28");
//		System.out.println(btd);
//		//加减运算
//		LocalDate lwbtd = btd.plusDays(20000);
//		System.out.println(lwbtd);
//		//比较运算
//		LocalDate begin = LocalDate.of(1976, 11, 28);
//		LocalDate end = LocalDate.of(2000, 11, 20);
//		long a = begin.until(end, ChronoUnit.DAYS);
//		System.out.println(a);

	}
}
