import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] sizeCount = Arrays.stream(tangerine)
            .boxed()
            .collect(Collectors.groupingBy(
                i -> i,
                Collectors.counting()
            ))
            .values().stream()
            .sorted(Collections.reverseOrder())
            .mapToInt(Long::intValue)
            .toArray();
        int types = 0;
        int total = 0;
        while(total < k) {
            total += sizeCount[types++];
        }
        return types;
    }
}