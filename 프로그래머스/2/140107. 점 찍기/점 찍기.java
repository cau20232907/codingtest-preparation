class Solution {
    public long solution(int k, int d) {
        long distPow=((long)d)*d;
        long answer=0;
        long x=d,y=0;
        x-=x%k; //x보다 작은 가장 큰 k의 배수
        while(x!=0){
            answer+=x/k+1;
            y+=k;
            if(y>d) return answer;
            while(x*x+y*y>distPow) x-=k;
        }
        answer+=(d-y)/k+1;
        return answer;
    }
}