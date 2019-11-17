package chessLatest.chessboard;

import chessLatest.chessman.*;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * 8 7 6
 * 1 a b c d e f g h
 */
public class ChessBoard {
    final static Logger logger = Logger.getLogger(ChessBoard.class);
    static int[] ROW = {8, 7, 6, 5, 4, 3, 2, 1};
    static char[] COLOUMN = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    ArrayList<List<Cell>> grid;
    History history;
    Color turn;

    public ChessBoard() {
        grid = new ArrayList<>();
        history = new History(this,new LinkedList<>());
        turn = Color.WHITE;

        // cells.add(Arrays.asList(1, 2, 3));
        for (int i : ROW) {
            List<Cell> cellRow = new ArrayList<>();
            for (char j : COLOUMN) {
                Colour c;
                int x = i + Character.getNumericValue(j) - Character.getNumericValue('a');
                logger.info(" i=" + i + " j=" + j + "  x=" + x);
                if (x % 2 != 0)
                    c = Colour.BLACK;
                else
                    c = Colour.WHITE;

                Chessman chessman = placeChessman(new Point(i, j));
                cellRow.add(new Cell(c, chessman));
            }
            grid.add(cellRow);
        }
    }

    public void printChessBoard() {
        for (int i = 0; i < ROW.length; i++) {
            for (int j = 0; j < COLOUMN.length; j++) {
                Cell c = grid.get(i).get(j);
                if (j == 0)
                    System.out.print(ROW[i]);
                c.draw();
            }
            if (i == grid.size() - 1) {
                System.out.println();
                System.out.print(" ");
                for (int j = 0; j < COLOUMN.length; j++) {
                    System.out.print("   " + COLOUMN[j] + "   ");
                }
            }

            System.out.println();
            System.out.println("==========================================================");

        }
    }

    public Chessman getChessmanAt(Point p) {
        return grid.get(ROW.length - p.getX()).get(IntStream.range(0, COLOUMN.length)
                .filter(i -> p.getY() == COLOUMN[i])
                .findFirst().orElse(-1)).getChessman();
    }

    void placeChessmanAt(Chessman chessman, Point pt) {
        // place piece p at location pt
    }

    // this will be called by the chessman after the checking if move is possible of not.
    void move(Point p1, Point p2) {

    }

    // this will be called by the chessman after the checking if move is possible of not.
    void Move(Point p1, Point p2, Point ep) {
        // move piece at p1 to p2, remembering space that was jumped over
    }


    //this will be called from outside.
    void TryToMove(Point p1, Point p2) {

    }


    private Chessman placeChessman(Point pos) {

        int x = pos.getX();
        char y = pos.getY();

        if (x > 2 && x < 7) {
            return null;
        } else if (x == 7) {
            return new Pawn(pos, Colour.BLACK, this);
        } else if (x == 2) {
            return new Pawn(pos, Colour.WHITE, this);
        } else if (x == 1) {
            if (y == 'a' || y == 'h')
                return new Rook(pos, Colour.WHITE, this);
            else if (y == 'b' || y == 'g')
                return new Knight(pos, Colour.WHITE, this);
            else if (y == 'c' || y == 'f')
                return new Bishop(pos, Colour.WHITE, this);
            else if (y == 'd')
                return new King(pos, Colour.WHITE, this);
            else
                return new Queen(pos, Colour.WHITE, this);
        } else {
            if (y == 'a' || y == 'h')
                return new Rook(pos, Colour.BLACK, this);
            else if (y == 'b' || y == 'g')
                return new Knight(pos, Colour.BLACK, this);
            else if (y == 'c' || y == 'f')
                return new Bishop(pos, Colour.BLACK, this);
            else if (y == 'd')
                return new King(pos, Colour.BLACK, this);
            else
                return new Queen(pos, Colour.BLACK, this);
        }
    }
}
