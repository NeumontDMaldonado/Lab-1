package JAXB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXB 
{
	public static void main(String[] args)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Contact.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// Marshal
			Contact c = new Contact("John Doe", "john@doe.com", "01/01/12", "801-555-5555");
			m.marshal(c, new FileOutputStream("test.xml"));
			
			// Unmarshal
			Unmarshaller u = jc.createUnmarshaller();
			Contact c2 = (Contact)u.unmarshal(new FileInputStream("test.xml"));
			
			System.out.println(c2.getName());
			System.out.println(c2.getEmail());
		}
		catch (JAXBException | FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
