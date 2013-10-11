package fileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class File {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		FileReader input = new FileReader("test.txt");
		BufferedReader reader = new BufferedReader(input);
		
		String line = "";
		while(reader.ready())
		{
			line = reader.readLine(); 
			//System.out.println(line);
//			ArrayList <String> list = new ArrayList<String>(2);
//			list.add("asdfs");
//			list.add("343");
//			list.add("stuff");
//			//System.out.println(list);
//			
//			ArrayList <String> dynamic = new ArrayList<String>();
//			dynamic.add("asdfs");
//			dynamic.add("343");
//			dynamic.add("stuff");
//			dynamic.add(line);
//			
//			for(int counter = 0; counter <dynamic.size(); counter++)
//			{
//				String s = dynamic.get(counter);
//				dynamic.remove(counter);
//			}
			System.out.println(line);
			//System.out.println(line.charAt(1));
			System.out.println(line.contains("001"));
			System.out.println(line.indexOf("001"));
			System.out.println(line.endsWith(".png"));
			System.out.println(line.lastIndexOf("801"));
			line.length();
			line.isEmpty();
			//line.matches(regex);
		}
		reader.close();
	}
}