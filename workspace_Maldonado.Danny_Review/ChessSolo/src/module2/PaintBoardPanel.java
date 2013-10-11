package module2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintBoardPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int BOARDSIZE = 8;
	private int distance = 120, Hundred = 120;
	public KingPlacer kingPlacer;
	public PawnPlacer pawnPlacer;
	public RookPlacer rookPlacer;
	public KnightPlacer knightPlacer;
	public BishopPlacer bishopPlacer;
	public QueenPlacer queenPlacer;

	public PaintBoardPanel()
	{
		rookPlacer = new RookPlacer();
		queenPlacer = new QueenPlacer();
		kingPlacer = new KingPlacer();
		pawnPlacer = new PawnPlacer();
		knightPlacer = new KnightPlacer();
		bishopPlacer = new BishopPlacer();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int far = 0;
		int apart = 0;
		int blackCounter = 0, whiteCounter = 0;
		far = 0;
		while(blackCounter < 8)
		{
			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far += distance;
			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far +=distance;
		}
		apart +=distance;
		far = 0;
		while(whiteCounter < 8)
		{
			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far += distance;

			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far +=distance;
		}
		apart+=distance;
		far = 0;
		blackCounter = 0;
		while(blackCounter < 8)
		{
			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far += distance;

			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far +=distance;
		}
		apart +=distance;
		far = 0;
		whiteCounter = 0;
		while(whiteCounter < 8)
		{
			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far += distance;

			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far +=distance;
		}
		apart +=distance;
		far = 0;
		blackCounter = 0;
		while(blackCounter < 8)
		{
			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far += distance;
			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far +=distance;
		}
		apart +=distance;
		far = 0;
		whiteCounter = 0;
		while(whiteCounter < 8)
		{
			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far += distance;

			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far +=distance;
		}
		apart+=distance;
		far = 0;
		blackCounter = 0;
		while(blackCounter < 8)
		{
			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far += distance;

			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			blackCounter++;
			far +=distance;
		}
		apart +=distance;
		far = 0;
		whiteCounter = 0;
		while(whiteCounter < 8)
		{
			g.setColor(Color.white);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far += distance;

			g.setColor(Color.black);
			g.fillRect(far, apart, Hundred, Hundred);
			whiteCounter++;
			far +=distance;
		}
		rookPlacer.paintComponent(g);
		knightPlacer.paintComponent(g);
		bishopPlacer.paintComponent(g);
		queenPlacer.paintComponent(g);
		kingPlacer.paintComponent(g);
		pawnPlacer.paintComponent(g);
	}
}