package JAXB;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class ContactList<T>
{
	@XmlElement(name="Contacts")
	public ArrayList<T> array;
	
	public ContactList()
	{
		array = new ArrayList<>();
	}
	
}

