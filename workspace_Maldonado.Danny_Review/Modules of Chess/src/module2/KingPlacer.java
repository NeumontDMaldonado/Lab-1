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
public class KingPlacer extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon whiteKing = new ImageIcon("whiteKing.png");
	protected ImageIcon blackKing = new ImageIcon("blackKing.png");
	
	public class BlackKing
	{
		public int x, y;
		public ImageIcon icon;

		public BlackKing(ImageIcon icon, int x, int y)
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
	
	public class WhiteKing
	{
		public int x, y;
		public ImageIcon icon;

		public WhiteKing(ImageIcon icon, int x, int y)
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

	public ArrayList<WhiteKing> whiteList = new ArrayList<>();
	WhiteKing lk1 = new  WhiteKing(whiteKing,PossibleSpaces.D, PossibleSpaces.ONE);
	
	public ArrayList<BlackKing> blackList = new ArrayList<>();
	BlackKing dk1 = new  BlackKing(blackKing,PossibleSpaces.D, PossibleSpaces.EIGHT);
	
	public KingPlacer()
	{
		whiteList.add(lk1);
		
		blackList.add(dk1);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		lk1.icon.paintIcon(this, g, lk1.x, lk1.y);
		
		dk1.icon.paintIcon(this, g, dk1.x, dk1.y);
	}
}
