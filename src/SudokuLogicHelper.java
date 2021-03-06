public class SudokuLogicHelper {

    // {Row Start, Row End, Col Start, Col End}
    public static final int[][] BLOCK_RANGE = {
        {0,2,0,2}, //Block 0
        {0,2,3,5}, //Block 1
        {0,2,6,8}, //Block 2
        {3,5,0,2}, //Block 3
        {3,5,3,5}, //Block 4
        {3,5,6,8}, //Block 5
        {6,8,0,2}, //Block 6
        {6,8,3,5}, //Block 7
        {6,8,6,8}  //Block 8
    };
    /*
     Block numbering layour
     0|1|2
     3|4|5
     6|7|8
    */


    SudokuLogicHelper () {

    }

    public static boolean checkBlock(SudokuGame g, Node n) {
        int row = n.getRow();
        int col = n.getCol();
        int blockIndex = inBlock(row, col);

        for (int r = BLOCK_RANGE[blockIndex][0]; r <= BLOCK_RANGE[blockIndex][1]; r++) {
            for (int c = BLOCK_RANGE[blockIndex][2]; c <= BLOCK_RANGE[blockIndex][3]; c++) {
                if ((r == row && c == col) == false && (g.getNodeValue(r, c) == n.getValue() && n.getValue() != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkRow(SudokuGame g, Node n) {
        int row = n.getRow();
        int col = n.getCol();

        for (int c = 0; c <= 8; c++) {
            if (c != col && g.getNodeValue(row, c) == n.getValue() && n.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(SudokuGame g, Node n) {
        int row = n.getRow();
        int col = n.getCol();

        for (int r = 0; r <= 8; r++) {
            if (r != row && g.getNodeValue(r, col) == n.getValue() && n.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static int inBlock(int row, int col) {
        try {
            if (row >= 0 && row <= 2) {
                if (col >= 0 && col <= 2) {
                    return 0;
                } else if (col >= 3 && col <= 5) {
                    return 1;
                } else if (col >= 6 && col <= 8) {
                    return 2;
                }
            } else if (row >= 3 && row <= 5) {
                if (col >= 0 && col <= 2) {
                    return 3;
                } else if (col >= 3 && col <= 5) {
                    return 4;
                } else if (col >= 6 && col <= 8) {
                    return 5;
                }
            } else if (row >= 6 && row <= 8) {
                if (col >= 0 && col <= 2) {
                    return 6;
                } else if (col >= 3 && col <= 5) {
                    return 7;
                } else if (col >= 6 && col <= 8) {
                    return 8;
                }
            } else {
                throw new ValueOutOfBoundsException("Row/Col Out of bounds");
            }
        }
        catch(ValueOutOfBoundsException e) {
            System.err.println(e);
        }
        return -1;
    }

    public static boolean checkAll(SudokuGame g, Node n) {
        return checkBlock(g, n) && checkRow(g, n) && checkCol(g, n);
    }
}
