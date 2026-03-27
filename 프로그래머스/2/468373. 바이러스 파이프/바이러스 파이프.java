import java.util.*;
import java.util.stream.*;

class Solution {
    // 아 변수명 짓기 힘들다
    Set<Integer>[][] connectedPoints;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        // 계산 및 입력 값 parsing의 편의를 위해 row 0, col 0 버림
        connectedPoints = new Set[n+1][4];
        
        for(int i=1; i<connectedPoints.length; i++){
            for(int j=1; j<connectedPoints[i].length; j++){
                connectedPoints[i][j] = new HashSet<>();
            }
        }
        
        for(int i=0;i<edges.length;i++){
            connectedPoints[edges[i][0]][edges[i][2]].add(edges[i][1]);
            connectedPoints[edges[i][1]][edges[i][2]].add(edges[i][0]);
        }
        
        // 계산
        Set<Integer> initialInfectedSet = Set.of(infection);
        Set<Integer>[] nextConnectedToInfected = new Set[4];
        for(int j=1; j<nextConnectedToInfected.length; j++) {
            nextConnectedToInfected[j] = new HashSet<>(connectedPoints[infection][j]);
            for (int infectedThisTurn:connectedPoints[infection][j]) {
                calculateConnection(
                    nextConnectedToInfected[j],
                    infectedThisTurn,
                    j
                );
            }
        }
        return calculateInfection(
            initialInfectedSet,
            nextConnectedToInfected,
            k-1
        );
    }
    
    void calculateConnection(Set<Integer> saved, int point, int type){
        for(int connected:connectedPoints[point][type]){
            if(saved.contains(connected)) {
                continue;
            }
            saved.add(connected);
            calculateConnection(saved, connected, type);
        }
    }
    
    int calculateInfection(
        Set<Integer> infected,
        Set<Integer>[] connectedToInfected,
        int remainingTimes
    ){
        int maxResult = infected.size();
        for(int i=1; i<connectedToInfected.length; i++) {
            // infect connectedToInfected[i]
            if(connectedToInfected[i].size()==0) {
                continue;
            }
            Set<Integer> nextInfected = new HashSet<>(infected); // copy
            nextInfected.addAll(connectedToInfected[i]);
            if (remainingTimes==0) {
                maxResult = Math.max(maxResult, nextInfected.size());
                continue;
            } else if (nextInfected.size() == connectedPoints.length - 1){
                return nextInfected.size();
            }
            Set<Integer>[] nextConnectedToInfected = new Set[4];
            for(int j=1; j<nextConnectedToInfected.length; j++) {
                if (i==j) {
                    nextConnectedToInfected[j] = new HashSet<>();
                } else {
                    nextConnectedToInfected[j] = new HashSet<>(connectedToInfected[j]);
                    for (int infectedThisTurn:connectedToInfected[i]) {
                        calculateConnection(
                            nextConnectedToInfected[j],
                            infectedThisTurn,
                            j
                        );
                    }
                }
            }
            int result = calculateInfection(
                nextInfected,
                nextConnectedToInfected,
                remainingTimes-1
            );
            maxResult = Math.max(maxResult, result);
            if (maxResult == connectedPoints.length - 1){
                return maxResult;
            }
        }
        return maxResult;
    }
}