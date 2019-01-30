package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermCheckTest {

    @Test
    public void testOne() {
        PermCheck subject = new PermCheck();
        int result = subject.solution(new int[]{4,1,3,2});
        assertEquals(1, result);
    }

    @Test
    public void testTwo() {
        PermCheck subject = new PermCheck();
        int result = subject.solution(new int[]{4,1,3});
        assertEquals(0, result);
    }

    @Test
    public void testThree() {
        PermCheck subject = new PermCheck();
        int result = subject.solution(new int[]{9, 5, 7, 3, 2, 7, 3, 1, 10, 8});
        assertEquals(0, result);
    }
}