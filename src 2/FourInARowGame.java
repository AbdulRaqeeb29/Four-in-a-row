import java.util.Scanner;

public class FourInARowGame {
    private final Board<String> board;
    private final Player<String>[] players;
    private int currentPlayerIndex;


    public FourInARowGame(int rows, int columns, String player1Name, String player2Name) {
        board = new Board<>(rows, columns);
        players = new Playe[2];
        players[0] = new HumanPlayer(player1Name, "\uD83D\uDE02");
        if(player2Name == "AI"){
            players[1] = new AIPlayer(player2Name, "\uD83D\uDE80");
        }else{
            players[1] = new HumanPlayer(player2Name, "\uD83D\uDE80");
        }
        currentPlayerIndex = 0;
    }

    public void playMove(int column) {
        int rows = board.getRows();
        for (int row = rows - 1; row >= 0; row--) {
            Cell<String> cell = board.getCell(row, column);
            if (cell.getValue() == null) {
                Player currentPlayer = getCurrentPlayer();
                cell.setValue((String) currentPlayer.getSymbol());
                break;
            }
        }
    }

    public boolean isGameOver() {
        return board.hasWinningfourinarowCondition() || isBoardFull();
    }

    public Player getWinner() {
        if (board.hasWinningfourinarowCondition()) {
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


    private boolean isBoardFull() {
        int rows = board.getRows();
        int columns = board.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (board.getCell(row, col).getValue() == null) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isCellEmpty(int row,int col) {
        if(board.getCell(row,col).getValue() == null){
            return true;
        }
        return false;
    }
}
