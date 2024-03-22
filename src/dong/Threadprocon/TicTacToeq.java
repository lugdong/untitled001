package dong.Threadprocon;
import java.util.Scanner;

public class TicTacToeq {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeMark(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        } else {
            System.out.println("该位置已被占用，请重新选择。");
            return false;
        }
    }

    public boolean checkWin() {
        // 检查行
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }

        // 检查列
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return true;
            }
        }

        // 检查对角线
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '
                || board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }

        return false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!checkWin()) {
            printBoard();
            System.out.print("玩家 " + currentPlayer + ", 请输入您的位置 (例如: 1 1): ");
            String[] pos = scanner.nextLine().trim().split(" ");
            if (pos.length == 2 && Integer.parseInt(pos[0]) >= 1 && Integer.parseInt(pos[0]) <= 3
                    && Integer.parseInt(pos[1]) >= 1 && Integer.parseInt(pos[1]) <= 3) {
                int row = Integer.parseInt(pos[0]) - 1;
                int col = Integer.parseInt(pos[1]) - 1;
                if (!placeMark(row, col)) {
                    continue;
                }
            } else {
                System.out.println("输入的位置格式不正确，请重新输入。");
                continue;
            }
        }
        printBoard();
        System.out.println("玩家 " + currentPlayer + " 赢得了比赛！");
    }

    public static void main(String[] args) {
        TicTacToeq game = new TicTacToeq();
        game.playGame();
    }
}

