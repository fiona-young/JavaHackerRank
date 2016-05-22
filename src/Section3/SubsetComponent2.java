package Section3;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by FI on 23-Apr-16.
 */
public class SubsetComponent2 {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        SubsetComponent2 myObject = new SubsetComponent2();
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
            private HashMap<Integer, BigInteger> disconnectedList;
            private int countId = 0;

            private DynamicProgram() {
                disconnectedList = new HashMap<>();
            }

            private DynamicProgram(DynamicProgram lastDP) {
                disconnectedList = new HashMap<>(lastDP.disconnectedList);
                countId =lastDP.countId;
            }

            private boolean nodesInCommon(BigInteger lastInt, BigInteger newInt) {
                return ((lastInt.bitCount() == 0) || (newInt.bitCount() == 0) ||
                        !(lastInt.or(newInt)).equals(lastInt.xor(newInt)));
            }

            private void add(BigInteger newInt) {
                Integer joinedKey = null;
                for (Integer key : disconnectedList.keySet()) {
                    if (nodesInCommon(disconnectedList.get(key), newInt)) {
                        if (joinedKey == null) {
                            joinedKey = key;
                            newInt = disconnectedList.get(key).or(newInt);
                            disconnectedList.put(joinedKey, newInt);
                        } else {
                            newInt = disconnectedList.get(key).or(newInt);
                            disconnectedList.put(joinedKey, newInt);
                            disconnectedList.remove(key);
                        }
                    }
                }
                if (newInt.bitCount() != 0 && joinedKey == null) {
                    disconnectedList.put(countId++, newInt);
                }
            }

            private int countGroups() {
                if (disconnectedList.size() == 0) {
                    return NODES;
                } else {
                    int usedNodes = 0;
                    int groupCount = 0;
                    for (Integer key : disconnectedList.keySet()) {
                        groupCount++;
                        usedNodes += disconnectedList.get(key).bitCount();
                    }
                    int result = groupCount + NODES - usedNodes;
                    return result;
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


    private long groupCount(BigInteger myNumber) {
        long connectedSet = myNumber.bitCount();
        if (connectedSet == 0) {
            return NODES;
        } else {
            return NODES - connectedSet + 1;
        }
    }

    long calculate() {
        long count;
        if (hasDisjoint) {
            count = countWithClashes();
        } else {
            count = countWithClashes();
        }
        return count;

    }
}
