package Section1;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by FI on 10-Apr-16.
 */
public class AlienLanguages {
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
            int cases = s.nextInt();
            while ((input = br.readLine()) != null) {
                AlienLanguages mySolution = new AlienLanguages(input);
                System.out.println(mySolution.calculate().toString());
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int letterCount;
    private int wordLength;
    private int anyCount;

    public AlienLanguages(String inputLine) {
        Scanner s = new Scanner(inputLine);
        letterCount = s.nextInt();
        wordLength = s.nextInt();
        anyCount = letterCount - letterCount/2;
    }

    public BigInteger calculate() {
        BigInteger result = calculateDpCum();
        return result.mod(BigInteger.valueOf(100000007));
    }
    private BigInteger calculateDpCum() {
        BigInteger dpMatrix[][] = new BigInteger[wordLength][letterCount + 1];
        for (int iWord = 0; iWord < wordLength; iWord++) {
            for (int iLetter = letterCount; iLetter > 0; iLetter--) {
                dpMatrix[iWord][iLetter] = getDpCountCum(iWord, iLetter, dpMatrix);
            }
        }
        return dpMatrix[(wordLength-1)][1];
    }

    private BigInteger getDpCountCum(int iWord, int iLetter, BigInteger dpMatrix[][]) {
        BigInteger result = BigInteger.valueOf(0);
        if (iWord == 0) {
            if (iLetter > (letterCount / 2)) {
                result = BigInteger.valueOf(1);
            }
        } else {
            int myLetter;
            if(iLetter>(letterCount / 2)){
                myLetter = 1;
            }else{
                myLetter = iLetter*2;
            }
            result = dpMatrix[(iWord - 1)][myLetter];
        }
        if(iLetter<letterCount){
            result = result.add(dpMatrix[(iWord)][iLetter+1]);
        }
        return result;
    }
}
