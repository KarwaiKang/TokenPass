class TokenPass {
    private int[] board;
    private int currentPlayer;

    /** Creates the board array to be of size playerCount and fills it with
     * random integer values from 1 to 10, inclusive. Initializes currentPlayer to a
     * random integer value in the range between 0 and playerCount-1, inclusive.
     * @param playerCount the number of players
     */
    TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++)
            board[i] = 1 + (int) (10 * Math.random());
        currentPlayer = (int) (playerCount * Math.random());
    }

    /** Distributes the tokens from the current player's position one at a time to each player in
     * the game. Distribution begins with the next position and continues until all the tokens
     * have been distributed. If there are still tokens to distribute when the player at the
     * highest position is reached, the next token will be distributed to the player at position 0.
     * Precondition: the current player has at least one token.
     * Postcondition: the current player has not changed.
     */
    void distributeCurrentPlayerTokens() {
        int tokens = board[currentPlayer];
        board[currentPlayer] = 0;
        for (int i = 0; i < tokens; i++)
            board[(currentPlayer + 1 + i) % board.length]++;
    }

    /**
     * Determines whether the game is over, and if so, who the winner is.
     * @return -1 if the game is not over; otherwise, the player who won.
     */
    int gameOver() {
        for (int i = 0; i < board.length; i ++) {
            if (board[i] == 0)
                return i;
        }
        return -1;
    }

    /**
     * Prints the players and the amount of tokens they each have.
     */
    void printBoard() {
        String out = "";
        for (int i = 0; i < board.length; i++)
            out += "Player " + i + ": " + board[i] + " ";
        System.out.println(out);
    }

    /**
     * Advances the turn to the next player,
     * who is the player directly succeeding the current player,
     * or {@code currentPlayer + 1}, and {@code 0} if there is no succeeding player.
     */
    void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % board.length;
        System.out.println("Current Player: " + currentPlayer);
    }
}
