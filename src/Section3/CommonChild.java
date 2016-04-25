package Section3;

import java.util.Scanner;

public class CommonChild {
    public static void main(String[] args) {
        CommonChild myObject = new CommonChild();
        Scanner scanIn = new Scanner(System.in);
        myObject.readIn(scanIn.nextLine().trim(),scanIn.nextLine().trim());
        System.out.println(myObject.calculate());
    }

    private String mum;
    private String dad;
    private int dp[][];
 //   private char dpChar[][];
    private int dpUsedAbove[][];

    private void readIn(String mum, String dad) {
        this.mum = mum;
        this.dad = dad;
        dpUsedAbove = new int[mum.length()][dad.length()];
        dp = new int[mum.length()][dad.length()];
 //       dpChar = new char[mum.length()][dad.length()];
    }

    private int calculate(){
        for(int iMum=0;iMum < mum.length(); iMum++ ){
            for(int iDad=0;iDad < dad.length(); iDad++ ){
                addDp(iMum,iDad);
            }

        }

/*        for(int iMum=0;iMum < mum.length(); iMum++ ) {
            for (int iDad = 0; iDad < dad.length(); iDad++) {
                System.out.print(dp[iMum][iDad]+" ");
            }
            System.out.println();
        }*/


/*        for(int iMum=0;iMum < mum.length(); iMum++ ) {
            for (int iDad = 0; iDad < dad.length(); iDad++) {
                System.out.print(dpChar[iMum][iDad]+" ");
            }
            System.out.println();
        }*/


        return dp[mum.length()-1][dad.length()-1];
    }


    private void addDp(int iMum, int iDad){
        int above;
        int left;
        int current;
        if(mum.charAt(iMum) == dad.charAt(iDad)) {
            current = 1;
        }else{
            current = 0;
        }
        if(iMum == 0){
            above =0;
        }else{
            if(dpUsedAbove[iMum-1][iDad]==1){
                current = 0;
            }
            above = dp[iMum-1][iDad];
        }
        if(iDad == 0){
            left =0;
        }else{
            left = dp[iMum][iDad-1];
        }
        if(current+above > left){
            dpUsedAbove[iMum][iDad] = 1;
/*            if(current == 1){
                dpChar[iMum][iDad]=mum.charAt(iMum);
            }else if(iMum>0){
                dpChar[iMum][iDad]= dpChar[iMum-1][iDad];
            }*/
/*        }else if(iDad > 0){
            dpChar[iMum][iDad]= dpChar[iMum][iDad-1];*/
        }
        dp[iMum][iDad]=Math.max(current+above,left);
    }
}
