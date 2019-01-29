package Section1;
import Section1.ShortestReach;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by FI on 13-Apr-16.
 */
public class ShortestReachTest {

    @Test
    public void test1(){
        ShortestReach testSubject = new ShortestReach(" 4 2");
        testSubject.addEdge(" 1 2");
        testSubject.addEdge("  1   3");
        assertEquals("6 6 -1",testSubject.calculate("1"));
    }

    @Test
    public void test2(){
        ShortestReach testSubject = new ShortestReach(" 3 1 ");
        testSubject.addEdge(" 2 3");
        assertEquals("-1 6",testSubject.calculate("2"));
    }

}