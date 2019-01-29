package Section2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 17-Apr-16.
 */
public class InsertionSortAdvancedTest {
    @Test
    public void testStringDirectVal1() throws IOException {
        String testInput = "5  \n" +
                "1 1 1 2 2  \n";
        String testOutput = "0\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVal2() throws IOException {
        String testInput = "5  \n" +
                "2 1 3 1 2";
        String testOutput = "4\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }


    @Test
    public void testStringDirectVal3() throws IOException {
        String testInput = "5  \n" +
                "2 5 4 1 3";
        String testOutput = "6\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVal4() throws IOException {
        String testInput = "5  \n" +
                "5 4 3 2 1";
        String testOutput = "10\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVal5() throws IOException {
        String testInput = "7  \n" +
                "9 5 4 6 1 8 7";
        String testOutput = "11\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testLongString() throws IOException {

        String testInput = "2  \n" +
                "5  \n" +
                "1 1 1 2 2  \n" +
                "5  \n" +
                "2 1 3 1 2";
        String testOutput = "0\n" +
                "4";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        int testCases = scanIn.nextInt();
        for (int i = 0; i < testCases; i++) {
            InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
            testSubject.calculate();
            assertEquals("Input string: ", scanOut.nextLine().trim(), baos.toString().trim());
            baos.reset();
        }

    }

    @Test
    public void testFileString1() throws IOException {
        String fileNameIn = "InsertionSortAdvancedIn1.txt";
        String testOutput = "0\n" +
                "0\n" +
                "0\n" +
                "4999950000\n" +
                "4999950000";
        URL pathIn = InsertionSortAdvanced.class.getResource(fileNameIn);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        int testCases = scanIn.nextInt();
        for (int i = 0; i < testCases; i++) {
            InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
            testSubject.calculate();
            assertEquals("Input string: ", scanOut.nextLine().trim(), baos.toString().trim());
            baos.reset();
        }
    }

    @Test
    public void testFileString2() throws IOException {
        String fileNameIn = "InsertionSortAdvancedIn2.txt";
        String testOutput = "233522831\n" +
                "128027785\n" +
                "7351907\n" +
                "3203642\n" +
                "839080835";
        URL pathIn = InsertionSortAdvanced.class.getResource(fileNameIn);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        int testCases = scanIn.nextInt();
        for (int i = 0; i < testCases; i++) {
            InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
            testSubject.calculate();
            assertEquals("Input string: ", scanOut.nextLine().trim(), baos.toString().trim());
            baos.reset();
        }
    }

    @Test
    public void testFileString3() throws IOException {
        String fileNameIn = "InsertionSortAdvancedIn3.txt";
        String testOutput = "38046\n" +
                "78149\n" +
                "97560\n" +
                "174498\n" +
                "3083";
        URL pathIn = InsertionSortAdvanced.class.getResource(fileNameIn);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        int testCases = scanIn.nextInt();
        for (int i = 0; i < testCases; i++) {
            InsertionSortAdvanced testSubject = new InsertionSortAdvanced(scanIn);
            testSubject.calculate();
            assertEquals("Input string: ", scanOut.nextLine().trim(), baos.toString().trim());
            baos.reset();
        }
    }

}