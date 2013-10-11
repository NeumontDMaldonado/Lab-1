package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Startup {

	/**
	 * @param args
	 */
	static int counter = 0;
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Title");
		frame.setVisible(true);
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("Guess a number!");
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		JPanel panel = new JPanel();
		label.setBorder(new LineBorder(Color.green, 1));
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("clicked!");
				counter++;
			}
		});
		panel.add(label);
		panel.add(button);
		frame.add(panel);
	}
}