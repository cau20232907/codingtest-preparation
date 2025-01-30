import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] lines=new Stack[board[0].length];
        Stack<Integer> basket=new Stack<>();
        for(int i=0;i<board[0].length;i++){
            Stack<Integer> singleLine=new Stack<>();
            for(int j=board.length-1;j>=0;j--){
                if(board[j][i]==0) break;
                else singleLine.add(board[j][i]);
            }
            lines[i]=singleLine;
        }
        //Initialize 끝
        
        for(int move:moves){
            move--;
            if(lines[move].isEmpty()) continue;
            Integer picked=lines[move].pop();
            //Class로 저장되어 있고 push시 Class로 들어가니 primitive type으로 변경하지 않음
            if(!basket.isEmpty()&&
              basket.peek().equals(picked)){ //==비교 불가
                basket.pop();
                answer++; //*2는 한번에(+=2보다 ++이 약간 빠름)
            }
            else basket.add(picked);
        }
        return answer*2;
    }
}