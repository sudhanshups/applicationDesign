package chessLatest.chessboard;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Point {
    /*    static int[] ROW = { 8, 7, 6, 5, 4, 3, 2, 1 };
        static char[] COLOUMN = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };*/
    private int x;
    private char y;
}
