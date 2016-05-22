package Section3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SubsetComponentTest {
    @Test
    public void testCase1() {
        String inputString = "3\n" +
                "2 5 9\n";
        String outputString = "504";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        SubsetComponent3.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(), actualOutput.toString().replace("\r", "").trim());
    }

    @Test
    public void testWorstCase() {
        String inputString = "20\n" +
                "13064769702345019347 17645604135140084697 14573023922744149389 9725327617823295938 " +
        "13706030454256814013 1061768711999361577 13628786686351584901 15849292096118399700 " +
        "16874439716125349329 2526794377617770837 10579495580343725574 12284449878999589071 " +
        "14544871209768210805 11034875607935546714 14772754046804214000 12899444798559069517 " +
        "15466126417063826708 1385341090865279291 17661415554894177718 4377492544227287154";
        String outputString = "1243695";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        SubsetComponent3.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(), actualOutput.toString().replace("\r", "").trim());
    }

    @Test
    public void testWorstCaseDisjoint() {
        String inputString = "20\n" +
                "3 24 288 384 " +
                "3072 12288 49152 458752 " +
                "11010048 1040187392 126701535232 16217796509696 " +
                "2075877953241088 472 60416 7733248 " +
                "989855744 126701535232 16217796509696 196608";
        String outputString = "44302336";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        SubsetComponent3.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(), actualOutput.toString().replace("\r", "").trim());
    }

     @Test
    public void testDisjointSets() {
        String inputString = "10\n" +
                "3 24 288 384 3072 12288 49152 196608 5153965387048937874 1721960921505604718";
        String outputString = "34304";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        SubsetComponent3.main(new String[0]);
        assertEquals("Comparison failed: ", outputString.trim(), actualOutput.toString().replace("\r", "").trim());
    }
}