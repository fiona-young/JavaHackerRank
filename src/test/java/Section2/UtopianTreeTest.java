package Section2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by FI on 16-Apr-16.
 */
public class UtopianTreeTest {
    @Test
    public void testFileString() throws IOException {
        String testInput="3\n0\n1\n4\n";
        String testOutput = "1\n2\n7\n";
        Scanner scanIn = new Scanner(testInput);
        Scanner scanOut = new Scanner(testOutput);
        String input, expectedOutput, actualOutput;
        input = scanIn.nextLine().trim();
        UtopianTree utopianTree = new UtopianTree();
        int lines = Integer.valueOf(input);
        for (int i = 0; i < lines; i++) {
            input = scanIn.nextLine().trim();
            expectedOutput = scanOut.nextLine();
            actualOutput=utopianTree.calculate(Integer.valueOf(input));
            assertEquals("Input string: "+i+" "+input,expectedOutput.trim(), actualOutput.trim());
        }
    }


}