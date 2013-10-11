package module1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationReader
{
	static final String PIECEPLACEMENT = "\\b([a-z])[1-8]?([ld])([a-h][1-8])";
	static final String PIECEMOVEMENT = "\\b([a-h][1-8]?[1-8])[ ]([a-h][1-8])(\\*?)";
	static final String SPECIALPIECEMOVEMENT = "\\b([a-h1-8]{2})[ ]([a-h1-8]{2})[ ]([a-h1-8]{2})[ ]([a-h1-8]{2})";
	static final String CASTLING = "\\b([a-h])[1-8][ ]([a-h])[1-8][ ][a-h1-8]{2}[ ][a-h1-8]{2}\\b";
	public static final String PLACEPIECE = "\\b([a-z][ld])([a-h])([1-8])";
	static final String EMPTY = "";
	public String line = EMPTY; //line represents the line in the file the buffered reader is currently reading 
	static final String ROOK = "r", KNIGHT = "n", KING = "k", BISHOP = "b", PAWN = "p", QUEEN = "q";
	static final String ROOKPIECE = "rook", KNIGHTPIECE = "knight", KINGPIECE = "king", BISHOPPIECE = "bishop", PAWNPIECE = "pawn", QUEENPIECE = "queen";
	public static final int BOARD_SIZE = 8; 
	public static final int PLACEPAWN = 11;
	public static final int PLACEROOK = 12;
	public static final int PLACEKNIGHT = 13;
	public static final int PLACEBISHOP = 14;
	public static final int PLACEQUEEN= 15;
	public static final int PLACEKING = 16;
	public static final int PLACEBLACKPAWN = 18;
	public static final int PLACEBLACKROOK = 19;
	public static final int PLACEBLACKKNIGHT = 20;
	public static final int PLACEBLACKBISHOP = 21;
	public static final int PLACEBLACKQUEEN= 22;
	public static final int PLACEBLACKKING = 23;
	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;
	public static final int F = 5;
	public static final int G = 6;
	public static final int H = 7;
	public static final String AA = "a";
	public static final String BB = "b";
	public static final String CC = "c";
	public static final String DD = "d";
	public static final String EE = "e";
	public static final String FF = "f";
	public static final String GG = "g";
	public static final String HH = "h";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String FIVE = "5";
	public static final String SIX = "6";
	public static final String SEVEN = "7";
	public static final String EIGHT = "8";
	public int board[][];

	/**
	 * constructor
	 * @param args
	 * @throws IOException
	 */
	public InformationReader(String args)
	{
		FileReader chessNotationFile = null;
		try 
		{
			chessNotationFile = new FileReader(args);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("No file found");
		}
		BufferedReader buff = new BufferedReader(chessNotationFile);
		read(buff);
	}

	/**
	 * @param buff
	 * @throws IOException
	 */
	public void read(BufferedReader buff)
	{
		board = new int[BOARD_SIZE][BOARD_SIZE];
		setBoard();
		int counter = 0;
		try 
		{
			while(buff.ready())
			{
				counter++;
				line = buff.readLine();
				Pattern piecePlacement = Pattern.compile(PIECEPLACEMENT);
				Pattern pieceMovement = Pattern.compile(PIECEMOVEMENT);
				Pattern specialPieceMovement = Pattern.compile(SPECIALPIECEMOVEMENT);
				Matcher placement = piecePlacement.matcher(line);
				Matcher movement = pieceMovement.matcher(line);
				Matcher castling = specialPieceMovement.matcher(line);

				//what piece being placed and where
				if(placement.find())
				{
					//System.out.println(findColor(placement.group(2)) + " " + findPieceName(placement.group(1)) + " is bing placed at " + findLocation(placement.group(3)));
					methodRedirection(line);
				}

				//Moving two pieces e.g. castling
				else if(castling.find())
				{
					castling(line);
					System.out.println("Move " + findLocation(castling.group(1)) + " to " + findLocation(castling.group(2)) + " and move " + findLocation(castling.group(3)) 
							+ " to " + findLocation(castling.group(4)));
				}

				//Moving one piece from one location to another
				else if(movement.find())
				{
					if(movement.group(3).equals(EMPTY))
						System.out.println("Move " + findLocation(movement.group(1)) + " to " + findLocation(movement.group(2)));
					else
						System.out.println("Move " + findLocation(movement.group(1)) + " to capture " + findLocation(movement.group(2)));
				}

				else
				{
					System.err.println("Invalid entry at line "+counter+": " + line);
				}

			}
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				buff.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	/**
	 * find out what piece the chess notation is referring to
	 * @param match1
	 * @return a string representation of the chess piece
	 */
	public String findPieceName(String match)
	{
		String match1;
		String piece = null;
		match1 = match;

		//finds what piece the chess notation is refering to using the regex group given to it.
		if(match1.equals(ROOK))
			piece = ROOKPIECE;

		else if(match1.equals(KNIGHT))
			piece = KNIGHTPIECE;

		else if(match1.equals(KING))
			piece = KINGPIECE;

		else if(match1.equals(BISHOP))
			piece = BISHOPPIECE;

		else if(match1.equals(PAWN))
			piece = PAWNPIECE;

		else if(match1.equals(QUEEN))
			piece = QUEENPIECE;


		return piece;
	}


	/**
	 * finds the location of a piece based on the location. Note, the location may be the start or end location
	 * @param coordinates
	 * @return a string representation of the board location
	 */
	public String findLocation(String coordinates)
	{
		String location = coordinates;
		return location;
	}

	/**
	 * finds what color the piece is based on the chess notation
	 * @param color as chess piece color
	 * @return a string representation of the color
	 */
	public String findColor(String fileRepColor)
	{
		String color = null;
		String white = "l", black = "d";
		if(fileRepColor.equals(white))
			color = "White";

		else if(fileRepColor.equals(black))
			color = "Black";

		return color;
	}


	/**
	 * This method figures out if the castling is queenside or kingside
	 * @param token
	 */
	public void castling(String token)
	{
		Pattern castling = Pattern.compile(CASTLING);
		Matcher Castling = castling.matcher(token);
		int queenside = -2, kingside = -1;
		if(Castling.find())
		{
			int value = Castling.group(1).charAt(0) - Castling.group(2).charAt(0);

			if(value == kingside)
			{
				System.out.print("King side castling: ");
			}

			else if(value == queenside)
			{
				System.out.print("Queen side castling: ");
			}
		}
	}

	/**
	 * The message that is printed out when the file ends
	 */
	public void end()
	{
		System.out.println("There is no more information to parse.");
	}

	/**
	 * This method takes the line from the file, and using grouping determines which row the piece belongs in
	 * @param line
	 */
	public void methodRedirection(String line)
	{
		Pattern pieceLocation = Pattern.compile(PLACEPIECE);
		Matcher methodToPlacePiece = pieceLocation.matcher(line);
		if(methodToPlacePiece.find())
		{
			if(methodToPlacePiece.group(2).equals(ONE))
			{
				placeFirstRow();
			}
			
			else if(methodToPlacePiece.group(2).equals(TWO))
			{
				placeSecondRow();
			}
			
			else if(methodToPlacePiece.group(2).equals(SEVEN))
			{
				placeSeventhRow();
			}
			
			else if(methodToPlacePiece.group(2).equals(EIGHT))
			{
				placeEightRow();
			}
		}
	}

	/**
	 * places the pieces in the first row
	 */
	public void placeFirstRow()
	{
		Pattern pieceLocation = Pattern.compile(PLACEPIECE);
		Matcher placePiece = pieceLocation.matcher(line);
		if(placePiece.find())
		{
			if(placePiece.group(1).equals(AA))
			{
				board[A][A] = PLACEBLACKROOK;
			}

			else if(placePiece.group(1).equals(BB))
			{
				board[A][B] = PLACEBLACKKNIGHT;
			}
			
			else if(placePiece.group(1).equals(CC))
			{
				board[A][C] = PLACEBLACKBISHOP;
			}
			
			else if(placePiece.group(1).equals(DD))
			{
				board[A][D] = PLACEBLACKQUEEN;
			}
			
			else if(placePiece.group(1).equals(EE))
			{
				board[A][E] = PLACEBLACKKING;
			}
			
			else if(placePiece.group(1).equals(FF))
			{
				board[A][F] = PLACEBLACKBISHOP;
			}
			
			else if(placePiece.group(1).equals(GG))
			{
				board[A][G] = PLACEBLACKKNIGHT;
			}
			
			else if(placePiece.group(1).equals(HH))
			{
				board[A][H] = PLACEBLACKROOK;
			}
		}
	}
	
	/**
	 * places the pieces in the second row
	 */
	public void placeSecondRow()
	{
		for(int counter = 0; counter < BOARD_SIZE; counter++)
		{
			board[B][counter] = PLACEBLACKPAWN;
		}
	}
	
	/**
	 * places the pieces in the seventh row
	 */
	public void placeSeventhRow()
	{
		for(int counter = 0; counter < BOARD_SIZE; counter++)
		{
			board[G][counter] = PLACEPAWN;
		}
	}
	
	/**
	 * places the pieces in the eight row
	 */
	public void placeEightRow()
	{
		Pattern pieceLocation = Pattern.compile(PLACEPIECE);
		Matcher placePiece = pieceLocation.matcher(line);
		if(placePiece.find())
		{
			if(placePiece.group(1).equals(AA))
			{
				board[H][A] = PLACEROOK;
			}
			
			else if(placePiece.group(1).equals(BB))
			{
				board[H][B] = PLACEKNIGHT;
			}
			
			else if(placePiece.group(1).equals(CC))
			{
				board[H][C] = PLACEBISHOP;
			}
			
			else if(placePiece.group(1).equals(DD))
			{
				board[H][D] = PLACEQUEEN;
			}
			
			else if(placePiece.group(1).equals(EE))
			{
				board[H][E] = PLACEKING;
			}
			
			else if(placePiece.group(1).equals(FF))
			{
				board[H][F] = PLACEBISHOP;
			}
			
			else if(placePiece.group(1).equals(GG))
			{
				board[H][G] = PLACEKNIGHT;
			}
			
			else if(placePiece.group(1).equals(HH))
			{
				board[H][H] = PLACEROOK;
			}
		}
	}

	
	/**
	 * Set the board to 10
	 */
	public void setBoard()
	{
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			System.out.println("");

			for (int j = 0; j < BOARD_SIZE; j++)
			{
				board [i][j] = 10;
			}
		}
	}
	
	/**
	 * displays current board
	 */
	public void displayBoard()
	{
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			System.out.println("");

			for (int j = 0; j < BOARD_SIZE; j++)
			{
				System.out.print(board [i][j] + " ");
			}
		}
	}
}