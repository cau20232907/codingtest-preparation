class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int currentRange=0;
        for(int i=0;i<section.length;i++)
            if(section[i]>=currentRange){
                currentRange=section[i]+m;
                answer++;
            }
        return answer;
    }
}