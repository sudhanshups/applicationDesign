package chessLatest.chessman;

import chessLatest.chessboard.ChessBoard;
import chessLatest.chessboard.Colour;
import chessLatest.chessboard.Point;
import lombok.Data;

@Data
public class King extends Chessman {

    final String name = "King";
    final char Symbol = 'K';

    public King(Point position, Colour colour, ChessBoard chessBoard) {
        super(position, colour, chessBoard);
    }


    @Override
    public  MoveType canMove(Point p) {
        return null;
    }

    @Override
    public void TryToMove(Point p) {

    }

    @Override
    public char getSymbol() {
        return Symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
