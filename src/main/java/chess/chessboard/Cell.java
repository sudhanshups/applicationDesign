package chess.chessboard;

import chess.chessman.Chessman;

public class Cell {

	Colour colour;
	String position;
	Chessman chessman;

	public Cell(Colour colour, String position, Chessman chessman) {
		super();
		this.colour = colour;
		this.position = position;
		this.chessman = chessman;
	}

	@Override
	public String toString() {
		return "Cell [color=" + colour + ", position=" + position + ", chess.chessman=" + chessman + "]";
	}

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

	public boolean available(Chessman chessman2) {
		if (chessman.getColor() == chessman2.getColor()) {
			return false;
		}
		return true;
	}

	/**
	 * @return the color
	 */
	public Colour getColor() {
		return colour;
	}

	/**
	 * @param colour
	 *            the color to set
	 */
	public void setColor(Colour colour) {
		this.colour = colour;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the chess.chessman
	 */
	public Chessman getChessman() {
		return chessman;
	}

	/**
	 * @param chessman
	 *            the chess.chessman to set
	 */
	public void setChessman(Chessman chessman) {
		this.chessman = chessman;
	}

}
