package secondDay;

public class Main 
{
	public static void doSomething() 
	{
		
	}
	
	public static void doSomethingElse() 
	{
		
	}
	
	public static void doSomethingAgain() 
	{
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Hello World");
		Main.doSomething();
		Main.doSomethingAgain();
		Main.doSomethingElse();
		Tree tree = new Tree();
		Plant plant = new Tree();
		tree.setLeaves("green");
		System.out.println(tree.getLeaves());
		plant.setLeaves("blue");
		System.out.println(plant.getLeaves());
		PineTree pine = new PineTree();
		pine.setLeaves("red");
		System.out.println(pine.getLeaves());
		System.out.println(pine.toString());
	}
}
