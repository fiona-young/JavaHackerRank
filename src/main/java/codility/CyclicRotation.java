package codility;

public class CyclicRotation {
    public int[] solution(int[] A, int K){
        int length = A.length;
        int[] result = new int[length];
        if(length>0) {
            K = K%length;
            for (int i = 0; i < length; i++) {
                int map = (i + length - K) % length;
                result[i] = A[map];
            }
        }
        return result;
    }
}
