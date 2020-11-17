public class Node {
    private int value;
    private int row;
    private int col;
    private boolean fixed;
    
    Node(int row, int col) {
        this.value = 0;
        this.row = row;
        this.col = col;
        this.fixed = false;
    }
    
    Node(int row, int col, int v) {
        this.value = v;
        this.row = row;
        this.col = col;
    }

    public void setToFixed() {
        this.fixed = true;
    }

    public boolean getFixed() {
        return this.fixed;
    }
    
    public int getValue() {
        return this.value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int inBlock() {
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

    public void setValue(int v) {
        if (v >= 0 && v <= 9) {
            this.value = v;
        
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
