/**
 * 
 */
package networking2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author dmaldonado
 *
 */
public class NetworkTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try {
			//port 1234
			ServerSocket listen = new ServerSocket(1234);
			System.out.println("Listening...");
			Socket server = listen.accept();
			System.out.println("Connected to: " + server.getInetAddress());
			
//			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
			ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
//			out.writeObject("You are connected");
			out.writeObject("1 1");
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		To be server or client
//		Socket socket = null;
//		if(args[0].equals("1"))
//		{
//			ServerSocket listen = null;
//			try {
//				listen = new ServerSocket(1234);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				socket = listen.accept();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		else if(args[0].equals("2"))
//		{
//			try {
//				socket = new Socket("localhost", 1234);
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
	}

}
