package Section2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by FI on 17-Apr-16.
 */
public class InsertionSortAdvanced {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            int cases = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < cases; i++) {
                InsertionSortAdvanced mySolution = new InsertionSortAdvanced(scan);
                mySolution.calculate();
            }


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int[] rawArray;

    public InsertionSortAdvanced(Scanner scanInput) {
        int arrayLen = scanInput.nextInt();
        scanInput.nextLine();
        rawArray = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            rawArray[i] = scanInput.nextInt();
        }
    }


    public void calculate() {
        long runningSum = 0;
        int runningMax = rawArray[0] - 1;
        int runningMin = rawArray[0] + 1;
        Processed myProcess = new ProcessedAVLTree();
        long dp[] = new long[rawArray.length];

        long shift[] = new long[rawArray.length];
        HashMap<Integer, Integer> minVal = new HashMap<>();
        int myArray[] = Arrays.copyOf(rawArray, rawArray.length);
        for (int i = 0; i < rawArray.length; i++) {
            dp[i] = myProcess.countLarger(rawArray[i]);
            myProcess.add(rawArray[i]);
            runningSum += dp[i];
        }
        System.out.println(runningSum);
    }


}

abstract class Processed {
    abstract void add(Integer value);

    abstract long countLarger(Integer value);

}

class ProcessedList extends Processed {
    ArrayList<Integer> myData = new ArrayList<>();

    void add(Integer value) {
        myData.add(value);
    }

    long countLarger(Integer value) {
        long largerCount = 0;
        for (Integer val : myData) {
            if (val > value) {
                largerCount++;
            }
        }
        return largerCount;
    }
}

class ProcessedAVLTree extends Processed {
    AVLNode root = null;

    void add(Integer value) {
        AVLNode myNode = new AVLNode(value);
        if (root == null) {
            root = myNode;
        } else {
            root = root.add(myNode);
            int a = 1;
        }

    }


    long countLarger(Integer value) {
        if (root == null) {
            return 0;
        }
        return root.countLarger(value);
    }
}

class AVLNode {
    private Integer value;
    private AVLNode parent = null;
    private AVLNode left = null;
    private AVLNode right = null;
    private int subtreeNodes = 1;
    private int height = 0;


    public AVLNode(Integer value) {
        this.value = value;
    }

    AVLNode add(AVLNode myNode) {
        AVLNode rootNode = this;
        while (true) {
            if (myNode.value <= rootNode.value) {
                if (rootNode.left == null) {
                    rootNode = rootNode.addMin(myNode);
                    break;
                } else {
                    rootNode = rootNode.left;
                }
            } else {
                if (rootNode.right == null) {
                    rootNode = rootNode.addMax(myNode);
                    break;
                } else {
                    rootNode = rootNode.right;
                }
            }
        }
        return rootNode;
    }

    private AVLNode addMax(AVLNode myNode) {
        myNode.parent = this;
        right = myNode;
        return myNode.update();
    }

    private AVLNode addMin(AVLNode myNode) {
        myNode.parent = this;
        left = myNode;
        return myNode.update();
    }

    long countLarger(Integer value) {
        AVLNode myNode = this;
        long largerThan = 0;
        while (myNode != null) {
            if (value < myNode.value) {
                largerThan += 1 + myNode.getRightSubnodes();
                myNode = myNode.left;
            } else {
                myNode = myNode.right;
            }
        }
        return largerThan;
    }

    private AVLNode update() {
        rebalance();
        height = Math.max(this.getLeftHeight(), this.getRightHeight()) + 1;
        subtreeNodes = getLeftSubnodes() + getRightSubnodes() + 1;
        if (parent != null) {
            return parent.update();
        }
        else{
            return this;
        }
    }

    private void rebalance() {
        int leftHeight = this.getLeftHeight();
        int rightHeight = this.getRightHeight();
        while (Math.abs(leftHeight - rightHeight) > 1) {
            if (leftHeight > rightHeight) {//:#left heavy
                int leftLeftHeight = left.getLeftHeight();
                int leftRightHeight = left.getRightHeight();
                if (leftLeftHeight > leftRightHeight) {
                    this.rotateRight();
                } else {
                    this.left.rotateLeft();
                    this.rotateRight();
                }
            } else if (leftHeight < rightHeight) {//:#right heavy

                int rightLeftHeight = right.getLeftHeight();
                int rightRightHeight = right.getRightHeight();
                if (rightRightHeight > rightLeftHeight) {
                    this.rotateLeft();
                } else {
                    this.right.rotateRight();
                    this.rotateLeft();
                }
            }
                leftHeight = this.getLeftHeight();
                rightHeight = this.getRightHeight();
        }
    }

    private void updateSingle() {
        subtreeNodes = getLeftSubnodes() + getRightSubnodes() + 1;
        height = Math.max(this.getLeftHeight(), this.getRightHeight()) + 1;
    }


    private void rotateLeft() {
        AVLNode Y = this.right;
        AVLNode beta = Y.left;
        AVLNode gamma = Y.right;
        setParentLink(Y);
        Y.parent = this.parent;
        this.parent = Y;
        Y.left = this;
        this.right = beta;
        if(beta != null) {
            beta.parent = this;
        }
        Y.right = gamma;
        if(gamma != null) {
            gamma.parent = Y;
        }
        this.updateSingle();
        Y.updateSingle();
    }


    private void rotateRight() {
        AVLNode X = this.left;
        AVLNode beta = X.right;
        AVLNode gamma = this.right;
        setParentLink(X);
        X.right = this;
        this.parent = X;
        this.left = beta;
        if(beta!= null) {
            beta.parent = this;
        }
        if(gamma != null){
            gamma.parent = this;
        }
        this.right = gamma;
        this.updateSingle();
        X.updateSingle();

    }

    private void setParentLink(AVLNode X){
        if(this.parent != null) {
            if (this.parent.right == this) {
                this.parent.right = X;
            } else {
                this.parent.left = X;
            }
        }
        X.parent = this.parent;
    }


    private int getLeftSubnodes() {
        if (left == null) {
            return 0;
        } else {
            return left.subtreeNodes;
        }
    }

    private int getRightSubnodes() {
        if (right == null) {
            return 0;
        } else {
            return right.subtreeNodes;
        }
    }


    private int getLeftHeight() {
        if (left == null) {
            return -1;
        } else {
            return left.height;
        }
    }

    private int getRightHeight() {
        if (right == null) {
            return -1;
        } else {
            return right.height;
        }
    }


}
