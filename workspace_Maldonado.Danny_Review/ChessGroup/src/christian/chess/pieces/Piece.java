package christian.chess.pieces;

public abstract class Piece {
	private String name;
	private String color;
	public int maxBounds = 7;
	
	public Piece(String s, String c) {
		name = s;
		color = c;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return color + name;
	}
}