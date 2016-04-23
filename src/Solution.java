import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by FI on 23-Apr-16.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        Solution myObject = new Solution();
        System.out.println(myObject.hasPalindrome(scanIn.nextLine().trim()));
    }

    String hasPalindrome(String myString){
        HashMap<Character,Integer> stringMap = new HashMap<>();
        for(char myChar: myString.toCharArray()){
            stringMap.put(myChar,stringMap.getOrDefault(myChar,0)+1);
        }
        int oddCount=0;
        for(int charCount: stringMap.values()){
            if(charCount%2 !=0){
                oddCount ++;
            }
        }
        if(oddCount>getAllowedOdd(myString)){
            return "NO";
        }else{
            return "YES";
        }

    }

    private int getAllowedOdd(String myString){
        if(myString.length()%2 == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
}
