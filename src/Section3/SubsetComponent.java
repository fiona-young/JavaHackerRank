package Section3;

import java.math.BigInteger;
import java.util.*;

public class SubsetComponent {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        SubsetComponent myObject = new SubsetComponent();
        myObject.readIn(scanIn);
        myObject.initialize();
        System.out.println(myObject.calculate());
    }

    private BigInteger edgeInt[];
    private int length;
    private int combinationCount;
    private boolean hasDisjoint = false;
    private final int NODES = 64;
    private Integer[] disjoint;

    private void readIn(Scanner scanIn) {
        length = scanIn.nextInt();
        BigInteger d;
        edgeInt = new BigInteger[length];
        combinationCount = (int)Math.pow(2,length);
        scanIn.nextLine();
        for (int i = 0; i < length; i++) {
            d = scanIn.nextBigInteger();
            if (d.bitCount() <= 1) {
                edgeInt[i] = BigInteger.valueOf(0);
            } else {
                edgeInt[i] = d;
            }
        }
    }

    private void initialize() {
        class NodeSort implements Comparable<NodeSort>{
            private BigInteger edgeInt;
            private Integer clashCount;
            private NodeSort(BigInteger edgeInt, int clashesCount){
                this.edgeInt = edgeInt;
                this.clashCount = clashesCount;
            }

            @Override
            public int compareTo(NodeSort o) {
                return this.clashCount.compareTo(o.clashCount);
            }

            public BigInteger getEdgeInt() {
                return edgeInt;
            }
        }
        disjoint = new Integer[length];
        Arrays.fill(disjoint,0);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i!= j) &&(edgeInt[i].bitCount() != 0) && (edgeInt[j].bitCount() != 0) && (
                        (edgeInt[i].or(edgeInt[j])).equals(edgeInt[i].xor(edgeInt[j]))
                )) {
                    hasDisjoint = true;
                    disjoint[i]++;
                    disjoint[j]++;
                }
            }
        }
        if(hasDisjoint) {
            NodeSort[] disjointCount =new NodeSort[length];
            for(int i =0;i<disjoint.length;i++){
                disjointCount[i]=new NodeSort(edgeInt[i],disjoint[i]);
            }
            Arrays.sort(disjointCount);
            for(int i =0;i<disjoint.length;i++){
                edgeInt[i]= disjointCount[i].getEdgeInt();
            }
        }

    }


    private long countWithClashes(){
        BigInteger[] dp =new BigInteger[combinationCount];
        dp[0] = BigInteger.valueOf(0);
        int count = NODES;
        int iCombo;
        for(iCombo=1;iCombo < combinationCount; iCombo++){
            int index = get64BitColumn(BigInteger.valueOf(iCombo));
            int dpIndex = iCombo - Integer.highestOneBit(iCombo);
            BigInteger dpValue = dp[dpIndex];
            if (dpValue == null || ((edgeInt[index].bitCount() != 0) && (dpValue.bitCount() != 0) && (
                    (edgeInt[index].or(dpValue)).equals(edgeInt[index].xor(dpValue)))
            )){
                count += countDisjoint(iCombo, dp);
            }else {
                BigInteger myNumber = dpValue.or(edgeInt[index]);
                dp[iCombo] = myNumber;
                count += groupCount(myNumber);
            }
        }
        return count;
    }

    private Integer countDisjoint(int iCombo,BigInteger[] dp){
        Integer lastCalculated = iCombo;
        ArrayList<BigInteger> notAdded = new ArrayList<>();
        BigInteger dpValue;
        do{
            int index = get64BitColumn(BigInteger.valueOf(lastCalculated));
            notAdded.add(edgeInt[index]);
            lastCalculated -= Integer.highestOneBit(lastCalculated);
            dpValue = dp[lastCalculated];
        }while(dpValue == null);
        notAdded.add(dpValue);
        Integer[] connectedList;
        ArrayList<Integer[]>edgeList=new ArrayList<>();
        for(BigInteger node : notAdded){
            connectedList=getOnBitsSet(node);
            Integer edgeOne = connectedList[0];
            for(int i=1; i<connectedList.length;i++){
                Integer[] edge = {edgeOne,connectedList[i]};
                edgeList.add(edge);
            }
        }
        return getConnected(edgeList);
    }

    private Integer getConnected(ArrayList<Integer[]>edgeList){
        int nodeLookup[] = new int[NODES];
        HashMap<Integer,HashSet<Integer>> nodeGroups=new HashMap<>();
        for (int iNode=0; iNode < NODES;iNode++){
            nodeLookup[iNode]=iNode;
            nodeGroups.put(iNode,new HashSet<>());
            nodeGroups.get(iNode).add(iNode);
        }
        for (Integer[] edge: edgeList){
            int newSetId = nodeLookup[edge[0]];
            int oldSetId = nodeLookup[edge[1]];
            if(newSetId == oldSetId){
                continue;
            }
            nodeGroups.get(newSetId).addAll(nodeGroups.get(oldSetId));
            for(int iNode : nodeGroups.get(oldSetId)){
                nodeLookup[iNode]=newSetId;
            }
            nodeGroups.remove(oldSetId);
        }
        return nodeGroups.size();
    }



    private int get64BitColumn(BigInteger value){
        return value.bitLength()-1;
    }
    private Integer[] getOnBitsSet(BigInteger iCombo) {
        int len = iCombo.bitCount();
        Integer[] result = new Integer[len];
        if(len == 1){
            result[0]=get64BitColumn(iCombo);
        }else{
            String asBinary = iCombo.toString(2);
            int oneCount = 0;
            for(int i = 0; i<asBinary.length(); i++){
                if(asBinary.charAt(i)=='1'){
                    result[oneCount++]=asBinary.length()-1-i;
                }
            }
        }
        return result;


    }

    private long countWithoutClashes(){
        BigInteger[] dp =new BigInteger[combinationCount];
        dp[0] = BigInteger.valueOf(0);
        int count = NODES;
        for(int iCombo=1;iCombo < combinationCount; iCombo++){
            int index = get64BitColumn(BigInteger.valueOf(iCombo));
            int highestOneBit = Integer.highestOneBit(iCombo);
            int dpIndex = iCombo - highestOneBit;
            BigInteger dpValue = dp[dpIndex];
            BigInteger myNumber = dpValue.or(edgeInt[index]);
            dp[iCombo]=myNumber;
            count += groupCount(myNumber);
        }
        return count;
    }

    private long groupCount(BigInteger myNumber){
        long connectedSet = myNumber.bitCount();
        if(connectedSet==0){
            return NODES;
        }else{
            return NODES - connectedSet + 1;
        }
    }

    long calculate() {
        long count;
        if (hasDisjoint) {
            count = countWithClashes();
        }else {
            count = countWithoutClashes();
        }
        return count;

    }
}
