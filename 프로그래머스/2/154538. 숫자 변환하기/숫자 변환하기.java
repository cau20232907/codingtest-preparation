import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        int[] idx=new int[y];
        ArrayDeque<Integer> nextCal=new ArrayDeque<>();
        nextCal.add(x);
        do{
            x=nextCal.poll();
            int[] nextNum={x*2,x*3,x+n};
            for(int i=0;i<nextNum.length;i++){
                if(nextNum[i]==y) return idx[x]+1;
                else if(nextNum[i]>y) continue;
                else if(idx[nextNum[i]]==0){
                    nextCal.add(nextNum[i]);
                    idx[nextNum[i]]=idx[x]+1;
                }
            }
        }while(!nextCal.isEmpty());
        return -1;
    }
}