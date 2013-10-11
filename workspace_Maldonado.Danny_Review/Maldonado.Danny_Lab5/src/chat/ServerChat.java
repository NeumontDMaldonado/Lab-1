/**
 * 
 */
package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author dmaldonado
 *
 */
public class ServerChat 
{
	int counter = 0;
	Socket socket;
	//ServerSocket listen;

	public ServerChat(boolean serverYes)
	{
		if(serverYes)
		{
			try 
			{
				ServerSocket listen = new ServerSocket(1145);
				socket = listen.accept();
				System.out.println("Connected");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(serverYes==false)
		{
			try 
			{
				socket = new Socket("localhost",1145);
				System.out.println("Connnected to server");
				counter++;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void redirect() 
	{
		while(true)
		{
		if(counter%2 == 0)
		{
			sendChat();
		}
		else
		{
			recieveChat();
		}
		counter++;
		}
	}



	private void sendChat() 
	{
		try 
		{
			Scanner scan = new Scanner(System.in);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

			out.writeObject(scan.nextLine());
			Thread.sleep(1000);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}



	public void recieveChat()
	{
		try 
		{
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			String line = null;
			while(line == null)
			{
				line = (String) in.readObject();
			}
			System.out.println("Message from server: "+line);
			if(line.equalsIgnoreCase("end chat"))
			{
				endChat();
			}
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void endChat()
	{
		System.out.println("Goodbye");
	}
}
