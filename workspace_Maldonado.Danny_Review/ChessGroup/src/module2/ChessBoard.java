package module2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import christian.chess.tile.Tile;
import christian.chess.pieces.Pawn;
import christian.chess.pieces.Rook;
import christian.chess.pieces.Bishop;
import christian.chess.pieces.Knight;
import christian.chess.pieces.King;
import christian.chess.pieces.Queen;
import module1.ChessDriver;
import module1.ChessIO;
import module1.ChessPiece;
import module1.ChessPieces;

@SuppressWarnings("serial")
public class ChessBoard extends JFrame {

	// Initialize variables
	private Image whiteTile;
	private Image darkTile;
	private Tile[][] newBaseBoard;
	private final int BOARD_SQUARES = 64;
	private final int BOARD_SIZE = 700;
	private final int BOARD_LENGTH = 8;    
	// Initialize components
	private JPanel boardPanel = new JPanel();
	private JPanel columnPanel = new JPanel();
	private JPanel rowPanel = new JPanel();    
	// Initialize arrays to hold panels and images of the board
	public JLabel[] jLabels = new JLabel[BOARD_SQUARES];
	private ImagePanel[] imgPanels = new ImagePanel[BOARD_SQUARES];
	int spaceCounter;
	private String spaceName;
	
	ChessIO chess = new ChessIO();
	ChessDriver driver = new ChessDriver();

	//Creates a 2D tile array to hold the pieces, like an actual board
	public ChessBoard() {
		newBaseBoard = new Tile[BOARD_LENGTH][BOARD_LENGTH];
	}

	// Constructor to set up the chess board.
	public ChessBoard(Image whiteBlock, Image darkBlock) {
		this.whiteTile = whiteBlock;
		this.darkTile = darkBlock;

		createAndShowGUI();
	}

	/**
	 * @return the spaceName
	 */
	public String getSpaceName() {
		return spaceName;
	}

	/**
	 * @param spaceName the spaceName to set
	 */
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	/**
	 * @return the jLabels
	 */
	public JLabel[] getjLabels() {
		return jLabels;
	}

