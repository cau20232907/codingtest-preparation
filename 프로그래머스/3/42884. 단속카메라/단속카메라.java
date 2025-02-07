import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(i,j)->Integer.compare(i[1],j[1]));
        int lastCam=Integer.MIN_VALUE;
        for(int i=0;i<routes.length;i++){
            if(lastCam<routes[i][0]){
                answer++;
                lastCam=routes[i][1];
            }
        }
        return answer;
    }
}
//나가는 곳 기준 정렬
//가장 먼저 나가는 곳에 카메라 설치, 이전에 들어온 건 전부 제외