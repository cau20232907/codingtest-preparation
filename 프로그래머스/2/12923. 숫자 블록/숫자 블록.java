import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(long begin, long end) {
        // 조건상 long을 사용할 이유가 없음
        int[] answer = IntStream.range((int)begin, (int)end + 1)
            .map(position -> {
                int loopEnd =
                    (int) Math.sqrt(Math.min(position, 1_000_000_000))
                    + 2; //int 형 변환 문제로 인해 +2
                loopEnd = Math.min(loopEnd, position);
                int max = 1;
                for(int i = 2; i < loopEnd; i++) {
                    if (position % i == 0) {
                        if (position / i <= 10_000_000) {
                            max = Math.max(max, position / i);
                        }
                        if (i <= 10_000_000) {
                            max = Math.max(max, i);
                        }
                    }
                }
                return max;
            })
            .toArray();
        if (begin == 1) {
            answer[0] = 0; //edge case
        }
        return answer;
    }
}