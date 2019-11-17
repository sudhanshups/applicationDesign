package chessLatest.chessman;

import chessLatest.chessboard.ChessBoard;
import chessLatest.chessboard.Colour;
import chessLatest.chessboard.Point;
import lombok.Data;

@Data
public class Bishop extends Chessman {

    final String name = "Bishop";
    final char Symbol = 'B';

    public Bishop(Point position, Colour colour, ChessBoard chessBoard) {
        super(position, colour, chessBoard);
    }

    @Override
    protected MoveType canMove(Point p) {
        return null;
    }

    @Override
    void TryToMove(Point p) {

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
