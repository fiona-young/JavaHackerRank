package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class TwoStringsTest {
    @Test
    public void testCase1(){
        String inputString="2\n" +
                "hello\n" +
                "world\n" +
                "hi\n" +
                "world";
        String outputString="YES\n" +
                "NO";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        TwoStrings.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

}