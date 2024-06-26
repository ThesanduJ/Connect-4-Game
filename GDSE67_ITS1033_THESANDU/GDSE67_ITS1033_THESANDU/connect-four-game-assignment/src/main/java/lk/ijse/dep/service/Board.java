package lk.ijse.dep.service;

public interface Board {
    int NUM_OF_ROWS = 5;
    int NUM_OF_COLS = 6;

    public int findNextAvailableSpot(int col);

    public boolean isLegalMove(int col);

    public void updateMove(int col, Piece piece);

    public BoardUI getBoardUI();

    public void updateMove(int col, int row, Piece move);

    public Winner findWinner();

    public boolean existLegalMoves();

}
