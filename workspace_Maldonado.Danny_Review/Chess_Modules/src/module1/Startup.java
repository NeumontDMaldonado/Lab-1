/**
 * 
 */
package module1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dmaldonado
 * This program takes a file from the command line, reads it, and deciphers the chess notation
 */
public class Startup {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		FileReader file = new FileReader(args[0]);
		BufferedReader buff = new BufferedReader(file);

		String line = "";
		while(buff.ready())
		{
			line = buff.readLine();
			Pattern pattern1 = Pattern.compile("([a-z])([ld])([a-h][1-8])");
			Pattern pattern2 = Pattern.compile("([a-h][1-8])[ ]([a-h][1-8])([*]?)");
			Pattern pattern3 = Pattern.compile("([a-h1-8]{2})[ ]([a-h1-8]{2})[ ]([a-h1-8]{2})[ ]([a-h1-8]{2})");
			Matcher matcher1 = pattern1.matcher(line);
			Matcher matcher2 = pattern2.matcher(line);
			Matcher matcher3 = pattern3.matcher(line);

			if(matcher1.find())
			{
				//what piece being placed and where
				System.out.println(PieceColor.findColor(matcher1.group(2)) + " " + FindPiece.piece(matcher1.group(1)) + " is bing placed at " 
								   + LocationFinder.findLocation(matcher1.group(3)));
			}
			if(matcher3.find())
			{
				//Moving two pieces e.g. castling
				System.out.println("Move " + LocationFinder.findLocation(matcher3.group(1)) + " to " + LocationFinder.findLocation(matcher3.group(2)) + " and move " 
								   + LocationFinder.findLocation(matcher3.group(3)) + " to " + LocationFinder.findLocation(matcher3.group(4)));
			}
			
			else if(matcher2.find())
			{
				//Moving one piece from one location to another
				if(matcher2.group(3).equals(""))
					System.out.println("Move " + LocationFinder.findLocation(matcher2.group(1)) + " to " + LocationFinder.findLocation(matcher2.group(2)));
				else
					System.out.println("Move " + LocationFinder.findLocation(matcher2.group(1)) + " to capture " + LocationFinder.findLocation(matcher2.group(2)));
			}
			
		}
		buff.close();
	}

	/**
	 * @author dmaldonado
	 *
	 */
	public static class FindPiece
	{
		static String match1;
		static String piece;

		/**
		 * @param match1
		 * @return
		 * find out what piece the chess notation is refering to
		 */
		public static String piece(String match1)
		{
			FindPiece.match1 = match1;
			if(match1.equals("r"))
				piece = "rook";

			if(match1.equals("n"))
				piece = "knight";

			if(match1.equals("k"))
				piece = "king";

			if(match1.equals("b"))
				piece = "bishop";

			if(match1.equals("p"))
				piece = "pawn";

			if(match1.equals("q"))
				piece = "queen";


			return piece;
		}
	}

	/**
	 * @author dmaldonado
	 *
	 */
	public static class PieceColor
	{
		static String color;
		
		/**
		 * @param color
		 * @return
		 * finds what color the piece is based on the chess notation
		 */
		public static String findColor(String color)
		{
			if(color.equals("l"))
				PieceColor.color = "White";

			if(color.equals("d"))
				PieceColor.color = "Black";

			return PieceColor.color;
		}
	}

	/**
	 * @author dmaldonado
	 *
	 */
	public static class LocationFinder
	{
		static String location;
		
		/**
		 * @param coordinates
		 * @return
		 * finds the location of a piece based on the location. Note, the location may be the start or end location
		 */
		public static String findLocation(String coordinates)
		{
			location = coordinates;
			return location;
		}
	}
}