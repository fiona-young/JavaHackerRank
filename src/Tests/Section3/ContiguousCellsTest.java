package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 24-Apr-16.
 */
public class ContiguousCellsTest {
    @Test
    public void testCase1(){
        String inputString ="18,00,95,40,36,26,57,48,54,65,76,87,97,47,00";
        String outputString="3\n" +
                "1\n" +
                "-1\n" +
                "2\n" +
                "0\n" +
                "1";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ContiguousCells.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase2(){
        String inputString ="18,00,95,40,36,26,57,48,54,65,76,87,97,47,00,60,90,61,91,62,72,82,92";
        String outputString="3\n" +
                "1\n" +
                "-1\n" +
                "2\n" +
                "0\n" +
                "1";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        ContiguousCells.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }
}