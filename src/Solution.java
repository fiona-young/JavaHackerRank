import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        HashMap<Integer, Integer> count = new HashMap<>();
        int values = scanIn.nextInt();
        scanIn.nextLine();
        for(int i = 0; i<values; i++){
            int value = scanIn.nextInt();
            count.put(value,count.getOrDefault(value,0)+1);
        }
        for(int key:count.keySet()){
            if(count.get(key)==1){
                System.out.println(key);
                break;
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}