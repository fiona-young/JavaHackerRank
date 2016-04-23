package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class GameOfThrones1Test {
    @Test
    public void testCase1(){
        String inputString = "aaabbbb";
        String expectedOutput = "YES";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        GameOfThrones1.main(new String[0]);
        assertEquals(expectedOutput,actualOutput.toString().trim());
    }

    @Test
    public void testCase2(){
        String inputString = "cdefghmnopqrstuvw";
        String expectedOutput = "NO";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        GameOfThrones1.main(new String[0]);
        assertEquals(expectedOutput,actualOutput.toString().trim());
    }

    @Test
    public void testCase3(){
        String inputString = "cdcdcdcdeeeef";
        String expectedOutput = "YES";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        GameOfThrones1.main(new String[0]);
        assertEquals(expectedOutput,actualOutput.toString().trim());
    }
}