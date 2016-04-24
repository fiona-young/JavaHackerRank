package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class SherlockAndAnagramsTest {
    @Test
    public void testCase1(){
        String inputString ="2\n" +
                "abba\n" +
                "abcd";
        String outputString="4\n" +
                "0";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        SherlockAndAnagrams.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase2(){
        String inputString ="5\n" +
                "ifailuhkqq\n" +
                "hucpoltgty\n" +
                "ovarjsnrbf\n" +
                "pvmupwjjjf\n" +
                "iwwhrlkpek";
        String outputString="3\n" +
                "2\n" +
                "2\n" +
                "6\n" +
                "3";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        SherlockAndAnagrams.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }

    @Test
    public void testCase3(){
        String inputString ="5\n" +
                "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel\n" +
                "gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde\n" +
                "mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw\n" +
                "ofeqjnqnxwidhbuxxhfwargwkikjqwyghpsygjxyrarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqktkryutpqvbgbgthfges\n" +
                "zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw";
        String outputString="399\n" +
                "471\n" +
                "370\n" +
                "403\n" +
                "428";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
       System.setOut(new PrintStream(actualOutput));
        SherlockAndAnagrams.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(),actualOutput.toString().replace("\r","").trim());
    }
}