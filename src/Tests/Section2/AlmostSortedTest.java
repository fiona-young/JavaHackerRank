package Section2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 16-Apr-16.
 */
public class AlmostSortedTest {
    private StringBuilder actualOutput=new StringBuilder();
    private StringBuilder expectedOutput = new StringBuilder();

    @Test
    public void testStringDirect() throws IOException {
        String testInput = "2  \n" +
                "4 2\n";
        String testOutput = "yes  \n" +
                "swap 1 2\n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AlmostSorted testSubject = new AlmostSorted(scanIn);
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        while (scanOut.hasNextLine()) {
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVer2() throws IOException {
        String testInput = "3\n" +
                "3 1 2\n";
        String testOutput = "no  \n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AlmostSorted testSubject = new AlmostSorted(scanIn);
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        while (scanOut.hasNextLine()) {
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }
    @Test
    public void testStringDirectVer3() throws IOException {
        String testInput = "6\n" +
                "1 5 4 3 2 6\n";
        String testOutput = "yes\n" +
                "reverse 2 5\n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AlmostSorted testSubject = new AlmostSorted(scanIn);
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        while (scanOut.hasNextLine()) {
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVer4() throws IOException {
        String testInput = "6\n" +
                "1 2 3 6 5 4\n";
        String testOutput = "yes\n" +
                "reverse 4 6\n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AlmostSorted testSubject = new AlmostSorted(scanIn);
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        while (scanOut.hasNextLine()) {
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVer5() throws IOException {
        String testInput = "6\n" +
                "1 5 3 4 2 6\n";
        String testOutput = "yes\n" +
                "swap 2 5\n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AlmostSorted testSubject = new AlmostSorted(scanIn);
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        while (scanOut.hasNextLine()) {
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectVer6() throws IOException {
        String testInput = "6\n" +
                "1 2 3 4 5 6\n";
        String testOutput = "yes\n" ;
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AlmostSorted testSubject = new AlmostSorted(scanIn);
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        while (scanOut.hasNextLine()) {
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }
}