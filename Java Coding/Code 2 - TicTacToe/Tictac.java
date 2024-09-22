import java.util.Scanner;

public class Tictac {
    static char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
    static char AI = 'O';
    static char YOU = 'X';

    public static void printBoard(char[] board) {
        for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i] + "|" + board[i + 1] + "|" + board[i + 2]);
        }
        System.out.println();
    }

    public static boolean checkWinner(char[] board, char player) {
        int[][] winningCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, 
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  
            {0, 4, 8}, {2, 4, 6}             
        };
        for (int[] combo : winningCombinations) {
            if (board[combo[0]] == player && board[combo[1]] == player && board[combo[2]] == player) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBoardFull(char[] board) {
        for (char cell : board) {
            if (cell == '-') {
                return false;
            }
        }
        return true;
    }

    public static int minimaxAlphaBeta(char[] board, int depth, int alpha, int beta, boolean maximizingPlayer) {
        if (checkWinner(board, AI)) {
            return 1;
        } else if (checkWinner(board, YOU)) {
            return -1;
        } else if (isBoardFull(board)) {
            return 0;
        }

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == '-') {
                    board[i] = AI;
                    int eval = minimaxAlphaBeta(board, depth + 1, alpha, beta, false);
                    board[i] = '-';
                    maxEval = Math.max(maxEval, eval);
                    alpha = Math.max(alpha, eval);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == '-') {
                    board[i] = YOU;
                    int eval = minimaxAlphaBeta(board, depth + 1, alpha, beta, true);
                    board[i] = '-';
                    minEval = Math.min(minEval, eval);
                    beta = Math.min(beta, eval);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return minEval;
        }
    }

    public static int findBestMove(char[] board) {
        int bestMove = -1;
        int bestEval = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            if (board[i] == '-') {
                board[i] = AI;
                int eval = minimaxAlphaBeta(board, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                board[i] = '-';
                if (eval > bestEval) {
                    bestEval = eval;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);
            System.out.print("Enter your choice box (0-8): ");
            int move = scanner.nextInt();
            if (board[move] == '-') {
                board[move] = YOU;
                if (checkWinner(board, YOU)) {
                    printBoard(board);
                    System.out.println("Congratulations You won!");
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("ohh It's a draw!");
                    break;
                }
                int aiMove = findBestMove(board);
                board[aiMove] = AI;
                if (checkWinner(board, AI)) {
                    printBoard(board);
                    System.out.println("AI Bot wins!");
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("Don't feel bad. It's a draw!");
                    break;
                }
            } else {
                System.out.println("Cell already filled. Try another number.");
            }
        }

        scanner.close();
    }
}
