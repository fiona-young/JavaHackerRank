package Section3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by FI on 17-Apr-16.
 */
public class Pangrams {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            int cases = 1;//scan.nextInt();
          //  scan.nextLine();
            for (int i = 0; i < cases; i++) {
                Pangrams mySolution = new Pangrams(scan);
                mySolution.calculate();
            }


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private String inputString;

    public Pangrams(Scanner scanInput) {
        inputString = scanInput.nextLine().toLowerCase().trim();
    }


    public void calculate() {
        Set<Character> pangramSet  =  new HashSet<>();
        for(char c: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            pangramSet.add(c);
        }
        for(char c: inputString.toCharArray()){
            if(pangramSet.contains(c)){
                pangramSet.remove(c);
            }
        }
        String result;
        if(pangramSet.isEmpty()){
            result = "pangram";
        }else{
            result = "not pangram";
        }
        System.out.println(result);
    }


}
