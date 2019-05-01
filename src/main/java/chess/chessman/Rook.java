package chess.chessman;
import chess.chessboard.Colour;

public class Rook extends Chessman {

	static final String name = "Rook";
	static final char Symbol = 'R';

	public Rook(Colour colour, String position) {
		super(colour, position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rook [color=" + getColor() + ", position=" + position + ", toString()=" + super.toString() + "]";
	}

	@Override
	public char getSymbol() {
		return Symbol;
	}

	@Override
	public String getName() {
		return name;
	}

}
