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
 * Created by FI on 16-Apr-16.
 */
public class SherlockAndWatsonTest {
    @Test
    public void testStringDirect() throws IOException {
        String testInput = "3 2 3\n" +
                "1 2 3\n" +
                "0\n" +
                "1\n" +
                "2\n";
        String testOutput = "2\n" +
                "3\n" +
                "1\n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String expectedOutput;
        SherlockAndWatson testSubject = new SherlockAndWatson(scanIn);
        //for(int i = 0; i<numList; i++) {
        //   testSubject.addLine(scanIn.nextInt(),scanIn.next().trim());
        // }
       // expectedOutput = scanOut.nextLine();
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        StringBuilder actualOutput=new StringBuilder();
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", testOutput.trim(), actualOutput.toString().trim());
        baos.reset();
    }

    @Test
    public void testFileString() throws IOException {
        String fileNameIn =  "SherlockAndWatsonIn.txt";
        String fileNameOut = "SherlockAndWatsonOut.txt";
        URL pathIn = SherlockAndWatsonTest.class.getResource(fileNameIn);
        URL pathOut = SherlockAndWatsonTest.class.getResource(fileNameOut);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
        Scanner scanOut = new Scanner(new File(pathOut.getFile()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        SherlockAndWatson testSubject = new SherlockAndWatson(scanIn);
        //for(int i = 0; i<numList; i++) {
        //   testSubject.addLine(scanIn.nextInt(),scanIn.next().trim());
        // }
        // expectedOutput = scanOut.nextLine();
        testSubject.calculate();
        Scanner outputStream =new Scanner(baos.toString().trim());
        StringBuilder actualOutput=new StringBuilder();
        StringBuilder expectedOutput = new StringBuilder();
        while (outputStream.hasNextLine()) {
            actualOutput.append(outputStream.nextLine().trim()).append('\n');
            expectedOutput.append(scanOut.nextLine().trim()).append('\n');
        }
        assertEquals("Input string: ", expectedOutput.toString().trim(), actualOutput.toString().trim());
        baos.reset();
    }
}