public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            board[i] = 1 + (int) (10 * Math.random());
        }
        currentPlayer = (int) (playerCount * Math.random());
    }

    public void distributeCurrentPlayerTokens() {
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

    String printBoard() {
        for (int i : )
    }
}
