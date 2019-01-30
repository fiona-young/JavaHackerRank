package codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public int solution(int X, int[] A){
        Set<Integer> leavesInAir  = new HashSet<>();
        for(int i = 1; i<=X; i++){
            leavesInAir.add(i);
        }
        for(int i = 0; i<A.length; i++){
            leavesInAir.remove(A[i]);
            if(leavesInAir.isEmpty()){
                return i;
            }

        }
        return -1;
    }
}
