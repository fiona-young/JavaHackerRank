package Section3;

import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        TwoDArrays myObject = new TwoDArrays();
        Scanner scanIn = new Scanner(System.in);
        myObject.readIn(scanIn);
        System.out.println(myObject.calculate());
    }

    private final int LEN = 6;
    private int grid[][] = new int[LEN][LEN];

    private void readIn(Scanner scanIn){

        for(int iRow=0; iRow<LEN; iRow++){
            for(int iCol=0; iCol<LEN; iCol++){
                grid[iRow][iCol]=scanIn.nextInt();
            }
            if(iRow<LEN-1) {
                scanIn.nextLine();
            }
        }
    }

    private int calculate(){
        int myMax = -10000;
        for(int iRow=1; iRow<LEN-1; iRow++) {
            for (int iCol = 1; iCol < LEN-1; iCol++) {
                myMax = Math.max(myMax,getHourglassSum(iRow,iCol));
            }
        }
        return myMax;
    }

    private int getHourglassSum(int iRow, int iCol){
        int count = 0;
        for(int i=0;i<3;i++){
            count+=grid[iRow-1][iCol-i+1]+grid[iRow+1][iCol-i+1];
        }
        count += grid[iRow][iCol];
        return count;
    }

}