	/**
	 *  Creates the board GUI
	 */
	private void createAndShowGUI() {
		setTitle("Chess board - Tyler Howes");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addComponentsToPanel(getContentPane());

		setSize(BOARD_SIZE, BOARD_SIZE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Adds all the necessary components to the content pane of the JFrame.
	 */
	private void addComponentsToPanel(Container contentPanel) {

		GridLayout boardLayout = new GridLayout(BOARD_LENGTH, BOARD_LENGTH);
		boardPanel.setLayout(boardLayout);

		// Call method to add labels to south (column) panel
		addLabelsToColumnPanel();
		// Call method to add panels to west (row) panel
		addLabelsToRowPanel();
		// Call method to add panels and labels to the center panel which holds the board
		addPanelsAndLabels();
		// Add all panels to frame
		contentPanel.add(boardPanel, BorderLayout.CENTER);
		contentPanel.add(columnPanel, BorderLayout.SOUTH);
		contentPanel.add(rowPanel, BorderLayout.WEST);
	}

	// Adds column labels to the column panel at bottom of board
	private void addLabelsToColumnPanel() {
		GridLayout gridLayout = new GridLayout(0, BOARD_LENGTH);

		columnPanel.setLayout(gridLayout);
		JLabel[] cLabels = new JLabel[BOARD_LENGTH];
		String[] label = {"A", "B", "C", "D", "E", "F", "G", "H"};

		for (int i = 0; i < cLabels.length; i++) {
			cLabels[i] = new JLabel(label[i] + "");
			columnPanel.add(cLabels[i]);
		}
	}

	// Adds the # labels to the row panel off the side of the board.
	private void addLabelsToRowPanel() {
		GridLayout gridLayout = new GridLayout(BOARD_LENGTH, 0);

		rowPanel.setLayout(gridLayout);
		JLabel[] rLables = new JLabel[BOARD_LENGTH];
		int[] num = {8, 7, 6, 5, 4, 3, 2, 1};

		for (int i = 0; i < rLables.length; i++) {
			rLables[i] = new JLabel(num[i] + "");
			rowPanel.add(rLables[i]);
		}
	}

	private void addPanelsAndLabels() {
		// Creates panels with background images and appropriate names
		addPanelsAndImages();

		for (spaceCounter = 0; spaceCounter < imgPanels.length; spaceCounter++) 
		{
			jLabels[spaceCounter] = new JLabel();
			jLabels[spaceCounter].addMouseListener(new PieceClicked(spaceCounter)); //TODO
			//used to know the position of the label on the board
			jLabels[spaceCounter].setName(imgPanels[spaceCounter].getName());

			imgPanels[spaceCounter].add(jLabels[spaceCounter]);

			//adds panels created in addPanelsAndImages()
			boardPanel.add(imgPanels[spaceCounter]);
			toString();
		}
	}
	
	public String toString()
	{
		return jLabels[spaceCounter].getName();
	}

	// Create panels with background images of chess board and set its name according to 1-8 for rows and A-H for columns
	private void addPanelsAndImages() {
		int count = 0;
		String[] label = {"a", "b", "c", "d", "e", "f", "g", "h"};
		int[] num = {8, 7, 6, 5, 4, 3, 2, 1};

		// Draws the 64 panels in alternating colors
		for (int row = 0; row < BOARD_LENGTH; row++) {
			for (int col = 0; col < BOARD_LENGTH; col++) {
				// even numbers get white pieces
				if ((col + row) % 2 == 0) {		
					imgPanels[count] = new ImagePanel(whiteTile);
					imgPanels[count].addMouseListener(new SpaceClicked(count)); //TODO
				}
				// odd numbers get black pieces
				else {						
					imgPanels[count] = new ImagePanel(darkTile);
					imgPanels[count].addMouseListener(new SpaceClicked(count));
				}

				imgPanels[count++].setName(label[col] + num[row]);
			}
		}
	}

	/**
	 * Sets image of a label at a certain position on the board according to the block name i.e D4 
	 * @param img - the image of the piece.
	 * @param pieceLoc - the location of the block or tile on the board.
	 */
	public void drawPieceIcon(ImageIcon img, String pieceLoc) {
		for (int s = 0; s < jLabels.length; s++) {
			if (jLabels[s].getName().equalsIgnoreCase(pieceLoc)) {
				jLabels[s].setIcon(img);
			}
		}
	}

	public void removePieceIcon(String pieceLoc) {
		for (int s = 0; s < jLabels.length; s++) {
			if (jLabels[s].getName().equalsIgnoreCase(pieceLoc)) {
				jLabels[s].setIcon(null);
			}
		}
	}

	public void movePiece(String startLoc, String endLoc, ChessPieces container) {    	    	
		for(int i = 0; i < container.getLength(); i++) {
			ChessPiece currentPiece = container.getPiece(i);

			if (currentPiece.getLocation().equals(startLoc)) {

				if(!isPieceAtLoc(endLoc, container)) {
					removePieceIcon(startLoc);
					currentPiece.setLocation(endLoc);
					drawPieceIcon(currentPiece.getImageIcon(), currentPiece.getLocation());
					System.out.println("The Piece at " + startLoc + " was moved to " + endLoc);
				}

				if(isPieceAtLoc(endLoc, container) && isPieceAtEndLocIsOpColor(currentPiece, container, endLoc)) {
					removePieceIcon(startLoc);
					removePieceIcon(endLoc);
					container.overWritePieceInContainer(container, endLoc, currentPiece);
					currentPiece.setLocation(endLoc);
					drawPieceIcon(currentPiece.getImageIcon(), currentPiece.getLocation());	
					System.out.print("The Piece at " + startLoc + " was moved to " + endLoc);
					System.err.println(" and captured the piece there.");
				}

			}
		}

	}

	public boolean isPieceAtEndLocIsOpColor(ChessPiece piece, ChessPieces container, String endLoc) {
		boolean pieceAtEndLocIsOpColor = false;

		for(int i = 0; i < container.getLength(); i++) {
			if (container.getPiece(i).getLocation().equals(endLoc) && container.getPiece(i).getColor() != piece.getColor())
				pieceAtEndLocIsOpColor = true;
		}

		return pieceAtEndLocIsOpColor;
	}


	public boolean isPieceAtLoc(String endLoc, ChessPieces container) {
		boolean isAtLoc = false;

		for(int j = 0; j < container.getLength(); j++) {
			ChessPiece currentPiece = container.getPiece(j);

			if (currentPiece.getLocation().equals(endLoc))
				isAtLoc = true;
		}    	
		return isAtLoc;
	}

	/*
	 * Starts creating the components of the 2D board
	 */
	public void createBaseBoard() {
		createBaseBoardPawns();
		createBaseBoardSpecialPieces();
		printBoard();
	}

	/*
	 * Creates pawns on the board
	 */
	public void createBaseBoardPawns() {
		final int DARK_PAWN_ROW = 6;
		final int LIGHT_PAWN_ROW = 1;

		//Fill board with pawns
		//Hint, if in doubt, it's probably the way you placed the pawns and special pieces
		for(int i = 0; i < BOARD_LENGTH; i++) {
			newBaseBoard[i][LIGHT_PAWN_ROW] = new Tile(new Pawn("P", "l"));
		}
		for(int i = 0; i < BOARD_LENGTH; i++) {
			newBaseBoard[i][DARK_PAWN_ROW] = new Tile(new Pawn("P", "d"));
		}
	}

	/*
	 * Creates special pieces on the board
	 */
	public void createBaseBoardSpecialPieces() {
		//Represents the row in which special pieces will be placed
		final int DARK_SPECIAL_ROW = 0;
		final int LIGHT_SPECIAL_ROW = 7;

		//Rooks
		newBaseBoard[0][DARK_SPECIAL_ROW] = new Tile(new Rook("R", "d"));
		newBaseBoard[7][DARK_SPECIAL_ROW] = new Tile(new Rook("R", "d"));
		newBaseBoard[0][LIGHT_SPECIAL_ROW] = new Tile(new Rook("R", "l"));
		newBaseBoard[7][LIGHT_SPECIAL_ROW] = new Tile(new Rook("R", "l"));

		//Knights
		newBaseBoard[1][DARK_SPECIAL_ROW] = new Tile(new Knight("N", "d"));
		newBaseBoard[6][DARK_SPECIAL_ROW] = new Tile(new Knight("N", "d"));
		newBaseBoard[1][LIGHT_SPECIAL_ROW] = new Tile(new Knight("N", "l"));
		newBaseBoard[6][LIGHT_SPECIAL_ROW] = new Tile(new Knight("N", "l"));

		//Bishops
		newBaseBoard[2][DARK_SPECIAL_ROW] = new Tile(new Bishop("B", "d"));
		newBaseBoard[5][DARK_SPECIAL_ROW] = new Tile(new Bishop("B", "d"));
		newBaseBoard[2][LIGHT_SPECIAL_ROW] = new Tile(new Bishop("B", "l"));
		newBaseBoard[5][LIGHT_SPECIAL_ROW] = new Tile(new Bishop("B", "l"));

		//Queens
		newBaseBoard[3][DARK_SPECIAL_ROW] = new Tile(new Queen("Q", "d"));
		newBaseBoard[3][LIGHT_SPECIAL_ROW] = new Tile(new Queen("Q", "l"));

		//Kings
		newBaseBoard[4][DARK_SPECIAL_ROW] = new Tile(new King("K", "d"));
		newBaseBoard[4][LIGHT_SPECIAL_ROW] = new Tile(new King("K", "l"));
	}

	/*
	 * Prints out board in the console
	 */
	public void printBoard() {
		for (int i = 0; i < BOARD_LENGTH; i++) {
			// Prints out the numbers on the side of the board to signify one of the axes
			System.out.print(i + 1 + "      ");
			for (int j = 0; j < BOARD_LENGTH; j++) {
				if (newBaseBoard[j][i] != null) {
					// If the element isn't null, check the type of the piece in the array, and print it out
					System.out.print(newBaseBoard[j][i].checkName() + "  ");

				} else {
					// Else if the element is null, print x instead to signify an empty space
					System.out.print("x   ");
				}
			}
			System.out.println("");
		}
		// Prints out the other axis of the board on the bottom of the board
		System.out.println("\n       a   b   c   d   e   f   g   h");
		System.out.println("\n\n");
	}

	public int getBOARD_SQUARES() {
		return BOARD_SQUARES;
	}


	public int getBOARD_SIZE() {
		return BOARD_SIZE;
	}


	public int getBOARD_LENGTH() {
		return BOARD_LENGTH;
	}


	// Nested class used to set the background of frame contentPanel
	class ImagePanel extends JPanel {

		private Image image;

		/**
		 * Default constructor used to set the image for the background for the
		 * instance
		 */
		public ImagePanel(Image img) {
			image = img;
		}

		@Override
		protected void paintComponent(Graphics g) {
			//draws image to background to scale of frame
			g.drawImage(image, 0, 0, null);
		}
	}

	public class PieceClicked implements MouseListener
	{
		int counter = 1;
		int space;
		public PieceClicked(int spaceCounter) 
		{
			space = spaceCounter;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) //TODO
		{
			setSpaceName(jLabels[space].getName());
			System.out.println(chess.getPieceByLoc(getSpaceName()).getName());
			System.out.println(chess.listAvailableMoves(chess.getPieceByLoc(getSpaceName()), driver.board, chess.playerTurn));
		}

		@Override
		public void mouseEntered(MouseEvent arg0) 
		{
//			System.out.println("entered " + counter);
//			counter++;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}
	}
	
	public class SpaceClicked implements MouseListener
	{
		int counter = 1;
		int space;
		public SpaceClicked(int spaceCounter) 
		{
			space = spaceCounter;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			System.out.println(jLabels[space].getName()); //TODO
		}

		@Override
		public void mouseEntered(MouseEvent arg0) 
		{
//			System.out.println("entered " + counter);
//			counter++;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}
	}
}
