/**
 * 
 */
package module3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import module2.PaintBoardPanel;

/**
 * @author dmaldonado
 *
 */
public class InformationParser
{
	private PaintBoardPanel panel;
	static final String PIECEMOVEMENT = "\\b([a-z])([1-8])([ld])[ ]([a-h])([1-8])(\\*?)";
	public String line = null;
	private int sleep = 1000;
	private static String color = "l";

	/**
	 * @param args
	 * @param panel
	 */
	public InformationParser(String args, PaintBoardPanel panel)
	{
		FileReader chessFile = null;
		try 
		{
			chessFile = new FileReader(args);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("No file found");
		}
		BufferedReader buff = new BufferedReader(chessFile);
		this.panel = panel;
		read(buff);
	}

	/**
	 * @return the color
	 */
	public static String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public static void setColor(String color) 
	{
		InformationParser.color = color;
	}

	/**
	 * @param buff
	 * reads the file and feeds the line to the right method to check if it the piece is moving in a valid manner
	 * the line is parsed so that the line's info is given to the methods is parsed
	 */
	public void read(BufferedReader buff) 
	{
		try
		{
			while(buff.ready())
			{
				line = buff.readLine();
				Pattern pieceMovement = Pattern.compile(PIECEMOVEMENT);
				Matcher movement = pieceMovement.matcher(line);
				
				System.out.println("hi");
				String pieceNr = movement.group(2); //TODO fix movement
				String pieceColor = movement.group(3);
				String newXLocation = movement.group(4);
				String newYLocation = movement.group(5);
				String capture = movement.group(6);
				if(movement.find())
				{
					if(getColor().equals(pieceColor))
					{
						if(movement.group(1).equals("p"))
						{
							PawnMovement move = new PawnMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, panel.pawnPlacer);
							move.checkPawnMove();
							panel.repaint();
							try 
							{
								Thread.sleep(sleep);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						}
						else if(movement.group(1).equals("r"))
						{
							RookMovement move = new RookMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, panel.rookPlacer);
							move.checkRookMove();
							panel.repaint();
							try 
							{
								Thread.sleep(sleep);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						}
						else if(movement.group(1).equals("k"))
						{
							KingMovement move = new KingMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, panel.kingPlacer);
							move.checkKingMovement();
							panel.repaint();
							try 
							{
								Thread.sleep(sleep);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						}
						else if(movement.group(1).equals("n"))
						{
							KnightMovement move = new KnightMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, panel.knightPlacer);
							move.checkKnightMovement();
							panel.repaint();
							try 
							{
								Thread.sleep(sleep);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						}
						else if(movement.group(1).equals("b"))
						{
							BishopMovement move = new BishopMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, panel.bishopPlacer);
							move.checkBishopMove();
							panel.repaint();
							try 
							{
								Thread.sleep(sleep);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						}
						else if(movement.group(1).equals("q"))
						{
							QueenMovement move = new QueenMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, panel.queenPlacer);
							move.checkRookMove();
							panel.repaint();
							try 
							{
								Thread.sleep(sleep);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						}
					}
					else
					{
						System.err.println("Invalid move");
					}
				}
			}
		}
		catch (IOException e)
		{
			System.err.println("IO exception happened");
		}
	}

	/**
	 * signals the end of the file
	 */
	public void end()
	{
		System.out.println("There is no more information to parse");
	}
}