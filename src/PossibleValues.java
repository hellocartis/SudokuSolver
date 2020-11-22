import java.util.ArrayList;

public class PossibleValues {
    private ArrayList<Integer> posVals;
    
    PossibleValues() {
        posVals = new ArrayList<Integer>();
    }

    public int possibleRemaining() {
        return posVals.size();
    }

    public void delete(int val) {
        int i = posVals.indexOf(val);
        if (i != -1) {
            posVals.remove(i);
        }
    }

    public void add(int val) {
        posVals.add(val);
    }

    public int size() {
        return posVals.size();
    }

    public int get(int index) {
        return posVals.get(index);
    }

    @Override
    public String toString() {
        String s = " [ ";
        for (Integer i : posVals) {
            s += Integer.toString(i) + " ";
        }
        s += "]";
        return s;
    }
}
