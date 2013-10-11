package chess.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChessServer {
	public void createServer() {
		
		try(ServerSocket s = new ServerSocket(12345)) {
			System.out.println("Listening for connection");
			Socket newSocket = s.accept();
			System.out.println("Connection found: " + newSocket.getInetAddress());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ChessServer servar = new ChessServer();
		System.out.println("Creating server");
		servar.createServer();
	}
}
