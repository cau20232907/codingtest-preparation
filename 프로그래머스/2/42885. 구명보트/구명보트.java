import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Stack<Integer> leftBoat=new Stack<>(); //정렬했다 보니 뒤에서부터 빼게 됨
        Arrays.sort(people);
        for(int i=people.length-1;i>=0;i--){
            //이미 존재하는 boat 중 여석 있는지 조사
            if(!leftBoat.isEmpty()&&leftBoat.peek()>=people[i]){
                leftBoat.pop();
            }else{
                answer++;
                if(people[i]!=limit){
                    leftBoat.add(limit-people[i]);
                }
            }
        }
        return answer;
    }
}