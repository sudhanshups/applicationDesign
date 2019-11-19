package ticTacToe;

public interface Rule {
    boolean run(Board board);
}

class InProgressRule implements Rule{
    @Override
    public boolean run(Board board) {
        return true;
    }
}