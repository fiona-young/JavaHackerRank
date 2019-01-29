package main.java;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        Solution myFunnyString = new Solution(scanIn);
    }

    public Solution(Scanner scanIn) {
        int strCount = scanIn.nextInt();
        scanIn.nextLine();
        for(int i = 0; i < strCount; i++){
            String myStr = scanIn.nextLine().trim();
            checkFunny(myStr);
        }
    }

    void checkFunny(String myStr){
        boolean isFunny = true;
        for(int i=0;i<(myStr.length()/2);i++){
            int diff1 = myStr.charAt(i)-myStr.charAt(i+1);
            int diff2 = myStr.charAt(myStr.length()-2-i)-myStr.charAt(myStr.length()-1-i);
            if(diff1 != diff2){
                isFunny = false;
                break;
            }
        }
        if(isFunny){
            System.out.println("Funny");
        }else{
            System.out.println("Not Funny");
        }
    }
}
