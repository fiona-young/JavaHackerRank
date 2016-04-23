package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 20-Apr-16.
 */
public class LongestCommonSubsequenceTest {
    @Test
    public void testStringDirectVal1() throws IOException {
        String testInput = "5 6\n" +
                "1 2 3 4 1\n" +
                "3 4 1 2 1 3";
        String testOutput = "1 2 3";
        System.setIn( new ByteArrayInputStream( testInput.getBytes() ));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        LongestCommonSubsequence.main(new String[0]);
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVal2() throws IOException {
        String testInput = "6 6\n" +
                "3 4 1 2 1 3\n" +
                "3 4 1 2 1 3";
        String testOutput = "3 4 1 2 1 3";
        System.setIn( new ByteArrayInputStream( testInput.getBytes() ));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        LongestCommonSubsequence.main(new String[0]);
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVal3() throws IOException {
        String testInput = "9 10\n" +
                "3 9 8 3 9 7 9 7 0\n" +
                "3 3 9 9 9 1 7 2 0 6";
        String testOutput = "3 9 9 9 7 0";
        System.setIn( new ByteArrayInputStream( testInput.getBytes() ));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        LongestCommonSubsequence.main(new String[0]);
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

}