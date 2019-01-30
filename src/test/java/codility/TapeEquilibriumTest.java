package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class TapeEquilibriumTest {
    @Test
    public void testOne(){
        TapeEquilibrium subject = new TapeEquilibrium();
        int result = subject.solution(new int[]{3,1,2,4,3});
        assertEquals(1,result);
    }

    @Test
    public void testTwo(){
        TapeEquilibrium subject = new TapeEquilibrium();
        int result = subject.solution(new int[]{3,3});
        assertEquals(0,result);
    }
}