/**
 * 
 */
package module3;

import module2.BishopPlacer;
import module2.PaintBoardPanel;
import module2.BishopPlacer.BlackBishop;

/**
 * @author dmaldonado
 *
 */
public class BishopMovement
{
	String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	BishopPlacer bishopPlacer;
	private String invalid = "invalid bishop movement";

	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param bishop
	 * constructor
	 */
	public BishopMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, BishopPlacer bishop)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		bishopPlacer = bishop;
	}
	
	/**
	 * sees if bishop movement is valid and executes
	 */
	public void checkBishopMove()
	{
		int currentYLocation = 0, currentXLocation = 0,intNewXLocation = 0;
		int intNewYLocation = (newYLocation.charAt(0)-'0');
		
		int bishop = Integer.parseInt(pieceNr)-1;
		
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
			BlackBishop bb = bishopPlacer.blackList.get(bishop);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (bb.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bb.y/120);
			int num = 0;
			
			if(intNewXLocation < currentXLocation)//positive x movement
			{
				if(intNewYLocation > currentYLocation) //++
				{
					if((currentXLocation-intNewXLocation)/(intNewYLocation-currentYLocation) == 1)
					{
						num = currentXLocation-intNewXLocation;
						bb.x += 120 * num;
						bb.y -= 120 * num;
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
						bb.x -=120*num;
						bb.y -=120*num;
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
					bb.x +=120;
					bb.y -=120;
				}
				else if(intNewYLocation > currentYLocation) //-+
				{
					bb.x -=120;
					bb.y +=120;
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