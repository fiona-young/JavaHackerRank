package codility;

public class PermMissingElem {
    public int solution(int[] A){
        boolean[] exists = new boolean[A.length+2];
        for(int value: A){
            exists[value]=true;
        }
        for(int i=1;i <= exists.length; i++){
            if(!exists[i]){
                return i;
            }
        }
        return -1;
    }
}
