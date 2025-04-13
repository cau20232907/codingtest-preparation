class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] stack=new int[order.length-1];
        int next=1;
        int stackPos=-1;
        do{
            if(order[answer]>=next){
                //stack에 넣기
                while(order[answer]!=next)
                    stack[++stackPos]=next++;
                next++;
            }
            else if(stackPos!=-1&&stack[stackPos]==order[answer])
                stackPos--;
            else return answer;
            answer++;
        } while(answer!=order.length);
        return answer;
    }
}