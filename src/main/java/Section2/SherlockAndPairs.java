package Section2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FI on 17-Apr-16.
 */
public class SherlockAndPairs {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            int cases = scan.nextInt();
            scan.nextLine();
            for(int i = 0; i<cases; i++) {
                SherlockAndPairs mySolution = new SherlockAndPairs(scan);
                mySolution.calculate();
            }


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int[] rawArray;
    private int arrayLen;

    public SherlockAndPairs(Scanner scanInput) {
        arrayLen = scanInput.nextInt();
        scanInput.nextLine();
        rawArray = new int[arrayLen];
        for(int i=0;i<arrayLen;i++){
            rawArray[i]=scanInput.nextInt();
        }
    }


    public void calculate() {
     QuickSortLight quickSort = new QuickSortLight(rawArray);
        quickSort.sort();
        int lastVal=0;
        long valCount = 0;
        long comboCount = 0;
        for(int i=0;i<rawArray.length;i++){
            if(i<rawArray.length-1){
                if(rawArray[i]>rawArray[i+1]){
                    throw new IndexOutOfBoundsException(String.format("Not sorted at %s",i));
                }
            }
            if(i==0 || rawArray[i]!=lastVal){
                if(valCount>1){
                    comboCount+=valCount*(valCount-1);
                }
                valCount=1;
                lastVal=rawArray[i];
            }
            else{
                valCount++;
            }
        }

        if(valCount>1){
            comboCount+=valCount*(valCount-1);
        }
        System.out.println(comboCount);
    }


}

class QuickSortLight {
    private int[] myArray;
    public QuickSortLight(int[] myArray) {
        this.myArray=myArray;
    }

    void sort() {
        quickSort(0, myArray.length - 1);
    }

    private void quickSort(int minKey, int maxKey) {
        if (minKey == maxKey) {
            return;
        }
        int pivotKey = maxKey;

        int randomKey = minKey+(int)((double)(maxKey-minKey)* Math.random());
        if(randomKey<minKey || randomKey>maxKey){
            throw new IndexOutOfBoundsException("random key outside array");
        }
        swap(pivotKey,randomKey);
        int partitionKey = minKey;
        for (int i = minKey; i < maxKey; i++) {
            if (myArray[i]<myArray[pivotKey]) {
                this.swap(i, partitionKey);
                partitionKey++;
            }
        }
        if(partitionKey==minKey){
            while ((partitionKey < ((maxKey - minKey) / 2 + minKey)) && myArray[partitionKey] == myArray[partitionKey + 1] && myArray[partitionKey] <= myArray[pivotKey]) {
                partitionKey++;
            }
        }
        this.swap(pivotKey, partitionKey);
        quickSort(minKey, Math.max(minKey, partitionKey - 1));
        quickSort(Math.min(maxKey, partitionKey + 1), maxKey);
    }

    private void swap(int key1, int key2) {
        int temp = myArray[key1];
        myArray[key1] = myArray[key2];
        myArray[key2] = temp;
    }


}