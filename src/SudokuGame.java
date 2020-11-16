public class SudokuGame {
    public static final int NUM_ROWS = 9;
    public static final int NUM_COLUMNS = 9;

    private Node[][] gameData = new Node[NUM_ROWS][NUM_COLUMNS];
    private boolean completed = false;

    SudokuGame() {
        try {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLUMNS; col++) {
                    gameData[row][col] = new Node();
                }
            }
        }
        catch(Exception e) {
            System.err.println("Failed to instantiate game nodes: " + e);
        }
    }

    public void setNode(int row, int col, int value) {
        try{
            if (value < 0 || value > 9) {
                throw new ValueOutOfBoundsException(
                    value + " at ROW:" + Integer.toString(row) + " COL:" + Integer.toString(col) + 
                    " must be between 0 to 9");
            }
            
            this.gameData[row][col].setValue(value);
        }
        catch(IndexOutOfBoundsException|ValueOutOfBoundsException e) {
            System.err.println(e);
        }
    }

    public boolean getCompleted() {
        return completed;
    }

    public void displayGame() {
        try{
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLUMNS; col++) {
                    System.out.print(gameData[row][col].toString());
                    if ((col + 1) % 3 == 0 && col != NUM_COLUMNS - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println("");
                if ((row + 1) % 3 == 0 && row != NUM_ROWS - 1) {
                    System.out.println("---+---+---");
                }
            }
        }
        catch(Exception e) {
            System.err.println("Failed to display current game state" + e);
        }
    }
}
