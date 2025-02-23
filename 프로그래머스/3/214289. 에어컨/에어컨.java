import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        List<int[]> timeMark=new ArrayList<>();
        int board=0;
        boolean ifBoard=false;
        for(int i=0;i<onboard.length;i++){
            if(ifBoard&&onboard[i]==0){
                timeMark.add(new int[]{board, i-1});
                ifBoard=false;
            }else if(!ifBoard&&onboard[i]>0){
                ifBoard=true;
                board=i;
            }
        }
        if(ifBoard) timeMark.add(new int[]{board, onboard.length-1});
        final int gap=t2-t1;
        final boolean ifStay=gap==0?true:a>b*2;
        final boolean ifOneStay=gap==0?true:a>b;
        final int initialDiff=temperature>t2?temperature-t2:t1-temperature;
        boolean oddLeft=false;
        int time = timeMark.get(0)[0];
        int answer = a*initialDiff;
        for(int i=0;i<timeMark.size();i++){
            if((ifStay&&(timeMark.get(i)[0]-time)*b<initialDiff*a)||
                (!ifStay&&(timeMark.get(i)[0]-time)<initialDiff*2)){
                //stay
            }else{
                if(oddLeft) {
                    answer+=b;
                    time++;
                }
                if(initialDiff>(timeMark.get(i)[0]-time)/2){
                    answer+=(timeMark.get(i)[0]-time)/2*a;
                    if((timeMark.get(i)[0]-time)%2==1)
                        time=timeMark.get(i)[0]-1;
                    else time=timeMark.get(i)[0];
                }else{
                    answer+=initialDiff*a;
                    time=timeMark.get(i)[0];
                }
            }
            oddLeft=false;
            if(ifStay){
                answer+=(timeMark.get(i)[1]-time)*b;
                time=timeMark.get(i)[1];
            }else{
                answer+=(timeMark.get(i)[1]-time)/2*a;
                if((timeMark.get(i)[1]-time)%2==1){
                    if(!ifOneStay){
                        answer+=a;
                        time=timeMark.get(i)[1]+1;
                    }else{
                        oddLeft=true;
                        time=timeMark.get(i)[1]-1;
                    }
                }else time=timeMark.get(i)[1];
            }
        }
        if(oddLeft) answer+=b;
        return answer;
    }
}