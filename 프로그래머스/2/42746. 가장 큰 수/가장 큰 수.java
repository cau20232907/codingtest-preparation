import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb=new StringBuilder();
        Arrays.stream(numbers).mapToObj(Integer::toString)
            .sorted((i,j)->{
                return Integer.compare(Integer.parseInt(j+i),Integer.parseInt(i+j));
            })
            .forEach(i->sb.append(i));
        while(sb.length()!=0&&sb.charAt(0)=='0'){
            sb.delete(0,1);
        }
        if(sb.length()==0) sb.append('0');
        return sb.toString();
    }
}