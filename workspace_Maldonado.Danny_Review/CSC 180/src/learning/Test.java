/*package learning;

import java.util.HashMap;
import java.util.TreeSet;

public class Test 
{

	@SuppressWarnings("serial")
	public class MashMap<K, V> extends HashMap<K,V>
	{

	}

	public class Contact() implements Comparable
	{
		public String name;
		public String email;

		public Contact(String name, String email)
		{
			this.name = name;
			this.email = email;
		}

		public String getNameEmail()
		{
			return name + email; 
		}

		@Override
		public int compareTo(Contact c)
		{
			return this.name.compareTo(c.name);
		}
	}


	/**
	 * @param args
	 */
/*	public static void main(String[] args) 
	{
		//do the monster mash
		// we did the mash
		MashMap<String, Integer> map = new MashMap<>();
		Contact c1 = new Contact("Joe", "joe@myhouse.com");
		Contact c2 = new Contact("Sally", "sally@joeshouse.org");
		Contact c3 = new Contact("Kate", "Kat4e@joeshouse.org");

		map.put(c1.getNameEmail(), c1);
		map.put(c2.getNameEmail(), c2);
		System.out.println(c1.getNameEmail().hashcode());
		System.out.println(c2.getNameEmail().hashcode());

		TreeSet<Contact> tree = new TreeSet<>();
		tree.add(c1);
		tree.add(c2);
		tree.add(c3);
		
		for(Contact c : tree)
		{
			System.out.println(c.name);
		}
	}
}*/