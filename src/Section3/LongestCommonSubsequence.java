package Section3;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FI on 20-Apr-16.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        int cases = 1;//scan.nextInt();
        //  scan.nextLine();
        for (int i = 0; i < cases; i++) {
            LongestCommonSubsequence mySolution = new LongestCommonSubsequence(scan);
            mySolution.calculate();
        }
    }

    int [] sequence1;
    int [] sequence2;

    private LongestCommonSubsequence(Scanner scan){
        int len1 = scan.nextInt();
        int len2 = scan.nextInt();
        scan.nextLine();
        sequence1 = new int[len1];
        for( int i = 0; i< len1;i++) {
            sequence1[i] = scan.nextInt();
        }
        sequence2 = new int[len2];
        for( int i = 0; i< len2;i++) {
            sequence2[i] = scan.nextInt();
        }
    }

    void calculate(){
        DP dp = new DP();
        for( int i = sequence1.length-1; i>=0; i--){
            for( int j = sequence2.length-1; j>=0 ; j--){
                    dp.add(sequence1[i],sequence2[j],i,j);
            }
        }
        dp.output();
    }

    private class DP{
        Node dp[][] = new Node[sequence1.length][sequence2.length];
        Node dp2[][] = new Node[sequence1.length][sequence2.length];

        void output(){
             dp2[0][0].output();
        }

        void add(int value1, int value2, int index1, int index2) {
            Node myNode;
            if(value1 == value2) {
                myNode = new InstanceNode(value1, index1, index2);
                dp[index1][index2]= myNode;
            }
            else{
                myNode = new ZeroNode();
            }
            updateDp2(myNode, index1, index2);
        }

        void updateDp2(Node newNode, int index1, int index2){
            Node nodeBelow, nodeRight;
            if(index2 == sequence2.length-1){
                nodeRight = new ZeroNode();
            }else{
                nodeRight = dp2[index1][index2+1];
            }
            if(index1 == sequence1.length-1){
                nodeBelow = new ZeroNode();
            }else{
                nodeBelow = dp2[index1+1][index2];
            }
            dp2[index1][index2]=newNode.getBest(nodeBelow,nodeRight);

        }

        abstract class Node {
            int len;
            int index1;
            int index2;
            Node parent = null;

            Node getBest(Node nodeBelow, Node nodeRight){
                if(nodeBelow.len == 0 && nodeRight.len == 0) {
                    return this;
                }
                else if(nodeBelow.len == 0){
                    return nodeRight;
                }
                Node bestExisting;
                if(this.index1 == nodeRight.index1){
                    bestExisting = nodeBelow;
                }else if(this.index2 == nodeBelow.index2){
                    bestExisting = nodeRight;
                }
                else{
                    bestExisting = nodeBelow.getLongest(nodeRight);
                }
                if(this.len == 0){
                    return bestExisting;
                }
                return this.add(bestExisting);
            }

            Node getLongest(Node other){
                if(this.len > other.len || this == other) {
                    return this;
                }
                else if(other.len > this.len) {
                    return other;
                }
                if(other.index2 <= this.index2) {
                    return this;
                }
                else if(other.index2 > this.index2) {
                    return other;
                }

                return this;
            }

            Node add(Node other){
                parent = other;
                len = other.len+1;
                return this;
            }

            abstract void output();
        }

        class InstanceNode extends Node{
            int value;

            void output(){
                System.out.print(value);
                if(parent!= null){
                    System.out.print(" ");
                    parent.output();
                }
                System.out.println();
            }

            public InstanceNode(int value, int index1, int index2) {
                this.value = value;
                this.index1 = index1;
                this.index2 = index2;
                len = 1;
            }

        }

        class ZeroNode extends Node{
            public ZeroNode() {
                 len = 0;
                 index1 = -1;
                 index2 = -1;
            }
            void output(){
                ;
            }


        }

    }

}
