package Section3;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class SubsetComponent3 {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        SubsetComponent3 myObject = new SubsetComponent3();
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
        combinationCount = (int) Math.pow(2, length);
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
        class NodeSort implements Comparable<NodeSort> {
            private BigInteger edgeInt;
            private Integer clashCount;

            private NodeSort(BigInteger edgeInt, int clashesCount) {
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
        Arrays.fill(disjoint, 0);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i != j) && (edgeInt[i].bitCount() != 0) && (edgeInt[j].bitCount() != 0) && (
                        (edgeInt[i].or(edgeInt[j])).equals(edgeInt[i].xor(edgeInt[j]))
                )) {
                    hasDisjoint = true;
                    disjoint[i]++;
                    disjoint[j]++;
                }
            }
        }
        if (hasDisjoint) {
            NodeSort[] disjointCount = new NodeSort[length];
            for (int i = 0; i < disjoint.length; i++) {
                disjointCount[i] = new NodeSort(edgeInt[i], disjoint[i]);
            }
            Arrays.sort(disjointCount);
            for (int i = 0; i < disjoint.length; i++) {
                edgeInt[i] = disjointCount[i].getEdgeInt();
            }
        }

    }


    private long countWithClashes() {
        class DynamicProgram {
            private boolean connected = true;
            private Integer setCount = 0;
            private BigInteger nodeInt;

            private DynamicProgram() {
            }

            private DynamicProgram(DynamicProgram lastDP) {
                connected = lastDP.connected;
                setCount = lastDP.setCount;
                nodeInt = lastDP.nodeInt;
                //if(!connected) {
                //   nodeStrArr = lastDP.nodeStrArr.clone();
                //}
            }

            private boolean nodesInCommon(BigInteger lastInt, BigInteger newInt) {
                return ((lastInt.bitCount() == 0) || (newInt.bitCount() == 0) ||
                        !(lastInt.or(newInt)).equals(lastInt.xor(newInt)));
            }

            private void add(BigInteger newInt) {
                if (newInt.bitCount() == 0) {
                    return;
                }
                if (setCount == 0) {
                    nodeInt = newInt;
                    setCount = 1;
                }
                if (!nodesInCommon(nodeInt, newInt)) {
                    setCount += 1;
                }
                nodeInt = nodeInt.or(newInt);

            }


            private int countGroups() {
                if (setCount == 0) {
                    return NODES;
                } else {
                    return setCount + NODES - nodeInt.bitCount();
                }
            }
        }
        DynamicProgram[] dp = new DynamicProgram[combinationCount];
        dp[0] = new DynamicProgram();
        int count = NODES;
        int iCombo;
        for (iCombo = 1; iCombo < combinationCount; iCombo++) {
            int index = get64BitColumn(BigInteger.valueOf(iCombo));
            int dpIndex = iCombo - Integer.highestOneBit(iCombo);
            dp[iCombo] = new DynamicProgram(dp[dpIndex]);
            dp[iCombo].add(edgeInt[index]);
            count += dp[iCombo].countGroups();
        }
        return count;
    }


    private int get64BitColumn(BigInteger value) {
        return value.bitLength() - 1;
    }


    long calculate() {
        return countWithClashes();

    }
}
