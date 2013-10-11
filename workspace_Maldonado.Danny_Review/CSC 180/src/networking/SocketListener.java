/**
 * 
 */
package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author dmaldonado
 *
 */
public class SocketListener implements Runnable
{
	private Socket socket;
	private boolean bounce;
	
	public SocketListener(Socket socket, boolean bounce)
	{
		this.socket = socket;
		this.bounce = bounce;
	}
	
	@Override
	public void run()
	{
		//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try
		{
			in = new ObjectInputStream(socket.getInputStream());
			
			if(bounce == true)
			{
				out = new ObjectOutputStream(socket.getOutputStream());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		while(Thread.currentThread().isInterrupted() == false)
		{
			try
			{
				Object obj = in.readObject();
				DataPacket data = null;
				
				if(obj instanceof DataPacket)
				{
					data = (DataPacket)obj;
					
					if(data.getData() == null)
					{
						Thread.currentThread().interrupt();
						break;
					}
					
					System.out.println(socket.getInetAddress() + ": " + data.getData());
				}
				
				// send the message back
				if(out != null)
				{
					out.writeObject(new DataPacket("Bounce: " + data.getData()));
				}
			}
			catch(IOException | ClassNotFoundException e)
			{
				// no data received
			}
		}
		
		try
		{
			in.close();
			if(out != null)
			{
				out.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
