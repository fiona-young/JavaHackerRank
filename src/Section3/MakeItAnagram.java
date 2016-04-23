package Section3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by FI on 23-Apr-16.
 */
public class MakeItAnagram {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        MakeItAnagram myObject = new MakeItAnagram();
        myObject.calculate(scanIn.nextLine().trim(),scanIn.nextLine().trim());
    }

    void calculate(String string1, String string2){
        HashSet<Character> allSet = new HashSet<>();
        HashMap<Character, Integer> hashMap1 =new HashMap<>();
        HashMap<Character, Integer> hashMap2 =new HashMap<>();
        for(char myChar: string1.toCharArray()){
            allSet.add(myChar);
            hashMap1.put(myChar,hashMap1.getOrDefault(myChar,0)+1);
        }
        for(char myChar: string2.toCharArray()){
            allSet.add(myChar);
            hashMap2.put(myChar,hashMap2.getOrDefault(myChar,0)+1);
        }
        int deletions = 0;
        for(char myChar: allSet){
            deletions+= Math.abs(hashMap1.getOrDefault(myChar,0)-hashMap2.getOrDefault(myChar,0));
        }
        System.out.println(deletions);
    }
}
