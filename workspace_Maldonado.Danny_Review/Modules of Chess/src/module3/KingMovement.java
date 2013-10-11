/**
 * 
 */
package module3;

import module2.KingPlacer;
import module2.KingPlacer.WhiteKing;
import module2.PaintBoardPanel;
import module2.KingPlacer.BlackKing;

/**
 * @author dmaldonado
 *
 */
public class KingMovement 
{
	String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	KingPlacer kingPlacer;
	private String invalid = "invalid king movement";
	
	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param king
	 * constructor
	 */
	public KingMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, KingPlacer king)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		kingPlacer = king;
	}


	/**
	 * check if king movement is valid and executes
	 */
	public void checkKingMovement()
	{
		int currentYLocation = 0, currentXLocation = 0;
		int intNewYLocation = (newYLocation.charAt(0)-'0');
		int king = Integer.parseInt(pieceNr)-1;

		int intNewXLocation = 0;
		switch (newXLocation)
		{
		case "a": intNewXLocation = 8;
		break;
		case "b": intNewXLocation = 7;
		break;
		case "c": intNewXLocation = 6;
		break;
		case "d": intNewXLocation = 5;
		break;
		case "e": intNewXLocation = 4;
		break;
		case "f": intNewXLocation = 3;
		break;
		case "g": intNewXLocation = 2;
		break;
		case "h": intNewXLocation = 1;
		break;
		}

		if(pieceColor.equals("d"))
		{
			BlackKing bk = kingPlacer.blackList.get(king);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (bk.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bk.y/120);

			if(currentXLocation == intNewXLocation)
			{
				if(currentYLocation - intNewYLocation == 1)
				{
					bk.y +=120;
					InformationParser.setColor("l");
				}
				else if(intNewYLocation - currentYLocation == 1)
				{
					bk.y -=120;
					InformationParser.setColor("l");
				}
				else
				{
					System.err.println(invalid);
				}
			}

			else if(currentYLocation == intNewYLocation)
			{
				if(currentXLocation - intNewXLocation == 1)
				{
					bk.x +=120;
					InformationParser.setColor("l");
				}
				else if(intNewXLocation - currentXLocation == 1)
				{
					bk.x -=120;
					InformationParser.setColor("l");
				}
				else
				{
					System.err.println(invalid);
				}
			}

			else if(intNewYLocation - currentYLocation == 1)
			{
				bk.y -= 120;
				if(currentXLocation-intNewXLocation == 1)
				{
					bk.x += 120;
					InformationParser.setColor("l");
				}
				
				else if(intNewXLocation - currentXLocation == 1)
				{
					bk.x -=120;
					InformationParser.setColor("l");
				}
				else
				{
					System.err.println(invalid);
				}
			}

			else if(currentYLocation - intNewYLocation == 1)
			{
				bk.y += 120;
				if(intNewXLocation - currentXLocation == 1)
				{
					bk.x -= 120;
					InformationParser.setColor("l");
				}
				
				else if(currentXLocation - intNewXLocation ==1)
				{
					bk.x += 120;
					InformationParser.setColor("l");
				}
				else
				{
					System.err.println(invalid);
				}
			}
			else
			{
				System.err.println(invalid);
			}
		}

		else if(pieceColor.equals("l"))
		{
			WhiteKing wk = kingPlacer.whiteList.get(king);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (wk.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wk.y/120);
			
			if(currentXLocation == intNewXLocation)
			{
				if(currentYLocation - intNewYLocation == 1)
				{
					wk.y +=120;
					InformationParser.setColor("d");
				}
				else if(intNewYLocation - currentYLocation == 1)
				{
					wk.y -=120;
					InformationParser.setColor("d");
				}
				else
				{
					System.err.println(invalid);
				}
			}

			else if(currentYLocation == intNewYLocation)
			{
				if(currentXLocation - intNewXLocation == 1)
				{
					wk.x +=120;
					InformationParser.setColor("d");
				}
				else if(intNewXLocation - currentXLocation == 1)
				{
					wk.x -=120;
					InformationParser.setColor("d");
				}
				else
				{
					System.err.println(invalid);
				}
			}

			else if(intNewYLocation - currentYLocation == 1)
			{
				wk.y -= 120;
				if(currentXLocation-intNewXLocation == 1)
				{
					wk.x += 120;
					InformationParser.setColor("d");
				}
				
				else if(intNewXLocation - currentXLocation == 1)
				{
					wk.x -=120;
					InformationParser.setColor("d");
				}
				else
				{
					System.err.println(invalid);
				}
			}

			else if(currentYLocation - intNewYLocation == 1)
			{
				wk.y += 120;
				if(intNewXLocation - currentXLocation == 1)
				{
					wk.x -= 120;
					InformationParser.setColor("d");
				}
				
				else if(currentXLocation - intNewXLocation ==1)
				{
					wk.x += 120;
					InformationParser.setColor("d");
				}
				else
				{
					System.err.println(invalid);
				}
			}
			else
			{
				System.err.println(invalid);
			}
		}
		else
		{
			System.err.println("Not a valid move");
		}
	}
}