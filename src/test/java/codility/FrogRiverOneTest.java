package codility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrogRiverOneTest {

    private FrogRiverOne subject;

    @Before
    public void setUp() throws Exception {
        subject = new FrogRiverOne();
    }

    @Test
    public void testOne() {
        int result = subject.solution(5,new int[]{1,3,1,4,2,3,5,4});
        assertEquals(6,result);
    }

    @Test
    public void testTwo() {
        int result = subject.solution(5,new int[]{66,3,43,4,2,3,5,4});
        assertEquals(-1,result);
    }
}