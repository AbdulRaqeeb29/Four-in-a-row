public class BoardPrinter {
    public static <T> void printBoard(Board<T> board) {
        int rows = board.getRows();
        int columns = board.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Cell<T> cell = board.getCell(row, col);
                T value = cell.getValue();
                if (value != null) {
                    System.out.print(value);
                } else {
                    System.out.print("-");
                }
                if (col < columns - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < rows - 1) {
                for (int col = 0; col < columns - 1; col++) {
                    System.out.print("-----");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
