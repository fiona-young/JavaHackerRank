package codility;

import java.util.*;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer value: A){
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        for(Integer key: map.keySet()){
            if((map.get(key)%2)==1){
                return key;
            }
        }
        return -1;
    }
}
