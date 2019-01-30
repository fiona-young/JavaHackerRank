package codility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassingCarsTest {
    private PassingCars subject;

    @Before
    public void setUp() throws Exception {
        subject = new PassingCars();
    }

    @Test
    public void testOne() {
        int result = subject.solution(new int[]{0,1,0,1,1});
        assertEquals(5,result);
    }
}