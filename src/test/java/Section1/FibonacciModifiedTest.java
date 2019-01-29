package Section1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by FI on 10-Apr-16.
 */
public class FibonacciModifiedTest {
    @Test
    public void testSimple(){
        FibonacciModified testSubject = new FibonacciModified("0 1 5");
        assertEquals("5",testSubject.toString());
    }

    @Test
    public void testSimpleLong(){
        FibonacciModified testSubject = new FibonacciModified("0 1 10");
        assertEquals("84266613096281243382112",testSubject.toString());
    }
}