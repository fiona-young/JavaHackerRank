package codility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoTaskTest {

    private DemoTask subject;

    @Before
    public void setUp() throws Exception {
        subject = new DemoTask();
    }

    @Test
    public void testOne() {
        int result = subject.solution(new int[]{1, 3, 6, 4, 1, 2});
        assertEquals(5,result);
    }

    @Test
    public void testTwo() {
        int result = subject.solution(new int[]{3});
        assertEquals(5,result);
    }
}