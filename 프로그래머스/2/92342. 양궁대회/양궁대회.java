import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        Set<State> cases=new HashSet<>();
        State max=new State(n,info);
        cases.add(max);
        for(int i=0;i<10;i++){
            Set<State> newCases=new HashSet<>();
            for(State state:cases){
                int[] lion=state.getLion();
                if(lion[10]<=info[i]) continue;
                lion[i]+=info[i]+1;
                lion[10]-=info[i]+1;
                State newOne=new State(lion,info);
                newCases.add(newOne);
                if(max.compareTo(newOne)>0) max=newOne;
            }
            cases.addAll(newCases);
        }
        if(max.winable()) return max.getLion();
        else return new int[]{-1};
    }
    
    private class State implements Comparable<State>{
        private int[] lion; //final 생략
        private final int diff;
        State(int n, int[] other){
            lion=new int[11];
            lion[10]=n; //leftovers
            int cal=0;
            for(int i=0;i<other.length;i++){
                if(other[i]!=0) cal-=10-i;
            }
            diff=cal;
        }
        
        State(int[] changed, int[] other){
            lion=changed;
            int cal=0;
            for(int i=0;i<other.length;i++){
                if(changed[i]==0&&other[i]==0) continue;
                else if(changed[i]>other[i]) cal+=10-i;
                else cal-=10-i;
            }
            diff=cal;
        }
        
        int[] getLion(){
            int[] clone=new int[11];
            System.arraycopy(lion,0,clone,0,11);
            return clone;
        }
        
        boolean winable(){
            return diff>0;
        }
        
        public int compareTo(State other){
            if(this.diff==other.diff){
                for(int i=other.lion.length-1;i>0;i--){
                    int eachRes=other.lion[i]-this.lion[i];
                    if(eachRes!=0) return eachRes;
                }
                return 0;
            }else return other.diff-this.diff;
        }
    }
}
/*
10 -> 0
이기거나 버리거나
10점 이길 때, 질때
9점 이길 때, 질 때
...

*/