
package Section2;
import java.io.*;
import java.util.Arrays;

/**
 * Created by FI on 15-Apr-16.
 */
public class BiggerIsGreater {
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
                BiggerIsGreater mySolution = new BiggerIsGreater(input);
                System.out.println(mySolution.calculate());
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private String inputString;
    private String[] quickSortArray;

    public BiggerIsGreater(String input) {
        inputString = input.trim();
        char[] stringArray = inputString.toCharArray();//.split("\\s+");
        quickSortArray = new String[stringArray.length];
        for (int i = stringArray.length-1; i >= 0; i--) {
            quickSortArray[i] = String.valueOf(stringArray[i]);
        }


    }

    public String calculate() {
        String result;
        int i = quickSortArray.length-1;
        while(i>0 && (quickSortArray[i-1].compareTo(quickSortArray[i])>=0)){
            i--;
        }
        if(i==0){
            result = "no answer";
        }
        else{
            this.getNextLarger(i-1);
            String outString="";
            for(String charVal:quickSortArray){
                outString+=charVal;
            }
            result= outString;
        }
        return result;
    }

    void getNextLarger( int index){
        String arrayToSort[] = Arrays.copyOfRange(quickSortArray,index,quickSortArray.length);
        QuickSort<String> quickSort = new QuickSort<String>(arrayToSort);
        quickSort.sort();
        int valueToChangeIndex = quickSort.find(quickSortArray[index])+1;
        while(quickSortArray[index].compareTo(arrayToSort[valueToChangeIndex])>=0){
            valueToChangeIndex++;
        }
        quickSortArray[index]=arrayToSort[valueToChangeIndex];
        int i = index+1;
        boolean charUsed = false;
        for(String charValue: arrayToSort){
            if(charUsed || !charValue.equals(quickSortArray[index])){
                quickSortArray[i]=charValue;
                i++;
            }
            else{
                charUsed = true;
            }
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

    int find(T value){
        int minKey = 0;
        int maxKey = myArray.length-1;
        int mid = maxKey/2;
        while ((minKey!=maxKey)&&!value.equals(myArray[mid])){
            if(value.compareTo(myArray[mid])<0){
                maxKey=mid;
                mid = minKey+(maxKey - minKey)/2;
            }
            else{
                minKey=mid;
                mid = minKey+(maxKey - minKey)/2;
            }
        }
        return mid;
    }




}





