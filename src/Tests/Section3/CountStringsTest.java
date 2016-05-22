package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 26-Apr-16.
 */
public class CountStringsTest {
    @Test
    public void testCase1(){
        String inputString="3  \n" +
                "((ab)|(ba)) 2  \n" +
                "((a|b)*) 5  \n" +
                "((a*)(b(a*))) 100";
        String outputString="2  \n" +
                "32  \n" +
                "100";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(actualOutput));
        CountStrings.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }
}