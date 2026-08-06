class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i=2; n/i-(i/2-1)>0; i++){
            if(n%i==i/2 && n/i-(i/2-1)>0) answer++;
            i++;
            if(n%i==0 && n/i-((i-1)/2)>0) answer++;
        }
        return answer;
    }
}