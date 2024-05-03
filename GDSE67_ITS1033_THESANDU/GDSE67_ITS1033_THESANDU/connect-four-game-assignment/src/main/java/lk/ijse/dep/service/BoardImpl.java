package lk.ijse.dep.service;


public class BoardImpl implements Board {

    private static final Piece[][] pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    public static Piece[][] getPieces() {
        return pieces;
    }

    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < 5; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        return findNextAvailableSpot(col) != -1;
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        for (int i = 0; i < 5; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                pieces[col][i] = move;
                break;
            }
        }
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {
        Winner win;

        for (int i = 0; i < 5; i++) {
            if (pieces[0][i] == Piece.GREEN && pieces[1][i] == Piece.GREEN && pieces[2][i] == Piece.GREEN && pieces[3][i] == Piece.GREEN) {
                return win = new Winner(Piece.GREEN, i, i, 0, 3);
            } else if (pieces[1][i] == Piece.GREEN && pieces[2][i] == Piece.GREEN && pieces[3][i] == Piece.GREEN && pieces[4][i] == Piece.GREEN) {
                return win = new Winner(Piece.GREEN, i, i, 1, 4);
            } else if (pieces[2][i] == Piece.GREEN && pieces[3][i] == Piece.GREEN && pieces[4][i] == Piece.GREEN && pieces[5][i] == Piece.GREEN) {
                return win = new Winner(Piece.GREEN, i, i, 2, 5);
            } else if (pieces[0][i] == Piece.BLUE && pieces[1][i] == Piece.BLUE && pieces[2][i] == Piece.BLUE && pieces[3][i] == Piece.BLUE) {
                return win = new Winner(Piece.BLUE, i, i, 0, 3);
            } else if (pieces[1][i] == Piece.BLUE && pieces[2][i] == Piece.BLUE && pieces[3][i] == Piece.BLUE && pieces[4][i] == Piece.BLUE) {
                return win = new Winner(Piece.BLUE, i, i, 1, 4);
            } else if (pieces[2][i] == Piece.BLUE && pieces[3][i] == Piece.BLUE && pieces[4][i] == Piece.BLUE && pieces[5][i] == Piece.BLUE) {
                return win = new Winner(Piece.BLUE, i, i, 2, 5);
            }
        }
        for (int i = 0; i < 6; i++) {
            if (pieces[i][0] == Piece.GREEN && pieces[i][1] == Piece.GREEN && pieces[i][2] == Piece.GREEN && pieces[i][3] == Piece.GREEN) {
                return win = new Winner(Piece.GREEN, 0, 3, i, i);
            } else if (pieces[i][1] == Piece.GREEN && pieces[i][2] == Piece.GREEN && pieces[i][3] == Piece.GREEN && pieces[i][4] == Piece.GREEN) {
                return win = new Winner(Piece.GREEN, 1, 4, i, i);
            } else if (pieces[i][0] == Piece.BLUE && pieces[i][1] == Piece.BLUE && pieces[i][2] == Piece.BLUE && pieces[i][3] == Piece.BLUE) {
                return win = new Winner(Piece.BLUE, 0, 3, i, i);
            } else if (pieces[i][1] == Piece.BLUE && pieces[i][2] == Piece.BLUE && pieces[i][3] == Piece.BLUE && pieces[i][4] == Piece.BLUE) {
                return win = new Winner(Piece.BLUE, 1, 4, i, i);
            }
        }
        return null;
    }
}
