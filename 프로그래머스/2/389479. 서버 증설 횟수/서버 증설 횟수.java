class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] returns=new int[players.length+k];
        int current=0;
        for(int i=0;i<players.length;i++){
            current-=returns[i];
            int extendAmount=(players[i]/m)-current;
            if(extendAmount>0){
                answer+=extendAmount;
                current+=extendAmount;
                returns[i+k]=extendAmount;
            }
        }
        return answer;
    }
}