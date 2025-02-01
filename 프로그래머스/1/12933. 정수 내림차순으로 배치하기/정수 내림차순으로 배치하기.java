class Solution {
    public long solution(long n) {
        int[] countPerDigit=new int[10];
        while(n!=0){
            countPerDigit[(int)(n%10)]++;
            n/=10;
        }
        long answer=0;
        for(int i=9;i>=0;i--){
            for(int j=countPerDigit[i];j>0;j--){
                answer*=10;
                answer+=i;
            }
        }
        return answer;
    }
}