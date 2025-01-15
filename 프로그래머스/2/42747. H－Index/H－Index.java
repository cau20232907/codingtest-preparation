import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // Arrays.sort(citations);
        // Arrays.reverse(citations);
        
        citations=Arrays.stream(citations).mapToObj(i->i)
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int i=citations.length-1;i>=0;i--)
            answer=Math.max(Math.min(citations[i],i+1),answer);
        
        return answer;
    }
}