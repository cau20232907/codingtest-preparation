class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0,0};
        board[0]/=2;
        board[1]/=2; //bound로 수정
        for(String input:keyinput){
            switch(input){
                case "up":{
                    if(answer[1]!=board[1]) answer[1]++;
                    break;
                }
                case "down":{
                    if(answer[1]!=-board[1]) answer[1]--;
                    break;
                }
                case "left":{
                    if(answer[0]!=-board[0]) answer[0]--;
                    break;
                }
                case "right":{
                    if(answer[0]!=board[0]) answer[0]++;
                    break;
                }
            }
        }
        return answer;
    }
}