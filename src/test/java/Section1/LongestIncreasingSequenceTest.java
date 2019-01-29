package Section1;

        import Section1.LongestIncreasingSequence;
        import org.junit.Test;

        import static org.junit.Assert.*;

/**
 * Created by FI on 11-Apr-16.
 */
public class LongestIncreasingSequenceTest {
    @Test
    public void testInitial(){
        int myArray[] = {5,2,7,4,3,8};
        LongestIncreasingSequence subject = new LongestIncreasingSequence(myArray.length);
        for(int i: myArray){
            subject.addValue(Integer.toString(i));
        }
        assertEquals("3",subject.calculate().toString());
    }

    @Test
    public void test2(){
        String myArray[] = "19 43 82 23 74 9 57 91 86 59 74 29 43 57 71 1 46 33 8 11 44 89 2 73 82 74 44 27 57 40 23 27 82 56 1 7 64 57 98 49 68 23 77 10 31 48 10 76 32 70 38 27 10 39 99 92 64 95 18 21 34 92 47 67 48 48 73 63 56 70 64 23 92 40 84 22 39 46 49 22 15 87 49 76 77 99 67 41 45 36 61 30 80".split(" ");
        LongestIncreasingSequence subject = new LongestIncreasingSequence(myArray.length);
        for(String i: myArray){
            subject.addValue(i);
        }
        assertEquals("3",subject.calculate().toString());
    }

}