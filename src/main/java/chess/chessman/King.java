package chess.chessman;
import chess.chessboard.Colour;

public class King extends Chessman {

	static final String name = "King";
	static final char Symbol = 'K';

	public King(Colour colour, String position) {
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
		return "King [color=" + getColor() + ", position=" + position + ", toString()=" + super.toString() + "]";
	}
}
