package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class AnagramTest {
    @Test
    public void testCase1(){
        String inputString ="6\n" +
                "aaabbb\n" +
                "ab\n" +
                "abc\n" +
                "mnop\n" +
                "xyyx\n" +
                "xaxbbbxx";
        String outputString="3\n" +
                "1\n" +
                "-1\n" +
                "2\n" +
                "0\n" +
                "1";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        Anagram.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }
}