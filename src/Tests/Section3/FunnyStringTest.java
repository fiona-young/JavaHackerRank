package Section3;

import Section2.InsertionSortAdvanced;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class FunnyStringTest {
    @Test
    public void testIsFunny(){
        String inputString ="2\n" +
                "acxz\n" +
                "bcxz";
        String outputString = "Funny\n" +
                "Not Funny";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        FunnyString.main(new String[0]);
        assertEquals("Output differs",outputString.replace("\r","").trim(),baos.toString().replace("\r","").trim());
    }

    @Test
    public void testIsFunny2() throws FileNotFoundException {
        String outputString = "Not Funny\n" +
                "Funny\n" +
                "Funny\n" +
                "Not Funny\n" +
                "Funny\n" +
                "Not Funny\n" +
                "Not Funny\n" +
                "Funny\n" +
                "Funny\n" +
                "Funny";
        String fileNameIn = "FunnyStringIn1.txt";
        URL pathIn = this.getClass().getResource(fileNameIn);
        System.setIn(new FileInputStream(new File(pathIn.getFile())));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        FunnyString.main(new String[0]);
        assertEquals("Output differs",outputString.replace("\r","").trim(),baos.toString().replace("\r","").trim());
    }
}