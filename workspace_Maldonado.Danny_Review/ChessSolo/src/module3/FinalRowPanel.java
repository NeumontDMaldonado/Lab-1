package module3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FinalRowPanel extends JPanel 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton queen, rook, knight, bishop, pawn;
	boolean yesQueen = false, yesRook = false, yesKnight = false, yesBishop = false, yesPawn = false;
	
	public FinalRowPanel()
	{
		queen = new JButton("Queen");
		queen.addMouseListener(new QueenListener());
		rook = new JButton("Rook");
		rook.addMouseListener(new RookListener());
		knight = new JButton("Knight");
		knight.addMouseListener(new KnightListener());
		bishop = new JButton("Bishop");
		bishop.addMouseListener(new BishopListener());
		pawn = new JButton("Pawn");
		pawn.addMouseListener(new PawnListener());
		
		add(queen);
		add(rook);
		add(knight);
		add(bishop);
		add(pawn);
	}
	
	/**
	 * @return the yesQueen
	 */
	public boolean isYesQueen() {
		return yesQueen;
	}

	/**
	 * @param yesQueen the yesQueen to set
	 */
	public void setYesQueen(boolean yesQueen) {
		this.yesQueen = yesQueen;
	}

	/**
	 * @return the yesRook
	 */
	public boolean isYesRook() {
		return yesRook;
	}

	/**
	 * @param yesRook the yesRook to set
	 */
	public void setYesRook(boolean yesRook) {
		this.yesRook = yesRook;
	}

	/**
	 * @return the yesKnight
	 */
	public boolean isYesKnight() {
		return yesKnight;
	}

	/**
	 * @param yesKnight the yesKnight to set
	 */
	public void setYesKnight(boolean yesKnight) {
		this.yesKnight = yesKnight;
	}

	/**
	 * @return the yesBishop
	 */
	public boolean isYesBishop() {
		return yesBishop;
	}

	/**
	 * @param yesBishop the yesBishop to set
	 */
	public void setYesBishop(boolean yesBishop) {
		this.yesBishop = yesBishop;
	}

	/**
	 * @return the yesPawn
	 */
	public boolean isYesPawn() {
		return yesPawn;
	}

	/**
	 * @param yesPawn the yesPawn to set
	 */
	public void setYesPawn(boolean yesPawn) {
		this.yesPawn = yesPawn;
	}

	private class QueenListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			setYesQueen(true);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class RookListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			setYesRook(true);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class KnightListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			setYesKnight(true);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class BishopListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			setYesBishop(true);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class PawnListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			setYesPawn(true);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
}