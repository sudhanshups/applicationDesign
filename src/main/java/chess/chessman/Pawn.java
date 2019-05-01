package chess.chessman;
import chess.chessboard.Colour;

public class Pawn extends Chessman {

	static final String name="Pawn";
	static final char Symbol='P';
	public Pawn(Colour colour, String position) {
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
		return "Pawn [color=" + getColor() + ", position=" + position + ", toString()=" + super.toString() + "]";
	}
}
