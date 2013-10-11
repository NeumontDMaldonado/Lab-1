package exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ExceptionsRevisit 
{

	public static void main(String[] args) throws IOException
	{
		File file = new File("test.txt"); //".." current directory try with test.txt
		System.out.println(file.exists());
		file.isDirectory();
		file.isFile();
		
//		for(String path : file.list())
//		{
//			System.out.println(path);
//			if(path.contains(".txt") == true)
//			{
//				System.out.println(path);
//			}
//		}
		
//		System.out.println(file.getAbsoluteFile());
//		System.out.println(file.getCanonicalPath());
//		System.out.println(file.getPath());
//		System.out.println(file.getName());
		
		try 
		{
			FileReader input = new FileReader(file);
			BufferedReader buffer = new BufferedReader(input);
			
			
			String line = "";
			while(buffer.ready())
			{
				line = buffer.readLine();
				System.out.println(line);
			}
//			char[] line = new char[3];
//			input.read(line);
//			for(char c : line)
//			{
//				System.out.println(c);
//			}
			
//			int data = 0;
//			while(data !=-1)
//			{
//				data = input.read();
//				System.out.println(data);
//			}
			input.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
//		Scanner scan= new Scanner(System.in);
//		try(FileReader reader = new FileReader("test"))
//		{
//			
//		}
//		catch(Exception ex)
//		{
//			System.err.println("File not found");
//		}
//		try 
//		{
//			scan.nextInt();
//		} 
//		catch (InputMismatchException e) 
//		{
//			System.err.println(e.getMessage());
//			System.err.println("Not a number");
////		}
//		finally
//		{
//			scan.close();
//		}
//		try
//		{
//			for(int i = 0; i < 10; i++)
//			{
//				if (i == 0)
//				{
//					throwException();
//				}
//				if(i == 3)
//				{
//					Exception e = new Exception("Terrible 3!");
//					throw e;
//				}
//			}
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}

		try 
		{
			if(file.exists() == false)
			{
				file.createNewFile();
			}
			FileWriter output = new FileWriter(file/*, true*/);
			BufferedWriter buffer = new BufferedWriter(output);
			
			String line = "";
			buffer.write("Testing");
			//buffer.flush();
			buffer.close();
			output.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
//	public static void throwException() throws Exception
//	{
//		throw new Exception("");
//	}
}