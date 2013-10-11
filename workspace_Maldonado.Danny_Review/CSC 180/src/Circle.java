public class Circle extends Shape
{
	double radius;
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	@Override
	public double computeArea() 
	{
		area = Math.PI * radius * radius;
		return area;
	}
}