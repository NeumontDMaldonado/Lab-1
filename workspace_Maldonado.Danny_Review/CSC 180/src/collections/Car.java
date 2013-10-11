package collections;

import java.util.ArrayList;
import java.util.Collections;

public class Car implements Comparable
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Car car1 = new Car(3);
		Car car2 = new Car(2);
		Car car3 = new Car(3);
		
		ArrayList<Car> cars = new ArrayList();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		for (Car c : cars)
		{
			System.out.println(c.hashCode());
		}
		Collections.sort(cars);
		
		for(Car c : cars)
		{
			System.out.println(c.hashCode());
		}
	}

	final int vin;
	int mileage;
	protected int passengers;
	String color;
	String model;
	static int next;
	
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + vin;
		return result;
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		return true;
	}
	
	public Car(int passengers)
	{
		vin = next++;
		this.passengers = passengers;
	}
	
	@Override
	public int compareTo(Object arg0)
	{
		if(arg0 == null || arg0.getClass() != this.getClass())
		{
			return -1;
		}
		
		Car car = (Car)arg0;
		return mileage;	
	}
}