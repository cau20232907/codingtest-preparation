class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        java.util.Arrays.sort(score);
        for(int i=score.length-m;i>=0;i-=m)
            answer+=score[i];
        return answer*m;
    }
}