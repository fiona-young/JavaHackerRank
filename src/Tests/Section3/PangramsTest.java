package Section3;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 17-Apr-16.
 */
public class PangramsTest {
    @Test
    public void testStringDirectVal1() throws IOException {
        String testInput = "We promptly judged antique ivory buckles for the next prize ";
        String testOutput = "pangram";
        System.setIn( new ByteArrayInputStream( testInput.getBytes() ));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Pangrams.main(new String[0]);
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVal2() throws IOException {
        String testInput = "We promptly judged antique ivory buckles for the prize   ";
        String testOutput = "not pangram";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Pangrams testSubject = new Pangrams(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

}