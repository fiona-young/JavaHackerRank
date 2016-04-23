
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        Solution myObject = new Solution();
        myObject.readIn(scanIn);
        myObject.calculate();
    }
    int steadyCount;
    String inputString;
    HashMap<Character, Integer> hashMap =new HashMap<>();
    LinkedList<Character> range = new LinkedList<>();
    void readIn(Scanner scanIn){
        steadyCount = scanIn.nextInt()/4;
        scanIn.nextLine();
        inputString = scanIn.nextLine().trim();
    }

    void calculate(){
        int maxCount = 0;
        int dp[]=new int[inputString.length()];
        for(char myChar: "ACTG".toCharArray()){
            hashMap.put(myChar,0);
        }
        for(int i = 0; i<inputString.length();i++){
            dp[i]=getLength(i);
        }
        for(int i = 0; i<inputString.length();i++){
            int dp_last=dp[i];
            dp[i]=getLength(i);
            if(dp_last == dp[i]){
                break;
            }
        }
        System.out.println(getSubstringLength(dp));
    }

    int getLength(int index){
        Character newChar = inputString.charAt(index);
        int inListCount = hashMap.get(newChar);
        if(inListCount>=steadyCount){
            char popChar;
            do {
                popChar = range.removeFirst();
                hashMap.put(popChar, hashMap.get(popChar) - 1);
            } while (popChar != newChar);
        }
        range.addLast(newChar);
        hashMap.put(newChar,hashMap.get(newChar)+1);
        return range.size();
    }

    int getSubstringLength(int dp[]){
        int minSubstring = dp.length;
        int index = 0;
        while (index < dp.length && dp[index] >= index) {
            minSubstring = Math.min(dp.length - dp[index], minSubstring);
            index++;
        }

        return minSubstring;
    }


}
