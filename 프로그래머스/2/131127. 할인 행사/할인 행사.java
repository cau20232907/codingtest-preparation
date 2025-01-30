import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> diffs=new HashMap<>();
        int answer = 0;
        for(int i=0;i<want.length;i++)
            diffs.put(want[i],number[i]*-1);
        //처음 10개 초기화
        for(int i=0;i<10;i++)
            diffs.put(discount[i],diffs.getOrDefault(discount[i],0)+1);
        if(new HashSet<Integer>(diffs.values()).size()==1)
            answer++; //넘치는 것도 있으면 부족한 것도 있어야 함
        for(int i=10;i<discount.length;i++){
            diffs.put(discount[i-10],diffs.get(discount[i-10])-1);
            diffs.put(discount[i],diffs.getOrDefault(discount[i],0)+1);
        if(new HashSet<Integer>(diffs.values()).size()==1)
            answer++;
        }
        return answer;
    }
}