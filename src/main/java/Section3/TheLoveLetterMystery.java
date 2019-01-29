package Section3;


import java.util.Scanner;

/**
 * Created by FI on 22-Apr-16.
 */
public class TheLoveLetterMystery {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        TheLoveLetterMystery theLoveLetterMystery = new TheLoveLetterMystery(scanIn);
    }

    TheLoveLetterMystery(Scanner scanIn){
        int count = scanIn.nextInt();
        scanIn.nextLine();
        for(int i=0; i<count; i++){
            String myString = scanIn.nextLine().trim();
            System.out.println(getChanges(myString));
        }
    }

    int getChanges(String myString){
        int changes = 0;
        for(int i = 0; i<myString.length()/2; i++){
            changes += Math.abs(myString.charAt(i)-myString.charAt(myString.length()-1-i));
        }
        return changes;
    }
}
