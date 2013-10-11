package chess.networking;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChessConnectionWindow {
	JFrame frame;
	JPanel panel;
	JButton submit;
	JTextField input;
	
	public ChessConnectionWindow() {
		frame = new JFrame("Connect to other");
		panel = new JPanel();
		
		frame.setPreferredSize(new Dimension(250,65));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createComponents() {
		FlowLayout layout = new FlowLayout();
		submit = new JButton("Connect");
		input = new JTextField();
		input.setPreferredSize(new Dimension(145,25));
		
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectToServer();
			}
		});
		
		layout.setAlignment(FlowLayout.TRAILING);
		panel.setLayout(layout);
		panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(input);
		panel.add(submit);
		
		frame.add(panel);
		frame.pack();
	}
	
	//Takes an int and creates a connection with a server with the given int as the port
	//Prompts user to add an IP to connect to
	public void connectToServer() {
		try {
			System.out.println("Attempting to create connection to server");
			frame.setVisible(false);
			frame.dispose();
			
			Socket s = new Socket();
			s.connect(new InetSocketAddress(input.getText(), 12345), 10000);
			System.out.println("Connected to something");
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
