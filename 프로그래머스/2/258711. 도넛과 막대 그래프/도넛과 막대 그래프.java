import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Point> points = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            // deparature
            if(points.containsKey(edges[i][0])){
                points.get(edges[i][0])
                    .deparature.add(edges[i][1]);
            }else{
                Point point = new Point();
                point.number = edges[i][0];
                point.deparature = new ArrayList<>();
                point.arrival = new ArrayList<>();
                point.deparature.add(edges[i][1]);
                points.put(point.number,point);
            }
            // arrival
            if(points.containsKey(edges[i][1])){
                points.get(edges[i][1])
                    .arrival.add(edges[i][0]);
            }else{
                Point point = new Point();
                point.number = edges[i][1];
                point.deparature = new ArrayList<>();
                point.arrival = new ArrayList<>();
                point.arrival.add(edges[i][0]);
                points.put(point.number,point);
            }
        }
        
        Point addedPoint = null; // 생성한 정점
        int arrivalOnlyCount = 0; // 도착만 있는 정점의 수
        int figure8MiddleCount = 0; // 8자 중앙의 수
        
        for(Point point:points.values()){
            if(point.deparature.size() == 0){
                arrivalOnlyCount++;
            }else if(point.arrival.size() == 0){
                if(point.deparature.size() >= 2){
                    addedPoint = point;
                }else if(points.get(point.deparature.get(0)).arrival.size() >= 2 &&
                        addedPoint == null){
                    addedPoint = point;
                }
            }else if(point.deparature.size() == 2){
                figure8MiddleCount++;
            }
        }
        
        int circleCount = addedPoint.deparature.size()
            -arrivalOnlyCount
            -figure8MiddleCount;
        
        return new int[]{
            addedPoint.number,
            circleCount,
            arrivalOnlyCount,
            figure8MiddleCount
            };
    }
    
    class Point{
        int number;
        List<Integer> deparature;
        List<Integer> arrival;
    }
    
    /*
    도착 없이 출발만 존재: 막대 시점 or 생성한 정점
    도착 없이 출발만 여러 개가 존재하는 게 있다면 그것이 생성한 정점
    도착 없으나 출발이 하나인 것이 2개 존재 시 막대 하나만 존재함, 출발 정점만 확인하면 됨(3개 이상 존재 불가)
    (확인 방법: 다음 정점이 도착 2개인가, 다른 생성한 정점이 없는가)
    -> 생성한 정점, 판별 가능
    막대 그래프의 수: 출발 없이 도착만 존재하는 정점의 수 (출발만으로 판정 시 생성한 정점이 출발지를 가리키는 상황에 대응이 어려움)

    도넛, 8자 및 그 수 확인방법
    도착 출발 2개씩: 8자의 중앙
    임의의 정점의 출발 수: 3가지 그래프의 합
    총합 - 막대 - 8자 = 도넛
    */
}