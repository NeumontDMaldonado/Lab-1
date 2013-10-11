
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Shape [] shapes = new Shape[3];
		shapes[0] = new Circle(3d);
		shapes[1] = new Square(1d);
		shapes[2] = new Square(5d); //the d is short for double. 5d = 5.0
		
		//for-each
		for(Shape/*class*/shape/*variable*/: shapes/*array*/)
		{
			double area = shape.computeArea();
			System.out.println(area);
		}
	}
}