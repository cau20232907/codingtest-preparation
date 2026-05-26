import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        Map<Integer, Set<Integer>> connected = new HashMap<>();
        for(int i = 0; i < nodes.length; i++) {
            connected.put(nodes[i], new HashSet<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            connected.get(edges[i][0]).add(edges[i][1]);
            connected.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] answer = new int[2];
        
        Set<Integer> searched = new HashSet<>();
        ArrayDeque<Integer> next = new ArrayDeque<>();
        
        for(int i = 0; i < nodes.length; i++) {
            if(searched.contains(nodes[i])) {
                continue;
            }
            
            int[] nodeTypes = new int[2]; //[정, 역]
            next.add(nodes[i]);
            do {
                int node = next.pollFirst();
                if(searched.contains(node)) {
                    continue;
                }
                searched.add(node);
                Set<Integer> connectedToThis = connected.get(node);
                if (node % 2 != connectedToThis.size() % 2) {
                    // 부모와 연결된 노드 하나 제외
                    nodeTypes[0]++; //정 (홀수 or 짝수)
                } else {
                    nodeTypes[1]++; //역 (역홀수 or 역짝수)
                }
                next.addAll(connectedToThis);
            } while(!next.isEmpty());
            
            if (nodeTypes[0] == 1) {
                answer[1]++; // 정이 1개: 해당하는 노드를 부모로 설정시 역홀짝 트리
            }
            if (nodeTypes[1] == 1) {
                answer[0]++; // 역이 1개
            }
        }
        
        return answer;
    }
}