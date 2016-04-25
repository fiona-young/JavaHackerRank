package Section3;

import java.util.Scanner;

public class BinaryNumbers {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        BinaryNumbers myObject = new BinaryNumbers();
        System.out.println(myObject.calculate(scanIn.nextInt()));
    }

    public int calculate(int decValue){
        int maxCount = 0;
        int val = 1;
        int count = 0;
        int compareVal = decValue;
        while(compareVal/val > 0){
            if(compareVal%(val*2)!=0){
                count++;
                compareVal -= val;
                maxCount = Math.max(count,maxCount);

            }
            else{
                count = 0;
            }
            val *=2;
        }
        return maxCount;

    }
}
