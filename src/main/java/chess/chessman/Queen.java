package chess.chessman;
import chess.chessboard.Colour;

public class Queen extends Chessman {

	static final String name="Queen";
	static final char Symbol='Q';
	public Queen(Colour colour, String position) {
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
		return "Queen [color=" + getColor() + ", position=" + position + ", toString()=" + super.toString() + "]";
	}
}
