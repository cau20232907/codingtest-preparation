import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> bridge=new ArrayDeque<>();
        for(int i=0;i<bridge_length;i++)
            bridge.add(0);
        int sumOfCurrentBridge=0;
        int nextCar=0;
        int time=0;
        do{
            time++;
            sumOfCurrentBridge-=bridge.poll();
            if(nextCar!=truck_weights.length) {
                if(sumOfCurrentBridge+truck_weights[nextCar]<=weight){
                    sumOfCurrentBridge+=truck_weights[nextCar];
                    bridge.add(truck_weights[nextCar++]);
                }
                else bridge.add(0);
            }
        }while(sumOfCurrentBridge!=0);
        return time;
    }
}