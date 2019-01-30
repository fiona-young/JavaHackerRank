package codility;

public class PermCheck {
    public int solution(int[] A){
        boolean[] tidy = new boolean[A.length];

        for(int value: A){
            if (value <= A.length) {
                tidy[value-1]= true;
            }else{
                return 0;
            }
        }
        for(boolean exists: tidy){
            if (!exists) {
                return 0;
            }
        }
        return 1;
    }
}
