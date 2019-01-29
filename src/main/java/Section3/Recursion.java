package Section3;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner scanIn=new Scanner(System.in);
        int value = scanIn.nextInt();
        Recursion myRecursion = new Recursion();
        System.out.println(myRecursion.factorial(value));
    }

    public int factorial(int value){
        if(value==1){
            return 1;
        }
        else{
            return value* factorial(value-1);
        }
    }
}
