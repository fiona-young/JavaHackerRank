
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution myObject = new Solution();
        Scanner scanIn = new Scanner(System.in);
        myObject.readIn(scanIn.nextLine().trim(),scanIn.nextLine().trim());
        System.out.println(myObject.calculate());
    }

    private String mum;
    private String dad;
    private boolean matches[][];
    private boolean mumUsed[];
    private int dp[][];
    private char dp2[][];

    private void readIn(String mum, String dad) {
        this.mum = mum;
        this.dad = dad;
        matches = new boolean[mum.length()][dad.length()];
        dp = new int[mum.length()][dad.length()];
        dp2 = new char[mum.length()][dad.length()];
        mumUsed = new boolean[dad.length()];
    }

    private int calculate(){
        for(int iMum=0;iMum < mum.length(); iMum++ ){
            for(int iDad=0;iDad < dad.length(); iDad++ ){
                if(mum.charAt(iMum) == dad.charAt(iDad)){
                    addMatch(iMum,iDad);
                }
                addDp(iMum,iDad);
            }
        }
        return dp[mum.length()-1][dad.length()-1];
    }

    private void addMatch(int iMum, int iDad){
        matches[iMum][iDad]=true;
        if(!mumUsed[iDad]){
            dp[iMum][iDad]=1;
        }
        mumUsed[iDad]=true;
    }

    private void addDp(int iMum, int iDad){
        int val = 0;
        if(iMum>0){
            val = Math.max( dp[iMum-1][iDad],val);
        }
        if(iDad > 0){
            val = Math.max( dp[iMum][iDad-1],val);
        }
        val+=dp[iMum][iDad];
        dp[iMum][iDad]=val;
    }
}
