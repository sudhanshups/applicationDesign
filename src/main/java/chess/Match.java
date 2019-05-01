package chess;

import chess.chessboard.ChessBoard;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Match {
	final static Logger logger = Logger.getLogger(Match.class);

	public static void main(String args[]) {
		BasicConfigurator.configure();

		ChessBoard board = new ChessBoard();
		board.printChessBoard();

// gdfgdfgdfgf
	}
}
