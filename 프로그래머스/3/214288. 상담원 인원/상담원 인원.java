import java.util.*;
import java.util.stream.*;

class Solution {
    int[][] arr;
    public int solution(int k, int n, int[][] reqs) {
        Map<Integer,List<Request>>reqByType=Arrays.stream(reqs)
            .collect(Collectors.groupingBy(r->r[2]-1,
                Collectors.mapping(Request::new, Collectors.toList())));
        int[][] waitingTime=new int[k][n-k+1];
        arr=waitingTime;
        //waitingTime[유형][추가 상담원 수]
        int totalTime=1;
        PriorityQueue<Integer> finishTimes=new PriorityQueue<>(waitingTime[0].length);
        for(int i:reqByType.keySet()){ //요청 없는 것 거르기 가능
            List<Request> requests=reqByType.get(i);
            for(int j=0;j<waitingTime[i].length;j++){
                totalTime=0;
                for(int l=0;l<=j;l++) finishTimes.add(0);
                for(Request request:requests){
                    int currentTime=finishTimes.poll();
                    if(currentTime<=request.time)
                        currentTime=request.time;
                    else totalTime+=currentTime-request.time;
                    finishTimes.add(currentTime+request.duration);
                }
                waitingTime[i][j]=totalTime;
                finishTimes.clear();
                if(totalTime==0) break;
            }
        }
        //상담원별 대기시간 계산 끝
        //백트래킹
        return minDFS(0,waitingTime[0].length-1);
    }
    private int minDFS(int idx, int left){
        if(idx+1==arr.length) return arr[idx][left];
        int value=Integer.MAX_VALUE;
        for(int i=0;i<=left;i++){
            value=Math.min(value,arr[idx][i]+minDFS(idx+1,left-i));
            if(arr[idx][i]==0) break;
        }
        return value;
    }
    private class Request{
        //getter 생략
        final int time;
        final int duration;
        Request(int[] req){
            this.time=req[0];
            this.duration=req[1];
        }
    }
}