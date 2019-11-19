package chessLatest.chessboard;

import chessLatest.chessman.Chessman;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class History {
    private ChessBoard board;
    List<Activity> history;

    public void addActivity(Activity a) {
        history.add(a);
    }

    void UndoLastMove() {

    }

    void RedoUndoneMove() {

    }
}

class Activity {
    private Point from;
    private Point to;// the point a piece was moved to
    private Chessman killed_piece;// remembers what piece was killed
}
