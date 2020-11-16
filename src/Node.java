public class Node {
    private int value;
    
    Node() {
        this.value = 0;
    }
    
    Node(int v) {
        this.value = v;
    }

    int getValue() {
        return this.value;
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
