package chat;

public class Server 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ServerChat server = new ServerChat(false);
		server.redirect();
	}
}