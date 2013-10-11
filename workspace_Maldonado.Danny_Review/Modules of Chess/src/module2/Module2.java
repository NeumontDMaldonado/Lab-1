/**
 * 
 */
package module2;

import module1.InformationReader;

/**
 * @author dmaldonado
 *
 */
public class Module2 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		InformationReader fileReading = null;
		try 
		{
			fileReading = new InformationReader("InitialChessPlacement.txt");
		} 
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.err.println("");
		}
		catch (NullPointerException e)
		{
			System.err.println("Null pointer");
		}
		ChessBoard board = new ChessBoard();
		board.BoardExplanation();
		fileReading.displayBoard();
		System.out.println();
		fileReading.end();
	}

}
