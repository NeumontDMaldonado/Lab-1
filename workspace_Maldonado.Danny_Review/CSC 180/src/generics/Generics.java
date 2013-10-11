package generics;

public class Generics 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Operations op = new Operations();

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		System.out.println(java.util.Arrays.toString(intArray));

		op.swap(intArray, 1, 3);

		System.out.println(java.util.Arrays.toString(intArray));

		op.reverse(intArray);

		System.out.println(java.util.Arrays.toString(intArray));

		Integer[] subArray = op.subset(intArray, 2, 3);

		System.out.println(java.util.Arrays.toString(subArray));
	}
}