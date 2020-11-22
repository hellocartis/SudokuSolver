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
