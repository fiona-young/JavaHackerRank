package Section3;

import java.util.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        SherlockAndAnagrams myObject = new SherlockAndAnagrams();
        myObject.readIn(scanIn);
    }


    public void readIn(Scanner scanIn){
        int cases = scanIn.nextInt();
        scanIn.nextLine();
        for(int i = 0; i<cases;i++){
            System.out.println(anagramPairCount(scanIn.nextLine().trim()));
        }
    }

    int anagramPairCount(String inString){
     //   System.out.println(inString);
        int count = 0;
        for(int length = 1;length<= inString.length(); length++){
            for(int i=0;i<=inString.length()-length;i++){
                char[] substr1= inString.substring(i,i+length).toCharArray();
                Arrays.sort(substr1);
                for(int j=i+1;j<=inString.length()-length;j++){
                    char[] substr2 = inString.substring(j,j+length).toCharArray();
                    Arrays.sort(substr2);
                    if(Arrays.equals(substr1,substr2)){
                       // System.out.println(String.format("%s|%s,%s| %s|%s,%s|", new String(substr1), i, i + length - 1, new String(substr2), j, j + length - 1));
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
