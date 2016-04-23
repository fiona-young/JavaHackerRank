package Section2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FindTheMedian {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));

            int listSize = Integer.valueOf(scan.nextLine().trim());
            FindTheMedian mySolution = new FindTheMedian(listSize, scan.nextLine().trim());
            mySolution.calculate();


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private Integer[] dataArray;
    private int target;

    public FindTheMedian(int listSize, String data) {
        target = listSize/2;
        dataArray = new Integer[listSize];
        Scanner scan = new Scanner(data);
        for (int i = 0; i < listSize; i++) {
            dataArray[i] = scan.nextInt();
        }
    }


    public void calculate() {
        int median = findMedian(0,dataArray.length-1);
        System.out.println(median);
    }

    int findMedian(int minKey, int maxKey) {
        if (minKey == maxKey) {
            return dataArray[minKey];
        }
        int pivotKey = maxKey;
        int partitionKey = minKey;
        for (int i = minKey; i < maxKey; i++) {
            if (lessThan(dataArray[i], dataArray[pivotKey])) {
                this.swap(i, partitionKey);
                partitionKey++;
            }
        }
        this.swap(pivotKey, partitionKey);
        if(partitionKey==target){
            return dataArray[partitionKey];
        }else if(target < partitionKey) {
            return findMedian(minKey, Math.max(minKey, partitionKey - 1));
        }else {
            return findMedian(Math.min(maxKey, partitionKey + 1), maxKey);
        }
    }

    protected void swap(int key1, int key2) {
        Integer temp = dataArray[key1];
        dataArray[key1] = dataArray[key2];
        dataArray[key2] = temp;
    }

    protected  boolean lessThan(Integer val1, Integer val2){
        return val1.compareTo(val2)<0;
    }



    private void getArrayAsString(int[] myArray) {
        StringBuilder stringOut = new StringBuilder();
        for (int val : myArray) {
            stringOut.append(val).append(' ');
        }
        System.out.println(stringOut.toString().trim());
    }

}