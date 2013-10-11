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
public class RookPlacer extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon whiteRook = new ImageIcon("whiteRook.png");
	protected ImageIcon blackRook = new ImageIcon("blackRook.jpg");

	public class BlackRook
	{
		public int x, y;
		public ImageIcon icon;

		public BlackRook(ImageIcon icon, int x, int y)
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

	public class WhiteRook
	{
		public int x, y;
		public ImageIcon icon;

		public WhiteRook(ImageIcon icon, int x, int y)
		{
			this.icon = icon;
			this.x = x;
			this.y = y;
		}
	}
	
	public ArrayList<BlackRook> blackList = new ArrayList<>();
	BlackRook br1 = new  BlackRook(blackRook,PossibleSpaces.A, PossibleSpaces.EIGHT);
	BlackRook br2 = new  BlackRook(blackRook,PossibleSpaces.H, PossibleSpaces.EIGHT);

	public ArrayList<WhiteRook> whiteList = new ArrayList<>();
	WhiteRook lr1 = new  WhiteRook(whiteRook,PossibleSpaces.A, PossibleSpaces.ONE);
	WhiteRook lr2 = new  WhiteRook(whiteRook,PossibleSpaces.H, PossibleSpaces.ONE);

	public RookPlacer()
	{
		whiteList.add(lr1);
		whiteList.add(lr2);
		
		blackList.add(br1);
		blackList.add(br2);
	}

	@Override
	public void paintComponent(Graphics g)
	{		
		br1.icon.paintIcon(this, g, br1.x, br1.y);
		br2.icon.paintIcon(this, g, br2.x, br2.y);
		lr1.icon.paintIcon(this, g, lr1.x, lr1.y);
		lr2.icon.paintIcon(this, g, lr2.x, lr2.y);
	}
}
