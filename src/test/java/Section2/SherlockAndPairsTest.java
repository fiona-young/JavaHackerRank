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
public class SherlockAndPairsTest {

    @Test
    public void testStringDirect() throws IOException {
        String testInput = "3\n1 2 3\n";
        String testOutput = "0\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        SherlockAndPairs testSubject = new SherlockAndPairs(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirect1() throws IOException {
        String testInput = "3\n1 1 2\n";
        String testOutput = "2\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        SherlockAndPairs testSubject = new SherlockAndPairs(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testStringDirectRepeatedValues() throws IOException {
        String testInput = "40\n1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n";
        String testOutput = "1560\n";
        Scanner scanIn = new Scanner(testInput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        SherlockAndPairs testSubject = new SherlockAndPairs(scanIn);
        testSubject.calculate();
        assertEquals("Input string: ", testOutput.trim(), baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testFileString() throws IOException {
        String fileNameIn = "SherlockAndPairsIn.txt";
        String fileNameOut = "SherlockAndPairsOut.txt";
        URL pathIn = SherlockAndPairsTest.class.getResource(fileNameIn);
        URL pathOut = SherlockAndPairsTest.class.getResource(fileNameOut);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
        Scanner scanOut = new Scanner(new File(pathOut.getFile()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        int testCases = scanIn.nextInt();

        for (int i = 0; i < testCases; i++) {
            if(i==3){
                int a = 1;
            }
            SherlockAndPairs testSubject = new SherlockAndPairs(scanIn);
            testSubject.calculate();
            assertEquals("Input string: ", scanOut.nextLine().trim(), baos.toString().trim());
            baos.reset();
        }
    }
}