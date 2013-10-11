/**
 * 
 */
package serialization;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author dmaldonado
 *
 */
public class Exercise6 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		Exercise6 start = new Exercise6();
	}

	ArrayList<Contact> list;
	private ObjectOutputStream out;

	public Exercise6()
	{
		list = new ArrayList<>();
		FileReader file = null;
		try 
		{
			file = new FileReader("Contacts.csv");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		BufferedReader buff = new BufferedReader(file);

		String line = "";
		try 
		{
			out = new ObjectOutputStream(new FileOutputStream("serialize.txt"));
			while(buff.ready())
			{
				line = buff.readLine();
				String[] contact = line.split(",");
				Contact c = new Contact(contact[0],contact[1],contact[2],contact[3]);
				list.add(c);
				out.writeObject(c);
			}
			out.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("serialize.txt")))
		{
			try 
			{
				while(true)
				{
					Object obj = null;
					obj = in.readObject();
					if(obj instanceof Contact)
					{	
						Object object = (Contact)obj;
						System.out.println(object);
					}
				}
			} 
			catch (EOFException e) 
			{
				System.out.println("End of file");
			}
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}