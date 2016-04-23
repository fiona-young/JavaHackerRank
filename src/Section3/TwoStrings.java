package Section3;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by FI on 23-Apr-16.
 */
public class TwoStrings {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        TwoStrings myTwoStrings = new TwoStrings();
        myTwoStrings.readIn(scanIn);
    }

    void readIn(Scanner scanIn){
        int cases = scanIn.nextInt();
        scanIn.nextLine();
        for(int i=0;i<cases;i++) {
            System.out.println(isCommonSubstring(scanIn.nextLine().trim(), scanIn.nextLine().trim()));
        }
    }

    String isCommonSubstring(String string1, String string2){
        HashSet<Character> string1Set = new HashSet<>();
        for(char myChar : string1.toCharArray()){
            string1Set.add(myChar);
        }
        for(char myChar : string2.toCharArray()){
            if(string1Set.contains(myChar)){
                return "YES";
            }
        }
        return "NO";
    }
}
