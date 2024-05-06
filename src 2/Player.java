import java.util.Random;
import java.util.Scanner;

public abstract class Player<T> {
    private final String name;
    private final T symbol;

    public Player(String name, T symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {

        return name;
    }

    public T getSymbol() {

        return symbol;
    }

    public abstract void makeMove(TicTacToeGame game,Scanner scanner);
    public abstract void makeMove(FourInARowGame game,Scanner scanner);

}




