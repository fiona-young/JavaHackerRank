package codility;


import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryGapTest {
    @Test
    public void testOne(){
        BinaryGap subject = new BinaryGap();
        int result = subject.solution(1);

        assertEquals(0, result);
    }

}
