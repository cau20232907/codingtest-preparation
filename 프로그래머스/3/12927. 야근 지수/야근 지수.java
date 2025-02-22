import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> remains=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++)
            remains.add(works[i]);
        for(int i=0;i<n&&!remains.isEmpty();i++){
            int high=remains.poll()-1;
            if(high>0) remains.add(high);
        }
        return remains.stream().mapToLong(i->((long)i)*i).sum();
    }
}