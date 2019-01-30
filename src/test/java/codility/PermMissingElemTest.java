package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermMissingElemTest {
    @Test
    public void testOne(){
        PermMissingElem subject = new PermMissingElem();
        int result = subject.solution(new int[]{2,3,1,5});
        assertEquals(4,result);
    }

    @Test
    public void testTwo(){
        PermMissingElem subject = new PermMissingElem();
        int result = subject.solution(new int[]{2,3,1,4});
        assertEquals(5,result);
    }
}