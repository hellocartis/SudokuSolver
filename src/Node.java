public class Node {
    private int value;
    private int row;
    private int col;
    
    Node(int row, int col) {
        this.value = 0;
        this.row = row;
        this.col = col;
    }
    
    Node(int row, int col, int v) {
        this.value = v;
        this.row = row;
        this.col = col;
    }

    int getValue() {
        return this.value;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }
    
    void setValue(int v) {
        if (v >= 0 && v <= 9) {
            this.value = v;
        
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
