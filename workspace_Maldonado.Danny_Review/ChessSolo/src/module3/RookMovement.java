package module3;

import module2.PaintBoardPanel;
import module2.RookPlacer;
import module2.RookPlacer.BlackRook;
import module2.RookPlacer.WhiteRook;

public class RookMovement 
{
	String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	RookPlacer rookPlacer;
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
	public RookMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, RookPlacer rook)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		rookPlacer = rook;
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

		int rook = Integer.parseInt(pieceNr)-1; //find rook reference for list

		if(pieceColor.equals("d"))
		{
			BlackRook br = rookPlacer.blackList.get(rook);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (br.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (br.y/120);

			if(currentYLocation == intNewYLocation)
			{
				int num = 0;
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
				br.x = 120*num;
				InformationParsing.setColor("l");
			}

			else if(currentXLocation == intNewXLocation)
			{
				int num = 0;
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
				br.y = 120*num;
				InformationParsing.setColor("l");
			}
			else
			{
				System.err.println(invalid);
			}
		}

		else if(pieceColor.equals("l"))
		{
			WhiteRook wr = rookPlacer.whiteList.get(rook);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (wr.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wr.y/120);
			if(currentYLocation == intNewYLocation)
			{
				int num = 0;
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
				wr.x = 120*num;	
				InformationParsing.setColor("d");
			}

			else if(currentXLocation == intNewXLocation)
			{
				int num = 0;
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
				wr.y = 120*num;
				InformationParsing.setColor("d");
			}
			else
			{
				System.err.println(invalid);
			}
		}
	}
}