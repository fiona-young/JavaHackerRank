package codility;

public class MissingInteger {
    public int solution(int[] A){
        boolean[] test = new boolean[A.length+2];
        for (int value : A) {
            if (value > 0 && value < test.length) {
                test[value] = true;
            }
        }
        for(int i=1; i<test.length;i++){
            if(!test[i]){
                return i;
            }
        }
        return -1;
    }
}
