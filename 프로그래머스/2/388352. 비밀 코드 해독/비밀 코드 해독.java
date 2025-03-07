import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<Trial> trials=new ArrayList<>();
        for(int i=0;i<q.length;i++)
            trials.add(new Trial(q[i],ans[i]));
        trials.sort(Trial::compareTo);
        // int availables=(1<<n)-1;
        // for(int i=trials.length-1;i>=0&&trials.get(i).ans==0;i++){
        //     availables&=(Integer.MAX_VALUE^trials.get(i).set);
        //     trials.remove(i);
        // }
        IntStream stream=IntStream.range(0,1<<n)
            .filter(i->Integer.bitCount(i)==5);
        for(Trial trial:trials)
            stream=stream.filter(trial::matches);
        return (int)stream.count();
    }
    private class Trial implements Comparable<Trial>{
        //getter 생략
        int set;
        final int ans;
        Trial(int[] q, int ans){
            this.set=0;
            for(int i:q) set|=1<<(i-1);
            this.ans=ans;
        }
        boolean matches(int pair){
            return Integer.bitCount(set&pair)==ans;
        }
        @Override
        public int compareTo(Trial other){
            return Double.compare((Integer.bitCount(other.set)/(double)other.ans),
                                  (Integer.bitCount(this.set)/(double)this.ans))
                *(-1);
        }
    }
}