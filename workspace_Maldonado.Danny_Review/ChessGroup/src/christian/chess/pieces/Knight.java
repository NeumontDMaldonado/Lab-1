package christian.chess.pieces;

import java.util.ArrayList;

import christian.chess.tile.Tile;

public class Knight extends Piece {
	public Knight(String s, String c) {
		super(s, c);
	}
	
	public boolean validateMove(int startCol, int startRow, int endCol, int endRow) {
		return true;
	}
}
