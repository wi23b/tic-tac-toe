package at.technikum;

   public void Main() {
        boolean gameEnded = false;
        while (!gameEnded) {
            printBoard();
            System.out.println("Current Player: " + currentPlayer);
            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");

            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. The selected square is not empty. Try again.");
            }
        }
        scanner.close();
    }

    private int getValidInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input < BOARD_SIZE) {
                    return input;
                }
            }
            System.out.println("Invalid input. Please enter a number between 0 and 2.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    private boolean isValidMove(int row, int col) {
        return board[row][col] == EMPTY;
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
    
