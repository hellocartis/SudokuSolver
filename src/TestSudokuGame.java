import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSudokuGame {
    
    @Test
    public void constructorWithNoArgumentsShouldReturnBlankGame() {
        // Empty for test
        SudokuGame test = new SudokuGame();
        assertEquals(0, test.getNodeValue(0, 0));
    }

    @Test 
    public void constructorWithInputMatrixShouldAssignWhenSpecified() {
        int[][] inputMatrix = 
            {
                {0,0,0,2,6,0,7,0,1}, // Row 0
                {6,8,0,0,7,0,0,9,0}, // Row 1
                {1,9,0,0,0,4,5,0,0}, // Row 2
                {8,2,0,1,0,0,0,4,0}, // Row 3
                {0,0,4,6,0,2,9,0,0}, // Row 4
                {0,5,0,0,0,3,0,2,8}, // Row 5
                {0,0,9,3,0,0,0,7,4}, // Row 6
                {0,4,0,0,0,5,0,3,6}, // Row 7
                {7,0,3,0,1,8,0,0,0}, // Row 8

            };
        SudokuGame test = new SudokuGame(inputMatrix);
        assertEquals(2, test.getNodeValue(0,3));
        assertEquals(6, test.getNodeValue(0,4));
        assertEquals(7, test.getNodeValue(0,6));
        assertEquals(1, test.getNodeValue(0,8));
        assertEquals(9, test.getNodeValue(6,2));

        assertEquals(0, test.getNodeValue(0,0));
        assertEquals(0, test.getNodeValue(1,3));
        assertEquals(0, test.getNodeValue(4,0));
        assertEquals(0, test.getNodeValue(7,6));
        assertEquals(0, test.getNodeValue(8,1));
    }

    @Test
    public void setNodeWithValidValueShouldChangeNodeValue() {
        SudokuGame test = new SudokuGame();
        test.setNode(0,0,1);
        assertEquals(1,test.getNodeValue(0,0));
    }

    @Test
    public void setNodeWithValidValueOnFixedNodeShouldNotChangeNodeValue() {
        int[][] inputMatrix = 
            {
                {1,0,0,0,0,0,0,0,0}, // Row 0
                {0,0,0,0,0,0,0,0,0}, // Row 1
                {0,0,0,0,0,0,0,0,0}, // Row 2
                {0,0,0,0,0,0,0,0,0}, // Row 3
                {0,0,0,0,0,0,0,0,0}, // Row 4
                {0,0,0,0,0,0,0,0,0}, // Row 5
                {0,0,0,0,0,0,0,0,0}, // Row 6
                {0,0,0,0,0,0,0,0,0}, // Row 7
                {0,0,0,0,0,0,0,0,0}, // Row 8

            };
        SudokuGame test = new SudokuGame(inputMatrix);
        test.setNode(0,0,2);
        assertEquals(1,test.getNodeValue(0,0));
    }

    @Test
    public void setNodeWithExistingValueInBlockShouldNotBeSetOnEmptyNodes() {
        int[][] inputMatrix = 
            {
                {0,0,0,0,0,0,0,0,0}, // Row 0
                {0,1,0,0,0,0,0,0,0}, // Row 1
                {0,0,0,0,0,0,0,0,0}, // Row 2
                {0,0,0,0,0,0,0,0,0}, // Row 3
                {0,0,0,0,0,0,0,0,0}, // Row 4
                {0,0,0,0,0,0,0,0,0}, // Row 5
                {0,0,0,0,0,0,0,0,0}, // Row 6
                {0,0,0,0,0,0,0,0,0}, // Row 7
                {0,0,0,0,0,0,0,0,0}, // Row 8

            };
        SudokuGame test = new SudokuGame(inputMatrix);
        test.setNode(0,0,1);
        assertEquals(0,test.getNodeValue(0,0));
    }

    @Test
    public void setNodeWithExistingValueInRowShouldNotBeSetOnEmptyNodes() {
        int[][] inputMatrix = 
            {
                {0,1,0,0,0,0,0,0,0}, // Row 0
                {0,0,0,0,0,0,0,0,0}, // Row 1
                {0,0,0,0,0,0,0,0,0}, // Row 2
                {0,0,0,0,0,0,0,0,0}, // Row 3
                {0,0,0,0,0,0,0,0,0}, // Row 4
                {0,0,0,0,0,0,0,0,0}, // Row 5
                {0,0,0,0,0,0,0,0,0}, // Row 6
                {0,0,0,0,0,0,0,0,0}, // Row 7
                {0,0,0,0,0,0,0,0,0}, // Row 8

            };
        SudokuGame test = new SudokuGame(inputMatrix);
        test.setNode(0,0,1);
        assertEquals(0,test.getNodeValue(0,0));
    }

    @Test
    public void setNodeWithExistingValueInColumnShouldNotBeSetOnEmptyNodes() {
        int[][] inputMatrix = 
            {
                {0,0,0,0,0,0,0,0,0}, // Row 0
                {1,0,0,0,0,0,0,0,0}, // Row 1
                {0,0,0,0,0,0,0,0,0}, // Row 2
                {0,0,0,0,0,0,0,0,0}, // Row 3
                {0,0,0,0,0,0,0,0,0}, // Row 4
                {0,0,0,0,0,0,0,0,0}, // Row 5
                {0,0,0,0,0,0,0,0,0}, // Row 6
                {0,0,0,0,0,0,0,0,0}, // Row 7
                {0,0,0,0,0,0,0,0,0}, // Row 8

            };
        SudokuGame test = new SudokuGame(inputMatrix);
        test.setNode(0,0,1);
        assertEquals(0,test.getNodeValue(0,0));
    }

    @Test
    public void setNodeWithNonExistingValueInColumnShouldBeSetOnEmptyNodes() {
        int[][] inputMatrix = 
            {
                {0,0,0,0,0,0,0,0,0}, // Row 0
                {1,0,0,0,0,0,0,0,0}, // Row 1
                {0,0,0,0,0,0,0,0,0}, // Row 2
                {0,0,0,0,0,0,0,0,0}, // Row 3
                {0,0,0,0,0,0,0,0,0}, // Row 4
                {0,0,0,0,0,0,0,0,0}, // Row 5
                {0,0,0,0,0,0,0,0,0}, // Row 6
                {0,0,0,0,0,0,0,0,0}, // Row 7
                {0,0,0,0,0,0,0,0,0}, // Row 8

            };
        SudokuGame test = new SudokuGame(inputMatrix);
        test.setNode(0,0,2);
        assertEquals(2,test.getNodeValue(0,0));
    }
}
