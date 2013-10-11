package module3;

import module2.KnightPlacer;
import module2.PaintBoardPanel;
import module2.KnightPlacer.BlackKnight;
import module2.KnightPlacer.WhiteKnight;

public class KnightMovement
{
	protected String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	KnightPlacer knightPlacer;
	private String invalid = "invalid knight movement";

	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param knight
	 * constructor
	 */
	public KnightMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, KnightPlacer knight)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		knightPlacer = knight;
	}

	/**
	 * checks if knight movement is valid and executes
	 */
	public void checkKnightMovement()
	{
		int currentYLocation = 0, currentXLocation = 0;
		int intNewYLocation = (newYLocation.charAt(0)-'0');
		int knight = Integer.parseInt(pieceNr)-1;

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
			BlackKnight bn = knightPlacer.blackList.get(knight);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (bn.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bn.y/120);
			if(intNewXLocation - currentXLocation == 2)
			{
				bn.y -= 240;
				if(intNewYLocation - currentYLocation == 1)
				{
					bn.x -= 120;
					InformationParsing.setColor("l");
				}

				else if(currentYLocation - intNewYLocation == 1)
				{
					bn.x +=120;
					InformationParsing.setColor("l");
				}
				else
				{
					bn.y +=240;
					System.err.println(invalid);
				}
			}

			else if(intNewXLocation - currentXLocation ==2)
			{
				bn.x -=240;
				if(currentYLocation - intNewYLocation == 1)
				{
					bn.y +=120;
					InformationParsing.setColor("l");
				}
				else if(intNewYLocation - currentYLocation == 1)
				{
					bn.y-=120;
					InformationParsing.setColor("l");
				}
				else
				{
					bn.x +=240;
					System.err.println(invalid);
				}
			}

			else if(currentYLocation - intNewYLocation == 2)
			{
				bn.y +=240;
				if(intNewXLocation - currentXLocation == 1)
				{
					System.err.println("invalid move, you are in check");
					bn.y -=240;
//					bn.x -=120;
//					InformationParsing.setColor("l");
				}
				else if(currentXLocation - intNewYLocation == 1)
				{
					bn.x += 120;
					InformationParsing.setColor("l");
				}
				else
				{
					bn.y -=240;
					System.err.println(invalid);
				}
			}
			else if(currentXLocation - intNewXLocation == 2)
			{
				bn.x += 240;
				if(intNewYLocation - currentYLocation ==1)
				{
					bn.y -=120;
					InformationParsing.setColor("l");
				}
				else if(currentYLocation - intNewYLocation == 1)
				{
					bn.y +=120;
					InformationParsing.setColor("l");
				}
				else
				{
					bn.x -= 240;
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
			WhiteKnight wn = knightPlacer.whiteList.get(knight);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (wn.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wn.y/120);
			if(intNewXLocation - currentXLocation == 2)
			{
				wn.y -= 240;
				if(intNewYLocation - currentYLocation == 1)
				{
					wn.x -= 120;
					InformationParsing.setColor("d");
				}

				else if(currentYLocation - intNewYLocation == 1)
				{
					wn.x +=120;
					InformationParsing.setColor("d");
				}
				else
				{
					wn.y +=240;
					System.err.println(invalid);
				}
			}

			else if(intNewXLocation - currentXLocation ==2)
			{
				wn.x -=240;
				if(currentYLocation - intNewYLocation == 1)
				{
					wn.y +=120;
					InformationParsing.setColor("d");
				}
				else if(intNewYLocation - currentYLocation == 1)
				{
					wn.y-=120;
					InformationParsing.setColor("d");
				}
				else
				{
					wn.x +=240;
					System.err.println(invalid);
				}
			}

			else if(currentYLocation - intNewYLocation == 2)
			{
				wn.y +=240;
				if(intNewXLocation - currentXLocation == 1)
				{
					wn.x -=120;
					InformationParsing.setColor("d");
				}
				else if(currentXLocation - intNewYLocation == 1)
				{
					wn.x += 120;
					InformationParsing.setColor("d");
				}
				else
				{
					wn.y -=240;
					System.err.println(invalid);
				}
			}
			else if(currentXLocation - intNewXLocation == 2)
			{
				wn.x += 240;
				if(intNewYLocation - currentYLocation ==1)
				{
					wn.y -=120;
					InformationParsing.setColor("d");
				}
				else if(currentYLocation - intNewYLocation == 1)
				{
					wn.y +=120;
					InformationParsing.setColor("d");
				}
				else
				{
					wn.x -= 240;
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
			System.err.println(invalid);
		}
	}
}