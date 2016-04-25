package Section3;

import java.util.*;

/**
 * Created by FI on 24-Apr-16.
 */
public class ReverseShuffleMerge {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        ReverseShuffleMerge myObject = new ReverseShuffleMerge();
        myObject.readIn(scanIn.nextLine().trim());
        myObject.calculate();
    }

    String processedString;
    char[] charArray;
    public void readIn(String inputString){
        processedString = inputString;
        charArray = inputString.toCharArray();
    }

    private void calculate(){
        GetSmallest getSmallest = new GetSmallest(processedString);
        getSmallest.printList();
    }

    class GetSmallest {
        private String processedString;
        private HashMap<Character, Integer> charCount = new HashMap<>();
        private HashMap<Character, Integer> passedCount = new HashMap<>();
        private HashMap<Character, Integer> addedCount = new HashMap<>();
        private LinkedList<Character> charList;
        private int index = 0;
        private boolean doubleMatch = false;

        GetSmallest(String processedString) {
            this.processedString = processedString;
            for (char myChar : processedString.toCharArray()) {
                charCount.put(myChar, charCount.getOrDefault(myChar, 0) + 1);
            }
            for (char myChar : charCount.keySet()) {
                charCount.put(myChar, charCount.get(myChar) / 2);
                passedCount.put(myChar, 0);
                addedCount.put(myChar, 0);
            }
            charList = new LinkedList<>(charCount.keySet());
            Collections.sort(charList);
        }

        void printList(){
            char [] resultChars = new char[processedString.length()/2];
            int passedNum;
            int i =  processedString.length()-1;
            ArrayList<Character> passedChars = new ArrayList<>();
            while(charList.size() > 0) {
                char myChar = processedString.charAt(i);
                passedNum = passedCount.get(myChar) + 1;
                passedCount.put(myChar, passedNum);
                if (myChar == charList.getFirst()) {
                    addMatch(myChar, resultChars);
                    passedChars.clear();
                } else if ((passedNum-addedCount.get(myChar)) > charCount.get(myChar) && charList.contains(myChar)) {
                    addSmaller(myChar,resultChars,passedChars);
                    addMatch(myChar, resultChars);
                    passedChars.clear();
                    if(doubleMatch){
                        passedChars.add(myChar);
                        doubleMatch = false;
                    }

                }else {
                    if(charList.contains(myChar)) {
                    passedChars.add(myChar);
                    }
                }
                i--;
            }
            System.out.println(resultChars);
        }

        private void addMatch(char myChar,char [] resultChars){
            resultChars[index++]=myChar;
            addedCount.put(myChar, addedCount.get(myChar) + 1);
            if (addedCount.get(myChar).equals(charCount.get(myChar))) {
                if(charList.getFirst().equals(myChar)) {
                    charList.removeFirst();
                }else{
                    charList.remove(charList.indexOf(myChar));
                }

            }
        }

        private void addSmaller(char myChar, char [] resultChars, ArrayList<Character> passedChars){
            LinkedList<Character> sortedChars = new LinkedList<>(passedChars);
            Collections.sort(sortedChars);
            for(char thisChar: passedChars){
                if(myChar <= sortedChars.getFirst()){
                    doubleMatch = myChar == sortedChars.getFirst();
                    break;
                }
                while(!charList.contains(sortedChars.getFirst())) {
                    sortedChars.removeFirst();
                }
                if(thisChar == sortedChars.getFirst()) {
                    addMatch(thisChar, resultChars);
                    sortedChars.removeFirst();
                }
                else{
                    sortedChars.remove(sortedChars.indexOf(thisChar));
                }
            }
        }
    }


}
