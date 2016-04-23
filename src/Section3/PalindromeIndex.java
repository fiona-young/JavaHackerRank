package Section3;

import java.util.Scanner;

/**
 * Created by FI on 23-Apr-16.
 */
public class PalindromeIndex {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        PalindromeIndex mySolution = new PalindromeIndex();
        mySolution.readIn(scanIn);
    }

    void readIn(Scanner scanIn){
        int cases = scanIn.nextInt();
        scanIn.nextLine();
        for(int i=0;i<cases; i++){
            System.out.println(getChangeIndex(scanIn.nextLine().trim()));
        }
    }

    int getChangeIndex(String inputString){
        for(int i=0;i<inputString.length()/2;i++)
        {
            if(inputString.charAt(i)!=inputString.charAt(inputString.length()-1-i)){
                if((inputString.charAt(i+1)==inputString.charAt(inputString.length()-1-i)) &&
                        (inputString.charAt(i+2)==inputString.charAt(inputString.length()-2-i) )){
                    return i;
                }else{
                    return inputString.length()-1-i;
                }
            }
        }
        return -1;
    }
}
