package codility;

public class PassingCars {
    public int solution(int[] A){
        int[] zeros = new int[A.length];
        int current = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i]==0){
                current+=1;
            }
            zeros[i]= current;
        }
        long pass = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i]==1){
                pass += zeros[i];
            }
        }
        if(pass > 1000000000){
            return -1;
        }else {
            return (int)pass;
        }
    }
}
