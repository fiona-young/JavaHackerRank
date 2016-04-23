package Section3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by FI on 23-Apr-16.
 */
public class Anagram {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        Anagram myAnagram = new Anagram();
        myAnagram.readIn(scanIn);
    }

    void readIn(Scanner scanIn) {
        int cases = scanIn.nextInt();
        scanIn.nextLine();
        for (int i = 0; i < cases; i++) {
            System.out.println(getAnagram(scanIn.nextLine().trim()));
        }
    }

    int getAnagram(String doubleString) {
        if ((doubleString.length() % 2) != 0) {
            return -1;
        } else {
            HashMap<Character, Integer> charMap = new HashMap<>();
            int count = 0;
            for (int i = 0; i < doubleString.length(); i++) {
                char myChar = doubleString.charAt(i);
                if (i < doubleString.length() / 2) {
                    charMap.put(myChar, charMap.getOrDefault(myChar, 0) + 1);
                } else {
                    if (charMap.containsKey(myChar)) {
                        int charCount = charMap.get(myChar) - 1;
                        if(charCount == 0){
                            charMap.remove(myChar);
                        }else{
                            charMap.put(myChar, charCount);
                        }
                    } else {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
