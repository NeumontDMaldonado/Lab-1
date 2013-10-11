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
public class PawnPlacer extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageIcon blackPawn = new ImageIcon("blackPawn.png");
	public ImageIcon whitePawn = new ImageIcon("whitePawn.jpg");
	public class BlackPawn
	{
		public int x, y;
		public ImageIcon icon;

		public BlackPawn(ImageIcon icon, int x, int y)
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
	
	public class WhitePawn
	{
		public ImageIcon icon;
		public int x;
		public int y;

		public WhitePawn(ImageIcon icon, int x, int y)
		{
			this.icon = icon;
			this.x = x;
			this.y = y;
		}

		public int setX(int x)
		{
			this.x = x;
			return x;
		}
		
		public int setY(int y)
		{
			this.y = y;
			return y;
		}
	}

	public ArrayList<BlackPawn> blackList = new ArrayList<>();
	public BlackPawn bp1 = new BlackPawn(blackPawn,PossibleSpaces.A, PossibleSpaces.SEVEN);
	public BlackPawn bp2 = new BlackPawn(blackPawn,PossibleSpaces.B, PossibleSpaces.SEVEN);
	public BlackPawn bp3 = new BlackPawn(blackPawn,PossibleSpaces.C, PossibleSpaces.SEVEN);
	public BlackPawn bp4 = new BlackPawn(blackPawn,PossibleSpaces.D, PossibleSpaces.SEVEN);
	public BlackPawn bp5 = new BlackPawn(blackPawn,PossibleSpaces.E, PossibleSpaces.SEVEN);
	public BlackPawn bp6 = new BlackPawn(blackPawn,PossibleSpaces.F, PossibleSpaces.SEVEN);
	public BlackPawn bp7 = new BlackPawn(blackPawn,PossibleSpaces.G, PossibleSpaces.SEVEN);
	public BlackPawn bp8 = new BlackPawn(blackPawn,PossibleSpaces.H, PossibleSpaces.SEVEN);
	
	public ArrayList<WhitePawn> whiteList = new ArrayList<>();
	public WhitePawn wp1 = new  WhitePawn(whitePawn,PossibleSpaces.A ,PossibleSpaces.TWO);
	public WhitePawn wp2 = new  WhitePawn(whitePawn,PossibleSpaces.B, PossibleSpaces.TWO);
	public WhitePawn wp3 = new  WhitePawn(whitePawn,PossibleSpaces.C, PossibleSpaces.TWO);
	public WhitePawn wp4 = new  WhitePawn(whitePawn,PossibleSpaces.D, PossibleSpaces.TWO);
	public WhitePawn wp5 = new  WhitePawn(whitePawn,PossibleSpaces.E, PossibleSpaces.TWO);
	public WhitePawn wp6 = new  WhitePawn(whitePawn,PossibleSpaces.F, PossibleSpaces.TWO);
	public WhitePawn wp7 = new  WhitePawn(whitePawn,PossibleSpaces.G, PossibleSpaces.TWO);
	public WhitePawn wp8 = new  WhitePawn(whitePawn,PossibleSpaces.H, PossibleSpaces.TWO);

	public PawnPlacer()
	{
		blackList.add(bp1);
		blackList.add(bp2);
		blackList.add(bp3);
		blackList.add(bp4);
		blackList.add(bp5);
		blackList.add(bp6);
		blackList.add(bp7);
		blackList.add(bp8);
		
		whiteList.add(wp1);
		whiteList.add(wp2);
		whiteList.add(wp3);
		whiteList.add(wp4);
		whiteList.add(wp5);
		whiteList.add(wp6);
		whiteList.add(wp7);
		whiteList.add(wp8);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		bp1.icon.paintIcon(this, g, bp1.x, bp1.y);
		bp2.icon.paintIcon(this, g, bp2.x, bp2.y);
		bp3.icon.paintIcon(this, g, bp3.x, bp3.y);
		bp4.icon.paintIcon(this, g, bp4.x, bp4.y);
		bp5.icon.paintIcon(this, g, bp5.x, bp5.y);
		bp6.icon.paintIcon(this, g, bp6.x, bp6.y);
		bp7.icon.paintIcon(this, g, bp7.x, bp7.y);
		bp8.icon.paintIcon(this, g, bp8.x, bp8.y);
		
		wp1.icon.paintIcon(this, g, wp1.x, wp1.y);
		wp2.icon.paintIcon(this, g, wp2.x, wp2.y);
		wp3.icon.paintIcon(this, g, wp3.x, wp3.y);
		wp4.icon.paintIcon(this, g, wp4.x, wp4.y);
		wp5.icon.paintIcon(this, g, wp5.x, wp5.y);
		wp6.icon.paintIcon(this, g, wp6.x, wp6.y);
		wp7.icon.paintIcon(this, g, wp7.x, wp7.y);
		wp8.icon.paintIcon(this, g, wp8.x, wp8.y);
	}
}