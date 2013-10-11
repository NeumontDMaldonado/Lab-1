/**
 * 
 */
package maldonado.Danny_Lab4;

import java.util.Scanner;

/**
 * @author dmaldonado
 *
 */
public class Elevator 
{
	public static Thread mainThread;
	public static Thread elevatorThread;
	static Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 */
	static int num = 0;
	public static void main(String[] args) 
	{
		System.out.println("This program takes a second to register multiple inputs for floors");
		Elevator.mainThread = new Thread(new FloorOptions());
		Elevator.elevatorThread = new Thread(new Queue());
		Elevator.mainThread.start();
		Elevator.elevatorThread.start();
	}

	public static class FloorOptions implements Runnable
	{
		@Override
		public void run() 
		{
			Thread.currentThread();
			System.out.println("What floor would you like to travel to?");
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("5");
			System.out.println("6");
			System.out.println("7");
			System.out.println("8");
			System.out.println("9");
			System.out.println("10");
			try 
			{
				elevatorThread.join();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static class Queue implements Runnable
	{
		static int currentFloor = 1;
		boolean chooseNewFloor = false;
		boolean movingUp = false;
		int newFloor1 = 0;
		int newFloor2 = 0;
		int newFloor3 = 0;
		int newFloor4 = 0;
		int newFloor5 = 0;
		int newFloor6 = 0;
		int newFloor7 = 0;
		int newFloor8 = 0;
		int newFloor9 = 0;
		@SuppressWarnings({ "static-access" })
		@Override
		public void run() 
		{
			elevatorThread.currentThread();
			while(true)
			{
				if(chooseNewFloor == false)
				{
					System.out.println("Waiting for floor");
					try 
					{
						num = scan.nextInt();
						elevatorThread.sleep(3000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}

					if(num != 0)
					{
						chooseNewFloor = true;
						newFloor1 = 0;
					}

				}
				if(chooseNewFloor)
				{
					if(newFloor1 == 0)
					{
						if(num > 10 || num < 1)
						{
							Thread.currentThread();
							System.out.println("Not a valid floor");
							break;
						}	
						System.out.println("Moving to new floor...");
						try 
						{
							newFloor1 = num;
							elevatorThread.sleep(3000);
							if(num != newFloor1)
							{
								if(newFloor2 == 0)
								{
									newFloor2 = num;
								}
								else if(num != newFloor2)
								{
									newFloor3 = num;
								}
							}
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						System.out.println("You have arrived at floor " + newFloor1);
						chooseNewFloor = false;
						elevatorThread.run();
					}
					if(newFloor2 == num)
					{
						try 
						{
							newFloor1 = num;
							elevatorThread.sleep(3000);
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						System.out.println("You have arrived at floor " + newFloor2);
						newFloor2 = 0;
						if(newFloor1 == 0 || newFloor2 == 0 || newFloor3 == 0 || newFloor4 == 0 || newFloor5 == 0|| 
								newFloor6 == 0 || newFloor7 == 0 || newFloor8 == 0 || newFloor9 == 0)
						{
							chooseNewFloor = false;
							System.out.println("Hi");
						}
					}

					if(newFloor3 == num)
					{
						try 
						{
							elevatorThread.sleep(3000);
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						System.out.println("You have arrived at floor " + newFloor3);
						chooseNewFloor = false;
						newFloor3 = 0;
					}
				}
			}
		}

	}
}