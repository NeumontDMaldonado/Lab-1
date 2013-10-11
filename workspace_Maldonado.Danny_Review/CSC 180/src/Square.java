public class Square extends Shape 
{
	private double side;
	
	public double getSide() 
	{
		return side;
	}

	public void setSide(double side) 
	{
		this.side = side;
	}

	public Square(double side)
	{
		this.side = side;
	}
	
	@Override
	public double computeArea() 
	{
		//return super.computeArea();
		area = side *side;
		return area;
	}
}