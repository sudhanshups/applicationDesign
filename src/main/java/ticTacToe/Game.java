package ticTacToe;

public class Game {

    public static void main(String args[]) {

        Board board = new Board(3);
        GameState s;
        while (true) {
            if (board.getTurn() == Piece.CROSS) {
                System.out.println("enter cross location");
            } else {
                System.out.println("enter nought location");
            }
            s = board.place(new Point(1, 1));
            if (s != GameState.IN_PROGRESS) {
                break;
            }
        }
        System.out.println("Game status = " + s);

    }
}
