package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddOccurrencesInArrayTest {
    @Test
    public void testOne(){
        OddOccurrencesInArray subject = new OddOccurrencesInArray();
        int result = subject.solution(new int[]{1,3,1});

        assertEquals(3, result);
    }

    @Test
    public void testTwo(){
        OddOccurrencesInArray subject = new OddOccurrencesInArray();
        int result = subject.solution(new int[]{3,3,1});

        assertEquals(1, result);
    }

    @Test
    public void testThree(){
        OddOccurrencesInArray subject = new OddOccurrencesInArray();
        int result = subject.solution(new int[]{9,3,7,3,2,3,1,1,7,3,9,2,7});

        assertEquals(7, result);
    }

}