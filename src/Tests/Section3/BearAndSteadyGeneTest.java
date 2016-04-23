package Section3;

import org.junit.Test;

import java.io.*;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class BearAndSteadyGeneTest {
    @Test
    public void testCase1(){
        String inputString ="8  \n" +
                "GAAATAAA";
        String expectedOutput = "5";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        BearAndSteadyGene.main(new String[0]);
        assertEquals(expectedOutput,actualOutput.toString().trim());
    }

    @Test
    public void testCase2(){
        String inputString ="8  \n" +
                "GAAATAAT";
        String expectedOutput = "3";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        BearAndSteadyGene.main(new String[0]);
        assertEquals(expectedOutput,actualOutput.toString().trim());
    }

    @Test
    public void testCase3() throws FileNotFoundException {
        String outputString = "150017";
        String fileNameIn = "BearAndSteadyIn1.txt";
        URL pathIn = this.getClass().getResource(fileNameIn);
        System.setIn(new FileInputStream(new File(pathIn.getFile())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        BearAndSteadyGene.main(new String[0]);
        assertEquals("Output differs",outputString.replace("\r","").trim(),baos.toString().replace("\r","").trim());
    }
}