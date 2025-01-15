import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int currentDay=(99-progresses[0]+speeds[0])/speeds[0];
        List<Integer> answer=new ArrayList<>(progresses.length);
        int currentFinishes=1;
        //첫 작업은 직접 초기화
        for(int i=1, dayOfThisProgress=0;i<progresses.length;i++){
            dayOfThisProgress=(99-progresses[i]+speeds[i])/speeds[i];
            if(dayOfThisProgress>currentDay){
                answer.add(currentFinishes);
                currentDay=dayOfThisProgress;
                currentFinishes=1;
            }else{
                currentFinishes++;
            }
        }
        answer.add(currentFinishes);
        return answer;
    }
}

/*
남은 날짜 수 구함(100-progresses+speeds-1)/speeds
현재 날짜 수와 같으면 기능++
아니면 날짜 업데이트하고 기능=1
*/