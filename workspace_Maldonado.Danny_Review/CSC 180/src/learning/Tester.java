package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tester
{
	public static class CompareContactName implements Comparator<Contact>
	{
		@Override
		public int compare(Contact c1, Contact c2)
		{
			if(c1 == null || c2 == null || c1.getClass() != c2.getClass())
			{
				return -1;
			}

			return c1.name.compareTo(c2.name);
		}

	}

	public static class Contact implements Comparable<Contact>
	{
		public String name;
		public int age;
		private int id;
		private static int counter = 8;

		public Contact(String name, int age)
		{
			this.name = name;
			this.age = age;
			id = ++counter;

		}

		@Override
		public int hashCode()
		{
			return id;
		}

		@Override
		public int compareTo(Contact obj)
		{
			// 0 = this object is equal to obj
			// > 0 = this object is greater than obj
			// < 0 = this object is less than obj
			return age - obj.age;
		}

	}


	public static void main(String[] args)
	{
		ArrayList<Contact> tree = new ArrayList<>();
		Contact c1 = new Contact("Bob", 17);
		Contact c2 = new Contact("Suzy", 89);
		Contact c3 = new Contact("Janifar", 1002);
		Contact c4 = new Contact("Ashtinh", 23);
		tree.add(c1);
		tree.add(c2);
		tree.add(c3);
		tree.add(c4);

		Collections.sort(tree, new CompareContactName());

		for(Contact c : tree)
		{
			System.out.println(c.name);
			//System.out.println(c);
		}
	}

}