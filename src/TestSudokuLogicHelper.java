import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSudokuLogicHelper {
    
    int[][] inputMatrix = 
    {
        {0,0,0,2,6,0,7,0,1}, // Row 0
        {6,8,0,0,7,0,0,9,0}, // Row 1
        {1,9,0,0,0,4,5,0,0}, // Row 2
        {8,2,0,1,0,0,0,4,0}, // Row 3
        {0,0,4,6,0,2,9,0,0}, // Row 4
        {0,5,0,0,0,3,0,2,8}, // Row 5
        {0,0,9,3,0,0,0,7,4}, // Row 6
        {0,4,0,0,5,0,0,3,6}, // Row 7
        {7,0,3,0,1,8,0,0,0}, // Row 8

    };
    SudokuGame game = new SudokuGame(inputMatrix);

    @Test
    public void checkBlockShouldReturnFalseIfSameValueExistsInBlock() {
        Node n = new Node(0,0,6);
        assertEquals(false, SudokuLogicHelper.checkBlock(game,n));
    }

    @Test
    public void checkBlockShouldReturnTrueIfNoValueExistsInBlock() {
        Node n = new Node(0,0,5);
        assertEquals(true, SudokuLogicHelper.checkBlock(game,n));
    }

    @Test
    public void checkRowShouldReturnFalseIfSameValueExistsInRow() {
        Node n = new Node(0,0,2);
        assertEquals(false, SudokuLogicHelper.checkRow(game,n));
    }

    @Test
    public void checkRowShouldReturnTrueIfNoValueExistsInRow() {
        Node n = new Node(0,0,3);
        assertEquals(true, SudokuLogicHelper.checkRow(game,n));
    }

    @Test
    public void checkColShouldReturnFalseIfSameValueExistsInColumn() {
        Node n = new Node(0,0,7);
        assertEquals(false, SudokuLogicHelper.checkCol(game,n));
    }

    @Test
    public void checkColShouldReturnTrueIfNoValueExistsInColumn() {
        Node n = new Node(0,0,4);
        assertEquals(true, SudokuLogicHelper.checkRow(game,n));
    }

    @Test
    public void inBlockOfZeroZeroShouldReturnBlockZero() {
        assertEquals(0, SudokuLogicHelper.inBlock(0,0));
    }

    @Test
    public void inBlockOfZeroThreeShouldReturnBlockOne() {
        assertEquals(1, SudokuLogicHelper.inBlock(0,3));
    }

    @Test
    public void inBlockOfZeroEightShouldReturnBlockTwo() {
        assertEquals(2, SudokuLogicHelper.inBlock(0,8));
    }

    @Test
    public void inBlockOfThreeZeroShouldReturnBlockThree() {
        assertEquals(3, SudokuLogicHelper.inBlock(3,0));
    }

    @Test
    public void inBlockOfFiveFiveShouldReturnBlockFour() {
        assertEquals(4, SudokuLogicHelper.inBlock(5,5));
    }

    @Test
    public void inBlockOfFourEightShouldReturnBlockFive() {
        assertEquals(5, SudokuLogicHelper.inBlock(4,8));
    }

    @Test
    public void inBlockOfSevenTwoShouldReturnBlockSix() {
        assertEquals(6, SudokuLogicHelper.inBlock(7,2));
    }

    @Test
    public void inBlockOfSixFiveShouldReturnBlockSeven() {
        assertEquals(7, SudokuLogicHelper.inBlock(6,5));
    }

    @Test
    public void inBlockOfEightEightShouldReturnBlockEight() {
        assertEquals(8, SudokuLogicHelper.inBlock(8,8));
    }
}
