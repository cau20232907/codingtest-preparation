import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long maxTime=0;
        double totalPart=0;
        Tester[] tempArray=new Tester[times.length];
        PriorityQueue<Tester> queue=new PriorityQueue<>();
        for(int i=0;i<times.length;i++){
            tempArray[i]=new Tester(times[i]);
            totalPart+=tempArray[i].part;
        }
        int remains=n;
        for(int i=0;i<times.length;i++){
            int allocAmount=(int)(n*(tempArray[i].part/totalPart));
            remains-=allocAmount;
            maxTime = Math.max(maxTime,
                tempArray[i].setAlloc(allocAmount));
            queue.add(tempArray[i]);
        }
        while(remains!=0){
            Tester target=queue.poll();
            maxTime=Math.max(maxTime,target.addAlloc());
            queue.add(target);
            remains--;
        }
        return maxTime;
    }
    
    private class Tester implements Comparable<Tester>{
        final int time;
        private int allocated;
        private long totalTime;
        final double part;
        
        Tester(int time){
            this.time=time;
            this.part=1.0/time;
            totalTime=time;
        }
        
        long setAlloc(int amount){
            allocated=amount;
            long timeAmount=((long)time)*allocated;
            totalTime=time+timeAmount;
            return amount;
        }
        
        long addAlloc(){
            allocated++;
            long amount=totalTime;
            totalTime+=time;
            return amount;
        }
        
        @Override
        public int compareTo(Tester other){
            return Long.compare(this.totalTime, other.totalTime);
        }
    }
}

/*
시간이 10:7이면 7:10으로 분배해야 함
중점은 나머지를 처리하는 방법
17->7:10
 6->2:4 (7:14)
 5->2:3 (7:10.5)
 4->2:2 (7:7)
 3->1:2 (7:14)
 2->1:1 (7:7)
 1->0:1
 
각 시간에 역수를 취함
역수 비율만큼 비례배분하고 나머지는 자름
남은 인원 분배
각 인원 +1의 사람의 소요시간만큼 정렬 후 앞의 것부터 1씩 더함
*/