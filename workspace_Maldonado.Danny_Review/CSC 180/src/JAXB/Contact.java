package JAXB;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class Contact implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String birthDate;
	private String phoneNumber;
	
	public Contact()
	{
	}
			
	public Contact(String name, String email, String birthDate, String phoneNumber)
	{
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getBirthDate()
	{
		return birthDate;
	}
	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}

