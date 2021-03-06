package module1;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ChessPiece {
	
	protected String name;
	protected String color;
	protected String pieceLoc;
	protected ImageIcon pieceIcon;
	protected String pieceColumn;
	protected int pieceRow;
	protected ArrayList <String> availableMoves;
	
	public ChessPiece(String name, String color, String pieceLoc, ImageIcon pieceIcon, ArrayList<String> moves) {
		this.name = name;
		this.color = color;
		this.pieceLoc = pieceLoc;
		this.pieceIcon = pieceIcon;
		this.pieceColumn = pieceLoc.substring(0, 1);
		this.pieceRow = Integer.parseInt(pieceLoc.substring(1));
		this.availableMoves = new ArrayList<String>();
		moves = availableMoves;
		
		/*
		 * Checks if the color char returned is an "l" or "d". 
		 * All l's will be replaced with white (for light), 
		 * All d's will be replaced with dark (for black).
		 */
		if(color.equals("l"))
			this.color = "white";
		else
			this.color = "black";

		// Changes the type being read in to a name for the piece. 
		switch(this.name) {
		case "r":
			this.name = "Rook";
			break;
		case "p":
			this.name = "Pawn";
			break;
		case "n":
			this.name = "Knight";
			break;
		case "b":
			this.name = "Bishop";
			break;
		case "q":
			this.name = "Queen";
			break;
		case "k":
			this.name = "King";
			break;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}

	public String getLocation() {
		return pieceLoc;
	}

	public void setImageIcon(String imgFile) {
		pieceIcon = new ImageIcon(imgFile);		
	}
	
	public ImageIcon getImageIcon() {
		return pieceIcon;
	}

	public void setLocation(String endLoc) {
		pieceLoc = endLoc;
		pieceColumn = pieceLoc.substring(0, 1);
		pieceRow = Integer.parseInt(pieceLoc.substring(1));
	}
	
	public String getPieceCol() {
		return pieceLoc.substring(0, 1);
	}
	
	public int getPieceRow() {
		return Integer.parseInt(pieceLoc.substring(1));
	}
	
	public void setPieceCol(String pieceCol) {
		pieceColumn = pieceCol;
	}
	
	public void setPieceRow(int pieceR) {
		pieceRow = pieceR;
	}
	
	public int getColAsInt() {
		return (int)pieceColumn.charAt(0) - 96;
	}
	
	public void addAvailableMove(String move) {
		availableMoves.add(move);
	}
	
	public ArrayList getAvailableMoves() {
		return availableMoves;
	}
	
	public void removeAvailableMoves() {
		availableMoves.clear();
	}
	
}