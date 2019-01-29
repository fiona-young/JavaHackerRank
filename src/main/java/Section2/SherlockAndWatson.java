package Section2;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndWatson {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            SherlockAndWatson mySolution = new SherlockAndWatson(scan);
            mySolution.calculate();


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int[] rawArray;
    private int[] shiftedArray;
    private int[] queryArray;
    private int arrayLen;
    private int shiftCount;
    private int queryCount;

    public SherlockAndWatson(Scanner scanInput) {
        arrayLen = scanInput.nextInt();
        shiftCount = scanInput.nextInt();
        queryCount =  scanInput.nextInt();
        scanInput.nextLine();
        rawArray = new int[arrayLen];
        for(int i=0;i<arrayLen;i++){
            rawArray[i]=scanInput.nextInt();
        }
        scanInput.nextLine();
        queryArray = new int[queryCount];
        for(int i=0;i<queryCount;i++){
            queryArray[i]=scanInput.nextInt();
        }
    }


    public void calculate() {
        int mult = (int)Math.ceil((double)shiftCount/(double)arrayLen);
        int shift=mult*arrayLen-shiftCount;
        for(int index:queryArray){
            int newKey =(index+shift)%arrayLen;
            System.out.println(rawArray[newKey]);
        }
    }

    private void shiftArray(){
        shiftedArray= Arrays.copyOf(rawArray,rawArray.length);
        int[] copyArray=new int[arrayLen];
        for(int i=0;i<shiftCount;i++){
            copyArray[0]=shiftedArray[shiftedArray.length-1];
            System.arraycopy(shiftedArray, 0, copyArray, 1, shiftedArray.length - 1);
            shiftedArray = Arrays.copyOf(copyArray,copyArray.length);
        }
    }

}

