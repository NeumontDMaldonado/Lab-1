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
public class KnightPlacer extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon whiteKnight = new ImageIcon("whiteKnight.png");
	protected ImageIcon blackKnight = new ImageIcon("blackKnight.png");
	
	public class WhiteKnight
	{
		public int x, y;
		public ImageIcon icon;

		public WhiteKnight(ImageIcon icon, int x, int y)
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
	
	public class BlackKnight
	{
		public int x, y;
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

		public ImageIcon icon;

		public BlackKnight(ImageIcon icon, int x, int y)
		{
			this.icon = icon;
			this.x = x;
			this.y = y;
		}

	}

	public ArrayList<BlackKnight> blackList = new ArrayList<>();
	BlackKnight n1 = new  BlackKnight(blackKnight,PossibleSpaces.B, PossibleSpaces.EIGHT);
	BlackKnight n2 = new  BlackKnight(blackKnight,PossibleSpaces.G, PossibleSpaces.EIGHT);

	public ArrayList<WhiteKnight> whiteList = new ArrayList<>();
	WhiteKnight ln1 = new  WhiteKnight(whiteKnight,PossibleSpaces.B, PossibleSpaces.ONE);
	WhiteKnight ln2 = new  WhiteKnight(whiteKnight,PossibleSpaces.G, PossibleSpaces.ONE);
	
	public KnightPlacer()
	{
		whiteList.add(ln1);
		whiteList.add(ln2);
		
		blackList.add(n1);
		blackList.add(n2);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		ln1.icon.paintIcon(this, g, ln1.x, ln1.y);
		ln2.icon.paintIcon(this, g, ln2.x, ln2.y);
		
		n1.icon.paintIcon(this, g, n1.x, n1.y);
		n2.icon.paintIcon(this, g, n2.x, n2.y);
	}
}