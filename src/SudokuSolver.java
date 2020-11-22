public class SudokuSolver {
    
    private SudokuGame game;
    private int numRemainingNodes;
    private PossibleValues[][] posMatrix = new PossibleValues[SudokuGame.NUM_ROWS][SudokuGame.NUM_COLUMNS];

    SudokuSolver(SudokuGame g){
        this.game = g;
        for (int r = 0; r < SudokuGame.NUM_ROWS; r++) {
            for (int c = 0; c < SudokuGame.NUM_COLUMNS; c++) {
                posMatrix[r][c] = new PossibleValues();
                if (g.getNodeValue(r, c) == 0) {
                    numRemainingNodes++;
                }
            }
        }
        calculatePosMatrix();

    }

    public SudokuGame solve(){
        while(numRemainingNodes > 0) {
            if (singlePosExists()) {
                fillSinglePos();
                System.out.println("Solving...");
            }
        }
        return this.game;
    }

    private void fillSinglePos() {
        for (int r = 0; r < SudokuGame.NUM_ROWS; r++) {
            for (int c = 0; c < SudokuGame.NUM_COLUMNS; c++) {
                if (posMatrix[r][c].size() == 1) {
                    int val = posMatrix[r][c].get(0);
                    game.setNode(r, c, val);
                    numRemainingNodes--;
                    removePosFromBlock(SudokuLogicHelper.inBlock(r, c), val);
                    removePosFromRow(r, val);
                    removePosFromCol(c, val);
                }
            }
        }
    }

    private void removePosFromRow(int r, int val) {
        for (int c = 0; c < SudokuGame.NUM_COLUMNS; c++) {
            posMatrix[r][c].delete(val);
        }
    }

    private void removePosFromCol(int c, int val) {
        for (int r = 0; r < SudokuGame.NUM_ROWS; r++) {
            posMatrix[r][c].delete(val);
        }
    }

    private void removePosFromBlock(int blockIndex, int val) {
        for (int r = SudokuLogicHelper.BLOCK_RANGE[blockIndex][0]; r <= SudokuLogicHelper.BLOCK_RANGE[blockIndex][1]; r++) {
            for (int c = SudokuLogicHelper.BLOCK_RANGE[blockIndex][2]; c <= SudokuLogicHelper.BLOCK_RANGE[blockIndex][3]; c++) {
                posMatrix[r][c].delete(val);
            }
        }
    }

    private boolean singlePosExists() {
        for (int r = 0; r < SudokuGame.NUM_ROWS; r++) {
            for (int c = 0; c < SudokuGame.NUM_COLUMNS; c++) {
                if (posMatrix[r][c].size() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void calculatePosMatrix() {
        for (int r = 0; r < SudokuGame.NUM_ROWS; r++) {
            for (int c = 0; c < SudokuGame.NUM_COLUMNS; c++) {
                for (int i = 1; i <= 9; i ++) {
                    if (game.getNodeValue(r,c) == 0 && SudokuLogicHelper.checkAll(game, new Node(r,c,i))){
                        posMatrix[r][c].add(i);
                    }
                }
            }
        }
    }

    public void print() {
        for (int r = 0; r < SudokuGame.NUM_ROWS; r++) {
            for (int c = 0; c < SudokuGame.NUM_COLUMNS; c++) {
                if (posMatrix[r][c].size() > 0) {
                    System.out.print("Row: "+ Integer.toString(r) + " Col: " + Integer.toString(c) + " ");
                    System.out.println(posMatrix[r][c].toString());
                }
                }
                
        }
    }
}
