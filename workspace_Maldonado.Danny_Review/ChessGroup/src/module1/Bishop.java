/**
 * 
 */
package module1;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * @author dmaldonado
 *
 */
//public class Bishop extends ChessPiece
//{
//	public Bishop(String name, String color, String pieceLoc,
//			ImageIcon pieceIcon, ArrayList<String> moves) 
//	{
//		super(name, color, pieceLoc, pieceIcon, moves);
//	}
//
//	public String getName() {
//		return name;
//	}
//	
//	public String getColor() {
//		return color;
//	}
//
//	public String getLocation() {
//		return pieceLoc;
//	}
//
//	public void setImageIcon(String imgFile) {
//		pieceIcon = new ImageIcon(imgFile);		
//	}
//	
//	public ImageIcon getImageIcon() {
//		return pieceIcon;
//	}
//
//	public void setLocation(String endLoc) {
//		pieceLoc = endLoc;
//		pieceColumn = pieceLoc.substring(0, 1);
//		pieceRow = Integer.parseInt(pieceLoc.substring(1));
//	}
//	
//	public String getPieceCol() {
//		return pieceLoc.substring(0, 1);
//	}
//	
//	public int getPieceRow() {
//		return Integer.parseInt(pieceLoc.substring(1));
//	}
//	
//	public void setPieceCol(String pieceCol) {
//		pieceColumn = pieceCol;
//	}
//	
//	public void setPieceRow(int pieceR) {
//		pieceRow = pieceR;
//	}
//	
//	public int getColAsInt() {
//		return (int)pieceColumn.charAt(0) - 96;
//	}
//	
//	public void addAvailableMove(String move) {
//		availableMoves.add(move);
//	}
//	
//	public String getAvailableMoves() {
//		return availableMoves.toString();
//	}
//	
//	public void removeAvailableMoves() {
//		availableMoves.clear();
//	}
//}