package Section2;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 16-Apr-16.
 */
public class BiggerIsGreaterTest {
    @Test
    public void testLongFile() throws IOException {
        String fileNameIn =  "BiggerIsGreaterTestIn.txt";
        String fileNameOut = "BiggerIsGreaterTestOut.txt";
        URL pathIn = BiggerIsGreaterTest.class.getResource(fileNameIn);
        URL pathOut = BiggerIsGreaterTest.class.getResource(fileNameOut);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
        Scanner scanOut = new Scanner(new File(pathOut.getFile()));
        String input, expectedOutput, actualOutput;
        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(outputStream));
        input = scanIn.nextLine().trim();
        int lines = Integer.valueOf(input);
        for (int i = 0; i < lines; i++) {
            input = scanIn.nextLine().trim();
            expectedOutput = scanOut.nextLine();
            BiggerIsGreater mySolution = new BiggerIsGreater(input);
            actualOutput=mySolution.calculate();
            assertEquals("Input string: "+i+" "+input,expectedOutput.trim(), actualOutput.trim());
            //outputStream.reset();
        }
    }

    @Test
    public void testRepeatedChar(){
        String input = "zyidilgenkmwlssnahsjcibbtktkkrxbmkncqvircgpqwuu";
        String expectedOutput = "zyidilgenkmwlssnahsjcibbtktkkrxbmkncqvircgpuquw";
        BiggerIsGreater mySolution = new BiggerIsGreater(input);
        String actualOutput=mySolution.calculate();
        assertEquals("Input string: "+input,expectedOutput.trim(), actualOutput.trim());
    }

}