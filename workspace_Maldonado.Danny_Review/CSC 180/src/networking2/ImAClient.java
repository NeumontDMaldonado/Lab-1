package networking2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ImAClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try {
			Socket client = new Socket("localhost", 1234);
			
			//BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			
			String line = null;
			while(line == null)
			{	
				line = (String) in.readObject();
				//line = in.readLine();
			}
			System.out.println("Message from the server: "+ line);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
