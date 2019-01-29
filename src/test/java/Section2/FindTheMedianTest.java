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
public class FindTheMedianTest {
    @Test
    public void testFileStringDirect() throws IOException {
        String testInput = "7\n" +
                "0 1 2 4 6 5 3\n";
        String testOutput = "3";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String input, expectedOutput, actualOutput;
        input = scanIn.nextLine().trim();
        int numList = Integer.valueOf(input);
        FindTheMedian testSubject = new FindTheMedian(numList,scanIn.nextLine().trim());
        //for(int i = 0; i<numList; i++) {
         //   testSubject.addLine(scanIn.nextInt(),scanIn.next().trim());
       // }
        expectedOutput = scanOut.nextLine();
        testSubject.calculate();
        actualOutput =baos.toString().trim();
        assertEquals("Input string: " + input, expectedOutput.trim(), actualOutput.trim());
        baos.reset();
    }

    @Test
    public void testFileStringGreater() throws IOException {
        String testInput = "7\n" +
                "0 1 2 3 4 6 5\n";
        String testOutput = "3";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String input, expectedOutput, actualOutput;
        input = scanIn.nextLine().trim();
        int numList = Integer.valueOf(input);
        FindTheMedian testSubject = new FindTheMedian(numList,scanIn.nextLine().trim());
        //for(int i = 0; i<numList; i++) {
        //   testSubject.addLine(scanIn.nextInt(),scanIn.next().trim());
        // }
        expectedOutput = scanOut.nextLine();
        testSubject.calculate();
        actualOutput =baos.toString().trim();
        assertEquals("Input string: " + input, expectedOutput.trim(), actualOutput.trim());
        baos.reset();
    }

    @Test
    public void testFileStringLess() throws IOException {
        String testInput = "7\n" +
                "0 2 3 4 6 5 1\n";
        String testOutput = "3";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String input, expectedOutput, actualOutput;
        input = scanIn.nextLine().trim();
        int numList = Integer.valueOf(input);
        FindTheMedian testSubject = new FindTheMedian(numList,scanIn.nextLine().trim());
        //for(int i = 0; i<numList; i++) {
        //   testSubject.addLine(scanIn.nextInt(),scanIn.next().trim());
        // }
        expectedOutput = scanOut.nextLine();
        testSubject.calculate();
        actualOutput =baos.toString().trim();
        assertEquals("Input string: " + input, expectedOutput.trim(), actualOutput.trim());
        baos.reset();
    }
}