import java.util.stream.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int downDiff=r-x;
        int rightDiff=c-y;
        k-=Math.abs(rightDiff)+Math.abs(downDiff);
        if(k%2==1||k<0) return "impossible";
        int downCount=0;
        int upCount=0;
        int rightCount=0;
        int leftCount=0;
        if(downDiff>0) downCount=downDiff;
        else upCount=-downDiff;
        if(rightDiff>0) rightCount=rightDiff;
        else leftCount=-rightDiff;
        //왕복운동 붙이기
        //반복 횟수: k/2 또는 n-x-downAdded 중 작은 쪽
        int rptVal=Math.min(k/2,n-x-downCount);
        k-=rptVal*2;
        downCount+=rptVal;
        upCount+=rptVal;
        rptVal=Math.min(k/2,y-leftCount-1);
        k-=rptVal*2;
        leftCount+=rptVal;
        rightCount+=rptVal;
        //m==1 처리 안함(문제 조건에 따름)
        int rlRepeat=k/2;
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<downCount;i++) answer.append('d');
        for(int i=0;i<leftCount;i++) answer.append('l');
        for(int i=0;i<rlRepeat;i++) answer.append("rl");
        for(int i=0;i<rightCount;i++) answer.append('r');
        for(int i=0;i<upCount;i++) answer.append('u');
        return answer.toString();
    }
}
//사전순: d,l,r,u
//최단거리 찾기->중간에 반복 넣기
//홀수 거리 남거나 최단거리 불가능시 impossible
//장애물 없음->지도 탐색 안 해도 됨