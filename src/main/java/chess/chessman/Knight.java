package chess.chessman;
import chess.chessboard.Colour;

public class Knight extends Chessman {

	static final String name="Knight";
	static final char Symbol='N';
	public Knight(Colour colour, String position) {
		super(colour, position);
	}
	@Override
	public char getSymbol() {
		return Symbol;
	}

	@Override
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Knight [color=" + getColor() + ", position=" + position + ", toString()=" + super.toString() + "]";
	}
}
