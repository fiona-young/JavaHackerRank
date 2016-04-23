package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class MakeItAnagramTest {
    @Test
    public void testCase1(){
        String inputString ="cde\n" +
                "abc";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        MakeItAnagram.main(new String[0]);
        assertEquals("4",actualOutput.toString().trim());
    }

}