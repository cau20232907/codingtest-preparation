import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Disk> queue=new PriorityQueue<>();
        PriorityQueue<Disk> timeQueue=new PriorityQueue<>((i,j)->i.compareToByTime(j));
        for(int i=0;i<jobs.length;i++){
            timeQueue.add(new Disk(i,jobs[i][0],jobs[i][1]));
        }
        long answer=0;
        int time=0;
        Disk current=timeQueue.poll();
        time=current.begin(current.getReqTime());
        answer+=current.getRetTime();
        while(!queue.isEmpty()||!timeQueue.isEmpty()){
            while(!timeQueue.isEmpty()&&
                  timeQueue.peek().getReqTime()<=time)
                queue.add(timeQueue.poll());
            if(queue.isEmpty()){
                current=timeQueue.poll();
                time=current.begin(current.getReqTime());
            }else{
                current=queue.poll();
                time=current.begin(time);
            }
            answer+=current.getRetTime();
        }
        return (int) answer/jobs.length;
    }
    
    private class Disk implements Comparable<Disk>{
        private final int no;
        private final int reqTime;
        private final int takeTime;
        private int finishTime;
        private boolean setFin;
        Disk(int no,int reqTime,int takeTime){
            this.no=no;
            this.reqTime=reqTime;
            this.takeTime=takeTime;
            this.finishTime=0;
            this.setFin=false;
        }
        @Override
        public int compareTo(Disk other){
            int res=Integer.compare(this.takeTime,other.takeTime);
            if(res!=0) return res;
            res=Integer.compare(this.reqTime,other.reqTime);
            if(res!=0) return res;
            else return Integer.compare(this.no,other.no);
        }
        int compareToByTime(Disk other){
            int res = Integer.compare(this.reqTime,other.reqTime);
            if(res!=0) return res;
            else return this.compareTo(other);
        }
        int getReqTime(){
            return reqTime;
        }
        int begin(int startTime){
            if(setFin) throw new RuntimeException();
            this.finishTime=startTime+takeTime;
            setFin=true;
            return this.finishTime;
        }
        int getRetTime(){
            return finishTime-reqTime;
        }
    }
}