import java.util.*;
import java.util.stream.*;

class Solution {
    Set<String> noneSet=Set.of();
    public int solution(String[] strs, String t) {
        int[] nums=new int[t.length()+1];
        Map<Character,Set<String>> strSet=Arrays.stream(strs)
            .collect(Collectors.groupingBy(s->s.charAt(s.length()-1),Collectors.toSet()));
        
        for(int i=1;i<nums.length;i++){
            nums[i]=Short.MAX_VALUE; //초기화, 그러나 여기서 더 더할 예정이라 Integer.MAX_VALUE는 불가능
            String current=t.substring(0,i);
            for(String cardStr:strSet.getOrDefault(t.charAt(i-1),noneSet)){
                if(current.endsWith(cardStr)){
                    nums[i]=Math.min(nums[i],nums[i-cardStr.length()]+1);
                }
            }
        }
        if(nums[nums.length-1]>=Short.MAX_VALUE) return -1;
        else return nums[nums.length-1];
    }
}