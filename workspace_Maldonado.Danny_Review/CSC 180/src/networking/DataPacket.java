/**
 * 
 */
package networking;

import java.io.Serializable;

/**
 * @author dmaldonado
 *
 */
public class DataPacket  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String data;
	
	public DataPacket(String data)
	{
		if(data.isEmpty())
		{
			data = null;
		}
		
		this.data = data;
	}
	
	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}
}
