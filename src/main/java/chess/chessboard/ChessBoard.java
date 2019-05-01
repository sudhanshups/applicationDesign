package chess.chessboard;
import chess.chessman.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
	/*
	 * 8 7 6
	 * 
	 * 1 a b c d e f g h
	 */
	final static Logger logger = Logger.getLogger(ChessBoard.class);
	static int[] ROW = { 8, 7, 6, 5, 4, 3, 2, 1 };
	static char[] COLOUMN = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	static ArrayList<List<Cell>> cells;

	public ChessBoard() {
		cells = new ArrayList<List<Cell>>();
		// cells.add(Arrays.asList(1, 2, 3));
		for (int i : ROW) {
			List<Cell> cellRow = new ArrayList<Cell>();
			for (char j : COLOUMN) {
				Colour c;
				int x = i + Character.getNumericValue(j) - Character.getNumericValue('a');
				logger.info(" i="+ i + " j="+j +"  x="+x  );
				if (x%2!=0)
					c = Colour.BLACK;
				else
					c = Colour.WHITE;

				String pos = "" + i + j;
				Chessman chessman = getChessman(pos);

				cellRow.add(new Cell(c, pos, chessman));
			}
			cells.add(cellRow);
		}
	}

	public void printChessBoard() {
		for(int i =0;i<cells.size();i++){
			List<Cell> cellRow = cells.get(i); 
			for(int j =0;j<cellRow.size();j++){
				Cell c= cellRow.get(j);
				if(j==0)
					System.out.print(c.position.charAt(0));
				c.draw();
			}
			if(i==cells.size()-1){
				System.out.println();
				System.out.print(" ");
				for(int j =0;j<cellRow.size();j++){
					Cell c= cellRow.get(j);
					System.out.print("   " + c.position.charAt(1)+"   ");	
				}
			}

			System.out.println();
			System.out.println("==========================================================");
		
		}
	}

	private static Chessman getChessman(String pos) {
		char x = pos.charAt(0), y = pos.charAt(1);
		int x_pos = Character.getNumericValue(x);
		
		if (x > '2' && x < '7') {
			return null;
		} else if (x == '7') {
			return new Pawn(Colour.BLACK, pos);
		} else if (x == '2') {
			return new Pawn(Colour.WHITE, pos);
		} else if (x == '1') {
			if (y == 'a' || y == 'h')
				return new Rook(Colour.WHITE, pos);
			else if (y == 'b' || y == 'g')
				return new Knight(Colour.WHITE, pos);
			else if (y == 'c' || y == 'f')
				return new Bishop(Colour.WHITE, pos);
			else if (y == 'd')
				return new King(Colour.WHITE, pos);
			else
				return new Queen(Colour.WHITE, pos);
		} else {
			if (y == 'a' || y == 'h')
				return new Rook(Colour.BLACK, pos);
			else if (y == 'b' || y == 'g')
				return new Knight(Colour.BLACK, pos);
			else if (y == 'c' || y == 'f')
				return new Bishop(Colour.BLACK, pos);
			else if (y == 'd')
				return new King(Colour.BLACK, pos);
			else
				return new Queen(Colour.BLACK, pos);
		}
	}

	static boolean isValidMove(String move) {
		if (move.length() < 5) {
			return false;
		}
		if (move.charAt(0) >= '1' && move.charAt(0) <= '8' && move.charAt(1) >= 'a' && move.charAt(1) <= 'h'
				&& move.charAt(3) >= '1' && move.charAt(3) <= '8' && move.charAt(4) >= 'a' && move.charAt(5) <= 'h') {
			Cell cell1 = cells.get(Character.getNumericValue(move.charAt(0)))
					.get(Character.getNumericValue(move.charAt(1)) - Character.getNumericValue('a'));
			Cell cell2 = cells.get(Character.getNumericValue(move.charAt(3)))
					.get(Character.getNumericValue(move.charAt(4)) - Character.getNumericValue('a'));
			if (cell2.chessman == null || cell2.chessman.getColor() != cell1.chessman.getColor())
				return true;
		}
		return false;
	}

}
