package Section2;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            AlmostSorted mySolution = new AlmostSorted(scan);
            mySolution.calculate();


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int[] rawArray;
    private int arrayLen;

    public AlmostSorted(Scanner scanInput) {
        arrayLen = scanInput.nextInt();
        scanInput.nextLine();
        rawArray = new int[arrayLen];
        for(int i=0;i<arrayLen;i++){
            rawArray[i]=scanInput.nextInt();
        }
    }


    public void calculate() {
        boolean inReversedSection = false;
        ArrayList<Reversed> reversedList = new ArrayList<>();
        int lastValue = 0;
        for(int i=0; i< rawArray.length-1;i++){
            if(rawArray[i]>rawArray[i+1]){
                if(!inReversedSection){
                   reversedList.add(new Reversed(i));
                    inReversedSection=true;
                }
                else{
                    reversedList.get(reversedList.size()-1).update(i);
                }
            }
            else{
                inReversedSection=false;
            }
        }
        if(reversedList.size()==0){
            System.out.println("yes");
            return;
        }
        else if(reversedList.size()==1){
            Reversed currentReversed = reversedList.get(0);
            if(canValueBeStart(currentReversed.getFirstIndex(),rawArray[currentReversed.getLastIndex()]) &&
                    canValueBeEnd(currentReversed.getLastIndex(),rawArray[currentReversed.getFirstIndex()]) ){
                currentReversed.printReverse();
                return;
            }
        }
        else if(reversedList.size()==2 && reversedList.get(0).getLength()==2 && reversedList.get(1).getLength()==2)
            {
                int index1=reversedList.get(0).getFirstIndex();
                int index2=reversedList.get(1).getLastIndex();
                if(willValueFitInPosition(index1, rawArray[index2])&& willValueFitInPosition(index2, rawArray[index1]) ){
                    System.out.println("yes");
                    System.out.println(String.format("swap %s %s", index1+1, index2+1));
                    return;
                }

            }

        System.out.println("no");

    }

    private boolean willValueFitInPosition(int index, int value){
        return canValueBeStart(index, value)&&canValueBeEnd(index, value);
    }

    private boolean canValueBeStart(int index, int value){
        return index == 0  || rawArray[index-1]<=value ;
    }

    private boolean canValueBeEnd(int index, int value){
        return index== rawArray.length-1 || rawArray[index+1]>=value ;
    }

}

class Reversed{
    int firstIndex;
    int lastIndex;

    public Reversed(int firstIndex) {
        this.firstIndex = firstIndex;
        this.lastIndex = firstIndex+1;
    }
    public void update(int currentIndex) {
        this.lastIndex = currentIndex+1;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    int getLength(){
        return getLastIndex()-getFirstIndex()+1;
    }

    void printReverse(){
        System.out.println("yes");
        if(this.getLength()==2) {
            System.out.println(String.format("swap %s %s", this.getFirstIndex()+1, this.getLastIndex()+1));
        }
        else{
            System.out.println(String.format("reverse %s %s", this.getFirstIndex()+1, this.getLastIndex()+1));
        }
    }
}
