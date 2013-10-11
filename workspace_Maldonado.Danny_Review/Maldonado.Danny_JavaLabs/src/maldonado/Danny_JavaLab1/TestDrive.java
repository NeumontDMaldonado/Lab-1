/**
 * 
 */
package maldonado.Danny_JavaLab1;

import java.util.Scanner;

/**
 * @author dmaldonado
 *
 */
public class TestDrive 
{
	private static String wrong = "Invalid entry, please try again";
	public enum Vehicle
	{
		Car(30.6, 0), 
		Atv(10.4, 0), 
		Motorcycle(28.3,0), 
		Boat(27.1,0), 
		Ufo(1843749,0);

		protected int time; //hours elapsed
		protected double speed;//kilometer per hour

		private Vehicle(double speed,int time)
		{
			setSpeed(speed);
			setTime(time);
		}
		/**
		 * @return the speed
		 */
		protected double getSpeed() 
		{
			return speed;
		}

		/**
		 * @param speed the speed to set
		 */
		protected void setSpeed(double speed) 
		{
			this.speed = speed;
		}

		/**
		 * @return the time
		 */
		protected int getTime()
		{
			return time;
		}

		/**
		 * @param time the time to set
		 */
		protected void setTime(int time)
		{
			this.time = time;
		}

		public void travel()
		{
			setTime(time+1);
		}

		public double computeDistance()
		{
			return time*speed;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ask();
	}
	private static void ask()
	{
		System.out.println("Please enter preffered mode of transport: Car, Atv, Motorbike, Boat, Ufo");
		System.out.println("Note, must be capital");
		askVehicle();
	}

	private static void ask2()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to test another vehicle? Yes/No");
		System.out.println("Note, if responce is neither yes or no, the program will terminate.");
		String responce = "";
		try
		{
			responce = scan.nextLine();
		} 
		catch (Exception e)
		{
			System.err.println(wrong);
			ask2();
		}
		while(responce.equalsIgnoreCase("yes"))
		{
			ask();
			break;
		}
		scan.close();
	}

	private static void askVehicle()
	{
		Scanner scan = new Scanner(System.in);
		String responce = ""; 
		try
		{
			responce = scan.nextLine();
		} 
		catch (Exception e)
		{
			System.err.println(wrong);
			askVehicle();
		}
		while(responce.equals("CAR"))
		{
			car();
			break;
		}
		while(responce.equals("ATV"))
		{
			atv();
			break;
		}
		
		while(responce.equals("MOTORCYLE"))
		{
			bike();
			break;
		}
		
		while(responce.equals("BOAT"))
		{
			boat();
			break;
		}
		
		while(responce.equals("UFO"))
		{
			ufo();
			break;
		}
		
		while(!responce.equals("UFO") || !responce.equals("CAR") || !responce.equals("BOAT") || !responce.equals("MOTORCYCLE") || !responce.equals("ATV"))
		{
			System.err.println(wrong);
			ask();
		}
		ask2();
		scan.close();
	}
	
	private static void car()
	{
		double distance = 0d;
		Vehicle veh = Vehicle.Car;
		while(distance < 100.0)
		{
			veh.travel();
			distance = veh.computeDistance();
		}
		System.out.println("Car has traveled "+distance+" kilometers. Test drive complete.");
	}
	
	private static void atv()
	{
		double distance = 0d;
		Vehicle veh = Vehicle.Atv;
		while(distance < 100.0)
		{
			veh.travel();
			distance = veh.computeDistance();
		}
		System.out.println("Atv has traveled "+distance+" kilometers. Test drive complete.");
	}
	
	private static void bike()
	{
		double distance = 0d;
		Vehicle veh = Vehicle.Motorcycle;
		while(distance < 100.0)
		{
			veh.travel();
			distance = veh.computeDistance();
		}
		System.out.println("Motorcycle has traveled "+distance+" kilometers. Test drive complete.");
	}
	
	private static void boat()
	{
		double distance = 0d;
		Vehicle veh = Vehicle.Boat;
		while(distance < 100.0)
		{
			veh.travel();
			distance = veh.computeDistance();
		}
		System.out.println("Boat has traveled "+distance+" kilometers. Test drive complete.");
	}
	
	private static void ufo()
	{
		double distance = 0d;
		Vehicle veh = Vehicle.Ufo;
		while(distance < 100.0)
		{
			veh.travel();
			distance = veh.computeDistance();
		}
		System.out.println("UFO has traveled "+distance+" kilometers. Test drive complete.");
	}
}