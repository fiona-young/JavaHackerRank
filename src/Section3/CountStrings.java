package Section3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by FI on 26-Apr-16.
 */
public class CountStrings {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        int cases = scanIn.nextInt();
        for(int i = 0 ; i< cases; i++) {
            scanIn.nextLine();
            CountStrings myObject = new CountStrings(scanIn.next(), scanIn.nextInt());
            myObject.calculate();
        }
        scanIn.close();
    }

    private String regEx;
    private int strLength;
    public CountStrings(String regEx, int strLength){
        this.regEx = regEx;
        this.strLength = strLength;
    }

    void calculate(){
        processRegEx();
        long result = 5;
        System.out.println(result);
    }

    void processRegEx() {
        StringBuilder resultNext = new StringBuilder();
        scanString(0,resultNext);
        System.out.println(resultNext);
       // RegEx myRegEx = new RegEx(regEx);
    }

    int scanString(int start,StringBuilder result){
        int index = start;
        while(index < regEx.length()){
            char myChar = regEx.charAt(index);
            if(myChar == '(') {
                StringBuilder resultNext = new StringBuilder();
                index = scanString(index + 1, resultNext);
                result.append(resultNext);
            }
            else if(myChar == ')'){
                return index;
            }
            else{
                result.append(myChar);
            }
            index++;
        }
        return index;
    }
}


class RegEx{
    private String raw;
    private HashMap<Integer, ArrayList<String>> levels = new HashMap<>();
    RegEx(String rawRegEx){
        raw = rawRegEx;
        if(raw.charAt(0)=='(' && raw.charAt(raw.length()-1)==')'){
            raw = raw.substring(1,raw.length()-1);
        }
        ArrayList<ArrayList<Integer>> open = new ArrayList<>();
        ArrayList<ArrayList<Integer>> close = new ArrayList<>();
        initialise(open, close);
      //  processBraces(open,close);

    }

    private void initialise(ArrayList<ArrayList<Integer>> open,ArrayList<ArrayList<Integer>> close) {
        int balance = 0;
        char myChar;
        Result result = new Result(raw);
        for (int i = 0; i < raw.length(); i++) {
            myChar = raw.charAt(i);
            if (myChar == '(') {
                result.openBrace(i);
                addBrace(open, balance,i);
                balance++;
            } else if (myChar == ')') {
                result.closeBrace(i);
                balance--;
                addBrace(close, balance,i);

                int a = 1;
            }
        }
    }



    private void addBrace(ArrayList<ArrayList<Integer>> myList, int level, int index){
        if(level >= myList.size()) {
            for (int i = myList.size(); i <= level; i++) {
                myList.add(new ArrayList<>());
            }
        }
        myList.get(level).add(index);
    }



}


class Result{
    ArrayList<ResultNode> data1 = new ArrayList<>();
    ArrayList<ResultNode> data2 = new ArrayList<>();
    ArrayList<LinkedList<Integer>> open = new ArrayList<>();
    //ArrayList<ArrayList<Integer>> close = new ArrayList<>();
    int level = 0;
    String regEx;


    private void addBrace(ArrayList<LinkedList<Integer>> myList, int level, int index){
        if(level >= myList.size()) {
            for (int i = myList.size(); i <= level; i++) {
                myList.add(new LinkedList<>());
                data1.add(new ResultNode());
                data2.add(new ResultNode());
            }
        }
        myList.get(level).addLast(index);
    }


    public Result(String regEx) {
        this.regEx = regEx;
    }

    void openBrace(int index) {
        int i = 0;
        addBrace(open,level,index);
        level ++;
    }
    void closeBrace(int index) {
        level --;
        int i = 1;
        int openPair = open.get(level).removeLast();
        processBracePair(openPair+1, index);

    }

    private void processBracePair(int openId, int closeId){

    }
}

class ResultNode{
    ArrayList<StringBuilder> data = new ArrayList<>();
    ResultNode(){
        data.add(new StringBuilder());
    }
    void add( String input){
        for (StringBuilder aData : data) {
            aData.append(input);
        }
    }

    void union( String input1, String input2){
        int a = 1;
    }
}