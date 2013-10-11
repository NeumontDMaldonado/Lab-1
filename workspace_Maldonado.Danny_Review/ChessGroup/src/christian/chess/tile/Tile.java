package christian.chess.tile;

import christian.chess.pieces.Piece;

public class Tile
{
	private Piece newPiece;
	
	public Tile(Piece p)
	{
		newPiece = p;
	}
	
	public Piece getPiece()
	{
		return newPiece;
	}
	
	//Checks the piece type and calls toString to print out the name
	public String checkName()
	{
		return newPiece.toString();
	}
}