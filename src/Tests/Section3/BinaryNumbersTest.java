package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 24-Apr-16.
 */
public class BinaryNumbersTest {
    @Test
    public void testCase1(){
        String inputString ="5";
        String outputString="1";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        BinaryNumbers.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase2(){
        String inputString ="13";
        String outputString="2";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        BinaryNumbers.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }
}