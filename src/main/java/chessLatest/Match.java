package chessLatest;

import chessLatest.chessboard.ChessBoard;
import chessLatest.chessboard.Point;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Match {
	final static Logger logger = Logger.getLogger(Match.class);

	public static void main(String args[]) {
		BasicConfigurator.configure();

		ChessBoard board = new ChessBoard();
		board.printChessBoard();

		Point from = new Point(1,'c');
		Point to = new Point(1,'d');
		board.getChessmanAt(from).TryToMove(to);
	}
}
