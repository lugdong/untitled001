package dong.Threadprocon;
import java.util.Scanner;

public class TicTacToe1 {
    private static final int SIZE = 3;
    private char[][] board = new char[SIZE][SIZE];
    private char currentPlayer = 'X';

    public TicTacToe1() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            if (checkWin()) {
                System.out.println("玩家 " + currentPlayer + " 获胜!");
                break;
            } else if (isDraw()) {
                System.out.println("平局!");
                break;
            }

            System.out.println("玩家 " + currentPlayer + " 的回合. 请输入行和列 (例如: 1 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (makeMove(row, col)) {
                switchPlayer();
            } else {
                System.out.println("无效的移动，请重新输入.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe1 game = new TicTacToe1();
        game.playGame();
    }
}
