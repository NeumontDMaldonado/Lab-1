package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Startup 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//date formatting
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		String dateToday = df.format(date);
		System.out.println(dateToday);
		
		String data = "Test this 4/22/13 and more stuff.";//"Some numbers 123 and more numbers 456";
		
		//create regular expression to match pattern DD/MM/YY
		Pattern pattern = Pattern.compile("\\d(1,2)/\\d(1,2)/\\d(1,2)");
		// \d find a digit 0-9
		// \w find a character a-z
		// + one or more
		// * zero or more
		// ? once or more
		Matcher matcher = pattern.matcher(data);
		
		while(matcher.find())
		{
			//display month
			System.out.println("Match: " +matcher.group(2));
		}
//		System.out.println(dateToday);
//		
//		DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
//		System.out.println(df2.format(date));
//		
//		Calendar cal = new GregorianCalendar();
//		cal.setTime(date);
//		cal.set(Calendar.MONTH, 8);
//		cal.set(Calendar.DATE, 29);
//		cal.set(Calendar.YEAR, 2050);
//		
//		//cal.set(Calendar.DATE, 20);
//		
//		System.out.println(df.format(cal.getTime()));
	}
// \.[A-Z]{2,4} = .letters, but only between 2-4
// 
}