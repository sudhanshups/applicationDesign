package chessLatest.chessman;

import chessLatest.chessboard.ChessBoard;
import chessLatest.chessboard.Colour;
import chessLatest.chessboard.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Chessman {
    private Point position;
    private Colour colour;
    private ChessBoard chessBoard;

    abstract public MoveType canMove(Point p);

    abstract public void TryToMove(Point p);

    public abstract char getSymbol();

    public abstract String getName();
}
