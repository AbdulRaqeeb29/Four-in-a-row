public class Board<T> {
    private final int rows;
    private final int columns;
    private final Cell<T>[][] cells;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                cells[row][col] = new Cell<>();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Cell<T> getCell(int row, int column) {
        return cells[row][column];
    }

    public boolean isBoardFull() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (cells[row][col].getValue() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinningCombination() {
        return hasHorizontalWin() || hasVerticalWin() || hasDiagonalWin();
    }

    private boolean hasHorizontalWin() {
        for (int row = 0; row < rows; row++) {
            T symbol = cells[row][0].getValue();
            if (symbol != null) {
                boolean win = true;
                for (int col = 1; col < columns; col++) {
                    if (cells[row][col].getValue() != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasVerticalWin() {
        for (int col = 0; col < columns; col++) {
            T symbol = cells[0][col].getValue();
            if (symbol != null) {
                boolean win = true;
                for (int row = 1; row < rows; row++) {
                    if (cells[row][col].getValue() != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasDiagonalWin() {

        return hasDiagonalWinDownwards() || hasDiagonalWinUpwards();
    }

    private boolean hasDiagonalWinDownwards() {
        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= columns - 3; col++) {
                T symbol = cells[row][col].getValue();
                if (symbol != null) {
                    boolean win = true;
                    for (int i = 1; i < 3; i++) {
                        if (cells[row + i][col + i].getValue() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasDiagonalWinUpwards() {
        for (int row = 2; row < rows; row++) {
            for (int col = 0; col <= columns - 3; col++) {
                T symbol = cells[row][col].getValue();
                if (symbol != null) {
                    boolean win = true;
                    for (int i = 1; i < 3; i++) {
                        if (cells[row - i][col + i].getValue() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasWinningfourinarowCondition(){

        return hasFourInARow();
    }

    private boolean hasFourInARow() {
        int rows = getRows();
        int columns = getColumns();
        int targetCount = 4;


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= columns - targetCount; col++) {
                T symbol = getCell(row, col).getValue();
                if (symbol != null) {
                    int count = 1;
                    for (int i = 1; i < targetCount; i++) {
                        if (getCell(row, col + i).getValue() == symbol) {
                            count++;
                        }
                    }
                    if (count == targetCount) {
                        return true;
                    }
                }
            }
        }


        for (int col = 0; col < columns; col++) {
            for (int row = 0; row <= rows - targetCount; row++) {
                T symbol = getCell(row, col).getValue();
                if (symbol != null) {
                    int count = 1;
                    for (int i = 1; i < targetCount; i++) {
                        if (getCell(row + i, col).getValue() == symbol) {
                            count++;
                        }
                    }
                    if (count == targetCount) {
                        return true;
                    }
                }
            }
        }


        for (int row = 0; row <= rows - targetCount; row++) {
            for (int col = 0; col <= columns - targetCount; col++) {
                T symbol = getCell(row, col).getValue();
                if (symbol != null) {
                    int count = 1;
                    for (int i = 1; i < targetCount; i++) {
                        if (getCell(row + i, col + i).getValue() == symbol) {
                            count++;
                        }
                    }
                    if (count == targetCount) {
                        return true;
                    }
                }
            }
        }

        for (int row = rows - 1; row >= targetCount - 1; row--) {
            for (int col = 0; col <= columns - targetCount; col++) {
                T symbol = getCell(row, col).getValue();
                if (symbol != null) {
                    int count = 1;
                    for (int i = 1; i < targetCount; i++) {
                        if (getCell(row - i, col + i).getValue() == symbol) {
                            count++;
                        }
                    }
                    if (count == targetCount) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
