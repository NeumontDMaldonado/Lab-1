package module1;

public class ChessPieces {

	public ChessPiece[] pieces;
	private int count = 0;
	
	public ChessPieces() {
		pieces = new ChessPiece[32];
	}
	
	public void addPieceToContainer(ChessPiece piece) {		
		pieces[count++] = piece;
	}

	public ChessPiece getPiece(int i) {
		return pieces[i];
	}

	public int getLength() {
		return pieces.length;
	}
	
	public void overWritePieceInContainer(ChessPieces container, String endLoc, ChessPiece newPiece) {
		for (int i = 0; i < this.getLength(); i++) {
			ChessPiece tempPiece = container.getPiece(i);
			
			if (tempPiece.getLocation().equalsIgnoreCase(endLoc))
				pieces[i] = newPiece;
		}
	}
	
}
