class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int begin=0;
        int sum=sequence[0];
        if(sum==k) return answer;
        answer[1]=sequence.length-1;
        for(int i=1;i<sequence.length;i++){
            sum+=sequence[i];
            while(sum>=k){
                if(sum==k&&i-begin<answer[1]-answer[0]){
                    answer[0]=begin;
                    answer[1]=i;
                }
                sum-=sequence[begin++];
            }
        }
        return answer;
    }
}