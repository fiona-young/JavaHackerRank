package Section1;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by FI on 10-Apr-16.
 */
public class FibonacciModified {
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
            while ((input = br.readLine()) != null) {
                FibonacciModified mySolution = new FibonacciModified(input);
                System.out.println(mySolution);
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private BigInteger result;
    public FibonacciModified(String inputLine) {
        Scanner s = new Scanner(inputLine);
        String zeroTerm = s.next();
        String firstTerm = s.next();
        int requiredTerm = s.nextInt();
        BigInteger a = new BigInteger("84266613096281243382112");
        calculateRequired(zeroTerm,firstTerm,requiredTerm);
    }

    void calculateRequired(String zeroTerm, String firstTerm, int requiredTerm){
        BigInteger dp[] = new BigInteger[requiredTerm];
        dp[0]= new BigInteger(zeroTerm);
        dp[1]= new BigInteger(firstTerm);
        for(int i = 2; i<requiredTerm;i++){
            dp[i]=dp[i-1].pow(2).add(dp[i-2]);
        }
        result =  dp[requiredTerm-1];
    }

    public String toString(){
        return String.format("%s",result);
    }
}
