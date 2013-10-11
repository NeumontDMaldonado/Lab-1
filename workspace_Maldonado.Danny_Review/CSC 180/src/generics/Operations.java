package generics;

@SuppressWarnings("unchecked")
public class Operations
{
	protected <T> T[] subset(T[] intArray,int v1 ,int v2)
	{
		int length = v2 - v1 +1;
		int counter = 0;
		int num = v1;
		T[] array = (T[]) new Integer[length];
		boolean continues = true;
		while(continues)
		{
			array[counter] = intArray[num];
			if(num == v2)
			{
				continues = false;
			}
			num++;
			counter++;
		}
		return array;
	}

	protected <T> void reverse(T[] intArray) 
	{
		T[] array = (T[]) new Integer[intArray.length];
		int arrayCounter2 = intArray.length - 1;
		for(int arrayCounter1 = 0; arrayCounter1 < intArray.length; arrayCounter1++)
		{
			array[arrayCounter1] = (T) intArray[arrayCounter2];
			arrayCounter2--;
		}
		
		for(int counter = 0; counter < intArray.length; counter++)
		{
			intArray[counter] = array[counter];
		}
	}

	protected <T> void swap(T[] intArray, int v1, int v2)
	{
		T num = intArray[v1];

		intArray[(Integer) v1] = intArray[(Integer) v2];
		intArray[(Integer) v2] = num;
	}
}