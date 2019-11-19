package chessLatest.chessman;

import chessLatest.chessboard.ChessBoard;
import chessLatest.chessboard.Colour;
import chessLatest.chessboard.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pawn extends Chessman {

    final String name = "Pawn";
    final char Symbol = 'P';

    public Pawn(Point position, Colour colour, ChessBoard chessBoard) {
        super(position, colour, chessBoard);
    }

    @Override
    protected MoveType canMove(Point p) {
        return null;
    }

    @Override
    public void TryToMove(Point p) {
        MoveType moveType = canMove(p);
        getChessBoard().placeChessmanAt(this,p);
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
