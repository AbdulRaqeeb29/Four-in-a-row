import java.util.Random;
import java.util.Scanner;

public class AIPlayer<T> extends Player {
    private Random random;

    public AIPlayer(String name, T symbol) {
        super(name, symbol);
        random = new Random();
    }

    public void makeMove(FourInARowGame game, Scanner scanner) {
        int columns = game.getBoard().getColumns();
        int rows = game.getBoard().getRows();
        int column = random.nextInt(game.getBoard().getColumns());
        for (int col = 0; col < columns; col++) {
            if (game.isCellEmpty(0,col)) {
                for (int row = 0; row < rows; row++) {
                    if (game.isCellEmpty(row, col)) {
                        game.getBoard().getCell(row,col).setValue('O');
                        if (game.getBoard().hasWinningfourinarowCondition()) {
                            game.getBoard().getCell(row,col).setValue(null);
                            column = col;
                            break;
                        }
                        game.getBoard().getCell(row,col).setValue(null);
                    }
                }
            }
        }

        for (int col = 0; col < columns; col++) {
            if (game.isCellEmpty(0,col)) {
                for (int row = 0; row < rows; row++) {
                    if (game.isCellEmpty(row, col)) {
                        game.getBoard().getCell(row,col).setValue('X');
                        if (game.getBoard().hasWinningfourinarowCondition()) {
                            game.getBoard().getCell(row,col).setValue(null);
                            column = col;
                            break;
                        }
                        game.getBoard().getCell(row,col).setValue(null);
                    }
                }
            }
        }
        if(game.getBoard().getCell(0,column).getValue() != null){
            column = random.nextInt(columns);
            return;
        }else {
            game.playMove(column);
            game.switchPlayer();
        }

    }

    public void makeMove(TicTacToeGame game,Scanner scanner) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.getBoard().getCell(i,j).getValue() == null) {
                    game.getBoard().getCell(i,j).setValue('O');
                    if (game.getBoard().hasWinningCombination()) {
                        game.switchPlayer();
                        return; // Found a winning move, so make it
                    }
                    game.getBoard().getCell(i,j).setValue(null); // Undo the move if it's not a winning move
                }
            }
        }

        // Check for blocking opponent's winning moves
        char opponentPlayer = (((Character) game.getCurrentPlayer().getSymbol()) == 'X') ? 'O' : 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.getBoard().getCell(i,j).getValue() == null) {
                    game.getBoard().getCell(i,j).setValue('X');
                    if (game.getBoard().hasWinningCombination()) {
                        game.getBoard().getCell(i,j).setValue('O'); // Block the opponent's winning move
                        game.switchPlayer();
                        return;
                    }
                    game.getBoard().getCell(i,j).setValue(null); // Undo the move if it doesn't block the opponent's winning move
                }
            }
        }

        // Choose a random available position
        int row, col;
        do {
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
        } while (game.getBoard().getCell(row,col).getValue() != null);
        game.playMove(row, col);
        game.switchPlayer();
    }

}