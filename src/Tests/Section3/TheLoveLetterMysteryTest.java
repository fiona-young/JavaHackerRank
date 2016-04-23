package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 22-Apr-16.
 */
public class TheLoveLetterMysteryTest {
    @Test
    public void testStringDirectVal1() throws IOException {
        String testInput = "4\n " +
        "abc\n" +
                "abcba\n" +
                "abcd\n" +
                "cba";
        String testOutput = "2\n" +
                "0\n" +
                "4\n" +
                "2";
        System.setIn( new ByteArrayInputStream( testInput.getBytes() ));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        TheLoveLetterMystery.main(new String[0]);
        assertEquals("Expected results do not match:", testOutput.replaceAll("\r","").trim(), baos.toString().replaceAll("\r","").trim());
        baos.reset();
    }

}