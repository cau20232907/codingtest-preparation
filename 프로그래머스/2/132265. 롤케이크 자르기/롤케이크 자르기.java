import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Set<Integer>> perLoc=new HashMap<>();
        for(int i=0;i<topping.length;i++){
            if(perLoc.containsKey(topping[i]))
                perLoc.get(topping[i]).add(i);
            else{
                Set<Integer> newSet=new HashSet<>();
                newSet.add(i);
                perLoc.put(topping[i],newSet);
            }
        }
        Set<Integer> opponent=new HashSet<>();
        for(int i=0;i<topping.length-1;i++){
            Set<Integer> locSet=perLoc.get(topping[i]);
            locSet.remove(i);
            if(locSet.isEmpty())
                perLoc.remove(topping[i]);
            opponent.add(topping[i]);
            if(perLoc.size()==opponent.size()) answer++;
        }
        return answer;
    }
}
//하나씩 옮기기