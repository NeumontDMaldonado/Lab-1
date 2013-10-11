package module5;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import module1.ChessIO;
import module2.ChessBoard;

public class ChessController implements MouseListener {
	private ChessBoard chessBoard;
	private ChessIO io;
	
	public ChessController(ChessIO io, ChessBoard board) {
		this.chessBoard = board;
		this.io = io;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int cellWidth = chessBoard.getBOARD_SIZE() / chessBoard.getBOARD_LENGTH();
		int cellHeight = chessBoard.getBOARD_SIZE() / chessBoard.getBOARD_LENGTH();
		
		// goal is to translate a clicked position to
		// a simplified x,y coordinate in the form of
		// (0, 0) or (0, 1)
		int x = e.getX() / cellWidth;
		int y = e.getY() / cellHeight;
		//view.repaint();
		System.out.println("(" + x + ", " + y + ")");
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
