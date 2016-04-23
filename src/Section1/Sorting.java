package Section1;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by FI on 13-Apr-16.
 */
public class Sorting {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;
            br.readLine();
            while ((input = br.readLine()) != null) {
                if(input.trim().equals("")) {
                    continue;
                }
                Sorting mySolution = new Sorting(input);
                mySolution.calculate();
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private String inputString;
    private String[] quickSortArray;
    private Integer[] insertionSortArray;

    public Sorting(String input) {
        inputString = input.trim();
        char[] stringArray = inputString.toCharArray();//.split("\\s+");


        //quickSortArray = new int[stringArray.length];
        quickSortArray = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            quickSortArray[i] = String.valueOf(stringArray[i]);
           // insertionSortArray[i] = Integer.valueOf(stringArray[i]);
        }

    }

    void calculate() {
        QuickSort<String> quickSort = new QuickSort<>(quickSortArray);
        quickSort.sort();
        String outString = "";
        for(String val: quickSortArray){
            outString+=val;
        }
        if(outString.equals(inputString)){
            System.out.println("no answer");
        }else{
            System.out.println(outString);
        }

    }

}

abstract class Sort<T extends Comparable<? super T>> {
    protected T[] myArray;
    protected int swapCount;

    public int getSwapCount() {
        return swapCount;
    }

    public Sort(T[] myArray) {
        this.myArray = myArray;
    }

    abstract void sort();

    protected void swap(int key1, int key2) {
        T temp = myArray[key1];
        myArray[key1] = myArray[key2];
        myArray[key2] = temp;
        //System.out.println(this.toString());
        swapCount++;
    }

    @Override
    public String toString() {
        String ret = "";
        for (T val : myArray) {
            ret += String.format("%s ", val);
        }
        return ret.trim();
    }

    protected  boolean lessThan(T val1, T val2){
        return val1.compareTo(val2)<0;
    }

    protected boolean greaterThan(T val1, T val2){
        return val1.compareTo(val2)>0;
    }
}


class InsertionSort<T extends Comparable<? super T>> extends Sort<T> {
    public InsertionSort(T[] myArray) {
        super(myArray);
    }

    void sort() {
        for (int j = 1; j < myArray.length; j++) {
            T temp = myArray[j];
            for (int i = j; i >= 0; i--) {
                if (i >= 1 && lessThan(temp,myArray[i - 1])) {
                    myArray[i] = myArray[i - 1];
                } else {
                    myArray[i] = temp;
                    break;
                }
            }
            //System.out.println(this.toString());
        }
    }
    // }
}

class BubbleSort<T extends Comparable<? super T>> extends Sort<T> {
    public BubbleSort(T[] myArray) {
        super(myArray);
    }

    void sort() {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (greaterThan(myArray[j],myArray[i])) {
                    this.swap(i, j);
                }
            }
            System.out.println(this.toString());
        }
    }
}

class QuickSort<T extends Comparable<? super T>> extends Sort<T> {
    public QuickSort(T[] myArray) {
        super(myArray);
    }

    void sort() {
        quickSort(0, myArray.length - 1);
    }

    void quickSort(int minKey, int maxKey) {
        if (minKey == maxKey) {
            return;
        }
        int pivotKey = maxKey;
        int partitionKey = minKey;
        for (int i = minKey; i < maxKey; i++) {
            if (lessThan(myArray[i],myArray[pivotKey])) {
                this.swap(i, partitionKey);
                partitionKey++;
            }
        }
        this.swap(pivotKey, partitionKey);
        quickSort(minKey, Math.max(minKey, partitionKey - 1));
        quickSort(Math.min(maxKey, partitionKey + 1), maxKey);
    }




}



