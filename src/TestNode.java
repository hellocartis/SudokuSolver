import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNode {
    @Test
    public void constructorWithNoValueShouldDefaultValueToZero() {
        // Empty for test
        Node test = new Node(0,0);
        assertEquals(0, test.getValue());
    }

    @Test
    public void constructorWithValueShouldReturnGivenValue() {
        Node test = new Node(0,0,3);
        assertEquals(3, test.getValue());
    }

    @Test
    public void inBlockOfZeroZeroShouldReturnBlockZero() {
        Node test = new Node(0,0);
        assertEquals(0, test.inBlock());
    }

    @Test
    public void inBlockOfZeroThreeShouldReturnBlockOne() {
        Node test = new Node(0,3);
        assertEquals(1, test.inBlock());
    }

    @Test
    public void inBlockOfZeroEightShouldReturnBlockTwo() {
        Node test = new Node(0,8);
        assertEquals(2, test.inBlock());
    }

    @Test
    public void inBlockOfThreeZeroShouldReturnBlockThree() {
        Node test = new Node(3,0);
        assertEquals(3, test.inBlock());
    }

    @Test
    public void inBlockOfFiveFiveShouldReturnBlockFour() {
        Node test = new Node(5,5);
        assertEquals(4, test.inBlock());
    }

    @Test
    public void inBlockOfFourEightShouldReturnBlockFive() {
        Node test = new Node(4,8);
        assertEquals(5, test.inBlock());
    }

    @Test
    public void inBlockOfSevenTwoShouldReturnBlockSix() {
        Node test = new Node(7,2);
        assertEquals(6, test.inBlock());
    }

    @Test
    public void inBlockOfSixFiveShouldReturnBlockSeven() {
        Node test = new Node(6,5);
        assertEquals(7, test.inBlock());
    }

    @Test
    public void inBlockOfEightEightShouldReturnBlockEight() {
        Node test = new Node(8,8);
        assertEquals(8, test.inBlock());
    }
}
