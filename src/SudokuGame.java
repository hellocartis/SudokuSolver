public class SudokuGame {
    public static final int NUM_ROWS = 9;
    public static final int NUM_COLUMNS = 9;

    private Node[][] gameData = new Node[NUM_ROWS][NUM_COLUMNS];
    private boolean completed = false;

    SudokuGame() {
        try {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLUMNS; col++) {
                    gameData[row][col] = new Node(row, col);
                }
            }
        }
        catch(Exception e) {
            System.err.println("Failed to instantiate game nodes: " + e);
        }
    }

    SudokuGame(int[][] inputMatrix) {
        this();
        try {
            for(int row = 0; row < NUM_ROWS; row++) {
                for(int col = 0; col < NUM_COLUMNS; col++) {
                    gameData[row][col] = new Node(row, col);
                    this.setNode(row, col, inputMatrix[row][col], true);
                }
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Instantiating matrix should 9x9");
        }
    }

    public void setNode(int row, int col, int value, boolean fixed) {
        if (fixed && value != 0 && this.gameData[row][col].getFixed() == false) {
            setNode(row, col, value);
            this.gameData[row][col].setToFixed();
        } else {
            setNode(row, col, value);
        }
    }

    public void setNode(int row, int col, int value) {
        try{
            if (value < 0 || value > 9) {
                throw new ValueOutOfBoundsException(
                    value + " at ROW:" + Integer.toString(row) + " COL:" + Integer.toString(col) + 
                    " must be between 0 to 9");
            }
            if (gameData[row][col].getFixed()) {
                throw new ValueAgainstGameLogic("You may not change a value that is predetermined");
            }else if (SudokuLogicHelper.checkBlock(this, new Node(row,col,value)) == false) {
                throw new ValueAgainstGameLogic("Value: " + value + " already exists in this block:" + SudokuLogicHelper.inBlock(row, col));
            } else if (SudokuLogicHelper.checkRow(this, new Node(row,col,value)) == false) {
                throw new ValueAgainstGameLogic("Value: " + value + " already exists in this row:" + row);
            } else if (SudokuLogicHelper.checkCol(this, new Node(row,col,value)) == false) {
                throw new ValueAgainstGameLogic("Value: " + value + " already exists in this column:" + col);
            } else {
                this.gameData[row][col].setValue(value);  
            }
        }
        catch(IndexOutOfBoundsException|ValueOutOfBoundsException|ValueAgainstGameLogic e) {
            System.err.println(e);
        }
    }

    public int getNodeValue(int row, int col) {
        return gameData[row][col].getValue();
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
