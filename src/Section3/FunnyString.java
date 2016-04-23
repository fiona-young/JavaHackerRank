package Section3;

import java.util.Scanner;

public class FunnyString {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        FunnyString myFunnyString = new FunnyString(scanIn);
    }

    public FunnyString(Scanner scanIn) {
        int strCount = scanIn.nextInt();
        scanIn.nextLine();
        for(int i = 0; i < strCount; i++){
            String myStr = scanIn.nextLine().trim();
            if(i==1){
                int a = 1;
            }
            checkFunny(myStr);
        }
    }

    void checkFunny(String myStr){
        boolean isFunny = true;
        for(int i=0;i<(myStr.length()/2);i++){
            int diff1 = myStr.charAt(i)-myStr.charAt(i+1);
            int diff2 = myStr.charAt(myStr.length()-2-i)-myStr.charAt(myStr.length()-1-i);
            if(Math.abs(diff1) != Math.abs(diff2)){
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
