/**
 * 
 */
package module3;

import module2.PaintBoardPanel;
import module2.PawnPlacer;
import module2.PawnPlacer.BlackPawn;
import module2.PawnPlacer.WhitePawn;

/**
 * @author dmaldonado
 *
 */
public class PawnMovement
{
	int pawnCounterD = 0, pawnCounterL = 0;

	String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	PawnPlacer pawnPlacer;
	private String invalid = "invalid pawn movement";

	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param pawn
	 * constructor
	 */
	public PawnMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, PawnPlacer pawn)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		pawnPlacer = pawn;
	}

	/**
	 * check if pawn movement is valid and executes
	 */
	public void checkPawnMove()
	{
		int currentYLocation = 0;
		int integerNewYLocation = (newYLocation.charAt(0)-'0');

		int pawn = Integer.parseInt(pieceNr)-1; //find pawn reference for list

		if(pieceColor.equals("d"))
		{
			BlackPawn bp = pawnPlacer.blackList.get(pawn); //find specific pawn
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bp.y/120);
			if(currentYLocation - integerNewYLocation == 1)
			{	
				bp.y+=120;
				InformationParser.setColor("l");
			}
			else if(currentYLocation - integerNewYLocation == 2 && pawnCounterD < 1)
			{
				bp.y+=240;
				InformationParser.setColor("l");
			}
			else if(capture.equals("*"))
			{
				bp.x+=120;
				bp.y+=120;
				InformationParser.setColor("l");
				//check if piece is there
				//move piece
				//set other piece to null
			}
			else
			{
				System.err.println(invalid);
			}
			pawnCounterD++;
		}

		else if(pieceColor.equals("l"))
		{
			WhitePawn wp = pawnPlacer.whiteList.get(pawn);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wp.y/120);
			if(integerNewYLocation - currentYLocation == 1)
			{
				wp.y-=120;
				InformationParser.setColor("d");
			}
			else if(integerNewYLocation - currentYLocation == 2 && pawnCounterL < 1)
			{
				wp.y-=240;
				InformationParser.setColor("d");
			}
			else if(capture.equals("*"))
 			{
				wp.x -= 120;
				wp.y -= 120;
				InformationParser.setColor("d");
			}
			else
			{
				System.err.println(invalid);
			}
			pawnCounterL++;
		}

		else
		{
			System.err.println(invalid);
		}
	}
}