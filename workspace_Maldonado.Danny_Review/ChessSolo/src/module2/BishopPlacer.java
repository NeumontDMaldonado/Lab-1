package module2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BishopPlacer extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon whiteBishop = new ImageIcon("whiteBishop.png");
	protected ImageIcon blackBishop = new ImageIcon("blackBishop.png");
	public class WhiteBishop
	{
		public int x, y;
		public ImageIcon icon;

		public WhiteBishop(ImageIcon icon, int x, int y)
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
	
	public class BlackBishop
	{
		public int x, y;
		public ImageIcon icon;

		public BlackBishop(ImageIcon icon, int x, int y)
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

	public ArrayList<BlackBishop> blackList = new ArrayList<>();
	BlackBishop b1 = new  BlackBishop(blackBishop,PossibleSpaces.C, PossibleSpaces.EIGHT);
	BlackBishop b2 = new  BlackBishop(blackBishop,PossibleSpaces.F, PossibleSpaces.EIGHT);

	public ArrayList<WhiteBishop> whiteList = new ArrayList<>();
	WhiteBishop lb1 = new  WhiteBishop(whiteBishop,PossibleSpaces.C, PossibleSpaces.ONE);
	WhiteBishop lb2 = new  WhiteBishop(whiteBishop,PossibleSpaces.F, PossibleSpaces.ONE);
	
	public BishopPlacer()
	{
		blackList.add(b1);
		blackList.add(b2);
		
		whiteList.add(lb1);
		whiteList.add(lb2);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		b1.icon.paintIcon(this, g, b1.x, b1.y);
		b2.icon.paintIcon(this, g, b2.x, b2.y);
		
		lb1.icon.paintIcon(this, g, lb1.x, lb1.y);
		lb2.icon.paintIcon(this, g, lb2.x, lb2.y);
	}
}
