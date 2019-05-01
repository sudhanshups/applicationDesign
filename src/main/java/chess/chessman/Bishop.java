package chess.chessman;
import chess.chessboard.Colour;

public class Bishop extends Chessman{

	static final String name="Bishop";
	static final char Symbol='B';
	public Bishop(Colour colour, String position) {
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
		return "Bishop [color=" + getColor() + ", position=" + position + ", toString()=" + super.toString() + "]";
	}
}
