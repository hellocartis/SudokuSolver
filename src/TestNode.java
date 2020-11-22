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
}
