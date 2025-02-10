import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer>[] idxByPriorities=IntStream.range(0,10)
            .mapToObj(i->new ArrayList<Integer>())
            .toArray(List[]::new);
        for(int i=0;i<priorities.length;i++){
            idxByPriorities[priorities[i]].add(i);
        }
        int lastIdx=-1;
        int count=0;
        for(int i=idxByPriorities.length-1;i>priorities[location];i--){
            count+=idxByPriorities[i].size();
            if(idxByPriorities[i].isEmpty()) continue;
            else if(idxByPriorities[i].get(0)>lastIdx){
                lastIdx=idxByPriorities[i].get(idxByPriorities[i].size()-1);
            }
            else{
                boolean isChanged=false;
                for(int j=1;j<idxByPriorities[i].size();j++){
                    if(idxByPriorities[i].get(j)>lastIdx){
                        isChanged=true;
                        lastIdx=idxByPriorities[i].get(j-1);
                        break;
                    }
                }
                if(!isChanged){
                lastIdx=idxByPriorities[i].get(idxByPriorities[i].size()-1);
                }
            }
        }
        
        List<Integer> target=idxByPriorities[priorities[location]];
        if(lastIdx<location){
            for(int i=0;i<target.size();i++){
                if(target.get(i)>lastIdx&&
                   target.get(i)<=location)
                    count++;
                else if(target.get(i)>location) break;
            }
        }else{
            for(int i=0;i<target.size();i++){
                if(target.get(i)>lastIdx||
                   target.get(i)<=location)
                    count++;
            }
        }
        return count;
    }
}