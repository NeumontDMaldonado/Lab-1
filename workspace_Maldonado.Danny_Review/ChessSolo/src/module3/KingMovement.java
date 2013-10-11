package module3;

import module2.KingPlacer;
import module2.PaintBoardPanel;
import module2.KingPlacer.BlackKing;
import module2.KingPlacer.WhiteKing;
import module2.PawnPlacer;
import module2.QueenPlacer;
import module2.RookPlacer;
import module2.RookPlacer.BlackRook;
import module2.RookPlacer.WhiteRook;

public class KingMovement {
	String pieceNr, pieceColor, newXLocation, newYLocation, capture, secondPieceNr;
	KingPlacer kingPlacer;
	RookPlacer rookPlacer;
	PawnPlacer pawns;
	QueenPlacer queen;

	private String invalid = "invalid king movement";
	boolean move = false, moveLight = false;


	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param king
	 * constructor
	 */
	public KingMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, KingPlacer king, String secondPieceNr, RookPlacer rook)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		kingPlacer = king;
		this.secondPieceNr = secondPieceNr;
		this.rookPlacer = rook;
	}
	PawnMovement pawn = new PawnMovement(pieceNr,pieceColor,newXLocation,newYLocation,capture, pawns, queen, rookPlacer);


	/**
	 * check if king movement is valid and executes
	 */
	public void checkKingMovement()
	{
		int currentYLocation = 0, currentXLocation = 0;
		int intNewYLocation = (newYLocation.charAt(0)-'0');
		int king = Integer.parseInt(pieceNr)-1;
		int rook = 2;
		try 
		{
			rook = Integer.parseInt(secondPieceNr)-1;
		}
		catch (NumberFormatException e) {}
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
			BlackRook br = rookPlacer.blackList.get(rook);
			BlackKing bk = kingPlacer.blackList.get(king);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (bk.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bk.y/120);

			if(rook == 1 || rook == 0)
			{
				if(intNewXLocation - currentXLocation == 2 && move == false)
				{
					bk.x = 120;
					br.x= 240;
					InformationParsing.setColor("l");
					move = true;
				}
				else if(currentXLocation - intNewXLocation == 2 && move == false)
				{
					bk.x +=240;
					br.x = 480;
					InformationParsing.setColor("l");
					move = true;
				}
			}

			else if(currentXLocation == intNewXLocation)
			{
				if(currentYLocation - intNewYLocation == 1)
				{
					bk.y +=120;
					InformationParsing.setColor("l");
					move = true;
				}
				else if(intNewYLocation - currentYLocation == 1)
				{
					if(pawn.boolQueen = false || pawn.boolRook != true)
					{
						System.err.println("Can't put yourself in check");
					}
					else
					{
						System.out.println("why?");		
						bk.y -=120;
						InformationParsing.setColor("l");
						move = true;
					}
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
					InformationParsing.setColor("l");
					move = true;
				}
				else if(intNewXLocation - currentXLocation == 1)
				{
					bk.x -=120;
					InformationParsing.setColor("l");
					move = true;
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
					InformationParsing.setColor("l");
					move = true;
				}

				else if(intNewXLocation - currentXLocation == 1)
				{
					bk.x -=120;
					InformationParsing.setColor("l");
					move = true;
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
					InformationParsing.setColor("l");
					move = true;
				}

				else if(currentXLocation - intNewXLocation ==1)
				{
					bk.x += 120;
					InformationParsing.setColor("l");
					move = true;
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
			WhiteRook wr = rookPlacer.whiteList.get(rook);
			WhiteKing wk = kingPlacer.whiteList.get(king);
			currentXLocation = PaintBoardPanel.BOARDSIZE - (wk.x/120);
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wk.y/120);

			if(rook == 1 || rook == 0)
			{
				if(intNewXLocation - currentXLocation == 2 && move == false)
				{
					wk.x = 120;
					wr.x= 240;
					InformationParsing.setColor("l");
					move = true;
				}
				else if(currentXLocation - intNewXLocation == 2 && move == false)
				{
					wk.x +=240;
					wr.x = 480;
					InformationParsing.setColor("l");
					move = true;
				}				
			}

			else if(currentXLocation == intNewXLocation)
			{
				if(currentYLocation - intNewYLocation == 1)
				{
					wk.y +=120;
					InformationParsing.setColor("d");
					moveLight = true;
				}
				else if(intNewYLocation - currentYLocation == 1)
				{
					wk.y -=120;
					InformationParsing.setColor("d");
					moveLight = true;
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
					InformationParsing.setColor("d");
					moveLight = true;
				}
				else if(intNewXLocation - currentXLocation == 1)
				{
					wk.x -=120;
					InformationParsing.setColor("d");
					moveLight = true;
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
					InformationParsing.setColor("d");
					moveLight = true;
				}

				else if(intNewXLocation - currentXLocation == 1)
				{
					wk.x -=120;
					InformationParsing.setColor("d");
					moveLight = true;
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
					InformationParsing.setColor("d");
					moveLight = true;
				}

				else if(currentXLocation - intNewXLocation ==1)
				{
					wk.x += 120;
					InformationParsing.setColor("d");
					moveLight = true;
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