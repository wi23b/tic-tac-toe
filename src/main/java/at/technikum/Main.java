package at.technikum;

public class Main {
    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
} 
