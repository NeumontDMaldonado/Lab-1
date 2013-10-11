/**
 * 
 */
package module2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author dmaldonado
 *
 */
public class QueenPlacer extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon whiteQueen = new ImageIcon("whiteQueen.png");
	protected ImageIcon blackQueen = new ImageIcon("blackQueen.png");
	
	public class BlackQueen
	{
		public int x, y;
		public ImageIcon icon;

		public BlackQueen(ImageIcon icon, int x, int y)
		{
			this.icon = icon;
			this.x = x;
			this.y = y;
		}

		/**
		 * @param x the x to set
		 */
		protected void setX(int x) {
			this.x = x;
		}

		/**
		 * @param y the y to set
		 */
		protected void setY(int y) {
			this.y = y;
		}
	}
	
	public class WhiteQueen
	{
		public int x, y;
		public ImageIcon icon;

		public WhiteQueen(ImageIcon icon, int x, int y)
		{
			this.icon = icon;
			this.x = x;
			this.y = y;
		}

		/**
		 * @param x the x to set
		 */
		protected void setX(int x) {
			this.x = x;
		}

		/**
		 * @param y the y to set
		 */
		protected void setY(int y) {
			this.y = y;
		}
	}

	public ArrayList<WhiteQueen> whiteList = new ArrayList<>();
	WhiteQueen lq1 = new  WhiteQueen(whiteQueen,PossibleSpaces.E, PossibleSpaces.ONE);
	
	public ArrayList<BlackQueen> blackList = new ArrayList<>();
	BlackQueen q1 = new  BlackQueen(blackQueen,PossibleSpaces.E, PossibleSpaces.EIGHT);
	
	public QueenPlacer()
	{
		whiteList.add(lq1);
		blackList.add(q1);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		lq1.icon.paintIcon(this, g, lq1.x, lq1.y);
		q1.icon.paintIcon(this, g, q1.x, q1.y);
	}
}
