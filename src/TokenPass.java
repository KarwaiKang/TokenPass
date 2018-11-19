class TokenPass {
    private int[] board;
    private int currentPlayer;

    TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            board[i] = 1 + (int) (10 * Math.random());
        }
        currentPlayer = (int) (playerCount * Math.random());
    }

    void distributeCurrentPlayerTokens() {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while (numToDistribute > 0) {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }

    int gameOver() {
        for (int i = 0; i < board.length; i ++) {
            if (board[i] == 0)
                return i;
        }
        return -1;
    }

    void printBoard() {
        String out = "";
        for (int i = 0; i < board.length; i++) {
            out += "Player " + i + ": " + board[i] + " ";
        }
        System.out.println(out);
    }

    void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % board.length;
        System.out.println("Current Player: " + currentPlayer);
    }
}
