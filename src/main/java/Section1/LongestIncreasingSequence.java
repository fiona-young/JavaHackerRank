package Section1;
import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by FI on 11-Apr-16.
 */
public class LongestIncreasingSequence {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;
            Scanner s = new Scanner(br.readLine());
            int lines = s.nextInt();
            LongestIncreasingSequence mySolution = new LongestIncreasingSequence(lines);
            while ((input = br.readLine()) != null) {
                mySolution.addValue(input);
            }
            System.out.println(mySolution.calculate().toString());
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int sequenceLength;
    private int sequence[];
    private int sequencePointer=0;
    private int anyCount;

    public LongestIncreasingSequence(int sequenceLength) {
        this.sequenceLength = sequenceLength;
        this.sequence = new int[sequenceLength];
    }

    public void addValue(String inputLine) {
        Scanner s = new Scanner(inputLine);
        sequence[sequencePointer++] = s.nextInt();
    }


    public Integer calculate() {
        int dpArray[] = new int[sequenceLength];
        int val;
        int runningMax = 0;
        for(int i=0; i<sequenceLength;i++){
            int max = 0;
            val = sequence[seqKey(i)];
            for(int j=0; j<i;j++) {
                if(val<sequence[seqKey(j)]){
                    max = Integer.max(max,dpArray[j]);
                }
            }
            dpArray[i]=max+1;
            runningMax = Integer.max(max+1,runningMax);
        }
        return runningMax;
    }

    private int seqKey(int i){
        return sequenceLength-1-i;
    }
}
