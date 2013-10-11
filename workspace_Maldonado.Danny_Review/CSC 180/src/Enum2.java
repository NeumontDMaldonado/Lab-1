
public class Enum2 
{
	private static String var;

	
	public enum AmberAlert
	{
		Green, //0
		Yellow,//1
		RED,   //2
		BLACK; //3
	}
	public enum GameState
	{
		STARTED(5),
		STOPPED(2),
		RUNNING(7),
		LOADING(10);

		
		private GameState(int val)
		{
			doWork(val);
			var = "hello";
			System.out.println(var);
		}

		public void doWork(int num)
		{
			System.out.println(num);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		GameState state = GameState.LOADING;
		System.out.println(state);
//		System.out.println("after");
//		//GameState state2 = GameState.RUNNING;
////		if(state == GameState.LOADING)
////		{
////			System.out.println(var);
////		}
//		
//		for(GameState state : GameState.values())
//		{
//			System.out.println(state);
//		}
//		
//		for(int counter = 0; counter < GameState.values().length; counter++)
//		{
//			
//		}
	}
}