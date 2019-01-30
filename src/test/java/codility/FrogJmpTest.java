package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogJmpTest {
    @Test
    public void testOne(){
        FrogJmp subject = new FrogJmp();
        int result = subject.solution(10, 85,30);
        assertEquals(3,result);
    }

    @Test
    public void testTwo(){
        FrogJmp subject = new FrogJmp();
        int result = subject.solution(1, 1000000000,1);
        assertEquals(999999999,result);
    }

    @Test
    public void testThree(){
        FrogJmp subject = new FrogJmp();
        int result = subject.solution(1, 1,1);
        assertEquals(0,result);
    }

    @Test
    public void testFour(){
        FrogJmp subject = new FrogJmp();
        int result = subject.solution(1, 2,1);
        assertEquals(1,result);
    }
}