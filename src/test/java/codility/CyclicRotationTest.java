package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicRotationTest {
    @Test
    public void testOne(){
        CyclicRotation subject = new CyclicRotation();
        int[] result = subject.solution(new int[]{3, 8, 9, 7, 6}, 3);
        assertArrayEquals(new int[]{9,7,6,3,8},result);
    }

    @Test
    public void testTwo(){
        CyclicRotation subject = new CyclicRotation();
        int[] result = subject.solution(new int[]{1,2,3}, 0);
        assertArrayEquals(new int[]{1,2,3},result);
    }

    @Test
    public void testThree(){
        CyclicRotation subject = new CyclicRotation();
        int[] result = subject.solution(new int[]{1,2,3,4}, 4);
        assertArrayEquals(new int[]{1,2,3,4},result);
    }

    @Test
    public void testFour(){
        CyclicRotation subject = new CyclicRotation();
        int[] result = subject.solution(new int[]{1,2,3,4}, 8);
        assertArrayEquals(new int[]{1,2,3,4},result);
    }


    @Test
    public void testFive(){
        CyclicRotation subject = new CyclicRotation();
        int[] result = subject.solution(new int[]{}, 8);
        assertArrayEquals(new int[]{},result);
    }


}