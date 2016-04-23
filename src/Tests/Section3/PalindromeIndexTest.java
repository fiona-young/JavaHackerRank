package Section3;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class PalindromeIndexTest {
    @Test
    public void testCase1(){
        String inputString ="3\n" +
                "aaab\n" +
                "baa\n" +
                "aaa";
        String expectedOutput = "3\n" +
                "0\n" +
                "-1";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        PalindromeIndex.main(new String[0]);
        assertEquals("Output does not match:",expectedOutput.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase2() throws FileNotFoundException {
        String expectedOutput = "16722\n" +
                "76661\n" +
                "10035\n" +
                "57089\n" +
                "46674";
        String fileNameIn = "PalindromeIndexIn1.txt";
        URL pathIn = this.getClass().getResource(fileNameIn);
        System.setIn(new FileInputStream(new File(pathIn.getFile())));;
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        PalindromeIndex.main(new String[0]);
        assertEquals("Output does not match:",expectedOutput.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase3() throws FileNotFoundException {
        String fileNameIn = "PalindromeIndexIn1.txt";
        URL pathIn = this.getClass().getResource(fileNameIn);
        Scanner scanIn = new Scanner(new File(pathIn.getFile()));
       // System.setIn(new FileInputStream(new File(pathIn.getFile())));
        //ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
       // System.setOut(new PrintStream(actualOutput));
        for(int i=0;i<4;i++) {
            scanIn.nextLine();
        }
        PalindromeIndex myPalindrome = new PalindromeIndex();
        assertEquals("Output does not match:",57089,myPalindrome.getChangeIndex(scanIn.nextLine().trim()));
    }
}