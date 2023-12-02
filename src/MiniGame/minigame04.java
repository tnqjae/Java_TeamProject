package minigamefile;
import java.util.Scanner;
public class minigame04 { ///한붓그리기 (그릴 수가 없어요...뭔가 웹프 처럼 그릴 수 있는 창을 열어야 할거 같은데 거기까지는 모르겠어요..
    private char[][] board;
    private char currentPlayer;

    public minigame04(int boardSize) {
        board = new char[boardSize][boardSize];
        currentPlayer = 'X';

        // Initialize the board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-".repeat(board.length * 2 - 1));
            }
        }
        System.out.println();
    }

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        } else {
            return false;
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < board.length; i++) {
            if (checkLine(board[i]) || checkLine(getColumn(i))) {
                return true;
            }
        }

        if (checkLine(getDiagonal()) || checkLine(getAntiDiagonal())) {
            return true;
        }

        return false;
    }

    private char[] getColumn(int col) {
        char[] column = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    private char[] getDiagonal() {
        char[] diagonal = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }

    private char[] getAntiDiagonal() {
        char[] antiDiagonal = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            antiDiagonal[i] = board[i][board.length - 1 - i];
        }
        return antiDiagonal;
    }

    private boolean checkLine(char[] line) {
        for (char c : line) {
            if (c != currentPlayer) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (e.g., 3 for a 3x3 board): ");
        int boardSize = scanner.nextInt();

        minigame04 game = new minigame04(boardSize);

        while (true) {
            game.printBoard();

            System.out.print("Player " + game.currentPlayer + ", enter row (0-" + (boardSize - 1) + "): ");
            int row = scanner.nextInt();

            System.out.print("Player " + game.currentPlayer + ", enter column (0-" + (boardSize - 1) + "): ");
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                if (game.checkWinner()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                } else if (allCellsFilled(game.board)) {
                    game.printBoard();
                    System.out.println("It's a tie!");
                    break;
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static boolean allCellsFilled(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
