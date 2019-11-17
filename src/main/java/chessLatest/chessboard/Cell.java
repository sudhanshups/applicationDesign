package chessLatest.chessboard;

import chessLatest.chessman.Chessman;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {

    Colour colour;
    Chessman chessman;


    void draw() {
        String s = "";// position;
        if (colour == Colour.WHITE)
            s += "W ";
        else
            s += "B ";
        if (chessman != null) {
            s += chessman.getSymbol();
        } else {
            s += " ";
        }
        System.out.print("| " + s + " |");
    }

/*	public boolean available(Chessman chessman2) {
		if (chessman.getColor() == chessman2.getColor()) {
			return false;
		}
		return true;
	}*/

}
