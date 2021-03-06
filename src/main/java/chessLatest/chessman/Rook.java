package chessLatest.chessman;

import chessLatest.chessboard.ChessBoard;
import chessLatest.chessboard.Colour;
import chessLatest.chessboard.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rook extends Chessman {

    final String name = "Rook";
    final char Symbol = 'R';

    public Rook(Point position, Colour colour, ChessBoard chessBoard) {
        super(position, colour, chessBoard);
    }


    @Override
    protected MoveType canMove(Point p) {
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
