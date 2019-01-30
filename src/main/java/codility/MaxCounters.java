package codility;

public class MaxCounters {
    public int[] solution(int N, int[] A){
        int maxCounter = 0;
        int minValue = 0;
        int[] counters = new int[N];
        for(int value: A){
            if(value>0 && value<=N){
                int currentValue = Math.max(counters[value-1],minValue);
                counters[value-1]=currentValue+1;
                maxCounter = Math.max(counters[value-1],maxCounter);
            }else if(value == (N+1)){
                minValue = maxCounter;
            }
        }
        for(int i=0; i<N; i++){
            counters[i]=Math.max(minValue, counters[i]);
        }
        return counters;
    }
}
