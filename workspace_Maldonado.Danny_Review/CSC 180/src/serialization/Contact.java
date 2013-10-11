package serialization;

import java.io.Serializable;

public class Contact implements Serializable
{
	private static final long serialVersionUID = 4039562927858493789L;
	private String name;
	private String phoneNr;
	private String email;
	private String birthDate;

	public Contact(String name, String phoneNr, String email, String birthDate) 
	{
		this.name = name;
		this.phoneNr = phoneNr;
		this.email = email;
		this.birthDate = birthDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
