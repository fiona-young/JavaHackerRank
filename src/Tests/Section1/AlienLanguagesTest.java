package Section1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by FI on 10-Apr-16.
 */
public class AlienLanguagesTest {
    @Test
    public void testSimple0() {
        AlienLanguages testSubject = new AlienLanguages("1 3");
        assertEquals("1", testSubject.calculate().toString());
    }

    @Test
    public void testSimple1() {
        AlienLanguages testSubject = new AlienLanguages("2 3");
        assertEquals("3", testSubject.calculate().toString());
    }

    @Test
    public void testSimple2() {
        AlienLanguages testSubject = new AlienLanguages("3 2");
        assertEquals("6", testSubject.calculate().toString());
    }

    @Test
    public void testSimple3() {
        AlienLanguages testSubject = new AlienLanguages("5 4");
        assertEquals("253", testSubject.calculate().toString());
    }

    @Test
    public void testBigger0() {
        AlienLanguages testSubject = new AlienLanguages("10000 1");
        assertEquals("5000", testSubject.calculate().toString());

    }

    @Test
    public void testBigger1() {
        AlienLanguages testSubject = new AlienLanguages("10000 2");
        assertEquals("43750000", testSubject.calculate().toString());

    }

    @Test
    public void testBigger2() {
        AlienLanguages testSubject = new AlienLanguages("10000 3");
        assertEquals("29143101", testSubject.calculate().toString());

    }

    @Test
    public void testBigger3() {
        AlienLanguages testSubject = new AlienLanguages("10000 4");
        assertEquals("96187357", testSubject.calculate().toString());

    }

    @Test
    public void testBigger4() {
        AlienLanguages testSubject = new AlienLanguages("10000 5");
        assertEquals("95307470", testSubject.calculate().toString());

    }

    @Test
    public void testSmallish0() {
        AlienLanguages testSubject = new AlienLanguages("5 10");
        assertEquals("1550477", testSubject.calculate().toString());
    }

        @Test
        public void testSmallish1() {
            AlienLanguages testSubject = new AlienLanguages("5 40");
            assertEquals("16632198", testSubject.calculate().toString());
        }

    @Test
    public void testGiant1() {
        AlienLanguages testSubject = new AlienLanguages("10000 500000");
        assertEquals("27311793", testSubject.calculate().toString());

    }
}
/*

       5
10000 500000
9999 499999
9998 499998
9997 499997
9996 499996

        27311793
56225236
10652216
15017890
2074407
*/

