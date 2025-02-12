import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Set<Integer>[] connectedPerNode=IntStream
            .range(-1,edge.length)
            .mapToObj(i->new HashSet<>())
            .toArray(Set[]::new);
        boolean[] visited=new boolean[edge.length+1];
        for(int[] eachEdge:edge){
            connectedPerNode[eachEdge[0]].add(eachEdge[1]);
            connectedPerNode[eachEdge[1]].add(eachEdge[0]);
        }
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        queue.add(1);
        queue.add(0);
        visited[1]=true;
        int finalArrivals=0;
        while(true){
            int target=queue.poll();
            if(target==0){
                if(queue.isEmpty()) break;
                target=queue.poll();
                finalArrivals=0;
                queue.add(0);
            }
            finalArrivals++;
            for(int next:connectedPerNode[target])
                if(!visited[next]) {
                    visited[next]=true;
                    queue.add(next);
                }
        }
        return finalArrivals;
    }
}