package fileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excercise3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception 
	{
		FileReader input = new FileReader("data.txt");
		BufferedReader buffer = new BufferedReader(input);

		Pattern address = Pattern.compile("(?:\\d+ [nsewNSEW]\\.? ){2}([\\w ]+), \\w{2} \\d{5}(?:-\\d{4})?");
		String addresses = "";
		while (buffer.ready())
		{
			String line = buffer.readLine();
			String line2 = buffer.readLine();
			SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yy"); //DD = day in year //YY = ? not what think
			Date firstDate = null; 
			try 
			{
				firstDate = simpleFormat.parse(line);
			} 
			catch (Exception e) 
			{
				simpleFormat.applyPattern("MM-dd-yyyy");
				try 
				{
					firstDate = simpleFormat.parse(line);
				} 
				catch (Exception e1) 
				{	
					System.err.println("Not a parsable date " + line);
				}
			}
			
			System.out.println(firstDate);
			
			Matcher matcher = address.matcher(line2);
			while(matcher.find())
			{
				System.out.println(matcher.group());
				addresses += matcher.group(1) + ", ";
			}
		}
		System.out.println(addresses);
		buffer.close();
	}
}