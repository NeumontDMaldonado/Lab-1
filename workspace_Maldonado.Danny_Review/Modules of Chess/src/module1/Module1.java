/**
 * 
 */
package module1;

/**
 * @author dmaldonado
 * This program takes a file from the command line, reads it, and deciphers the chess notation
 */
public class Module1 
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) 
	{
		InformationReader readingInfoFromFile = new InformationReader(args[0]);
		readingInfoFromFile.end();
	}
}