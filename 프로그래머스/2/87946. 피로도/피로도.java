import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        return calculateOne(Arrays.stream(dungeons)
            .map(Dungeon::new)
            .sorted()
            .toArray(Dungeon[]::new),k);
    }
    
    private int calculateOne(Dungeon[] remains, int leftK){
        int answer=0;
        for(int i=0;i<remains.length;i++){
            if(leftK<remains[i].prepared) continue;
            else{
                Dungeon[] next=new Dungeon[remains.length-1];
                for(int j=0,k=0;k<next.length;j++,k++){
                    if(i==j) j++; //자기 자신 제외
                    next[k]=remains[j];
                }
                int temp=calculateOne(next,leftK-remains[i].used)+1;
                if(temp>answer) answer=temp;
            }
        }
        return answer;
    }
    
    private class Dungeon implements Comparable<Dungeon>{
        //private 생략
        final int prepared;
        final int used;
        Dungeon(int[] arr){
            prepared=arr[0];
            used=arr[1];
        }
        
        @Override
        public int compareTo(Dungeon other){
            if(this.prepared==other.prepared)
                return this.used-other.used;
            else return this.prepared-other.prepared;
        }
    }
}