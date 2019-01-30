package codility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxCountersTest {
    private MaxCounters subject;

    @Before
    public void setUp() throws Exception {
        subject = new MaxCounters();
    }

    @Test
    public void testOne() {
        int[] result = subject.solution(5,new int[]{3,4,4,6,1,4,4});
        assertArrayEquals(new int[]{3,2,2,4,2},result);
    }
}