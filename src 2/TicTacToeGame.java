public class TicTacToeGame {
    private final Board<Character> board;
    private final Player<Character>[] players;
    private int currentPlayerIndex;

    public TicTacToeGame(String player1Name, String player2Name) {
        board = new Board<>(3, 3);
        players = new Player[2];
        players[0] = new HumanPlayer(player1Name, 'X');
        if(player2Name == "AI"){
            players[1] = new AIPlayer(player2Name, 'O');
        }else{
            players[1] = new HumanPlayer(player2Name, 'O');
        }
        currentPlayerIndex = 0;
    

    public void playMove(int row, int column) {
        Cell<Character> cell = board.getCell(row, column);
        if (cell.getValue() == null) {
            Player currentPlayer = getCurrentPlayer();
            cell.setValue((Character) currentPlayer.getSymbol());
        }
    }




    public boolean isGameOver() {
        return board.hasWinningCombination() || board.isBoardFull();
    }

    public Player getWinner() {
        if (board.hasWinningCombination()) {
            switchPlayer();
            return getCurrentPlayer();
        }
        return null;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    public Board getBoard() {
        return board;
    }
}

