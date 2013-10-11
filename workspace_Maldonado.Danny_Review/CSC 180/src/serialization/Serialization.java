package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization
{
	public static class SerializableObject implements Serializable
	{
		private static final long serialVersionUID = 4039562927858493789L;

		public String data;
		public int doWrite = 10;
		public transient int dontWrite = 7;
		public transient NonSerializableObject obj;

		public SerializableObject()
		{
			System.out.println("Call constructor (default)!");
		}

		public SerializableObject(String data)
		{
			this.data = data;
			obj = new NonSerializableObject();
			System.out.println("Call constructor (params)!");
		}
	}
	//@Override
	//public void readExternal(ObjectInput in) throws IOException,
	//ClassNotFoundException
	//{
	//data = (String)in.readObject();
	////dontWrite = in.readInt();
	//}
	//
	//@Override
	//public void writeExternal(ObjectOutput out) throws IOException
	//{
	//// do write, is serializable
	//out.writeObject(data);
	////out.writeInt(dontWrite);
	//}




	public static class NonSerializableObject
	{

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Write the object to file.
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serialize.txt")))
		{
			out.writeObject(new SerializableObject("something here!"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Read the object from file.
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("serialize.txt")))
		{
			Object obj = in.readObject();
			if(obj instanceof SerializableObject)
			{
				SerializableObject serialObj = (SerializableObject)obj;
				System.out.println("Data: " + serialObj.data);
				System.out.println("Do write: " + serialObj.doWrite);
				System.out.println("Don't write: " + serialObj.dontWrite);
			}
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
