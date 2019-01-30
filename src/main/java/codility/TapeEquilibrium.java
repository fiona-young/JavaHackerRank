package codility;

public class TapeEquilibrium {
    public int solution(int[] A){
        int right = 0;
        for(int value: A){
            right+= value;
        }
        int left = 0;
        int minDiff=0;
        for(int i = 0; i< A.length-1; i++){
            right -= A[i];
            left += A[i];
            int diff = Math.abs(left - right);
            if(i==0){
                minDiff = diff;
            }else{
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff;
    }
}
