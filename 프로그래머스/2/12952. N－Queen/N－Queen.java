import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] currentState=new int[n];
        for(int eachCase:IntStream.range(0,n/2).toArray()){ //앞 절반
            currentState[0]=eachCase;
            answer+=calculateStep(currentState,1);
        }
        answer*=2;
        if(n==1){
            answer=1;
        }
        else if(n%2!=0){ //홀수인 경우 중앙
            currentState[0]=n/2;
            answer+=calculateStep(currentState,1);
        }
        return answer;
    }
    
    private int calculateStep(int[] currentState, int step){
        int result=0;
        if(step+1==currentState.length){
            result+=possiblePositions(currentState, step).length; //1밖에 없긴 함
        }else{
            for(int eachCase:possiblePositions(currentState, step)){
                currentState[step]=eachCase;
                result+=calculateStep(currentState,step+1);
            }
        }
        return result;
    }
    
    private int[] possiblePositions(int[] currentState, int step){
        Set<Integer> notPossibles=new HashSet<>();
        for(int i=0;i<step;i++){
            notPossibles.add(currentState[i]);
            notPossibles.add(currentState[i]+i-step); //tar+step==cur+i
            notPossibles.add(currentState[i]-i+step);
        }
        return IntStream.range(0,currentState.length)
            .filter(i->!notPossibles.contains(i))
            .toArray();
    }
}
/*
윗줄 배치(1~절반)
나머지 줄 배치
count

윗줄 경우의 수 계산, for loop
아랫줄 경우의 수 계산, for loop

경우의 수 계산: x+y 같음, x 같음, x-y 같음

*/