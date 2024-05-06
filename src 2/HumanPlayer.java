import java.util.Scanner;



public class HumanPlayer<T> extends Player{
    public HumanPlayer(String name,T symbol) {
        super(name, symbol);
    }

    public void makeMove(FourInARowGame game,Scanner scanner) {
        int column;
        try {
            System.out.print("Enter the column (1-" + game.getBoard().getColumns() + "): ");
            column = scanner.nextInt() - 1;
            if(!(column >= 0 && column <= (game.getBoard().getColumns()-1))){
                throw new Exception();
            }
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("The entered value is incorrect");
            scanner.nextLine();
            return;
        }
        if(game.getBoard().getCell(0,column).getValue() == null){
            game.playMove(column);
            game.switchPlayer();
        }
        else{
            System.out.println();
            System.out.println("The place is already marked");
        }
    }
    public void makeMove(TicTacToeGame game,Scanner scanner){
        int row;
        try {
            System.out.print("Enter the row (1-3):");
            row = scanner.nextInt() - 1;
            if(!(row >= 0 && row <= 2)){
                throw new Exception();
            }
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("The entered value is incorrect");
            scanner.nextLine();
            return;
        }
        int column;
        try {
            System.out.print("Enter the column (1-3):");
            column = scanner.nextInt() - 1;
            if(!(column >= 0 && column <= 2)){
                throw new Exception();
            }
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("The entered value is incorrect");
            scanner.nextLine();
            return;
        }
        if(game.getBoard().getCell(row,column).getValue() == null) {
            game.playMove(row, column);
            game.switchPlayer();
        }
        else{
            System.out.println();
            System.out.println("The place is already marked");
        }
    }
}