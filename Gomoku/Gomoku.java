public class Gomoku {
    private static final int SIZE = 15;
    private static final int WIN_CONDITION = 5;
    private char[][] board;
    private char currentPlayer;

    public Gomoku() {
        board = new char[SIZE][SIZE];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void printBoard() {

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " "); // Print row number at the front
            for (int j = 0; j < SIZE; j++) {
            System.out.print(board[i][j] + " ");
            }
            System.out.println((i + 1)); // Print row number at the end
        }
        System.out.print("  "); // Align column numbers with the board
        for (int j = 0; j < SIZE; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
    }

    public boolean placeMove(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != '.') {
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == currentPlayer) {
                    if (checkDirection(i, j, 1, 0) || // Horizontal
                        checkDirection(i, j, 0, 1) || // Vertical
                        checkDirection(i, j, 1, 1) || // Diagonal \
                        checkDirection(i, j, 1, -1)) { // Diagonal /
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol) {
        int count = 0;
        for (int i = 0; i < WIN_CONDITION; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;
            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && board[newRow][newCol] == currentPlayer) {
                count++;
            } else {
                break;
            }
        }
        return count == WIN_CONDITION;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

}
