package codility;

public class DemoTask {
    public int solution(int[] A) {
        boolean[] check = new boolean[A.length+2];
        for(int value: A){
            if(value>0){
                check[value]=true;
            }
        }
        for(int i =1; i<(A.length+2);i++){
            if(!check[i]){
                return i;
            }
        }
        return -1;
        // write your code in Java SE 8
    }
}
