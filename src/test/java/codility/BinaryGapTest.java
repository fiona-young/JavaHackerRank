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

    @Test
    public void test1041(){
        BinaryGap subject = new BinaryGap();
        int result = subject.solution(1041);

        assertEquals(5, result);
    }

    @Test
    public void test2147483647(){
        BinaryGap subject = new BinaryGap();
        int result = subject.solution(2147483647);

        assertEquals(5, result);
    }

}
