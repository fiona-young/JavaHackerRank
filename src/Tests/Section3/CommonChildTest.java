package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 25-Apr-16.
 */
public class CommonChildTest {
    @Test
    public void testCase1(){
        String inputString="HARRY\n" +
                "SALLY";
        String outputString="2";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        CommonChild.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase2(){
        String inputString="AAA\n" +
                "AAA";
        String outputString="3";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        CommonChild.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase3(){
        String inputString="ABCDEF\n" +
                "FBDAMN";
        String outputString="2";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        CommonChild.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase4(){
        String inputString="ABCD\n" +
                "ABDC";
        String outputString="3";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        CommonChild.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase5(){
        String inputString="ELGGYJWKTDHLXJRBJLRYEJWVSUFZKYHOIKBGTVUTTOCGMLEXWDSXEBKRZTQUVCJNGKKRMUUBACVOEQKBFFYBUQEMYNENKYYGUZSP\n" +
                "FRVIFOVJYQLVZMFBNRUTIYFBMFFFRZVBYINXLDDSVMPWSQGJZYTKMZIPEGMVOUQBKYEWEYVOLSHCMHPAZYTENRNONTJWDANAMFRX";
        String outputString="27";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        CommonChild.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase6(){
        String inputString="ABABABBA\n" +
                "BAABAAB";
        String outputString="5";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        CommonChild.main(new String[0]);
        assertEquals("Results differ",outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }
}