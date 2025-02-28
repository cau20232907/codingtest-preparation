import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        Arrays.sort(info,(i,j)->{
            int result=Integer.compare(i[1]-i[0],j[1]-j[0]);
            if(result==0) result=Integer.compare(j[1],i[1]);
            return result;
        });
        int signB=0;
        int cursor1=0;
        while(cursor1<info.length&&signB+info[cursor1][1]<m){
            signB+=info[cursor1][1];
            cursor1++;
        }
        if(cursor1==info.length) return 0;
        int cursor2=cursor1;
        while(cursor2<info.length&&info[cursor2][1]>=m-signB) cursor2++;
        if(cursor2<info.length){
            //1~2개 흔적 자투리를 채울 수 있는 게 뒤에 있으면
            //signB+=info[cursor2][1];
            int[] temp=info[cursor2];
            info[cursor2]=info[cursor1];
            info[cursor1]=temp;
            cursor1++;
        }
        //cursor1까지는 전부 B가 먹음
        int answer = 0;
        for(int i=cursor1;i<info.length&&answer<n;i++)
            answer+=info[i][0];
        if(answer<n) return answer;
        else return -1;
    }
}