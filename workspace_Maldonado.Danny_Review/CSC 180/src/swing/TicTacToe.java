/**
 * 
 */
package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author dmaldonado
 *
 */
public class TicTacToe 
{
	public static int userChoice;
	static JLabel label = new JLabel("");

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.setVisible(true);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JButton b1 = new JButton("Rock");
		JButton b2 = new JButton("Paper");
		JButton b3 = new JButton("Scissors");
		b1.addActionListener(new Button1Listener());
		b2.addActionListener(new Button2Listener());
		b3.addActionListener(new Button3Listener());
		panel.add(label);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		frame.add(panel);

	}

	protected static class Button1Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			userChoice = 1;
			end.endGame();
		}
	}

	protected static class Button2Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			userChoice = 2;
			end.endGame();
		}
	}

	protected static class Button3Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			userChoice = 3;
			end.endGame();
		}
	}

	protected static class end
	{
		public static void endGame()
		{
			Random gen = new Random();
			int num = gen.nextInt(3)+1;
			if(num == 1)
			{
				switch(userChoice)
				{
				case 1: label.setText("Tie");
					break;
				case 2: label.setText("You lost");
					break;
				case 3: label.setText("You win!");
					break;
				}
			}
			
			if(num == 2)
			{
				switch(userChoice)
				{
				case 1: label.setText("You won!");
					break;
				case 2: label.setText("Tie game");
					break;
				case 3: label.setText("You lost");
					break;
				}
			}
			
			if(num == 3)
			{
				switch(userChoice)
				{
				case 1: label.setText("You lose");
					break;
				case 2: label.setText("You win!");
					break;
				case 3: label.setText("Well, you tied");
					break;
				}
			}
		}
	}
}