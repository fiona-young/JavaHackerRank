package codility;

class BinaryGap {
    public int solution(int N){
        System.out.println(Integer.toBinaryString(N));
        int maxLen = 0;
        int currentLen = 0;
        boolean inGap = false;
        while (N>0){
            if((1 & N)==1){
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 0;
                inGap = true;
            }else if(inGap){
                currentLen++;
            }
            N= N >> 1;
        }
        return maxLen;
    }
}