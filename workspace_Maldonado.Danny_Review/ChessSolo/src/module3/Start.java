/**
 * 
 */
package module3;

import javax.swing.JFrame;

import module2.PaintBoardPanel;

/**
 * @author dmaldonado
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		
		PaintBoardPanel board = new PaintBoardPanel();
		frame.getContentPane().add(board);
		frame.setSize(1000, 1000);
		InformationParsing parseFile = new InformationParsing(args[0], board);
		parseFile.end();
	}
}