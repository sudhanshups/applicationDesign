package chess.chessman;

import chess.chessboard.Colour;

public abstract class Chessman {
	private Colour colour;
	String position;

	public abstract char getSymbol();

	public abstract String getName();

	public Chessman(Colour colour, String position) {
		super();
		this.setColor(colour);
		this.position = position;
	}

	public Colour getColor() {
		return colour;
	}

	public void setColor(Colour colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Chessman [color=" + getColor() + ", position=" + position + "]";
	}

}
