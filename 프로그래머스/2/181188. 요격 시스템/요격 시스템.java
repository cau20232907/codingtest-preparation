import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(i,j)->Integer.compare(i[0],j[0]));
        int currentEnd = 0; // 마지막에 한번 더해야 하는거 그냥 조건문 들여보냄
        for(int[] range:targets){
            if (range[0]>=currentEnd) {
                answer++;
                currentEnd = range[1];
            } else {
                //정렬되어 시작값 확인 필요 없음
                currentEnd = Math.min(currentEnd, range[1]);
            }
        }
        return answer;
    }
}