import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Reservation[] reservation = Arrays.stream(book_time)
            .map(Reservation::new)
            .sorted((i,j)->Integer.compare(i.startTime,j.startTime))
            .toArray(Reservation[]::new);
        PriorityQueue<Integer> rooms=new PriorityQueue<>();
        for(int i=0;i<reservation.length;i++){
            rooms.add(reservation[i].endTime);
            if(rooms.peek()<=reservation[i].startTime)
                rooms.poll();
        }
        return rooms.size();
    }
    private class Reservation{
        //getter 생략
        final int startTime;
        final int endTime;
        Reservation(String[] target){
            this.startTime=strToTime(target[0]);
            this.endTime=strToTime(target[1])+10;
        }
    }
    private int strToTime(String str){
        return Integer.parseInt(str.substring(0,2))*60+
            Integer.parseInt(str.substring(3));
    }
}