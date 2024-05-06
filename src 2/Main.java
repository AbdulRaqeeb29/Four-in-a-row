import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rematch = true;

    while (rematch) {
            System.out.println("Welcome to the Game Center!");
            System.out.println("Choose the game to play:");
            System.out.println("1. Tic-Tac-Toe");
            System.out.println("2. 4-in-a-Row");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int gameChoice = 0;
            try {
                gameChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("error " + e + " found");
            }
            switch (gameChoice) {
                case 1 -> playTicTacToe(scanner);
                case 2 -> playFourInARow(scanner);
                case 3 -> System.exit(0);
            }


            System.out.print("Rematch? (Y/N): ");
            String rematchInput = scanner.next();
            rematch = rematchInput.equalsIgnoreCase("Y");
            scanner.nextLine();
        }
    }


    private static void playTicTacToe(Scanner scanner) {
        System.out.println("Let's play Tic-Tac-Toe!");

        System.out.print("Select the game mode (1 for single player, 2 for double player): ");
        int gameMode = scanner.nextInt();
        scanner.nextLine();

        String player1Name, player2Name;
        if (gameMode == 1) {
            player1Name = getPlayerName(scanner, 1);
            player2Name = "AI";
            System.out.println("You are playing against AI!");
        } else {
            player1Name = getPlayerName(scanner, 1);
            player2Name = getPlayerName(scanner, 2);
        }

        TicTacToeGame game = new TicTacToeGame(player1Name, player2Name);

        while (!game.isGameOver()) {
            System.out.println();
            BoardPrinter.printBoard(game.getBoard());
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn");
            currentPlayer.makeMove(game, scanner);
        }

        System.out.println();
        BoardPrinter.printBoard(game.getBoard());
        System.out.println("Game over!");

        Player winner = game.getWinner();
        if (winner != null) {
            if (winner.getName().equals("AI")) {
                System.out.println("You have lost!");
            } else {
                System.out.println("Congratulations, " + winner.getName() + "! You won!");
            }
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void playFourInARow(Scanner scanner) {
        System.out.println("Let's play 4-in-a-Row!");

        System.out.print("Select the game mode (1 for single player, 2 for double player): ");
        int gameMode = scanner.nextInt();
        scanner.nextLine();

        String player1Name, player2Name;
        if (gameMode == 1) {
            player1Name = getPlayerName(scanner, 1);
            player2Name = "AI";
            System.out.println("You are playing against AI!");
        } else {
            player1Name = getPlayerName(scanner, 1);
            player2Name = getPlayerName(scanner, 2);
        }

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        scanner.nextLine();

        FourInARowGame game = new FourInARowGame(rows, columns, player1Name, player2Name);

        while (!game.isGameOver()) {
            System.out.println();
            BoardPrinter.printBoard(game.getBoard());

            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn");
            currentPlayer.makeMove(game, scanner);
        }

        System.out.println();
        System.out.println("Game over!");
        BoardPrinter.printBoard(game.getBoard());

        Player winner = game.getWinner();
        if (winner != null) {
            if (winner.getName().equals("AI")) {
                System.out.println("You have lost!");
            } else {
                System.out.println("Congratulations, " + winner.getName() + "! You won!");
            }
        } else {
            System.out.println("It's a draw!");
        }


    }

    private static String getPlayerName(Scanner scanner, int playerNumber) {
        System.out.print("Enter Player " + playerNumber + " name: ");
        return scanner.nextLine();
    }
}
