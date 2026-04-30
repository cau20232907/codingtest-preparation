import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Set<Integer>[] connected = new Set[n + 1];
        for(int i = 1; i <= n; i++) {
            connected[i] = new HashSet<>();
        }
        for(int i = 0; i < roads.length; i++) {
            connected[roads[i][0]].add(roads[i][1]);
            connected[roads[i][1]].add(roads[i][0]);
        }
        
        int[] distances = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            distances[i] = -1;
        }
        
        distances[destination] = 0;
        Set<Integer> currentSearch = connected[destination];
        Set<Integer> nextSearch = new HashSet<>();
        
        for(int distance = 1; currentSearch.size() != 0; distance++) {
            for(int point:currentSearch) {
                distances[point] = distance;
                nextSearch.addAll(connected[point]);
            }
            currentSearch = nextSearch.stream()
                .filter(p -> distances[p] == -1)
                .collect(Collectors.toSet());
            nextSearch.clear();
        }
        
        return Arrays.stream(sources)
            .map(p -> distances[p])
            .toArray();
    }
}