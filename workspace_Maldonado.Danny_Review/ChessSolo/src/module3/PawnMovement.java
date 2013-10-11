package module3;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import module2.PaintBoardPanel;
import module2.PawnPlacer;
import module2.PawnPlacer.BlackPawn;
import module2.PawnPlacer.WhitePawn;
import module2.RookPlacer;
//import module2.QueenPlacer.WhiteQueen;
import module2.QueenPlacer;

public class PawnMovement 
{
	ImageIcon whiteQueen = new ImageIcon("whiteQueen.png");
	int pawnCounterD = 0, pawnCounterL = 0;

	String pieceNr, pieceColor, newXLocation, newYLocation, capture;
	PawnPlacer pawnPlacer;
	QueenPlacer queen;
	RookPlacer rook;
	private String invalid = "invalid pawn movement";
	boolean justMovedLight = false, justMovedDark = false, boolQueen, boolRook;
	int pawn = 1;


	/**
	 * @param pieceNr
	 * @param pieceColor
	 * @param newXLocation
	 * @param newYLocation
	 * @param capture
	 * @param pawn
	 * constructor
	 */
	public PawnMovement(String pieceNr, String pieceColor, String newXLocation, String newYLocation, String capture, PawnPlacer pawn, QueenPlacer queen, RookPlacer rook)
	{
		this.pieceNr = pieceNr;
		this.pieceColor = pieceColor;
		this.newXLocation = newXLocation;
		this.newYLocation = newYLocation;
		this.capture = capture;
		this.queen = queen;
		this.rook = rook;
		pawnPlacer = pawn;
		setStuff();
	}

	public void setStuff()
	{
		try 
		{
			pawn = Integer.parseInt(pieceNr)-1;
		} 
		catch (NumberFormatException e) {}
	}
	/**
	 * @return the boolQueen
	 */
	public boolean isBoolQueen() {
		return boolQueen;
	}

	/**
	 * @param boolQueen the boolQueen to set
	 */
	public void setBoolQueen(boolean boolQueen) {
		this.boolQueen = boolQueen;
	}

	/**
	 * @return the boolRook
	 */
	public boolean isBoolRook() {
		return boolRook;
	}

	/**
	 * @param boolRook the boolRook to set
	 */
	public void setBoolRook(boolean boolRook) {
		this.boolRook = boolRook;
	}

	/**
	 * check if pawn movement is valid and executes
	 */
	public void checkPawnMove()
	{
		int currentYLocation = 0;
		int integerNewYLocation = (newYLocation.charAt(0)-'0');

		BlackPawn bp = pawnPlacer.blackList.get(pawn); //find specific pawn
		WhitePawn wp = pawnPlacer.whiteList.get(pawn);

		if(pieceColor.equals("d"))
		{
			currentYLocation = PaintBoardPanel.BOARDSIZE - (bp.y/120);
			if(currentYLocation - integerNewYLocation == 1)
			{	
				bp.y+=120;
				InformationParsing.setColor("l");
			}
			else if(currentYLocation - integerNewYLocation == 2 && pawnCounterD < 1)
			{
				bp.y+=240;
				InformationParsing.setColor("l");
				justMovedDark = true;
			}
			else if(capture.equals("*"))
			{
				bp.x+=120;
				bp.y+=120;
				InformationParsing.setColor("l");
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
			currentYLocation = PaintBoardPanel.BOARDSIZE - (wp.y/120);
			if(capture.equals("*"))
			{
				wp.x -= 120;
				wp.y -= 120;
				InformationParsing.setColor("d");
				bp = pawnPlacer.blackList.get(pawn -1);
				bp.x = 2000;
				bp.y = 2000;
				if(InformationParsing.getCounter() == 3)
				{
					System.out.println("hi");
					bp = pawnPlacer.blackList.get(pawn -2);
					bp.x = 2000;
					bp.y = 2000;
				}

			}
			else if(integerNewYLocation - currentYLocation == 1)
			{
				wp.y-=120;
				InformationParsing.setColor("d");
			}
			else if(integerNewYLocation - currentYLocation == 2 && pawnCounterL < 1)
			{
				wp.y-=240;
				InformationParsing.setColor("d");
				justMovedDark = true;
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

	public void checkFinalRow()
	{
		WhitePawn wp = pawnPlacer.whiteList.get(pawn);
		BlackPawn bp = pawnPlacer.blackList.get(pawn);
		if(wp.y == 0)
		{
			JFrame frame = new JFrame("Pawn Promotion");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			FinalRowPanel panel = new FinalRowPanel();
			frame.getContentPane().add(panel);
			frame.setSize(250, 200);
			
			try 
			{
				Thread.sleep(6000);
			} catch (InterruptedException e) {}
			if(panel.yesQueen)
			{
				queen.lq2.x = wp.x;
				queen.lq2.y = wp.y;
				queen.whiteList.add(queen.lq2);
				boolQueen = true;
				wp.x = 2000;
				wp.y = 2000;

			}
			if(panel.yesRook)
			{
				rook.lr4.x = wp.x;
				rook.lr4.y = wp.y;
				rook.whiteList.add(rook.lr4);
				boolRook = true;
				wp.x = 2000;
				wp.y = 2000;
			}
		}
		else if(bp.y == 840)
		{
			
		}
	}
}