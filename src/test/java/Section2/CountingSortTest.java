package Section2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 16-Apr-16.
 */
public class CountingSortTest {
    @Test
    public void testFileString() throws IOException {
        String testInput = "20\n" +
                "0 ab\n" +
                "6 cd\n" +
                "0 ef\n" +
                "6 gh\n" +
                "4 ij\n" +
                "0 ab\n" +
                "6 cd\n" +
                "0 ef\n" +
                "6 gh\n" +
                "0 ij\n" +
                "4 that\n" +
                "3 be\n" +
                "0 to\n" +
                "1 be\n" +
                "5 question\n" +
                "1 or\n" +
                "2 not\n" +
                "4 is\n" +
                "2 to\n" +
                "4 the";
        String testOutput = "- - - - - to be or not to be - that is the question - - - -";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String input, expectedOutput, actualOutput;
        input = scanIn.nextLine().trim();
        int numList = Integer.valueOf(input);
        CountingSort testSubject = new CountingSort(numList);
       for(int i = 0; i<numList; i++) {
            testSubject.addLine(scanIn.nextInt(),scanIn.next().trim());
       }
        expectedOutput = scanOut.nextLine();
        testSubject.calculate();
        actualOutput =baos.toString().trim();
        assertEquals("Input string: " + input, expectedOutput.trim(), actualOutput.trim());
        baos.reset();
    }
}