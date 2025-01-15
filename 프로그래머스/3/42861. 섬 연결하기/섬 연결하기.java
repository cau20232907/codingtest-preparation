import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    
    int bridgesSelected=0;
    int totalCost=0;
    int[] connected;
    
    public int solution(int n, int[][] costs) {
        connected=IntStream.range(0,n).toArray();
        Bridge[] bridges=Arrays.stream(costs).map(Bridge::new).sorted().toArray(Bridge[]::new);
        
        for(int i=0, top1=0, top2=0;i<bridges.length;i++){
            top1=bridges[i].startIsland;
            top2=bridges[i].endIsland;
            while(top1!=connected[top1]) top1=connected[top1];
            while(top2!=connected[top2]) top2=connected[top2];
            
            if(top1!=top2){
                bridges[i].addThis(top1,top2);
                if(bridgesSelected==n-1) return totalCost;
            }
        }
        return totalCost;
    }
    
    //private 및 getter 생략
    private class Bridge implements Comparable<Bridge>{
        int startIsland;
        int endIsland;
        int cost;
        
        Bridge(int[] bridgeInfo){
            startIsland=bridgeInfo[0];
            endIsland=bridgeInfo[1];
            cost=bridgeInfo[2];
        }
        
        void addThis(int top1, int top2){
            bridgesSelected++;
            totalCost+=cost;
            if(top1>top2) connected[top1]=top2;
            else connected[top2]=top1;
        }
        
        @Override
        public int compareTo(Bridge other){
            return Integer.compare(this.cost, other.cost);
        }
        
        @Override
        public String toString(){
            return startIsland+" "+endIsland+" "+cost;
        }
    }
}

/*
최소 비용 신장 트리
다리 cost순 정렬 후 작은 것부터 선택
circle 확인: 여기서 그걸..
선택된 bridge 수와 cost 합을 저장한 후 bridge 수를 확인해 cost return
*/