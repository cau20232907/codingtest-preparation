import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Homework[] works = Arrays.stream(plans).map(Homework::new)
            .sorted((i,j)->Integer.compare(i.startTime,j.startTime))
            .toArray(Homework[]::new);
        String[] answer=new String[works.length];
        int time=works[0].startTime;
        Stack<Homework> stopped=new Stack<>();
        int i=1;
        int j=0;
        Homework current=works[0];
        while(i<works.length){
            int gap=Math.min(current.remains,works[i].startTime-time);
            current.remains-=gap;
            if(current.remains<=0){
                answer[j++]=current.name;
                current=null;
            }
            time+=gap;
            if(time==works[i].startTime){
                if(current!=null) stopped.add(current);
                current=works[i++];
            }else if(!stopped.isEmpty()){
                current=stopped.pop();
            }else{
                current=works[i++];
                time=current.startTime;
            }
        }
        answer[j++]=current.name; //if문에서 할당받으므로 not null
        while(!stopped.isEmpty()) answer[j++]=stopped.pop().name;
        return answer;
    }
    private class Homework{
        //getter 생략
        final String name;
        final int startTime;
        final int duration;
        int remains;
        Homework(String[] target){
            this.name=target[0];
            this.startTime=Integer.parseInt(target[1].substring(0,2))*60+
                Integer.parseInt(target[1].substring(3));
            this.duration=Integer.parseInt(target[2]);
            this.remains=this.duration;
        }
    }
}