package Section2;
import java.io.*;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));

            String input;
            int listSize = Integer.valueOf(scan.nextLine().trim());
            CountingSort mySolution = new CountingSort(listSize);
            for(int i = 0; i<listSize; i++) {
                mySolution.addLine(scan.nextInt(),scan.next().trim());
            }
            mySolution.calculate();


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private Value[] arrayToSort;
    private int[] countArray = new int[100];
    private Value[] sortedArray;
    private int inputPointer = 0;
    private int listSize;

    public CountingSort(int listSize) {
        this.listSize = listSize;
       arrayToSort = new Value[listSize];
       sortedArray = new Value[listSize];
    }

    public void addLine(int myInt, String line) {
        if(inputPointer<(listSize/2)){
            line = "-";
        }
        arrayToSort[inputPointer]=new Value(myInt,line);
        countArray[myInt]++;
        inputPointer++;
    }

    public void calculate() {
        addCumulativeCount();
        populateSortedArray();
       // countInstances();
        StringBuilder stringOut = new StringBuilder();
        for(Value val: sortedArray){
            stringOut.append(val.getStringValue()).append(' ');
        }
        System.out.println(stringOut.toString().trim());
       // getArrayAsString(countArray);
    }

/*    private void countInstances(){
        for(Value val: arrayToSort){
            countArray[val.getIntValue()]++;
        }
    }*/

    private void addCumulativeCount(){
        int cumulativeCount = 0;
        for(int i = 0; i<countArray.length;i++){
            cumulativeCount += countArray[i];
            countArray[i]=cumulativeCount;
        }
    }


    private void populateSortedArray(){
         for(int i=arrayToSort.length-1;i>=0;i--){
            int index = arrayToSort[i].getIntValue();
            countArray[index]--;
            sortedArray[countArray[index]]=arrayToSort[i];
        }

    }


    private void getArrayAsString(int[] myArray){
        StringBuilder stringOut = new StringBuilder();
        for(int val: myArray){
            stringOut.append(val).append(' ');
        }
        System.out.println(stringOut.toString().trim());
    }

}

class Value{
   int intValue;
    String stringValue;

    public Value(int intValue, String stringValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
