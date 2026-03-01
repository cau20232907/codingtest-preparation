import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[][] points = new int[1000001][2]; // [deparature, arrival]
        for(int i = 0; i < edges.length; i++){
            points[edges[i][0]][0]++; // deparature
            points[edges[i][1]][1]++; // arrival
        }
        
        int addedPoint = 0; // 생성한 정점
        int arrivalOnlyCount = 0; // 도착만 있는 정점의 수
        int figure8MiddleCount = 0; // 8자 중앙의 수
        
        for(int i = 1; i < points.length; i++){
            if (points[i][0] == 0 && points[i][1] == 0) {
                continue; // 아니 정점 번호에 결번이 있다니...
            } else if (points[i][1] == 0 && points[i][0] >= 2) {
                addedPoint = i; // 그래프는 2개 이상: 생성한 정점은 출발 2개 이상
            } else if (points[i][0] == 0) {
                arrivalOnlyCount++;
            } else if (points[i][0] == 2) {
                figure8MiddleCount++;
            } 
        }
        
        int circleCount = points[addedPoint][0]
            - arrivalOnlyCount
            - figure8MiddleCount;
        
        return new int[]{
            addedPoint,
            circleCount,
            arrivalOnlyCount,
            figure8MiddleCount
            };
    }
    
    /*
    도착 없이 출발만 존재: 막대 시점 or 생성한 정점
    도착 없이 출발만 여러 개가 존재하는 게 있다면 그것이 생성한 정점
    -> 생성한 정점 판별 가능
    막대 그래프의 수: 출발 없이 도착만 존재하는 정점의 수 (출발만으로 판정 시 생성한 정점이 출발지를 가리키는 상황에 대응이 어려움)

    도넛, 8자 및 그 수 확인방법
    도착 출발 2개씩: 8자의 중앙
    생성한 정점의 출발 수: 3가지 그래프의 합
    총합 - 막대 - 8자 = 도넛
    */
}