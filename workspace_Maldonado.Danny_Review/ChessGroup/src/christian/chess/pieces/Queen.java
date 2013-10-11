package christian.chess.pieces;

import java.util.ArrayList;

import christian.chess.tile.Tile;

public class Queen extends Piece {
	public Queen(String s, String c) {
		super(s, c);
	}
	
	public boolean validateMove(int startCol, int startRow, int endCol, int endRow) {
		//Return true if move is valid, false if it isn't
		return true;
	}
} 