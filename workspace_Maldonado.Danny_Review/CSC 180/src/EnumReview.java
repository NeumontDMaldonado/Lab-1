import java.util.Scanner;

/**
 * @author dmaldonado
 *
 */
public class EnumReview 
{	
	public enum Input
	{
		ADDITION()
		{
			protected double calculate(double num, double num2)
			{
				return num+num2;
			}
		},
		SUBTRACTION()
		{
			protected double calculate(double num, double num2)
			{
				return num-num2;
			}
		},
		DIVISION()
		{
			protected double calculate(double num, double num2)
			{
				return num/num2;
			}
		},
		MULTIPLICATION()
		{
			protected double calculate(double num, double num2)
			{
				return num*num2;
			}
		};

		protected abstract double calculate(double num, double num2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double option2 = 0d;
		double option3 = 0d;
		
		System.out.println ("Enter first number");
		option2 = scan.nextDouble();
		System.out.println("invalid. please enter a valid number");
		option2 = scan.nextDouble();
		 
		System.out.print ("Enter next number");
		option3 = scan.nextDouble();
		
		System.out.print ("Enter wanted opperation: +, -, *, /");
		String option = scan.next();
		
		if(option.equals("+"))
		{
			Input in = Input.ADDITION;
			System.out.println(in.calculate(option2, option3));
		}
		
		else if(option.equals("-"))
		{
			Input in = Input.SUBTRACTION;
			System.out.println(in.calculate(option2, option3));
		}
		
		else if(option.equals("*"))
		{
			Input in = Input.MULTIPLICATION;
			System.out.println(in.calculate(option2, option3));
		}
		
		else if(option.equals("/"))
		{
			Input in = Input.DIVISION;
			System.out.println(in.calculate(option2, option3));
		}
		scan.close();
	}
}