package exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class ExceptionStuff 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		FileReader file = null;
		try 
		{
			file = new FileReader(new File("testfile.txt"));
			file.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("file not found");
		} 
		catch (IOException e) 
		{
			System.out.println("i/o exception");
		}
		finally // if put return in try, finally still works
		{
			System.out.println("I ran no matter what.");
			if(file !=null)
			{
				System.out.println("file has been closed");
			}
		}
	}

}
