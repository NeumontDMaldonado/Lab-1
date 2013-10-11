/**
 * 
 */
package module3;

import module2.PaintBoardPanel;
import module2.QueenPlacer;
import module2.QueenPlacer.BlackQueen;
import module2.QueenPlacer.WhiteQueen;

/**
 * @author dmaldonado
 *
 */
public class QueenMovement 
{
	String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	QueenPlacer queenPlacer;
	private String invalid = "invalid rook movement";

	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param rook
	 * constructor
	 */
	public QueenMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, QueenPlacer queen)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		queenPlacer = queen;
	}

	/**
	 * checks to see if rook movement is valid and executes
	 */
	public void checkRookMove()
	{
		int currentYLocation = 0, currentXLocation = 0;
		int intNewYLocation = (newYLocation.charAt(0)-'0');
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

		int queen = Integer.parseInt(pieceNr)-1; //find rook reference for list

		if(pieceColor.equals("d"))
		{
			BlackQueen bq = queenPlacer.blackList.get(queen);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (bq.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bq.y/120);
			int num = 0;

			if(currentYLocation == intNewYLocation)
			{
				switch (intNewXLocation)
				{
				case 1: num = 7;
				break;
				case 2: num = 6;
				break;
				case 3: num = 5;
				break;
				case 4: num = 4;
				break;
				case 5: num = 3;
				break;
				case 6: num = 2;
				break;
				case 7: num = 1;
				break;
				case 8: num = 0;
				}
				bq.x = 120*num;
				InformationParser.setColor("l");
			}

			else if(currentXLocation == intNewXLocation)
			{
				switch (intNewYLocation)
				{
				case 1: num = 7;
				break;
				case 2: num = 6;
				break;
				case 3: num = 5;
				break;
				case 4: num = 4;
				break;
				case 5: num = 3;
				break;
				case 6: num = 2;
				break;
				case 7: num = 1;
				break;
				case 8: num = 0;
				}
				bq.y = 120*num;
				InformationParser.setColor("l");
			}
			
			else if(intNewXLocation < currentXLocation)//positive x movement
			{
				if(intNewYLocation > currentYLocation) //++
				{
					if((currentXLocation-intNewXLocation)/(intNewYLocation-currentYLocation) == 1)
					{
						num = currentXLocation-intNewXLocation;
						bq.x += 120 * num;
						bq.y -= 120 * num;
						InformationParser.setColor("l");
					}
					else
					{
						System.err.println(invalid);
					}
				}
				else if(intNewYLocation < currentYLocation) //+-
				{
					if((intNewXLocation-currentXLocation)/(intNewYLocation-currentYLocation) == 1)
					{
						num = intNewYLocation-currentYLocation;
						bq.x -=120*num;
						bq.y -=120*num;
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
			else if(intNewXLocation > currentXLocation) //--
			{
				if((intNewXLocation-currentXLocation)/(intNewYLocation -currentYLocation) == 1) //--
				{
					bq.x +=120;
					bq.y -=120;
					InformationParser.setColor("l");
				}
				else if(intNewYLocation > currentYLocation) //-+
				{
					bq.x -=120;
					bq.y +=120;
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
			WhiteQueen wq = queenPlacer.whiteList.get(queen);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (wq.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wq.y/120);
			int num = 0;
			if(currentYLocation == intNewYLocation)
			{
				switch (intNewXLocation)
				{
				case 1: num = 7;
				break;
				case 2: num = 6;
				break;
				case 3: num = 5;
				break;
				case 4: num = 4;
				break;
				case 5: num = 3;
				break;
				case 6: num = 2;
				break;
				case 7: num = 1;
				break;
				case 8: num = 0;
				}
				wq.x = 120*num;	
				InformationParser.setColor("d");
			}

			else if(currentXLocation == intNewXLocation)
			{
				switch (intNewYLocation)
				{
				case 1: num = 7;
				break;
				case 2: num = 6;
				break;
				case 3: num = 5;
				break;
				case 4: num = 4;
				break;
				case 5: num = 3;
				break;
				case 6: num = 2;
				break;
				case 7: num = 1;
				break;
				case 8: num = 0;
				}
				wq.y = 120*num;
				InformationParser.setColor("d");
			}
			
			else if(intNewXLocation < currentXLocation)//positive x movement
			{
				if(intNewYLocation > currentYLocation) //++
				{
					if((currentXLocation-intNewXLocation)/(intNewYLocation-currentYLocation) == 1)
					{
						num = currentXLocation-intNewXLocation;
						wq.x += 120 * num;
						wq.y -= 120 * num;
						InformationParser.setColor("d");
					}
					else
					{
						System.err.println(invalid);
					}
				}
				else if(intNewYLocation < currentYLocation) //+-
				{
					if((intNewXLocation-currentXLocation)/(intNewYLocation-currentYLocation) == 1)
					{
						num = intNewYLocation-currentYLocation;
						wq.x -=120*num;
						wq.y -=120*num;
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
			else if(intNewXLocation > currentXLocation) //--
			{
				if((intNewXLocation-currentXLocation)/(intNewYLocation -currentYLocation) == 1) //--
				{
					wq.x +=120;
					wq.y -=120;
					InformationParser.setColor("d");
				}
				else if(intNewYLocation > currentYLocation) //-+
				{
					wq.x -=120;
					wq.y +=120;
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
	}
}