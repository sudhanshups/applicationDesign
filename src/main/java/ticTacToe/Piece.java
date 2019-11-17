package ticTacToe;


import lombok.AllArgsConstructor;
import lombok.Data;

enum Piece {
    CROSS, NOUGHT
}

enum GameState {
    CROSS_WON, NOUGHT_WON, DRAW, IN_PROGRESS
}

enum CellState {
    OCCUPIED, FREE
}

@Data
class Cell {
    private Piece piece;
    private CellState cellState;
}

@Data
class Board {
    private Cell[][] grid;
    private GameState gameState;
    private Piece turn;
    Board(int size){
        grid = new Cell[size][size];
        turn = Piece.CROSS;
        gameState = GameState.IN_PROGRESS;
    }
    Piece getTurn(){
        return turn;
    }

    GameState place(Point p) {
        checkValidMove(p);
        grid[p.getX()][p.getY()].setPiece(turn);
        grid[p.getX()][p.getY()].setCellState(CellState.OCCUPIED);

        GameState state = checkStatus();
        if (state == GameState.IN_PROGRESS) {
            turn = turn == Piece.CROSS ? Piece.NOUGHT : Piece.CROSS;
        }
        return gameState;
    }

    private void checkValidMove(Point p ){

    }
    private GameState checkStatus() {
        return GameState.IN_PROGRESS;
    }
}


@AllArgsConstructor
@Data
class Point {
    private int x;
    private int y;
}
