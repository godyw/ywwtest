import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println("now:" + now);
		SimpleDateFormat df = new SimpleDateFormat();
		String str = df.format(now);
		System.out.println(str);
	}
	
	
}
